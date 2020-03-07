CREATE TABLE IF NOT EXISTS books(
    id         INT(11) PRIMARY KEY AUTO_INCREMENT,
    isbn         VARCHAR(17) NOT NULL,
    title VARCHAR(50) NOT NULL,
    author  VARCHAR(50) NOT NULL
);
insert into books
values(0,'Aldous Huxley','978-5-17-080085-8','Brave New World');
