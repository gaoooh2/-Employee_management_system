<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/logincss.css">
		<title>ログイン</title>
	</head>
	<body>
		<div class="titleh1">
			<h1>社員管理システム</h1>
		</div>

		<div class="errMsg">
			${errMsg}
		</div>

		<form action="/lastKadai/LoginProcessing" method="post">
		<div class="border">
			<div class="idPass">
				ログインID <input type="text" name="loginId"><br>
				パスワード <input type="password" name="password"><br>
			</div>
		</div>
		<div class="button">
			<button class="loginButton" type="submit" value="login">ログイン</button>
		</div>
		</form>
	</body>
</html>