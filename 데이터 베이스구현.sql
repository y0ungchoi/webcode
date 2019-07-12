
CREATE TABLE product (
	prod_no   INT       NOT NULL AUTO_INCREMENT PRIMARY KEY, -- 제품번호
	prod_nmk  VARCHAR(50) NOT NULL, -- 제품명(한)
	bnm       VARCHAR(50) NOT NULL, -- 브랜드명
	price     INT       NULL,     -- 가격
	cal       INT       NOT NULL, -- 칼로리
	prod_info TEXT      NOT NULL, -- 제품설명
	prod_img  VARCHAR(50) NOT NULL, -- 제품 이미지
	caffeine  CHAR      NOT NULL DEFAULT 'Y', -- 카페인
	milk      CHAR      NOT NULL DEFAULT 'N', -- 우유
	gluten    CHAR      NOT NULL DEFAULT 'N', -- 밀
	soy       CHAR      NOT NULL DEFAULT 'N', -- 대두
	etc       VARCHAR(50) NULL     DEFAULT 'N' -- 기타
);

CREATE TABLE member (
	mid     VARCHAR(50) NOT NULL primary key, -- 아이디
	pw      VARCHAR(100) NOT NULL, -- 비밀번호
	mnm     VARCHAR(50) NOT NULL, -- 이름
	nknm    VARCHAR(50) NULL,     -- 닉네임
	gd      VARCHAR(40) NOT NULL, -- 성별
	bd      VARCHAR(50) NOT NULL, -- 생년월일
	email   VARCHAR(40) NOT NULL, -- 이메일
	mimg    VARCHAR(50) NULL,     -- 이미지
	regdate DATE      NOT NULL  -- 가입일자
);


CREATE TABLE review (
	rev_no      INT       NOT NULL AUTO_INCREMENT PRIMARY KEY, -- 리뷰번호
	prod_no     INT       NOT NULL, -- 제품번호
	mid         VARCHAR(50) NOT NULL, -- 작성자ID
	rev_content TEXT      NOT NULL, -- 리뷰내용
	rev_date    DATE      NOT NULL, -- 작성날짜
	prod_rating INT       NOT NULL, -- 제품평가
	rev_rating  INT       NULL,     -- 리뷰평가
	rev_photo   VARCHAR(50) NULL      -- 리뷰이미지
);


CREATE TABLE rev_report (
	rev_no     INT       NOT NULL  PRIMARY KEY, -- 리뷰번호
	mid        VARCHAR(50) NOT NULL, -- 신고자ID
	rr_date    DATE      NOT NULL, -- 날짜
	rr_content TEXT      NOT NULL  -- 내용
);

CREATE TABLE brand (
	bnm   VARCHAR(50) NOT NULL primary key, -- 브랜드명
	bnm_k VARCHAR(50) NOT NULL, -- 브랜드명(한)
	bimg  VARCHAR(50) NOT NULL  -- 브랜드 이미지
);

CREATE TABLE prod_report (
	prod_no    INT       NOT NULL PRIMARY KEY, -- 제품번호
	mid        VARCHAR(50) NOT NULL, -- 신고자IDproduct
	pr_date    DATE      NOT NULL, -- 날짜
	pr_content TEXT      NOT NULL  -- 내용
);

