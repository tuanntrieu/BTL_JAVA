CREATE DATABASE QLShop
USE QLShop
drop database QLShop
CREATE TABLE Account(
username varchar(30) PRIMARY KEY,
password varchar(30) NOT NULL,
role varchar(10) NOT NULL
)

INSERT INTO Account VALUES
('tuantrieu','tuan03nd','admin'),
('thangpham','thang04nd','user'),
('tienpham','tien03nd','user'),
('huyman','man04nd','user'),
('quangvinh','221222','user')



CREATE TABLE Customer(
customerId varchar(10) PRIMARY KEY,
name nvarchar(40) NOT NUll,
age int NOT NULL,
address nvarchar(30) ,
phoneNumber varchar(10) NOT NULL,
email varchar(50) NOT NULL,
username varchar(30) FOREIGN KEY REFERENCES  Account(username)
)

INSERT INTO Customer VALUES
('AD1',N'Triệu Đăng Tuấn',20,N'Nam Định','0968712369','trieudangtuan18032003@gmail.com','tuantrieu'),
('KH01',N'Phạm Đức Thắng',19,N'Nam Định','0364828548','thang2004@gmail.com','thangpham'),
('KH02',N'Phạm Trung Tiến',20,N'Nam Định','0387262203','tien2003@gmail.com','tienpham'),
('KH03',N'Phạm Huy Mân',19,N'Nam Định','0123456789','mangiaoan@gmail.com','huyman'),
('KH04',N'Nguyễn Hoàng Quang Vinh',20,N'Hà Tĩnh','0944283594','vinhne@gmail.com','quangvinh')


CREATE TABLE Mobile 
(
id varchar(10) PRIMARY KEY,
name varchar(50) NOT NULL,
color nvarchar(10) NOT NULL,
price float NOT NULL,
number int NOT NULL,
brand varchar(20) NOT NULL,
memory int NOT NULL)


INSERT INTO Mobile VALUES
('SP01','Iphone 11',N'Đen',11.2,21,'Apple',64),
('SP02','Iphone 11',N'Đen',12.9,18,'Apple',128),
('SP03','Iphone 11',N'Xanh lá',12.6,15,'Apple',128),
('SP04','Iphone 11',N'Tím',12.6,12,'Apple',128),
('SP05','Iphone 11',N'Vàng',19,10,'Apple',256),
('SP06','Iphone 11 Pro',N'Đen',27,3,'Apple',512),
('SP07','Iphone 11 Pro',N'Vàng',25,9,'Apple',256),
('SP08','Iphone 11 Pro Max',N'Trắng',28,9,'Apple',256),
('SP09','Iphone 11 Pro Max',N'Đen',30,7,'Apple',512),
('SP10','Iphone 12',N'Trắng',15.19,3,'Apple',128),
('SP11','Iphone 12',N'Xanh dương',15.39,9,'Apple',64),
('SP12','Iphone 12 Pro',N'Xanh dương',24.99,6,'Apple',256),
('SP13','Iphone 12 Pro Max',N'Đen',31,11,'Apple',512),
('SP14','Iphone 13',N'Xanh lá',18.19,9,'Apple',128),
('SP15','Iphone 13 Pro',N'Xám',28.49,6,'Apple',512),
('SP16','Iphone 13 Pro Max',N'Vàng',26.99,20,'Apple',128),
('SP17','Iphone 14',N'Tím',19.79,23,'Apple',128),
('SP18','Iphone 14 Plus',N'Xanh',25.19,6,'Apple',256),
('SP19','Iphone 14 Pro Max',N'Vàng',36.99,11,'Apple',512),
('SP20','Iphone 14',N'Xanh lá',25.99,9,'Apple',512),
('SP21','Iphone 14 Plú',N'Trắng',22.69,6,'Apple',128),
('SP22','Iphone 14 Pro Max',N'Vàng',30.99,13,'Apple',256),
('SP23', 'Samsung Galaxy S21', N'Xanh dương', 21.9, 12, 'Samsung', 128),
('SP24', 'Samsung Galaxy S21 Plus', N'Đen', 25.9, 9, 'Samsung', 256),
('SP25', 'Samsung Galaxy S21 Ultra', N'Xám', 33.9, 7, 'Samsung', 512),
('SP26', 'Samsung Galaxy S22', N'Trắng', 19.9, 8, 'Samsung', 128),
('SP27', 'Samsung Galaxy S22 Plus', N'Đỏ', 26.9, 6, 'Samsung', 256),
('SP28', 'Samsung Galaxy S22 Ultra', N'Đen', 34.9, 4, 'Samsung', 512),
('SP29', 'Oppo A5', N'Đen', 4, 5, 'Oppo', 16),
('SP30', 'Oppo A9', N'Trắng', 4.5, 8, 'Oppo', 32),
('SP31', 'Oppo A52', N'Xanh', 5, 10, 'Oppo', 64),
('SP32', 'Oppo A12', N'Đỏ', 3.5, 15, 'Oppo', 128),
('SP33', 'Oppo F11', N'Vàng', 5, 12, 'Oppo', 16),
('SP34', 'Oppo Reno 5', N'Xám', 6, 7, 'Oppo', 64),
('SP35' ,'Oppo Find X2',N'Đen', 6, 5, 'Oppo', 128),
('SP36', 'Oppo R15', N'Trắng', 4, 8, 'Oppo', 64),
('SP37', 'Oppo F17', N'Xanh', 5.5, 10, 'Oppo', 128),
('SP38', 'Oppo A9X', N'Đỏ', 3.8, 20, 'Oppo', 256),
('SP39', 'Redmi Note 8 Pro', N'Đen', 5, 10, 'Xiaomi', 64),
('SP40', 'Xiaomi Redmi 9', N'Trắng', 3, 10, 'Xiaomi', 32),
('SP41', 'Xiaomi Redmi Note 10 Pro', N'Xanh', 6, 10, 'Xiaomi', 128),
('SP42', 'Xiaomi Mi 11', N'Trắng', 7, 10, 'Xiaomi', 256),
('SP43', 'Xiaomi Mi 10T Pro', N'Xám', 8, 10, 'Xiaomi', 256),
('SP44', 'Xiaomi Redmi Note 9S', N'Đỏ', 4, 10, 'Xiaomi', 64),
('SP45', 'Xiaomi Mi 9', N'Vàng', 5.5, 10, 'Xiaomi', 128),
('SP46', 'Xiaomi Mi 8', 'NĐen', 4.5, 10, 'Xiaomi', 64),
('SP47', 'Xiaomi Mi Note 10', N'Xanh dương', 6.5, 10, 'Xiaomi', 128),
('SP48', 'Xiaomi Redmi 9 Prime', N'Trắng', 3.5, 10, 'Xiaomi', 32),
('SP49', 'Realme 7 Pro', N'Xanh', 4.5, 10, 'Realme', 128),
('SP50', 'Realme 7', N'Đen', 3.5, 10, 'Realme', 64),
('SP51', 'Realme X3', N'Trắng', 6, 10, 'Realme', 256),
('SP52', 'Realme Narzo 30 Pro', N'Xám', 4, 10, 'Realme', 128),
('SP53', 'Realme C15', N'Xanh', 3, 10, 'Realme', 64),
('SP54', 'Realme X50 Pro', N'Đen', 7, 10, 'Realme', 256),
('SP55', 'Realme 6 Pro', N'Trắng', 5, 10, 'Realme', 128),
('SP56', 'Realme X7 Pro', N'Xanh', 6.5, 10, 'Realme', 256),
('SP57', 'Realme C3', N'Đen', 2.5, 10, 'Realme', 64),
('SP58', 'Realme 6', N'Trắng', 4.5, 10, 'Realme', 128)



CREATE TABLE Bill(
billId varchar(20) PRIMARY KEY,
customerId varchar(10) FOREIGN KEY REFERENCES Customer(customerID),
nameKH nvarchar(50) NOT NULL,
id varchar(10) FOREIGN KEY REFERENCES Mobile(id),
name varchar(50) NOT NULL,
price float NOT NULL,
time varchar(50) NOT NULL
)

SELECT * FROM Bill
SELECT * From Customer
SELECT * From Account
SELECT * FROM Mobile
