

CREATE TABLE category (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    CONSTRAINT PK_category PRIMARY KEY (id)
);


CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    image VARCHAR(255) NOT NULL,
    category_id_fk INT,
    CONSTRAINT PK_product PRIMARY KEY (id),
    CONSTRAINT FK_category FOREIGN KEY (category_id_fk) REFERENCES category(id)
);

CREATE TABLE cart(
	id INT NOT NULL AUTO_INCREMENT,
	created_at DateTime NOT NULL,
	CONSTRAINT PK_cart PRIMARY KEY (id)
);

CREATE TABLE item(

	id INT NOT NULL AUTO_INCREMENT,
	product_id_fk INT,
	quantity INT NOT NULL,
	price DECIMAL(10, 2) NOT NULL,
	cart_id_fk int,
	CONSTRAINT PK_item PRIMARY KEY(id),
	CONSTRAINT FK_product FOREIGN KEY(product_id_fk) REFERENCES product(id),
	CONSTRAINT FK_cart FOREIGN KEY(cart_id_fk) references cart(id)
);


INSERT INTO `eccomerce-it`.category (id,name) VALUES
	 (1,'Tecnologia'),
	 (2,'Hogar');


INSERT INTO `eccomerce-it`.product (name,description,price,image,category_id_fk) VALUES
	 ('Heladera','Heladera grande',3000.00,'https://acdn.mitiendanube.com/stores/002/392/919/products/heladera-con-freezer-no-frost-patrick-285-litros-blanca-hpk350m00b-21-465ef2ea6f8ddc23b116738873303715-1024-1024.jpg',2),
	 ('TV','25 pulgadas',10000.00,'https://images.fravega.com/f500/0ec3af99701dbf0665ec61ea3816b028.jpg',2),
	 ('Notebook','Intel core',3000222.00,'https://mexx-img-2019.s3.amazonaws.com/Notebook-Hp-250-G9-Core-i3-1215U-8Gb-Ssd_47495_2.jpeg',1),
	 ('Escritorio','Madera de calidad',3000222.00,'https://http2.mlstatic.com/D_NQ_NP_954264-MLU70728960609_072023-O.webp',2),
	 ('Play 5','2 joystick',3000222.00,'https://arsonyb2c.vtexassets.com/arquivos/ids/362074/PlayStation-5-DualShock.jpg',1),
	 ('Mouse','Mouse inalambrico',5000.00,'https://redragon.es/content/uploads/2021/04/GRIFFIN-B.png',1);
