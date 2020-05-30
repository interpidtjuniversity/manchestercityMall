package com.web2020.mall.aspect;

import com.google.common.collect.ImmutableList;
import com.web2020.mall.annotation.Limit;
import com.web2020.mall.enumerate.LimitType;
import com.web2020.mall.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;


/**
 * Created by cuiYao on 2020/5/19.
 * 限流切面
 */
@Aspect
@Configuration
public class LimitAspect {
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    private static final String UNKNOWN = "unknown";

    private final RedisTemplate<String, Serializable>limitRedisTemplate;

    @Autowired
    public LimitAspect(RedisTemplate<String,Serializable>limitRedisTemplate){
        this.limitRedisTemplate = limitRedisTemplate;
    }

    // public方法且有Limit注解的方法上
    @Around("execution(public * *(..)) && @annotation(com.web2020.mall.annotation.Limit)")
    public Object interceptor(ProceedingJoinPoint pjp){
        //获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取方法
        Method method = signature.getMethod();
        //获取方法上的注解
        Limit limit = method.getAnnotation(Limit.class);
        //获取注解属性
        LimitType type = limit.limitType();
        String name = limit.name();
        String key;
        int period = limit.period();
        int count = limit.count();

        /**
         * @default 默认对方法进行限流
         * @IP 对ip进行限流
         * */
        switch (type){
            case IP:
                key = getIpAddress();
                break;
            default:
                key = StringUtils.upperCase(method.getName());
        }

        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limit.prefix(), key));
        try {
            String luaScript = buildLuaScript();
            RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
            Number curCount = limitRedisTemplate.execute(redisScript, keys, count, period);
            logger.info("Access try curCount is {} for name={} and key = {}", curCount, name, key);
            if (curCount != null && curCount.intValue() <= count) {
                return pjp.proceed();
            } else {
                //限流
                return ResultUtil.SimpleResult("limited");
            }
        } catch (Throwable e) {
            if (e instanceof RuntimeException) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
            throw new RuntimeException("server exception");
        }
    }

    /**
     * 牛逼的方法 获取调用方IP
     * */
    public String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * redis执行lua脚本
     * */
    public String buildLuaScript() {
        StringBuilder lua = new StringBuilder();
        lua.append("local c");
        lua.append("\nc = redis.call('get',KEYS[1])");
        // 调用不超过最大值，则直接返回
        lua.append("\nif c and tonumber(c) > tonumber(ARGV[1]) then");
        lua.append("\nreturn c;");
        lua.append("\nend");
        // 执行计算器自加
        lua.append("\nc = redis.call('incr',KEYS[1])");
        lua.append("\nif tonumber(c) == 1 then");
        // 从第一次调用开始限流，设置对应键值的过期
        lua.append("\nredis.call('expire',KEYS[1],ARGV[2])");
        lua.append("\nend");
        lua.append("\nreturn c;");
        return lua.toString();
    }
}
