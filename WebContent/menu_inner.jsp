<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<c:if test="${id == 'admin' }">
		<jsp:include page="menu_admin.jsp"/>
 	</c:if> 
	<div class="header__top">
		<div class="container-fluid">
        	<div class="row">
                <div class="col-lg-6 col-md-8 col-sm-6 col-xs-12 ">
                  <p></p>
               	</div>           	
				<c:choose>
					<c:when test="${id == null}">
						 <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
							<div class="header__actions"><a href="goodsCartListAction.go"> 장바구니</a> </div>
						 	<div class="header__actions"><a href="myOrderList.od"> 주문배송</a> </div>
						 	<div class="header__actions"><a href="memberMyPageAction.me"> 마이페이지</a> </div>
						 	<div class="header__actions"><a href="memberJoin.me"> 회원가입</a> </div>
						 	<div class="header__actions"><a href="memberLogin.me"> 로그인</a> </div>
		                </div>
					</c:when>
					<c:otherwise>
						 <div class="col-lg-6 col-md-4 col-sm-6 col-xs-12 ">
		               		<div class="header__actions"><a href="goodsCartListAction.go"> 장바구니</a> </div>
						 	<div class="header__actions"><a href="myOrderList.od"> 주문배송</a> </div>
						 	<div class="header__actions"><a href="memberMyPageAction.me"> 마이페이지</a> </div>
						 	<div class="header__actions"><a href="memberLogoutAction.me"> 로그아웃</a> </div>
		                 </div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	

</body>
</html>