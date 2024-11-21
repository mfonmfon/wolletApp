-- TRUNCATE TABLE wallet;
-- TRUNCATE TABLE customer;


INSERT INTO wallet (id,  account_number, balance) VALUES
(210,  '123456789', 10000 ),
(201,  '123456789', 4000),
(202,  '123456789', 300 ),
(203, '123456789', 300);


INSERT INTO customer (id, wallet_id) VALUES
(100,  200),
(200,  201),
(300,  202),
(400,  203);
