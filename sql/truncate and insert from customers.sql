TRUNCATE customers CASCADE;

INSERT INTO customers 
(secondname, firstname, middlename) 
VALUES 
('Иванов', 'Иван', 'Иванович'),
('Петров', 'Петр', 'Петрович'),
('Сидоров', 'Сидор', 'Сидорович');