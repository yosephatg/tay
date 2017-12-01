# tay

How to start the tay application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/tay-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Dev environment instructions
---

1. Make sure you install MySql. Basic instructions for linux (ubuntu) located here https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04
2. Follow the instructions [here](MySqlInstructions.md)

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Twilio Integration
---
Tay can receive and send messages. In order to do this, you must have a valid Twilio phone number. Sign up for free [here.](https://www.twilio.com/try-twilio)

In order to send messages to Twilio, Twilio uses webhooks, meaning your application must face the internet. In order to test this functionality, see [Twilio's blog post](https://www.twilio.com/blog/2013/10/test-your-webhooks-locally-with-ngrok.html) on the subject. 


