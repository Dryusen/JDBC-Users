CREATE DATABASE company;

USE company;

CREATE TABLE employees (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255),
                           age INT,
                           position VARCHAR(255),
                           salary FLOAT
);