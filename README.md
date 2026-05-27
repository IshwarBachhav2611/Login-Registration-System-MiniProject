# Login-Registration-System-MiniProject
Simple Login & Registration System using Java Swing/AWT, JDBC, and MySQL.

## Features

* User Registration
* User Login
* MySQL Database Connection
* Simple GUI using Java Swing

## Technologies Used

* Java
* Swing/AWT
* JDBC
* MySQL

## Database
CREATE DATABASE login_system;
USE login_system;
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);


## Run Project
javac -cp ".;lib/mysql-connector-j-9.7.0.jar" *.java
java -cp ".;lib/mysql-connector-j-9.7.0.jar" Login

##Author
**Ishwar Bachhav**
