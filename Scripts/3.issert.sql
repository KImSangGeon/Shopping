select user(), database();

desc product_information;
desc customer_information;
desc sales_information ;
desc sign_in ;

select * from sales_information ;
select * from customer_information;
select * from product_information;
select * from sign_in;

drop table sales_information ;
drop table product_information ;
drop table customer_information ;
drop table sign_in ;

delete from product_information  
where p_code ='PA';
-- 3
insert into product_information values
('PA', '책상', 10000, 3),
('PB', '냉장고', 36000, 5),
('PC', '세탁기', 22000, 2),
('PD', 'VTR', 30000, 6),
('PE', '자전거', 90000, 4),
('PF', '시계', 6000, 10),
('PG', 'TV', 8000, 5),
('PH', '탁자', 3000, 6);


-- 1
insert into sign_in values
('aaaa', password('aaaa12'), '홍길동', 19770405, '남성', '010-9741-5821'),
('bbbb', password('bbbb12'), '김연수', 19850301, '여성', '010-4568-5581'),
('cccc', password('cccc12'), '김지원', 19860708, '여성', '010-9111-5556'),
('dddd', password('dddd12'), '문희원', 19800108, '여성', '010-7777-7777'),
('eeee', password('eeee12'), '유일한', 19790205, '남성', '010-4566-8886'),
('ffff', password('ffff12'), '김동수', 19811123, '남성', '010-1231-1211'),
('gggg', password('gggg12'), '배진태', 19820707, '남성', '010-7877-7777'),
('tkdrjs7', password('tkdrjs12'), '김이민', 20210409, '남성', '010-5555-5555' ),
('tkdrjs', password('tkdrjs12'), '김민한', 20210406, '남성', '010-8888-8888' ),
('dkdkdk', password('tkdrjs12'), '김지연', 20210410, '여성', '010-9999-9999' ),
('dldigh', password('tkdrjs12'), '김미준', 20210408, '남성', '010-5555-5553' ),
('zzzz', password('zzzz12'), '홍유니', 19770405, '여성', '010-9741-5821');

select * from customer_information ci ;

-- 2
insert into customer_information values
(12001, '홍길동', 19770405, '010-9741-5821', '남성', 'aaaa');


insert into customer_information(cu_name, birth, phone, sex, ID) values
('김연수', 19850301, '010-4568-5581', '여성', 'bbbb'),
('김지원', 19860708, '010-9111-5556', '여성', 'cccc'),
('문희원', 19800108, '010-7777-7777', '여성', 'dddd'),
('유일한', 19790205, '010-4566-8886', '남성', 'eeee'),
('김동수', 19811123, '010-1231-1211', '남성', 'ffff'),
('배진태', 19820707, '010-7877-7777', '남성', 'gggg'),
('김이민', 20210409, '010-5555-5555', '남성', 'tkdrjs7'),
('김민한', 20210406, '010-8888-8888', '남성', 'tkdrjs'),
('김지연', 20210410, '010-9999-9999', '여성', 'dkdkdk'),
('김미준', 20210408, '010-5555-5553', '남성', 'dldigh');


select * from customer_information ci ;
-- 4
insert into sales_information values
(0001, '2012.03.24', 2, 12003,'PA');

insert into sales_information(date, order_num, cu_no, p_code) values
('2012.03.27', 1, 12001,'PA'),
('2012.04.13', 4, 12003,'PF'),
('2012.04.14', 3, 12002,'PE'),
('2012.04.15', 10, 12004,'PH'),
('2012.04.17', 7, 12005,'PG'),
('2012.04.19', 2, 12006,'PG'),
('2012.04.20', 9, 12007,'PA'),
('2012.04.20', 3, 12001,'PB'),
('2012.04.20', 2, 12005,'PD'),
('2012.04.20', 2, 12006,'PG'),
('2012.05.01', 7, 12003,'PB'),
('2020.04.26', 10, 12008,'PC'),
('2020.04.26', 5, 12008,'PF'),
('2020.04.26', 4, 12009,'PE'),
('2020.04.26', 10, 12010,'PC'),
('2020.04.25', 5, 12011,'PD'),
('2020.04.25', 4, 12011,'PG'),
('2021.04.24', 2, 12001,'PA'),
('2021.04.26', 10, 12002,'PB'),
('2021.04.24', 8, 12003,'PF'),
('2021.04.26', 2, 12004,'PB'),
('2021.04.24', 2, 12005,'PG'),
('2021.04.26', 1, 12006,'PH'),
('2021.04.24', 5, 12007,'PD'),
('2021.04.26', 1, 12008,'PF');
select * from customer_information ci ;
insert into sales_information (date, order_num, Id, p_code) values
(now(), 1, 'tkdrjs7','PA');
