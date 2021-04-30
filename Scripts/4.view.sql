    
   create or replace view vw_shoppingmall as
   select 
   si.date, si.order_num, 
   si.order_no, si.p_code, 
   ci.cu_no, ci.cu_name, 
   ci.phone, ci.ID,
   pi.p_name, pi.price, pi.stock, pi.propic,
   (pi.price * si.order_num) as Customer_Price,
   (pi.price * si.order_num) *1.1 as Total_Sales,
   ((pi.price * si.order_num)* 1.1) - (pi.price * si.order_num) as Profit_Cost
   from sales_information si join customer_information ci on si.cu_no = ci.cu_no 
   join product_information pi on si.p_code = pi.p_code; 
   
  select * from sales_information si ;
  select * from vw_shoppingmall ;
 select * from sales_information si;
  
-- 메인화면(고객)
 select date, cu_no, order_no, ID, cu_name, phone, p_code, order_num, Total_Sales
 from vw_shoppingmall; 

-- 제품별 조회(제품)
 select date, cu_no, p_code, p_name, order_num, price, Total_Sales, Profit_Cost
 from vw_shoppingmall; 
 
-- 상세 조회(세일즈)
 select order_no, date, p_code, p_name, ID, cu_no, cu_name, order_num, price, Total_Sales, Profit_Cost
 from vw_shoppingmall; 
 
select  date, cu_no, p_code, p_name, order_num, price, Total_Sales, Profit_Cost from vw_shoppingmall;

select date, cu_no, p_code, p_name, order_num, price, Total_Sales, Profit_Cost from vw_shoppingmall where p_name = '자전거';

select date, cu_no, p_code, p_name, order_num,"
				+ " price, Total_Sales, Profit_Cost"
				+ "	from vw_shoppingmall where p_name = '자전거';
			
			select date, order_no, p_code, p_name, id, cu_no, cu_name, order_num, price, Total_Sales, Profit_Cost 
 from vw_shoppingmall where cu_name = '홍길동' and p_name = '냉장고';


select date, order_no, p_code, p_name, id, cu_no, cu_name, order_num, price, Total_Sales, Profit_Cost 
				from vw_shoppingmall where p_name = '책상' and cu_name = '김지원'; 
			
select ID, password, name, birth, phone, sex, from sign_in ;
select * from sign_in si;


select p_code, p_name, order_num, price,  Customer_Price from vw_shoppingmall;