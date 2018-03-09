## description
* register to eureka server, supply HELLO-SERVICE service

## package
* `./mvnw -s .mvn/settings.xml package`
* `./mvnw -s .mvn/settings.xml package -Dmaven.test.skip=true`
* `java -jar target/springcloud_hello-0.0.1-SNAPSHOT.jar --server.port=8081`
* `java -jar target/springcloud_hello-0.0.1-SNAPSHOT.jar --server.port=8082`
