select p_code,p_name,price,stock from product_information;

select p_code,p_name,price,stock from product_information where p_code = "pb";

insert into product_information values
("PI", "드론", 3000000, 4);

delete from product_information where p_code = "PI";

update product_information set p_name = "킥보드", price = 40000, stock =3 where p_code ="PI";

select * from customer_information;
select * from sign_in;

insert into sign_in values
('hhhh', 'hhhh12', '김수준', '1999-06-05', '남자', '010-3302-1982');

delete from sign_in where id= 'hhhh';

select cu_no,cu_name,birth,phone,sex,ID from customer_information;

select cu_no,cu_name,birth,phone,sex,ID from customer_information where cu_no =12001;

insert into customer_information values
(12008, '김미지', '1988-08-08', '010-3321-1920', '여자', 'hhhh');

delete from customer_information where cu_no =12008;


update customer_information set =  where;
select order_no, date, order_num, cu_no, p_code from sales_information si;

select order_no, date, order_num, cu_no, p_code from sales_information where order_no =3;

select date, order_no, cu_no, ID, cu_name, phone, p_code, order_num, Total_Sales from vw_shoppingmall;


select date, order_no, cu_no, ID, cu_name, phone, p_code, order_num, Total_Sales from vw_shoppingmall where date =?;

 select date, cu_no, p_code, p_name, order_num, price, Total_Sales, Profit_Cost from vw_shoppingmall where p_code ='PA'; 
 
select order_no, date, p_code, p_name, ID, cu_no, cu_name, order_num, price, Total_Sales, Profit_Cost
 from vw_shoppingmall where cu_no =12001 and p_code ='PA';