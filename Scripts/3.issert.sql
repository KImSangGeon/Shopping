select user(), database();

desc product_information;
desc customer_information;
desc sales_information ;
desc sign_in ;

select * from sales_information ;
select * from customer_information;
select * from product_information;
select * from sign_in;


delete from product_information  
where p_code ='PA';

insert into product_information values
('PA', '책상', 10000, 3),
('PB', '냉장고', 36000, 5),
('PC', '세탁기', 22000, 2),
('PD', 'VTR', 30000, 6),
('PE', '자전거', 90000, 4),
('PF', '시계', 6000, 10),
('PG', 'TV', 8000, 5),
('PH', '탁자', 3000, 6);

delete from sign_in 
where id ='aaaa';

insert into sign_in values
('aaaa', 'aaaa12', '홍길동', 19770405, '남자', '010-9741-5821'),
('bbbb', 'bbbb12', '김연수', 19850301, '여자', '010-4568-5581'),
('cccc', 'cccc12', '김지원', 19860708, '여자', '010-9111-5556'),
('dddd', 'dddd12', '문희원', 19800108, '여자', '010-7777-7777'),
('eeee', 'eeee12', '유일한', 19790205, '남자', '010-4566-8886'),
('ffff', 'ffff12', '김동수', 19811123, '남자', '010-1231-1211'),
('gggg', 'gggg12', '배진태', 19820707, '남자', '010-7877-7777');

delete from customer_information 
where cu_no = 12001;

insert into customer_information values
(12001, '홍길동', 19770405, '010-9741-5821', '남자', 'aaaa'),
(12002, '김연수', 19850301, '010-4568-5581', '여자', 'bbbb'),
(12003, '김지원', 19860708, '010-9111-5556', '여자', 'cccc'),
(12004, '문희원', 19800108, '010-7777-7777', '여자', 'dddd'),
(12005, '유일한', 19790205, '010-4566-8886', '남자', 'eeee'),
(12006, '김동수', 19811123, '010-1231-1211', '남자', 'ffff'),
(12007, '배진태', 19820707, '010-7877-7777', '남자', 'gggg');

select * from sales_information si ;
delete from sales_information 
where order_no =1;


insert into sales_information values
(0001, '2012.03.24', 2, 12003,'PA'),
(0002, '2012.03.27', 1, 12001,'PA'),
(0005, '2012.04.13', 4, 12003,'PF'),
(0006, '2012.04.14', 3, 12002,'PE'),
(0007, '2012.04.15', 10, 12004,'PH'),
(0008, '2012.04.17', 7, 12005,'PG'),
(0009, '2012.04.19', 2, 12006,'PG'),
(0010, '2012.04.20', 9, 12007,'PA'),
(0011, '2012.04.20', 3, 12001,'PB'),
(0012, '2012.04.20', 2, 12005,'PD'),
(0013, '2012.04.20', 2, 12006,'PG'),
(0016, '2012.05.01', 7, 12003,'PB');

select * from sales_information;
desc sales_information ;
insert into sales_information(order_no,date) values
(20, '2021-04-18'),
(19, '2021-04-18'),
(18, '2021-04-18');
alter table sales_information modify order_no int not null auto_increment;
