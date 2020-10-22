<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품출고</h3>
	<hr>
	<form>
		<table>
			<tr>
				<td>상품명</td>
				<td>${param.goo_name}<input type="hidden" name="goo_id" id="goo_id" value="${param.goo_id}"></td>
			</tr>
			<tr>
				<td>출고(출고고객)</td>
				<td><input type="text" name="sto_export" id="sto_export"/></td>
			</tr>
			<tr>
				<td>출고수량</td>
				<td><input type="text" name="sto_qty" id="sto_qty"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" formaction="adminGoodsStockExportAction.ad"></td>
			</tr>
		</table>
	</form>
</body>
</html>