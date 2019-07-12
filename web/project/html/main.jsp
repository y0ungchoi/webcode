<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="com.hk.th.dao.*"%>
<%@ page import="com.hk.th.vo.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css">

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="../js/jquery.vticker.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<div class="inner">
			<div class="sign">
				<button id="signUp" class="btn" onclick="location.href='join.html'">SignUp</button>
				<button id="signIn" class="btn" onclick="location.href='login.html'">SignIn</button>
			</div>
			<div class="header">
				<a href="#"> <img src="../images/momasil_logo.png" /></a>
				<p>모마실래?</p>
				<fieldset class="main_search">
					<form method="get" action="searchrst.jsp">
						<input id="main_search" name="shr" type="text"
							placeholder="음료명, 재료 또는 브랜드"> <input id="search_btn"
							class="btn" type="submit" value="검색">
					</form>
				</fieldset>
			</div>
		</div>
	</header>
	<!-- header: END -->
	<div id="wrap">
		<div class="left">
			<h3>BRAND NEW</h3>
			<div class="bxslider">
				<div class="slide">
					<a href="#"><img src="../images/신메뉴1.PNG" /></a>
				</div>
				<div class="slide">
					<a href="#"><img src="../images/신메뉴2.PNG" /></a>
				</div>
				<div class="slide">
					<a href="#"><img src="../images/신메뉴3.PNG" /></a>
				</div>
				<div class="slide">
					<a href="#"><img src="../images/신메뉴5.PNG" /></a>
				</div>
				<div class="slide">
					<a href="#"><img src="../images/신메뉴6.PNG" /></a>
				</div>
			</div>
			<div class="notice">
				<p>NOTICE</p>
				<div class="example" id="roll_list">
					<ul>
						<li>!리뷰이벤트! 리뷰 5개 작성시 음료 기프티콘을 드립니다.</li>
						<li>!리뷰이벤트! 리뷰 50개 작성시 음료 기프티콘을 드립니다.</li>
						<li>!리뷰이벤트! 리뷰 500개 작성시 음료 기프티콘을 드립니다.</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="right">
			<h3>인기메뉴</h3>
			<div class="rolling">
				<ul id="list">
					<%
						ReviewDao revdao = new ReviewDao();
						ArrayList list = revdao.mainrank();
						
						for (int i = 0; i < 10; i++) {
							EmpVo result = (EmpVo) list.get(i);
							out.println("<li>" + result.getId() + "</li>");
						}

					%>
				</ul>
			</div>
			<p id="clock">00:00</p>
		</div>
		<div class="bottom">
			<h3>이벤트</h3>
			<div class="inner">
				<div class="bxslider2">
					<div class="event">
						<a
							href="http://www.istarbucks.co.kr/whats_new/campaign_view.do?pro_seq=1584&menu_cd="><img
							title="스타벅스 이벤트" src="../images/SB_EV.PNG" /></a>
					</div>
					<div class="event">
						<a href="https://www.yogerpresso.co.kr/"><img
							title="요거프레소 이벤트" src="../images/YP_EV.PNG" /></a>
					</div>
					<div class="event">
						<a
							href="https://www.ediya.com/contents/event.html?tb_name=event&bbs_section=view&Ctg=&page=1&idx=98"><img
							title="이디야 이벤트" src="../images/ED_EV.PNG" /></a>
					</div>
					<div class="event">
						<a
							href="https://www.twosome.co.kr:7009/event/view.asp?idx=400&queryString="><img
							title="투썸플레이스 이벤트" src="../images/TS_EV.PNG" /></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- wrap: END -->
	<footer class="footer">
		<ul>
			<li><strong>Momasil</strong></li>
			<li><strong>고객센터 / 광고문의 </strong>: 010-0000-0000 | <strong>이메일</strong>
				: cs@momasil.com</li>
			<li>copyright &copy;Momasil. All Rights Reserved</li>
		</ul>
	</footer>
	<!-- footer: END -->

	<script src="../js/main.js">
		$(function() {
			$('.example').vTicker();
		});
	</script>
</body>
</html>