$(document).ready(function () {
    var main = $('.bxslider').bxSlider({
        auto: true,	//자동으로 슬라이드
        controls: true,	//좌우 화살표
        autoControls: true,	//stop,play
        pager: false,	//페이징
        pause: 3000,
        autoDelay: 0,
        slideWidth: 210, //이미지 박스 크기설정
        speed: 500,
        startAutoOnclick: true,
        stopAutoOnclick: true,
        minSlides: 1,
        maxSlides: 3,
        slideMargin: 10,
        moveSlides: 1,
        reloadSlider: true,
        responsive: true

    });

    $(".bx-stop").click(function () {	// 중지버튼 눌렀을때
        main.stopAuto();
        $(".bx-stop").hide();
        $(".bx-start").show();
        return false;
    });

    $(".bx-start").click(function () {	//시작버튼 눌렀을때
        main.startAuto();
        $(".bx-start").hide();
        $(".bx-stop").show();
        return false;
    });

    $(".bx-start").hide();	//onload시 시작버튼 숨김.

});