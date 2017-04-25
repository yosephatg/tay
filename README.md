# tay

How to start the tay application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/tay-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Dev environment instructions
---

1. Make sure you install MySql. Basic instructions for linux (ubuntu) located here https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04
2. 

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
