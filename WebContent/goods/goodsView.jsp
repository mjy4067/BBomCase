<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 페이지</title>
<script>
	function OneOrder(){
		document.view.action="orderForm.od?type=one";
		document.view.method="post";
		document.view.submit();
	}
	
	function check(c){
		var color = c.goo_color.value;
		
		if(color.trim() == "none"){
			alert("색상을 선택하세요");
			c.goo_color.focus();
			return false;
		}
		
		var qty = document.getElementById("sto_qty").value;
		var reg_qty = /^[1-9]{1}$|^10$/;
		
		if(!reg_qty.test(qty)){
			alert("1개이상 10개 이하만 가능합니다.");
			c.sto_qty.focus();
			return false;
		}
	}
	
</script>
</head>
<body class="ps-loading">
    <h2 align="center">Product Guide</h2><p style="float: right; font-size: 12px; margin-right:100px;"><a href="goodsMainAction.go">홈</a> > <a href="javascript:void(0);" onclick="location.href='goodsListAction.go?goo_model='+encodeURI('${goods.goo_model}%')">${goods.goo_model}</a> > ${goods.goo_name }</p>
	<hr><br>
	 <main class="ps-main">
	 <form method="post" name="view" action="goodsCartAddAction.go" onsubmit="return check(this)">	
      <div class="test">
        <div class="container">
          <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 ">
                </div>
          </div>
        </div>
      </div>
      <div class="ps-product--detail pt-60">
        <div class="ps-container">
          <div class="row">
            <div class="col-lg-10 col-md-12 col-lg-offset-1">
              <div class="ps-product__thumbnail">
                <div class="ps-product__image">
                  <div class="item"><img src="images/${goods.goo_image}" alt="" style="width:100%" height="550"></div>
                </div>
              </div>
              <div class="ps-product__thumbnail--mobile">
                <div class="ps-product__main-img"><img src="images/${goods.goo_image}" alt=""></div>
                <div class="ps-product__preview owl-slider" data-owl-auto="true" data-owl-loop="true" data-owl-speed="5000" data-owl-gap="20" data-owl-nav="true" data-owl-dots="false" data-owl-item="3" data-owl-item-xs="3" data-owl-item-sm="3" data-owl-item-md="3" data-owl-item-lg="3" data-owl-duration="1000" data-owl-mousedrag="on"><img src="images/shoe-detail/1.jpg" alt=""><img src="images/shoe-detail/2.jpg" alt=""><img src="images/shoe-detail/3.jpg" alt=""></div>
              </div>
              <div class="ps-product__info">
                <h3>${goods.goo_name }</h3>
                <p class="ps-product__category"><a href="#">${goods.goo_category}</a>,<a href="#">${goods.goo_model}</a></p>
                <h3 class="ps-product__price">${goods.goo_price}원</h3>
                <hr>
                  	<b>색상 : </b> <select  name="goo_color" id="goo_color">
						<option value="none" selected disabled hidden>-[필수]색상을 선택해주세요.-</option>
						<c:forEach var="list" items="${list }">
							<c:if test="${list.goo_color == 'white' }">
								<option value="white">white</option>
							</c:if>
							<c:if test="${list.goo_color == 'black' }">
								<option value="black">black</option>
							</c:if>
							<c:if test="${list.goo_color == 'red' }">
								<option value="red">red</option>
							</c:if>
							<c:if test="${list.goo_color == 'blue' }">
								<option value="blue">blue</option>
							</c:if>							
							<c:if test="${list.goo_color == 'pink' }">
								<option value="pink">pink</option>
							</c:if>
							<c:if test="${list.goo_color == 'yellow' }">
								<option value="yellow">yellow</option>
							</c:if>
							<c:if test="${list.goo_color == 'purple' }">
								<option value="purple">purple</option>
							</c:if>
							<c:if test="${list.goo_color == 'green' }">
								<option value="green">green</option>
							</c:if>
							<c:if test="${list.goo_color == 'brown' }">
								<option value="brown">brown</option>
							</c:if>
							<c:if test="${list.goo_color == 'gray' }">
								<option value="brown">gray</option>
							</c:if>
						</c:forEach>
							</select><br>
						<hr>
							<input type="hidden" name="goo_name" value="${goods.goo_name }" />
							<input type="hidden" name="goo_id" value="${goods.goo_id }"/>
							<input type="hidden" name="remove" value="1"/>
							<br>수량 : <input type="text" name="sto_qty" id="sto_qty" value="1" size="1"><br>
						<hr>			
							<b>${goods.goo_content}</b><br><br>
              </div>
              	<button class="ps-btn mb-10" type="submit" style="margin-left:2%;">장바구니에 담기<i class="ps-icon-next"></i></button>
              	<button class="ps-btn mb-10" type="submit" style="margin-left:2%;" formaction="orderForm.od?type=one&goo_id=${goods.goo_id}">상품 주문하기 <i class="ps-icon-next"></i></button>
              </div>
                </div>
		<br>
			<jsp:include page="Qna.jsp" flush="false"/>
		<br>
			<jsp:include page="Review.jsp" flush="false"/>	
			 </div>
            </div>
     </form>
     </main>
	</body>
</html>