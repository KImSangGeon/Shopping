select * from product_information pi2 ;

delete from product_information where p_code = 'pz';


select date, cu_no, p_code, p_name, order_num, price, Total_Sales, Profit_Cost
 from vw_shoppingmall; 
--  고객 구매 검색
select p_code, p_name, order_num , price, Customer_Price from vw_shoppingmall where id = 'aaaa'; 

select * from vw_shoppingmall ;

delete from sales_information where order_no = 27;

select * from sign_in si  ;

select ID, password, name, birth, sex, phone from sign_in si where id = 'tkdrjs8' and password = password('tkdrjs12');

delete from customer_information where id = 'tttt';

select ID, cu_name, birth, sex , phone from customer_information ci ;
select * from sign_in si ;
insert into sign_in values
('pppp', password('pppp12'), '김진이', 20010403, '여성', '010-4422-3313');

insert into customer_information(ID, cu_name, birth, sex , phone) values
('tttt', '김민지', 20000403, '여성', '010-4444-3333');


-- '김진이', 20010403,'010-4422-3313', '여성','pppp'
select * from customer_information ci ;
select  *from sign_in ;
delete from sign_in where name = '김진';
delete from customer_information where id = 'dkflfkd';

select p_name , price, stock, Customer_Price from vw_shoppingmall where p_code ='pa' ;