create schema if not exists MaterielsBD;

use MaterielsBD;

create table product(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
  inventory int (11) not null,
  brand varchar(50) not null, 
  model varchar(50),
  title varchar(150) not null,
  description text,
  price float (11,2),
  serialnumber varchar(30), 
  releaseDate date, 
  processor varchar(35), 
  ram int (3), 
  storage int (5), 
  os varchar(50), 
  screenSize float (11,2),
  computFormat varchar(20),
  productType ENUM('laptop', 'desktop', 'accessory')
);

create table user (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
  role ENUM ('client', 'employe'), 
  male boolean, 
  lastname varchar(20) not null,
  firstname varchar(30) not null, 
  email varchar(30) unique not null, 
  pass varchar(50) not null
);

create table address (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
  address varchar(50) not null, 
  complement varchar(30), 
  cp int(5) not null, 
  town varchar(50) not null, 
  phone int (10), 
  description varchar(250), 
  userId int, foreign key (userId) references user(id)
);

create table command (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
  date date not null, 
  status ENUM ('deleted', 'old', 'validated'), 
  userId int, foreign key (userId) references user(id)
);

create table product_command (
  commandId int,
  productId int,
  Quantity int(3) not null, 
  CONSTRAINT fk_command
    FOREIGN KEY(commandId)
      REFERENCES command(id),
  CONSTRAINT fk_product
    FOREIGN KEY(productId)
      REFERENCES product(id)
);

CREATE TABLE contact (
  id integer not null primary key AUTO_INCREMENT,
  firstname varchar(255) not null,
  lastname varchar(255) not null,
  email varchar(255) not null,
  message text,
  comment text,
  subject varchar(255) not null,
  status ENUM('to_treat', 'actif', 'treated')
);


#création des comptes pour les employés de l'entreprise
INSERT INTO `user` (role, male, lastname, firstname, email, pass) VALUES 
('employe', true, 'BENK', 'Guillaume', 'b.guillaume@bestcomputer.com', 'B1g8lkjmi9Eg'),
('employe', true, 'MIL', 'Tom', 'm.tom@bestcomputer.com', 'JkEl3,n(productType, kr)sivn'),
('employe', false, 'SING', 'Marine', 's.marine@bestcomputer.com', '3Klm-ioep9Zn'),
('employe', true, 'DUPONT', 'Jacque', 'd.jacque@bestcomputer.com', 'jNF-irçklnv-J'),
('employe', false, 'CHARM', 'Marie', 'c.marie@bestcomputer.com', 'EyU6cWs8En'),
('employe', true, 'MARL', 'Bruno', 'm.bruno@bestcomputer.com', 'IeAn8b6nE0Z'),
('employe', true, 'BEN', 'Sam', 'b.sam@bestcomputer.com', 'FwC53wwYS7i5'),
('employe', false, 'CONST', 'Lucie', 'c.lucie@bestcomputer.com', 'H5iht9WD38zC'),
('employe', true, 'BROWN', 'James', 'b.james@bestcomputer.com', '8qARcdE9c3U7'),
('employe', true, 'HARN', 'Carim', 'h.carim@bestcomputer.com', '7YZTrmT4b32i'),
('employe', true, 'CORK', 'Borice', 'c.borice@bestcomputer.com', '4jH7gpbUR4Y2');

#création des produits:


INSERT INTO `product` (productType, inventory, model, brand, title, description, price, serialnumber, releaseDate, processor, ram, storage, os, screenSize) VALUES 
('laptop', 3, 'Latitude 7300', 'Dell', 'Dell Latitude 7300', 'description à renseigner', 799.0, 'fkl2n3x', '2019-09-08', 'Intel Core i5-8365U', 8, 256, 'Windows 10 professionnelle', 13.3),
('laptop', 5, 'EliteBook', 'Hp', 'HP Elite dragonfly', 'description à renseigner', 1800.0, 'klmkj2jio3y', '2022-02-13', 'Intel Core i5-8265U', 8, 256, 'Windows 10 pro', 13.3),
('laptop', 1, 'Thinkpad', 'Lenovo', 'Thinkpad X1 Yoga gen 7', 'Description à renseigner', 1900.90, 'jlnu3jh6z', '2020-04-20', 'intel Core i7-1270P', 16, 256, 'Windows 11 pro', 14.0),
('laptop', 0, 'Vivobook', 'ASUS', 'ASUS Vivobook Pro', 'description à renseigner', 1799.95, 'N7600PC-L2010T', '2021-12-12', 'Intel Core i7-11370H', 16, 1000, 'Windows 10 pro', 16.0),
('laptop', 3, 'Katana GF66', 'MSI', 'MSI Katana GF66', 'description à renseigner', 1649.95, '12UE-850FR', '2022-11-12', 'Intel Core i7-12700H', 16, 512, 'Windows 11', 15.6),
('laptop', 2, 'Swift 3', 'Acer', 'ACER Swift 3', 'description à renseigner', 629.95, 'SF314-511-33KE', '2022-02-11', 'Intel Core i3-1115G4', 8, 256, 'Windows 11 en mode S', 14.0),
('laptop', 4, 'ThinkPad E15', 'Lenovo', 'Lenovo ThinkPad E15 Gen 2', 'description à renseigner', 1179.95, '20TD00GLFR', '2022-10-18', 'Intel Core i7-1165G7', 16, 512, 'Windows 11 Pro', 15.6),
('laptop', 2, 'G7', 'Gigabyte', 'Gigabyte G7', 'description à renseigner', 1199.95, 'MD-71FR123SO', '2022-10-25', 'Intel Core i7-11800H', 16, 512, 'Windows 10', 17.0),
('laptop', 5, 'MacBook air', 'Apple', 'Apple MacBook Air M2', 'description à renseigner', 1498.99, 'MLY13FN/A', '2022-07-15', 'Apple M2 GPU 8 coeurs', 8, 256, 'Mac OS Monterey', 13.6),
('laptop', 3, 'MacBook Pro', 'Apple', 'Apple MacBook Pro M2', 'description à renseigner', 2059.01, 'MNEJ3FN/A', '2022-06-17', 'Apple M2 GPU 10 coeurs', 16, 512, 'MacOS Monterey', 13.3);


INSERT INTO `product` (productType, inventory, model, brand, title, description, price, serialnumber, releaseDate, processor, ram, storage, os, computFormat) VALUES 
('desktop', 5, 'PB62', 'Asus', 'ASUS Mini PC PB62', 'description à renseigner', 749.95, 'B3020ZH', '2022-09-03', 'Intel Core i3-10105', 8, 256, 'Windows 10 Pro', 'MFF'),
('desktop', 2, 'MPG Trident ', 'MSI', 'MSI MPG Trident A', 'description à renseigner', 2099.95, '12TG-235FR', '2022-07-31', 'Intel Core i7-12700F', 16, 1000, 'Windows 11', 'UFF'),
('desktop', 0, 'ExpertCenter ', 'Asus',  'ASUS ExpertCenter D7', 'description à renseigner', 1099.94, 'D700MCES-711700009R', '2022-06-15', 'Intel Core i7-11700', 16, 512, 'Windows 10 Pro', 'MFF'),
('desktop', 1, 'ThinkCentre M90q ', 'Lenovo', 'Lenovo ThinkCentre M90q Tiny', 'description à renseigner', 869.95, '11CR0054FR', '2021-09-13', 'Intel Core i5-10500', 8, 256, 'Windows 10 Pro', 'SFF'),
('desktop', 4, 'Optiplex', 'Dell', 'Dell OptiPlex 3000 Micro', 'description à renseigner', 999.95, 'YTNMW', '2022-05-31', 'Intel Core i5-12500T', 16, 512, 'Windows 10 Pro', 'MFF'),
('desktop', 6, 'Alienware Aurora ', 'Dell', 'Alienware Aurora R13-583', 'description à renseigner', 1699.95, 'Y96TY', '2022-04-14', 'Intel Core i7-12700F', 16, 512, 'Windows 11 Famille', 'UFF'),
('desktop', 3, 'Inspiron ', 'Dell', 'Dell Inspiron 3910', 'description à renseigner', 1399.94, '6TFY2', '2022-12-20', 'Intel Core i7-12700F', 16, 512, 'Windows 11 Famille', 'SFF'),
('desktop', 2, 'Mac Studio ', 'apple', 'Apple Mac Studio M1 Max', 'description à renseigner', 2529.00, 'MJMV3FN/A_Z14J_2_FR_CTO', '2022-07-21', 'Apple M1 Max GPU 32 coeurs', 32, 512, 'macOS Monterey', 'SFF'),
('desktop', 3, 'iMac', 'apple', 'Apple iMac 2021', 'description à renseigner', 1975.01, 'MGPD3FN/A-MKPN-MT2', '2021-05-12', 'Apple M1 GPU 8 coeurs', 8, 512, 'macOS Big Sur', 'tout en 1 24 pouces'),
('desktop', 4, 'mac mini', 'apple', 'Apple Mac Mini M1', 'description à renseigner', 799.0, '1155939', '2020-11-10', 'apple m1 gpu 8 coeurs', 8, 256, 'Mac OS Big Sur', 'SFF');



INSERT INTO `product` (productType, inventory, model, brand, title, description, price, serialnumber, releaseDate) VALUES 
('accessory', 5, 'TUF', 'Asus', 'Ecran Asus TUF VG24VQE', 'description à renseigner', 189.95, '90LM0575-B01170', '2021-04-19'),
('accessory', 5, 'Wired', 'Microsoft', 'Microsoft Wired Keyboard 600 USB - Noir', 'description à renseigner', 15.95, 'ANB-00007', '2021-10-04'),
('accessory', 3, 'Magic Keyboard', 'Apple', 'Apple Magic Keyboard avec Touch ID', 'description à renseigner', 159.00, 'MK293F-A', '2021-04-15'),
('accessory', 6, 'Ripjaws KM570', 'G.Skill', 'clavier gamer G.Skill Ripjaws KM570 RGB', 'description à renseigner', 79.94, 'GK-K0CC5-KM570-S10FR', '2017-11-21'),
('accessory', 1, 'Maous bluetooth', 'Microsoft', 'souris Microsoft Bluetooth', 'description à renseigner', 69.95, 'QHG-00005', '2021-05-05'),
('accessory', 7, 'Pavilion Gaming', 'HP', 'HP Pavilion Gaming Souris M200 + Casque M400', 'description à renseigner', 39.95, 'M200+M400', '2022-06-21'),
('accessory', 2, 'Krypton', 'GLAB', 'The G-Lab Combo Krypton', 'description à renseigner', 29.95, 'COMBO-KRYPTON', '2020-04-21'),
('accessory', 3, 'sac à dos', 'Caselogic', 'Caselogic Sac à dos laptop 14', 'description à renseigner', 39.95, 'DLBP-114K', '2020-02-16'),
('accessory', 0, 'Trolley Executive', 'Targu', 'Malette 15.6 Targu Trolley Executive', 'description à renseigner', 79.96, 'TBR003EU', '2020-02-20'),
('accessory', 2, 'TUF', 'Asus', 'Ecran Asus TUF VG27AQ', 'description à renseigner', 329.95, 'VG27AQ', '2021-04-19'),
('accessory', 3, 'LAPS-113', 'Caselogic', 'housse 13.3 Caselogic LAPS-113', 'description à renseigner', 29.95, 'LAPS-113K', '2020-01-20'),
('accessory', 5, 'ADVA-117', 'Case Logic', 'sacoche 17 Case Logic ADVA-117', 'description à renseigner', 44.95, 'ADVA117', '2021-05-20'),
('accessory', 5, 'CityLite Sleeve', 'Targu', 'housse Targus CityLite Sleeve MacBook Pro 13', 'description à renseigner', 24.95, 'TSS975GL', '2021-04-20'),
('accessory', 5, 'HyperDrive ', 'Hyper', 'Hyper Hub USB-C 5-en-1 HyperDrive pour iMac 24', 'description à renseigner', 49.94, 'HD34A6', '2020-06-26'),
('accessory', 3, 'Hub USB-C', 'Akashi ', 'Akashi Hub USB Type-C 9-en-1', 'description à renseigner', 79.96, 'ALTHUB9IN1TC', '2021-05-28'),
('accessory', 5, 't7', 'Samsung', 'disque dur externe samsung t7 1TO usb-c', 'description à renseigner', 139.95, 'MU-PC1T0T', '2020-03-20'), 
('accessory', 5, 't7', 'Samsung', 'disque dur externe samsung t7 2to usb-c', 'description à renseigner', 219.95, 'MU-PC2T0T', '2020-03-20');





#source: www.materiel.net
