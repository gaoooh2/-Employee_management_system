<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/employeeListcss.css">
		<title>社員一覧</title>
	</head>
	<body>
		<div class="header">
			<a href="/lastKadai/Logout">ログアウト</a>
		</div>
		<div class="employeeAll">
			<h1>社員一覧</h1>
		</div>
		<div class="newAddButton">
			<form action="/lastKadai/EmployeeConnect" method="post">
				<button class="newAdd" type="submit" value="newAdd">新規登録</button>
			</form>
		</div>
		<form name="empForm" action="/lastKadai/EmployeeConnect" method="post">
			<table>
				<tr class="tableHeader">
					<td class="No">No</td>
					<td>会社</td>
					<td>事業部</td>
					<td>氏名</td>
					<td>氏名(ひらがな)</td>
					<td>年齢</td>
					<td>担当管理営業</td>
					<td>入社日</td>
					<td>稼働状況</td>
					<td>詳細</td>
					<td>削除</td>
				</tr>
				<c:forEach var="ad" items="${ ademp }">
					<tr>
						<td>${ ad.employee_id }</td>
						<td>${ ad.sex }</td>
						<td>${ ad.department }</td>
						<td>${ ad.name }</td>
						<td>${ ad.name_hiragana }</td>
						<td>${ ad.birthday }</td>
						<td>${ ad.business_manager }</td>
						<td>${ ad.hire_date }</td>
						<td>${ ad.commissioning_status }</td>
						<td><a href="/lastKadai/EmployeeConnect?employee_id=${ ad.employee_id }">詳細</a></td>
						<td><input type="submit" value="削除"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>