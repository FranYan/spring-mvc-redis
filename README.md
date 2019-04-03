# spring-mvc-redis
SSM 整合redis的demo

## 2019年4月1日<br/>
整合了redis进去 但是在构造redisTemplate时 发生了异常，原因暂不清楚
<br />
引入了日志配置，但是使用的是默认配置

## 2019年4月2日<br/>
导致redisTemplate构造失败的原因是spring-data-redis的版本过高
接下来需要做的是关注高版本下如何成功初始化

## 2019年4月3日<br />
修改了整合json的方式，原本的整合方式只作用于request上，所以异常捕获的advice无法进行json转换
将事物提交上升到了controller层，即：在controller层中，一旦抛出以上，则回滚所有的数据库操作
