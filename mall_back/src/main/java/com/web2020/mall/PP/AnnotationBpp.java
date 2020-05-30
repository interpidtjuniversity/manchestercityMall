package com.web2020.mall.PP;

import com.web2020.mall.controller.BaseController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

//@Component
//@ConfigurationProperties(prefix = "html")//前缀
//@PropertySource(value = "classpath:htmlPort.yml")//配置文件路径
public class AnnotationBpp implements BeanPostProcessor{
    @Value("${url}")
    private String url;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        CrossOrigin co = (CrossOrigin) bean.getClass().getAnnotation(CrossOrigin.class);
        if(co!=null){
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(co);
            try {
                Field field = invocationHandler.getClass().getDeclaredField("memberValues");
                field.setAccessible(true);
                Map memberValues = (Map) field.get(invocationHandler);
                String[] newOrigins = {url};
                memberValues.put("origins", newOrigins);
                System.out.println(co.origins()[0]+" "+beanName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        CrossOrigin co = (CrossOrigin) bean.getClass().getAnnotation(CrossOrigin.class);
        if(co!=null){
            System.out.println(co.origins()[0] + beanName);
            //System.out.println(beanName);
        }

        return bean;
    }

}
