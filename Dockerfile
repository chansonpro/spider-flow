# 环境
FROM java:8

# 创建目录存放 jar 包与配置文件
RUN mkdir -p /home/www

# 拷贝jar
ADD ./spider-flow-web/target/spider-flow.jar   /home/www/spider-flow.jar

# 设置暴露的端口号
EXPOSE 8080

# 设置工作目录
WORKDIR /home/www

# 执行命令
ENTRYPOINT   ["java","-jar","/home/www/spider-flow.jar"]

#CMD java -jar ./home/www/spider-flow.jar
