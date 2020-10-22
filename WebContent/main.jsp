<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 7]><html class="ie ie7"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="apple-touch-icon.png" rel="apple-touch-icon">
    <link href="favicon.png" rel="icon">
    <meta name="author" content="Nghia Minh Luong">
    <meta name="keywords" content="Default Description">
    <meta name="description" content="Default keyword">
    <title>뽐케이스</title>
    <!-- Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Archivo+Narrow:300,400,700%7CMontserrat:300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="plugins/ps-icon/style.css">
    <!-- CSS Library-->
    <link rel="stylesheet" href="plugins/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/owl-carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="plugins/jquery-bar-rating/dist/themes/fontawesome-stars.css">
    <link rel="stylesheet" href="plugins/slick/slick/slick.css">
    <link rel="stylesheet" href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="plugins/Magnific-Popup/dist/magnific-popup.css">
    <link rel="stylesheet" href="plugins/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="plugins/revolution/css/settings.css">
    <link rel="stylesheet" href="plugins/revolution/css/layers.css">
    <link rel="stylesheet" href="plugins/revolution/css/navigation.css">
    <!-- Custom-->
    <link rel="stylesheet" href="css/style.css">
    <!--HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries-->
    <!--WARNING: Respond.js doesn't work if you view the page via file://-->
    <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <!--[if IE 7]><body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
  <!--[if IE 8]><body class="ie8 lt-ie9 lt-ie10"><![endif]-->
  <!--[if IE 9]><body class="ie9 lt-ie10"><![endif]-->
  <body class="ps-loading">
     <div class="header--sidebar"></div>
    <header class="header">
        <jsp:include page="menu_inner.jsp"/>
       <nav class="navigation">
        <div class="container-fluid">
          <div class="navigation__column left">
            <div class="header__logo"><a class="ps-logo" href="goodsMainAction.go"><img src="images/logo.jpg" alt=""></a></div>
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
      <div class="ps-services owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="7000" data-owl-gap="0" data-owl-nav="true" data-owl-dots="false" data-owl-item="1" data-owl-item-xs="1" data-owl-item-sm="1" data-owl-item-md="1" data-owl-item-lg="1" data-owl-duration="1000" data-owl-mousedrag="on">
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with BoomCase</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with BoomCase</p>
        <p class="ps-service"><i class="ps-icon-delivery"></i><strong>Free delivery</strong>: Get free standard delivery on every order with BoomCase</p>
      </div>
    </div>
    <main class="ps-main">
      <div class="ps-banner">
        <div class="rev_slider fullscreenbanner" id="home-banner">
          <ul>
            <li class="ps-banner" data-index="rs-2972" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="images/banner-1.jpg" alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
            </li>
            <li class="ps-banner ps-banner--white" data-index="rs-100" data-transition="random" data-slotamount="default" data-hideafterloop="0" data-hideslideonmobile="off" data-rotate="0"><img class="rev-slidebg" src="images/banner-2.jpg" alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" data-no-retina>
            </li>
          </ul>
        </div>
      </div>
      <div class="ps-section--features-product ps-section masonry-root pt-100 pb-100">
        <div class="ps-container">
          <div class="ps-section__header mb-50">
            <h3 class="ps-section__title" data-mask="features">- Features Products</h3>
            <ul class="ps-masonry__filter">
              <li class="current"><a href="#" data-filter="*">All</a></li>
              <li><a href="#" data-filter=".nike">애플</a></li>
              <li><a href="#" data-filter=".adidas">삼성</a></li>
              <li><a href="#" data-filter=".men">LG</a></li>
              <li><a href="#" data-filter=".women">기타</a></li>
              <li><a href="#" data-filter=".kids">폴더폰</a></li>
            </ul>
          </div>
          <div class="ps-section__content pb-50">
            <div class="masonry-wrapper" data-col-md="4" data-col-sm="2" data-col-xs="1" data-gap="30" data-radio="100%">
              <div class="ps-masonry">
                <div class="grid-sizer"></div>
                <c:forEach var="list" items="${goodsAllList }">   
                <c:if test="${list.goo_category == '애플' }">
                <div class="grid-item nike">
 				</c:if>
 				<c:if test="${list.goo_category == '삼성' }">
                <div class="grid-item adidas">
 				</c:if>
 				<c:if test="${list.goo_category == 'LG' }">
                <div class="grid-item men">
 				</c:if>
 				<c:if test="${list.goo_category == '기타' }">
                <div class="grid-item women">
 				</c:if>
 				<c:if test="${list.goo_category == '폴더폰' }">
                <div class="grid-item kids">
 				</c:if>
                      <a class="ps-shoe__overlay" href="goodsViewAction.go?goo_name=${list.goo_name }&goo_id=${list.goo_id}"><img src="images/${list.goo_image}" alt="" width="300" height="300"></a>
                      <div class="ps-shoe__content">
                        <div class="ps-shoe__detail"><a class="ps-shoe__name" href="goodsViewAction.go?goo_name=${list.goo_name }&goo_id=${list.goo_id}">${list.goo_name}</a>
                          <p class="ps-shoe__categories"><a href="goodsListAction.go?goo_category=${list.goo_category }">${list.goo_category}</a>,<a href="goodsListAction.go?goo_model=${list.goo_model}">${list.goo_model}</a></p><span class="ps-shoe__price">
                            ${list.goo_price}<br><br></span>
                        </div>
                      </div>
                 </div>
               </c:forEach>           
              </div>
            </div>
          </div>
        </div>
      <div class="ps-section--sale-off ps-section pt-80 pb-40">
        <div class="ps-container">
          <div class="ps-section__header mb-50">
            <h3 class="ps-section__title" data-mask="Sale off">- Hot Deal Today</h3>
          </div>
          <div class="ps-section__content">
            <div class="row">
                  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
                    <div class="ps-hot-deal">
                      <h3>Nike DUNK Max 95 OG</h3>
                      <p class="ps-hot-deal__price">Only:  <span>£155</span></p>
                      <ul class="ps-countdown" data-time="December 13, 2017 15:37:25">
                        <li><span class="hours"></span><p>Hours</p></li>
                        <li class="divider">:</li>
                        <li><span class="minutes"></span><p>minutes</p></li>
                        <li class="divider">:</li>
                        <li><span class="seconds"></span><p>Seconds</p></li>
                      </ul><a class="ps-btn" href="#">Order Today<i class="ps-icon-next"></i></a>
                    </div>
                  </div>
                  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12 ">
                    <div class="ps-hotspot"><a class="point first active" href="javascript:;"><i class="fa fa-plus"></i>
                        <div class="ps-hotspot__content">
                          <p class="heading">JUMP TO HEADER</p>
                          <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
                        </div></a><a class="point second" href="javascript:;"><i class="fa fa-plus"></i>
                        <div class="ps-hotspot__content">
                          <p class="heading">JUMP TO HEADER</p>
                          <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
                        </div></a><a class="point third" href="javascript:;"><i class="fa fa-plus"></i>
                        <div class="ps-hotspot__content">
                          <p class="heading">JUMP TO HEADER</p>
                          <p>Dynamic Fit Collar en la zona del tobillo que une la parte inferior de la pierna y el pie sin reducir la libertad de movimiento.</p>
                        </div></a><img src="images/hot-deal.png" alt=""></div>
                  </div>
            </div>
          </div>
        </div>
      </div>
      <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
        <div class="ps-container">
          <div class="ps-section__header mb-50">
            <div class="row">
                  <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
                    <h3 class="ps-section__title" data-mask="BEST">- Best Products</h3>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                    <div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
                  </div>
            </div>
          </div>
          <div class="ps-section__content">
            <div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1" data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000" data-owl-mousedrag="on">
              <c:forEach var="rank" items="${goodsRankList}" begin="0" end="6"> 
              <div class="ps-shoes--carousel">
                    <a class="ps-shoe__overlay" href="goodsViewAction.go?goo_name=${news.goo_name }&goo_id=${news.goo_id}"><img src="images/${rank.goo_image}" alt=""></a>
                    <a class="ps-shoe__name" href="goodsViewAction.go?goo_name=${rank.goo_name }&goo_id=${rank.goo_id}"">${rank.goo_name }</a>
                      <p class="ps-shoe__categories"><a href="goodsListAction.go?goo_category=${rank.goo_category }">${rank.goo_category }</a>,<a href="goodsListAction.go?goo_category=${rank.goo_category }">${rank.goo_model }</a></p><span class="ps-shoe__price">${rank.goo_price }</span>
              </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
      <div class="ps-section ps-section--top-sales ps-owl-root pt-80 pb-80">
        <div class="ps-container">
          <div class="ps-section__header mb-50">
            <div class="row">
                  <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 ">
                    <h3 class="ps-section__title" data-mask="New">- New Products</h3>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                    <div class="ps-owl-actions"><a class="ps-prev" href="#"><i class="ps-icon-arrow-right"></i>Prev</a><a class="ps-next" href="#">Next<i class="ps-icon-arrow-left"></i></a></div>
                  </div>
            </div>
          </div>
          <div class="ps-section__content">
            <div class="ps-owl--colection owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="30" data-owl-nav="false" data-owl-dots="false" data-owl-item="4" data-owl-item-xs="1" data-owl-item-sm="2" data-owl-item-md="3" data-owl-item-lg="4" data-owl-duration="1000" data-owl-mousedrag="on">
              <c:forEach var="news" items="${goodsNewList}" begin="0" end="6"> 
              <div class="ps-shoes--carousel">
                    <a class="ps-shoe__overlay" href="goodsViewAction.go?goo_name=${news.goo_name }&goo_id=${news.goo_id}"><img src="images/${news.goo_image}" alt=""></a>
                    <a class="ps-shoe__name" href="goodsViewAction.go?goo_name=${news.goo_name }&goo_id=${news.goo_id}">${news.goo_name }</a>
                      <p class="ps-shoe__categories"><a href="goodsListAction.go?goo_category=${news.goo_category }">${news.goo_category }</a>,<a href="goodsListAction.go?goo_category=${news.goo_category }">${news.goo_model }</a></p><span class="ps-shoe__price">${news.goo_price }</span>
              </div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
      <div class="ps-footer bg--cover" data-background="images/background/parallax.jpg">
        <div class="ps-footer__content">
          <div class="ps-container">
            <div class="row">
                  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--info">
                      <header><a class="ps-logo" href="goodsMainAction.go"><img src="images/logo.jpg" alt=""></a>
                        <h3 class="ps-widget__title">Address Office 1</h3>
                      </header>
                      <footer>
                        <p><strong>460 West 34th Street, 15th floor, New York</strong></p>
                        <p>Email: <a href='mailto:support@store.com'>support@store.com</a></p>
                        <p>Phone: +323 32434 5334</p>
                        <p>Fax: ++323 32434 5333</p>
                      </footer>
                    </aside>
                  </div>
                  <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--info second">
                      <header>
                        <h3 class="ps-widget__title">Address Office 2</h3>
                      </header>
                      <footer>
                        <p><strong>PO Box 16122 Collins  Victoria 3000 Australia</strong></p>
                        <p>Email: <a href='mailto:support@store.com'>support@store.com</a></p>
                        <p>Phone: +323 32434 5334</p>
                        <p>Fax: ++323 32434 5333</p>
                      </footer>
                    </aside>
                  </div>
                  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--link">
                      <header>
                        <h3 class="ps-widget__title">Find Our store</h3>
                      </header>
                      <footer>
                        <ul class="ps-list--link">
                          <li><a href="#">Coupon Code</a></li>
                          <li><a href="#">SignUp For Email</a></li>
                          <li><a href="#">Site Feedback</a></li>
                          <li><a href="#">Careers</a></li>
                        </ul>
                      </footer>
                    </aside>
                  </div>
                  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--link">
                      <header>
                        <h3 class="ps-widget__title">Get Help</h3>
                      </header>
                      <footer>
                        <ul class="ps-list--line">
                          <li><a href="#">Order Status</a></li>
                          <li><a href="#">Shipping and Delivery</a></li>
                          <li><a href="#">Returns</a></li>
                          <li><a href="#">Payment Options</a></li>
                          <li><a href="#">Contact Us</a></li>
                        </ul>
                      </footer>
                    </aside>
                  </div>
                  <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 ">
                    <aside class="ps-widget--footer ps-widget--link">
                      <header>
                        <h3 class="ps-widget__title">Products</h3>
                      </header>
                      <footer>
                        <ul class="ps-list--line">
                          <li><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('애플')">Apple</a></li>
                          <li><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('삼성')">SamSung</a></li>
                          <li><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('LG')">LG</a></li>
                          <li><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('기타')">The Rest</a></li>
                          <li><a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_category='+encodeURI('폴더폰')">Folder</a></li>
                        </ul>
                      </footer>
                    </aside>
                  </div>
            </div>
          </div>
        </div>
        <div class="ps-footer__copyright">
          <div class="ps-container">
            <div class="row">
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 ">
                    <p>&copy; <a href="#">SKYTHEMES</a>, Inc. All rights Resevered. Design by <a href="#"> Alena Studio</a></p>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 ">
                    <ul class="ps-social">
                      <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                      <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                      <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                      <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                    </ul>
                  </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <!-- JS Library-->
    <script type="text/javascript" src="plugins/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="plugins/jquery-bar-rating/dist/jquery.barrating.min.js"></script>
    <script type="text/javascript" src="plugins/owl-carousel/owl.carousel.min.js"></script>
    <script type="text/javascript" src="plugins/gmap3.min.js"></script>
    <script type="text/javascript" src="plugins/imagesloaded.pkgd.js"></script>
    <script type="text/javascript" src="plugins/isotope.pkgd.min.js"></script>
    <script type="text/javascript" src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="plugins/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="plugins/slick/slick/slick.min.js"></script>
    <script type="text/javascript" src="plugins/elevatezoom/jquery.elevatezoom.js"></script>
    <script type="text/javascript" src="plugins/Magnific-Popup/dist/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="plugins/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAx39JFH5nhxze1ZydH-Kl8xXM3OK4fvcg&amp;region=GB"></script><script type="text/javascript" src="plugins/revolution/js/jquery.themepunch.tools.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
<script type="text/javascript" src="plugins/revolution/js/extensions/revolution.extension.actions.min.js"></script>
    <!-- Custom scripts-->
    <script type="text/javascript" src="js/main.js"></script>
  </body>
</html>