<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="ps-loading">
	<c:choose>
		<c:when test="${categoryList != null }">
			<h2 align="center">Product List</h2>
		 	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 상품리스트</p>
			<hr><br>
			
			<main class="ps-main">
	            <div class="ps-product__columns">
	           	<c:forEach var="category" items="${categoryList }">
		            <div class="ps-product__column" align="center" >
		                <div class="ps-shoe__thumbnail">
		                  <a class="ps-shoe__favorite" href="goodsViewAction.go?goo_name=${category.goo_name}&goo_id=${category.goo_id}"><img src="images/${category.goo_image}" alt="" width="300" height="300px"></a>
		                </div>
		                <div class="ps-shoe__content">
		                  <div class="ps-shoe__detail"><a class="ps-shoe__name" href="goodsViewAction.go?goo_name=${goods.goo_name }&goo_id=${goods.goo_id}">${category.goo_name }</a>
		                    <p class="ps-shoe__categories"><a href="#">${category.goo_category}</a>,<a href="goodsListAction.go?goo_model=${category.goo_model}">${category.goo_model}</a><br><br>
		                    <span class="ps-shoe__price">${category.goo_price}</span><br><br><br><br>
		                  </div>
		                </div>
		            </div>
	            </c:forEach>
	          </div>
	          
			<c:if test="${categoryList = null}">
				<h2 align="center">Product List</h2>
				<hr>
				<p align="center"> 상품목록이 없습니다</p>
			</c:if>
			
			</main>	
		</c:when>
		
		<c:otherwise>
		<main class="ps-main">
		 	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 상품리스트</p>
			<h2 align="center">Product List</h2>
			<hr>
	            <div class="ps-product__columns">
	           	<c:forEach var="goods" items="${goodsList }">
		            <div class="ps-product__column" align="center" >
		                <div class="ps-shoe__thumbnail">
		                  <a class="ps-shoe__favorite" href="goodsViewAction.go?goo_name=${goods.goo_name}&goo_id=${goods.goo_id}"><img src="images/${goods.goo_image}" alt="" width="300" height="300px"></a>
		                </div>
		                <div class="ps-shoe__content">
		                  <div class="ps-shoe__detail"><a class="ps-shoe__name" href="goodsViewAction.go?goo_name=${goods.goo_name }&goo_id=${goods.goo_id}">${goods.goo_name }</a>
		                    <p class="ps-shoe__categories"><a href="#">${goods.goo_category}</a>,<a href="goodsListAction.go?goo_model=${goods.goo_model}">${goods.goo_model}</a><br><br>
		                    <span class="ps-shoe__price">${category.goo_price}</span><br><br><br><br>
		                  </div>
		                </div>
		            </div>
	            </c:forEach>
	          </div>
	          
			<c:if test="${goodsList = null}">
				<h2 align="center">Product List</h2>
				<hr>
				<p align="center"> 상품목록이 없습니다</p>
			</c:if>
		</main>
		</c:otherwise>
	</c:choose>
</body>
</html>