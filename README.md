# manchestercityMall
前后端分离的微商城 仅登陆注册 添加购物车 清空购物车 查看订单功能,肥肠简单(一下午写完的....练手😂)
演示请戳 http://47.114.153.37:8080/

导入 建表.sql到数据库

用idea导入 mall_back 并配置redis

用webstorm 或 vscode 导入 mall_front(页面一定要用ide的内置浏览器打开!!!这样才能看见端口!!!)

然后修改 mall_back controller目录下的BaseController 上的@CrossOrigin注解中的值为页面所在的端口的URL(url只写到端口就行)

运行MallApplication

完成!!!
