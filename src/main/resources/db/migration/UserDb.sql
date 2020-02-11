CREATE TABLE user (
     id VARCHAR (100) NOT NULL PRIMARY KEY,
     firstName VARCHAR (100),
     lastName VARCHAR (100)

);
CREATE TABLE order (
     id VARCHAR (100)NOT NULL,
     userId VARCHAR (100) NOT NULL REFERENCES orders (id),
     serviceName VARCHAR (100),
     targetUrl VARCHAR (100),
     price FLOAT(100)
);

