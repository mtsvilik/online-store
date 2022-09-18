use online_stores_db;

insert into online_stores(name) values ('OZ.by'), ('Chitatel.by'), ('Kniga.by');

insert into admins(first_name, last_name, salary) values ('Max', 'Maximov', 1000);
insert into admins(first_name, last_name, salary) values ('Den', 'Denisov', 1500);
insert into admins(first_name, last_name, salary) values ('Vlad', 'Vladov', 1250);

insert into online_stores(admin_id, name) values
	(1, 'OZ.by'),
	(2, 'Chitatel.by'),
	(3, 'Kniga.by');

insert into cards(name, number, validity_period) values ('Master Card', 123456123, '2023-12-12');
insert into cards(name, number, validity_period) values ('Visa', 987456789, '2023-11-01');
insert into cards(name, number, validity_period) values ('Master Card', 123456777, '2024-12-12');
insert into cards(name, number, validity_period) values ('Visa', 123455589, '2025-02-12');
insert into cards(name, number, validity_period) values ('Visa', 124446789, '2024-10-12');

insert into contacts(email, password, phone_number) values ('nikit@gmail.com', 'NIK234555', 295554433);
insert into contacts(email, password, phone_number) values ('pavel@gmail.com', 'PAV345666', 292223344);
insert into contacts(email, password, phone_number) values ('miron@gmail.com', 'MIR456777', 293334455);
insert into contacts(email, password, phone_number) values ('petr@gmail.com', 'PET567888', 294445566);
insert into contacts(email, password, phone_number) values ('ivan@gmail.com', 'IVA678999', 295556677);

insert into customers(contact_id, card_id, first_name, last_name) values
	(4, 1, 'Nikita', 'Nikitin'),
	(6, 2, 'Pavel', 'Pavlov'),
	(7, 3, 'Miron', 'Mironov'),
	(8, 4, 'Petr', 'Petrov'),
	(9, 5, 'Ivan', 'Ivanov');

insert into countries(name, code) values
	('Belarus', 'BLRv112'),
    ('Belgium', 'BEL 056'),
    ('SPAIN', 'ESP 724'),
    ('SWEDEN', 'SWE 752'),
    ('GERMANY', 'DEU 276');

update countries set code = 'BLR 112' where id = 1;
update countries set name = 'BELARUS' where id = 1;
update countries set name = 'BELGIUM' where id = 2;

insert into authors(country_id, first_name, last_name) values
	(5, 'Natalia', 'Natalina'),
    (4, 'Olga', 'Olgina'),
    (3, 'Anna', 'Anina'),
    (4, 'Marina', 'Marinina'),
    (2, 'Zahar', 'Zaharin'),
    (1, 'Anastasia', 'Stasina'),
    (3, 'Oleg', 'Petrov');

insert into publishing_houses(name) values
	('AST'),
    ('EKSMO'),
    ('LABIRINT'),
    ('CLEVER');

update publishing_houses set name = 'SAGE Publishing' where id = 1;
update publishing_houses set name = 'S&P Global' where id = 2;

delete from publishing_houses where id = 3;
delete from countries where id = 3;

insert into countries(name, code) values
	('UNITED STATES OF AMERICA', 'USA 840'),
    ('RUSSIAN FEDERATION', 'RUS 643');

delete from authors where id = 5;

update authors set country_id = 6, first_name = 'Stephen', last_name = 'King' where id = 6;
update authors set country_id = 7, first_name = 'Victor', last_name = 'VPelevin' where id = 4;
update authors set country_id = 6, first_name = 'Joanne', last_name = 'Rowling' where id = 1;
update authors set country_id = 6, first_name = 'Robert', last_name = 'Leahy' where id = 2;

insert into books(online_store_id, publishing_house_id, name, genre, bestseller, sale, price) values
	(3, 2, 'The thorn birds', 'FICTION', 'FOR_ALL_TIMES', 'TWENTY_PERCENT', 50),
    (2, 1, 'It', 'FICTION', 'YEAR', 'TWENTY_PERCENT' , 75);

insert into books(online_store_id, publishing_house_id, name, genre, sale, price) values
	(2, 1, 'The outsider', 'SCIENCE_FICTION', 'FIFTY_PERCENT', 50),
    (2, 4, 'Homo Zapiens', 'FICTION', 'FIFTY_PERCENT', 70);

insert into books(online_store_id, publishing_house_id, name, genre, bestseller, price) values
	(1, 2, 'Misery', 'SCIENCE_FICTION', 'FOR_ALL_TIMES', 100),
    (1, 2, 'Anxiety Free', 'PSYCHOLOGY', 'FOR_ALL_TIMES', 150),
    (3, 2, 'Harry Potter and the Philosophers Stone', 'FICTION', 'FOR_ALL_TIMES', 75),
    (1, 1, 'Rich Dad Poor Dad', 'BUSINESS', 'MONTH', 75);

insert into author_books(author_id, book_id) values
	(1, 11),
	(6, 3),
	(6, 7),
	(3, 4),
	(4, 8),
	(6, 9),
	(3, 13),
	(2, 10);

insert into shopping_carts(customer_id) values
    (5),
	(4),
	(3),
	(2),
	(1);

insert into book_shopping_carts(book_id, shopping_cart_id) values
	(3),
	(3),
	(3);

insert into book_shopping_carts(book_id, shopping_cart_id) values
	(3, 1),
	(3, 2),
	(3, 3);

insert into online_store_customers(online_store_id, customer_id) values
	(1, 5),
	(1, 4),
	(2, 3),
	(3, 2),
	(3, 1);

-- display id, name, genre, price fields from books
select id, name, genre, price from books;

-- display authors and their countries
select
a.id as author_id, a.first_name, a.last_name,
c.id as country_id, c.name, c.code
from authors a
inner join countries c
on a.country_id = c.id;

-- display authors and their countries, where the country name contains e,
-- and the author's surname is "King".
select
a.id as author_id, a.first_name, a.last_name,
c.id as country_id, c.name, c.code
from authors a
inner join countries c
on a.country_id = c.id
where c.name like '%e%'
and a.last_name = 'King';

update authors set last_name = '' where id = 3;
update authors set last_name = 'Anina' where id = 3;

-- display authors and their countries
select
a.id as author_id, a.first_name, a.last_name,
c.id as country_id, c.name, c.code
from authors a
right join countries c
on a.country_id = c.id;

-- display authors and their countries
select
a.id as author_id, a.first_name, a.last_name,
c.id as country_id, c.name, c.code
from authors a
left join countries c
on a.country_id = c.id;

update authors set last_name = 'Pelevin' where id = 4;

--display customers and their contacts and sort by customer's name not alphabetically
select
cu.id as customer_id, cu.first_name, cu.last_name,
co.id as contact_id, co.email, co.password, co.phone_number
from customers cu
join contacts co
on cu.contact_id = co.id
order by first_name desc;

--display customers, their contacts and cards and sort by customer's surname by alphabet
select
cu.id as customer_id, cu.first_name, cu.last_name,
co.id as contact_id, co.email, co.password, co.phone_number,
ca.id as card_id, ca.name, ca.number, ca.validity_period
from customers cu
join contacts co
on cu.contact_id = co.id
join cards ca
on cu.card_id = ca.id
order by last_name;

-- display books, online_stores and publishing_houses, where the book name contains "i",
-- the book should be sold at a discount and should be a bestseller
select
b.id as book_id, b.name, b.genre, b.bestseller, b.sale, b.price,
ph.id as publishing_house_id, ph.name,
os.id as online_store_id, os.name
from books b
join publishing_houses ph
on b.publishing_house_id = ph.id
join online_stores os
on b.online_store_id = os.id
where b.name like '%i%'
and b.sale is not null
and b.bestseller is not null;

--display books, online_stores, publishing_houses and admins of online stores
select
b.id as book_id, b.name, b.genre, b.bestseller, b.sale, b.price,
ph.id as publishing_house_id, ph.name,
os.id as online_store_id, os.name,
a.id as admin_id, a.first_name, a.last_name, a.salary
from books b
join publishing_houses ph
on b.publishing_house_id = ph.id
join online_stores os
on b.online_store_id = os.id
join admins a
on os.admin_id = a.id;










