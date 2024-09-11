create database banhangmvc;
use banhangmvc;

create table users(
	uid int auto_increment primary key,
    name varchar(50),
    age int,
    phone varchar(20),
    email varchar(50),
    cccd varchar(20),
    address varchar(100),
    username varchar(50),
    password varchar(50),
    role varchar(1)
);
create table TypeProduct(
	tid int auto_increment primary key,
    tName varchar(50)
);
create table product(
	pid int auto_increment primary key,
    pName varchar(50),
    tid int,
    foreign key (tid) references TypeProduct(tid),
    price double,
    quantity int,
    img text
);

create table `order`(
	oid int primary key auto_increment,
	uid int,
    pid int,
    foreign key(uid) references users(uid),
    foreign key(pid) references product(pid),
    quantity int,
    totalprice double
);

INSERT INTO users (name, age, phone, email, cccd, address, username, password, role)
VALUES 
('Alice Johnson', 28, '555-1234', 'alice@example.com', '123456789', '123 Maple Street', 'alicej', 'password1', 'U'),
('Bob Smith', 35, '555-5678', 'bob@example.com', '987654321', '456 Oak Avenue', 'bobsmith', 'password2', 'A'),
('Charlie Brown', 22, '555-8765', 'charlie@example.com', '112233445', '789 Pine Road', 'charlieb', 'password3', 'U'),
('Diana Ross', 30, '555-3456', 'diana@example.com', '556677889', '321 Elm Street', 'dianar', 'password4', 'S'),
('Evan Davis', 40, '555-7890', 'evan@example.com', '998877665', '654 Birch Lane', 'evand', 'password5', 'U'),
('Vinh Davis', 40, '555-7890', 'evan@example.com', '998877665', '654 Birch Lane', 'a', 'a', 'U'),
('Jonny Daang', 40, '555-7890', 'evan@example.com', '998877665', '654 Birch Lane', 'b', 'b', 'S');
insert into TypeProduct (tName) values ('Electronics'),('Accessories'),('Decor');
INSERT INTO product (pName, tid, price, quantity, img)
VALUES 
('Laptop', 1, 999.99, 50,'https://th.bing.com/th/id/R.a243c72be94e93f1399f3399b06c7677?rik=hrhQ9%2b%2fJ1SSPHA&riu=http%3a%2f%2fwww.riskmanagementmonitor.com%2fwp-content%2fuploads%2f2014%2f12%2fLaptop1.jpg&ehk=OfidPRNnM1a1JERcjUs9J725LwV1tT7YdUTEmeAi5Gw%3d&risl=1&pid=ImgRaw&r=0'),
('Chair', 3, 49.99, 150,'https://th.bing.com/th/id/OIP.BinmNYx2Pl6PVxBewuyENgHaHT?rs=1&pid=ImgDetMain'),
('Smartphone', 1, 699.99, 200,'https://th.bing.com/th/id/OIP.zd-7LAg4rdImYuFL0o0PFgHaHa?rs=1&pid=ImgDetMain'),
('Table', 3, 89.99, 100,'https://th.bing.com/th/id/OIP.M5OgWGqRo-wM8wBgfP9owAHaFI?rs=1&pid=ImgDetMain'),
('Headphones', 2, 29.99, 300,'https://th.bing.com/th/id/OIP.7Rpt53WF85APw_WhnFxVIgHaK5?rs=1&pid=ImgDetMain');
select * from users;
select * from product;
select * from TypeProduct;
select * from `order`;