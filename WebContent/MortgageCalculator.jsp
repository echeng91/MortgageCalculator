<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mortgage Payment Calculator</title>
</head>
<body>
	<table>
		<form action="CalculateMortgage" method="post"><br>
			<tr>
				<td>Principal: </td>
				<td><input type="text" name="principal" value="${calcprincipal}"></td>
				<td><i style="color:red"><c:out value="${principalerror}" /></i></td>
			</tr>
			<tr>
				<td>Rate: </td>
				<td><input type="text" name="rate" value="${calcrate}"></td>
				<td><i style="color:red"><c:out value="${rateerror}" /></i></td>
			</tr>
			<tr>
				<td>Term (months): </td>
				<td><input type="text" name="term" value="${calcterm}"></td>
				<td><i style="color:red"><c:out value="${termerror}" /></i></td>
			</tr>
			<tr><td></td><td><input type="submit" value="Calculate"></td></tr>
		</form>
		<tr><td>Payment: </td><td><c:out value="${payment}" /></td></tr>
	</table>
</body>
</html>