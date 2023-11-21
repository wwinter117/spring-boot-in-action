# 使用 OpenJDK 17 作为基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制编译好的 JAR 文件到容器中
COPY target/spring-boot-in-action-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露应用程序的端口
EXPOSE 8080

# 启动 Spring Boot 应用
CMD ["java", "-jar", "app.jar"]
