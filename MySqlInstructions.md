MySql First Time Setup Instructions
---

1. Make sure you install MySql. Basic instructions for linux (ubuntu) located here https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04
2. (following steps inferred from https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial and https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql)
3. Access the MySQL shell:
    * ```mysql -u root -p```
4. Create a new user:
    * ```CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';```
    * replace newuser and password. keep in mind the password has to meet requirements set by step 1
5. Grant privileges to newuser:
    * ```GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';```
    * and reload them ```FLUSH PRIVILEGES;```
6. Test your new user:
    * ```quit```
    * ```mysql -u newuser -p```
7. Create a new database
    * ```CREATE DATABASE tay;```
7. Make sure to create the appropriate tables (for eg)
    * ```CREATE TABLE nutrition( id bigint primary key not null auto_increment, type varchar(255) not null, calories int not null, protein int not null, fiber int not null );```

7. Update config.yml to have the correct username/password/database
    * ```   
        user: tay
        password: tayfakepassword
        url: jdbc:mysql://localhost:3306/tay ```

Common pitfalls
---------------

1. Make sure your ubuntu isn't set up in PDT time! mysql-connector-java can't handle it
    * if you already setup everything up and hit a timezone error, you need to reset your computers timezone to something different
    * then go into mysql and change the timezone to match ```set GLOBAL time_zone = "-xx:xx""``` to match your computers timezone offset