-- 쇼핑몰프로젝트
DROP SCHEMA IF EXISTS shoppingmall_prj;

-- 쇼핑몰프로젝트
CREATE SCHEMA shoppingmall_prj;

-- 제품정보
CREATE TABLE shoppingmall_prj.product_information (
	p_code VARCHAR(13) NOT NULL COMMENT '제품코드', -- 제품코드
	p_name VARCHAR(30) NULL     COMMENT '제품명', -- 제품명
	price  INTEGER     NULL     COMMENT '단가', -- 단가
	stock  INTEGER     NULL     COMMENT '재고' -- 재고
)
COMMENT '제품정보';

-- 제품정보
ALTER TABLE shoppingmall_prj.product_information
	ADD CONSTRAINT PK_product_information -- 제품정보 기본키
		PRIMARY KEY (
			p_code -- 제품코드
		);

-- 회원정보
CREATE TABLE shoppingmall_prj.customer_information (
	cu_no   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
	cu_name VARCHAR(30) NULL     COMMENT '회원명', -- 회원명
	birth   DATE        NULL     COMMENT '생년월일', -- 생년월일
	phone   VARCHAR(30) NULL     COMMENT '휴대전화', -- 휴대전화
	sex     VARCHAR(10) NULL     COMMENT '성별', -- 성별
	ID      VARCHAR(50) NULL     COMMENT '아이디' -- 아이디
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE shoppingmall_prj.customer_information
	ADD CONSTRAINT PK_customer_information -- 회원정보 기본키
		PRIMARY KEY (
			cu_no -- 회원번호
		);

-- 판매내역
CREATE TABLE shoppingmall_prj.sales_information (
	order_no  INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	date      DATE        NULL     COMMENT '날짜', -- 날짜
	order_num INTEGER     NULL     COMMENT '주문수량', -- 주문수량
	cu_no     INTEGER     NULL     COMMENT '회원번호', -- 회원번호
	p_code    VARCHAR(13) NULL     COMMENT '제품코드' -- 제품코드
)
COMMENT '판매내역';

-- 판매내역
ALTER TABLE shoppingmall_prj.sales_information
	ADD CONSTRAINT PK_sales_information -- 판매내역 기본키
		PRIMARY KEY (
			order_no -- 주문번호
		);

-- 회원가입
CREATE TABLE shoppingmall_prj.sign_in (
	ID       VARCHAR(50) NOT NULL COMMENT '아이디', -- 아이디
	password VARCHAR(55) NULL     COMMENT '비밀번호', -- 비밀번호
	name     VARCHAR(30) NULL     COMMENT '이름', -- 이름
	birth    DATE        NULL     COMMENT '생년월일', -- 생년월일
	sex      VARCHAR(10) NULL     COMMENT '성별', -- 성별
	phone    VARCHAR(30) NULL     COMMENT '휴대전화' -- 휴대전화
)
COMMENT '회원가입';

-- 회원가입
ALTER TABLE shoppingmall_prj.sign_in
	ADD CONSTRAINT PK_sign_in -- 회원가입 기본키
		PRIMARY KEY (
			ID -- 아이디
		);

-- 회원정보
ALTER TABLE shoppingmall_prj.customer_information
	ADD CONSTRAINT FK_sign_in_TO_customer_information -- 회원가입 -> 회원정보
		FOREIGN KEY (
			ID -- 아이디
		)
		REFERENCES shoppingmall_prj.sign_in ( -- 회원가입
			ID -- 아이디
		);

-- 판매내역
ALTER TABLE shoppingmall_prj.sales_information
	ADD CONSTRAINT FK_customer_information_TO_sales_information -- 회원정보 -> 판매내역
		FOREIGN KEY (
			cu_no -- 회원번호
		)
		REFERENCES shoppingmall_prj.customer_information ( -- 회원정보
			cu_no -- 회원번호
		);

-- 판매내역
ALTER TABLE shoppingmall_prj.sales_information
	ADD CONSTRAINT FK_product_information_TO_sales_information -- 제품정보 -> 판매내역
		FOREIGN KEY (
			p_code -- 제품코드
		)
		REFERENCES shoppingmall_prj.product_information ( -- 제품정보
			p_code -- 제품코드
		);