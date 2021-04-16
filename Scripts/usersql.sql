
	-- 계정 권한 부여
	grant all 
	on shoppingmall_prj.* 
	to 'user_shopping'@'localhost'identified by 'rootroot';

grant File 
on *.*
to 'user_shopping'@'localhost';

select * from customer_information ;



create or replace
algorithm = UNDEFINED view `shopping_mall_project`.`vw_shoppingmall` as
select
    `si`.`date` as `date`,
    `si`.`order_num` as `order_num`,
    `si`.`order_no` as `order_no`,
    `ci`.`cu_no` as `cu_no`,
    `ci`.`cu_name` as `cu_name`,
    `ci`.`phone` as `phone`,
    `si`.`p_code` as `p_code`,
    `pi`.`p_name` as `p_name`,
    `pi`.`price` as `price`,
    ((`pi`.`price` * `si`.`order_num`) * 1.1) as `Total_Sales`,
    (((`pi`.`price` * `si`.`order_num`) * 1.1) - (`pi`.`price` * `si`.`order_num`)) as `Profit_Cost`
from
    ((`shopping_mall_project`.`sales_information` `si`
join `shopping_mall_project`.`customer_information` `ci` on
    ((`si`.`cu_no` = `ci`.`cu_no`)))
join `shopping_mall_project`.`product_information` `pi` on
    ((`si`.`p_code` = `pi`.`p_code`)))