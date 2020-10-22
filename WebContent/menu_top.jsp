<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<html lang="en">
  <head>
    <title>Sky - Homepage</title>
  </head>
  <body class="ps-loading">
      <div class="header--sidebar"></div>
    <header class="header">
        <jsp:include page="menu_inner.jsp"/>
       <nav class="navigation">
        <div class="container-fluid">
          <div class="navigation__column left">
            <div class="header__logo"><a class="ps-logo" href="goodsMainAction.go"><img src="images/logo.jpg" style="width:100%" alt=""></a></div>
          </div>
          <div class="navigation__column center">
                <ul class="main-menu menu">
                  <li class="menu-item menu-item-has-children dropdown"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('애플')">애플</a>
                        <ul class="sub-menu">
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('아이폰SE2%')">아이폰 SE2</a></li>
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('아이폰11%')">아이폰11</a></li>
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('아이폰XS%')">아이폰XS</a></li>
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('아이폰X%')">아이폰X</a></li>
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('아이폰XR%')">아이폰XR</a></li>
                        </ul>
                  </li>
                  <li class="menu-item menu-item-has-children dropdown"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('삼성')">삼성</a>
                          <ul class="sub-menu">
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('갤럭시S20%')">갤럭시S20</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('갤럭시S10%')">갤럭시S10</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('갤럭시노트20%')">갤럭시노트20</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('갤럭시노트10%')">갤럭시노트10</a></li>
                          </ul>
                  </li>
                  <li class="menu-item menu-item-has-children dropdown"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('LG')">LG</a>
                          <ul class="sub-menu">
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('벨벳%')">벨벳</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('V50%')">V50</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('G8')">G8</a></li>
                          </ul>
                  </li>
                  <li class="menu-item menu-item-has-children dropdown"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('기타')">기타</a>
                          <ul class="sub-menu">
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('베가LTA-A')">베가LTA-A</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('P30')">P30</a></li>
                            <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('비와이폰')">비와이폰</a></li>
                          </ul>
                  </li>
                  <li class="menu-item menu-item-has-children dropdown"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('폴더폰')">폴더폰</a>
                        <ul class="sub-menu">
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('삼성폴더폰')">삼성폴더폰</a></li>
                          <li class="menu-item"><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('엘지폴더폰')">엘지폴더폰</a></li>
                        </ul>
                  </li>
                <li class="menu-item menu-item-has-children dropdown"><a href="#">커뮤니티</a>
                        <ul class="sub-menu">
                          <li class="menu-item"><a href="notifyListAction.bo">공지사항</a></li>
                          <li class="menu-item"><a href="centerListAction.bo">고객센터</a></li>
                          <li class="menu-item"><a href="boardReviewList.bo">상품후기</a></li>
                        </ul>
                  </li>
                </ul>
          </div>
        </div>
      </nav>
    </header>
    <div class="header-services">
      <div class="ps-services owl-slider"  data-owl-gap="0"  data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1" data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000">
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with BoomCase</p>
      </div>
    </div>
  </body>
</html>