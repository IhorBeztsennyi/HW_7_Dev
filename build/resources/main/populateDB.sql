INSERT INTO promotion (amount, price)
VALUES
(0, 0.00),
(3, 3.00),
(6, 5.00);

INSERT INTO product (name, price, promotion_id)
VALUES
('A', 1.25, 2),
('B', 4.25, 1),
('C', 1.00, 3),
('D', 0.75, 1);