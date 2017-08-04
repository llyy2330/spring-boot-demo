# spring-boot-demo
spring boot  mybatis druid  mapper pageHelp ，maven分层


遇到的坑
###
1.分模块后 单个项目无法PACKAGE总是说丢失依赖，但是依赖的模块本地有源码也有JAR包，解决办法每个模块必须先INSTLL

2.使用yml配置，查找mybatis的配置与tk.mapper配置，经过多次调试，注意使用所使用的MAPPER，在启动类中增加mapper扫描路径

3.占位符问题 在spring boot以前都 使用${jdbc_url} 来替换，但是SPRING彻底变成了 @jdbc_url@

4.主模块打可执行JAR包，使用插件
    org.springframework.boot 
    spring-boot-maven-plugin 

5.中文乱码，在AOP中获取httpResponse 增加charset统一为utf-8

6.spring-boot扫描注解路径，如果没有配置则自动扫描启动类所在的包路径下的类。找不到注解的依赖，则提升启动类的包路径，或者在启动类写代码指定注解扫描类

7.统一异常处理获取不到异常，在类中增加注解@ControllerAdvice

8.
