$(document)
		.ready(
				function() {

					$("#list").css('color', 'red');				
					var clockTarget = document.getElementById("clock");

					function clock() {
						var date = new Date();
						var year = date.getFullYear();
						var month = date.getMonth();
						var clockDate = date.getDate();
						var day = date.getDay();
						var week = [ '일', '월', '화', '수', '목', '금', '토' ];
						clockTarget.innerText = `${year}년 ${month+1}월 ${clockDate}일 ${week[day]}요일`
								+ ' 기준';
					}
					function init() {
						clock();
						// setInterval(clock, 1000);
					}
					init();

					var main = $('.bxslider').bxSlider({
						auto : true, // 자동으로 슬라이드
						controls : true, // 좌우 화살표
						autoControls : true, // stop,play
						pager : false, // 페이징
						pause : 3000,
						autoDelay : 0,
						slideWidth : 210, // 이미지 박스 크기설정
						speed : 500,
						startAutoOnclick : true,
						stopAutoOnclick : true,
						minSlides : 1,
						maxSlides : 3,
						slideMargin : 10,
						moveSlides : 1,
						reloadSlider : true,
						responsive : true
					});

					var second = $('.bxslider2').bxSlider({
						// auto: true, //자동으로 슬라이드
						controls : false, // 좌우 화살표
						// autoControls: true, //stop,play
						pager : true, // 페이징
						// pause: 3000,
						// autoDelay: 0,
						slideWidth : 500, // 이미지 박스 크기설정
						// speed: 500,
						// startAutoOnclick: true,
						// stopAutoOnclick: true,
						minSlides : 1,
						maxSlides : 2,
						slideMargin : 20,
						moveSlides : 3,
						reloadSlider : true,
						responsive : true,
						captions : true
					});

					$(".bx-stop").click(function() { // 중지버튼 눌렀을때
						main.stopAuto();
						$(".bx-stop").hide();
						$(".bx-start").show();
						return false;
					});

					$(".bx-start").click(function() { // 시작버튼 눌렀을때
						main.startAuto();
						$(".bx-start").hide();
						$(".bx-stop").show();
						return false;
					});

					$(".bx-start").hide(); // onload시 시작버튼 숨김.

					// $('.event').hover(function () {
					// $('event').c
					// }, function () {
					// alert("Bye");
					//
					// });

					$('#roll_list').vTicker({
						margin : 10,
						speed : 1000,
						pause : 1000
					});
					
					$('#pause').click(function() {
						$this = $(this);
						if ($this.text() == 'Pause') {
							$('#roll_list').vTicker('pause', true);
							$this.text('Unpause');
						} else {
							$('#roll_list').vTicker('pause', false);
							$this.text('Pause');
						}
					});

				});
