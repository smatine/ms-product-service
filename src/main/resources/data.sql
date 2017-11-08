insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(232, 'item 232', 'desc 232', 100, 1000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4000, 'item 4000', 'desc 4000', 200, 2000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4001, 'item 4001', 'desc 4001', 300, 3000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4002, 'item 4002', 'desc 4002', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4003, 'item 4003', 'desc 4003', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4004, 'item 4004', 'desc 4004', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4005, 'item 4005', 'desc 4005', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4006, 'item 4006', 'desc 4006', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4007, 'item 4007', 'desc 4007', 400, 4000);
insert into PRODUCT_STORE(id, itemname, description, availableitems, cost) values(4008, 'item 4008', 'desc 4008', 400, 4000);


insert into CUSTOMER_DETAILS(customerid, username, password, firstname, lastname, email, address, phnum) values(1001, 'admin', 'admin', 'Admin', 'System', 'admin@sgstems.com', 'US', 1234567890 );
insert into CUSTOMER_DETAILS(customerid, username, password, firstname, lastname, email, address, phnum) values(1002, 'abhijit', 'abhijit', 'abhijit', 'P', 'abhijit@isa.com', 'FR', 0123456789 );

CREATE DATABASE testdb;
 
CREATE TABLE customer(id BIGINT PRIMARY KEY  NOT NULL, firstname VARCHAR(20), lastname VARCHAR(20));
 
psql -h localhost -p 5432 -u testdb
 
\c (connect to db) testdb
 
\d (Describe table) customer
 
Select (S capital) * from customer;
 
CREATE TABLE PUBLIC.PRODUCT_STORE(ID INTEGER PRIMARY KEY NOT NULL, AVAILABLEITEMS INTEGER NOT NULL, COST INTEGER NOT NULL, DESCRIPTION VARCHAR(255) NOT NULL, ITEMNAME VARCHAR(255) NOT NULL);
 
CREATE SEQUENCE PUBLIC.ORDER_SEQUENCE START WITH 1;
 
CREATE TABLE PUBLIC.ORDER_DETAILS(ORDERID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.ORDER_SEQUENCE) NOT NULL PRIMARY KEY NULL_TO_DEFAULT SEQUENCE PUBLIC.ORDER_SEQUENCE, BILLINGADDR VARCHAR(255),DELIVERYADDR VARCHAR(255), ORDERDATE DATETIME, ORDERQUANTITY INTEGER, PAYMENTMODE VARCHAR(255), PRODUCTID BIGINT, TOTALAMT BIGINT, USERNAME VARCHAR(255));
 
CREATE TABLE PUBLIC.ORDER_DETAILS(ORDERID BIGINT NOT NULL PRIMARY KEY , BILLINGADDR VARCHAR(255), DELIVERYADDR VARCHAR(255), ORDERDATE TIMESTAMP, ORDERQUANTITY INTEGER, PAYMENTMODE VARCHAR(255), PRODUCTID BIGINT, TOTALAMT BIGINT, USERNAME VARCHAR(255));
 
CREATE SEQUENCE PUBLIC.CUSTOMER_SEQUENCE START WITH 1;
 
CREATE TABLE PUBLIC.CUSTOMER_DETAILS(CUSTOMERID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_CE2E8B20_EF60_49A9_81B2_9CE4306C0F31) NOT NULL PRIMARY KEY NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_CE2E8B20_EF60_49A9_81B2_9CE4306C0F31, ADDRESS VARCHAR(255), EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PASSWORD VARCHAR(255), PHNUM BIGINT, USERNAME VARCHAR(255))
 
CREATE TABLE PUBLIC.CUSTOMER_DETAILS(CUSTOMERID BIGINT NOT NULL PRIMARY KEY , ADDRESS VARCHAR(255), EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PASSWORD VARCHAR(255), PHNUM BIGINT, USERNAME VARCHAR(255));
