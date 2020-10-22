<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
   	<title>뽐케이스</title>
<script>
	price = "<%=(int) request.getAttribute("totalMoney")%>";
	var tot = "<%=(int) request.getAttribute("totalMoney")%>";

	function checkAll(t) {
		if (t.remove.length == undefined) {
			t.remove.checked = t.allCheck.checked;
		} else {
			for (var i = 0; i < t.remove.length; i++) {
				t.remove[i].checked = t.allCheck.checked
			}
		}
		if (t.allCheck.checked) {
			price = tot;
			document.getElementById("sel").innerHTML = "<b>선택 상품 가격 : " + tot
					+ "원 </b>";
			document.getElementById("tot").innerHTML = "결제 예상 금액 : " + tot
					+ "원";
		} else {
			price = 0;
			document.getElementById("sel").innerHTML = "<b>선택 상품 가격 : " + price
					+ "원 </b>"
			document.getElementById("tot").innerHTML = "결제 예상 금액 : " + price
					+ "원";
			;
		}
	}

	function checkItem(v, f) {
		if (f.checked == true) {
			price = parseInt(price) + parseInt(v);
			document.getElementById("sel").innerHTML = "<b>선택 상품 가격  : "
					+ price + "</b>원";
		} else {
			price = parseInt(price) - parseInt(v);
			document.getElementById("sel").innerHTML = "<b>선택 상품 가격  : "
					+ price + "</b>원";
		}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body class="ps-loading">
 	<h2 align="center">Basket</h2>
 	<p style="float: right; font-size: 12px; margin-right: 100px;"><a href="goodsMainAction.go">홈</a> > 장바구니</p>
	<hr><br>
	
    <main class="ps-main">
      <div class="ps-content pt-80 pb-80">
        <div class="ps-container">
          <div class="ps-cart-listing ps-table--whishlist">
          <form method="post">
            <table class="table ps-cart__table">
				<c:if test="${cartList == '[]' }">
					<tr>
						<td colspan="6"><p align="center">장바구니가 비어 있습니다.</p></td>
					</tr>
				</c:if>
				  
				<thead>
	              	<tr>
	                  <th><input type="checkbox" id="allCheck" name="allCheck" onClick="checkAll(this.form)" checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지</th>
	                  <th>상품정보</th>
	                  <th>가격</th>
	                  <th>수량</th>
	                  <th>총 금액</th>
	                  <th></th>
	                </tr>
				</thead>
              
				<tbody>
					<c:forEach var="cart" items="${cartList }" varStatus="status">
	                <tr>
						<td>
							<input type="checkbox" id="remove" name="remove" value="${cart.item_code }"
						  	onClick="checkItem('${cart.price * cart.qty}', this)" checked />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="ps-product__preview" href="#"><img class="mr-15" src="images/${cart.image }" style="width:80%" alt=""></a>
					  	</td>
					  	<td><a class="ps-product__preview" href="#">${cart.name }(${cart.color })</a></td>
	                  	<td>${cart.price }</td>
	                  	<td><a href="goodsCartQtyUpAction.go?name=${cart.name }&color=${cart.color}">
							<img src="images/up.gif" border=0 />
							</a><br> ${cart.qty }<br>
						    <a href="goodsCartQtyDownAction.go?name=${cart.name }&color=${cart.color}">
							<img src="images/down.gif" /></a>
						</td>
					  	<td>${cart.price * cart.qty }</td>
					  	<td>
	                    	<a href="goodsCartRemoveAction.go?item_code=${cart.item_code }"><div class="ps-remove"></div></a>
	                  	</td>
	                </tr>
	            	</c:forEach>
              </tbody>
     			
     				<tr>
	          	    	<td>
	          	    		<c:if test="${cartList != '[]' }">
	          	    			<input type="submit" value="삭제하기" formaction='goodsCartRemoveAction.go'>&nbsp;
	          	    			<button type="button" onclick="location.href='goodsCartRemoveAllAction.go'">장바구니 비우기</button>
	          	    		</c:if>
	          	    	</td>
						<td colspan="4" style="text-align: center;">
							<p id="sel">&nbsp;&nbsp;&nbsp;결제 금액 : ${totalMoney }원</p>
						</td>
						<td>
							<input type="submit" value="선택주문" formaction="orderForm.od?type=sel"/>&nbsp;
							<input type="submit" value="전체주문" formaction="orderForm.od?type=all" />&nbsp;
							<button type="button" onclick="history.back();">쇼핑계속하기</button>
						</td>
					</tr>
            </table>
			</form>
				</div>
			</div>
		</div>
    </main>
</body>
</html>