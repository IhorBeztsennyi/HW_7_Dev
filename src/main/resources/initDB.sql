CREATE TABLE promotion (
 promotion_id SERIAL NOT NULL,
 amount INT NOT NULL,
 price DECIMAL(18,2) NOT NULL,
 PRIMARY KEY (promotion_id)
);

CREATE TABLE product (
 product_id SERIAL NOT NULL,
 name  VARCHAR(1) NOT NULL,
 price DECIMAL(18,2) NOT NULL,
 promotion_id SERIAL NOT NULL,
 PRIMARY KEY (product_id),
 FOREIGN KEY (promotion_id) REFERENCES promotion (promotion_id)
 ON DELETE CASCADE
);