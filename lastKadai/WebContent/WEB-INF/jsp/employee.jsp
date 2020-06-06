<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/employeecss.css">
		<title>社員詳細</title>
	</head>
	<body>
		<div class="titleh1">
			<h1>社員詳細</h1>
		</div>
		<div class="errFlagMsg">
			${errFlagMsg}
		</div>
		<form action="/lastKadai/AddEmpLogic" method="post">
		<input type="hidden" name ="employee_id" value="${ errVal.employee_id }">
		<table class="table" id="css-1">
			<col>
				<tr>
					<td>氏名</td>
					<td><input type="text" name="name" value="${ errVal.name }"></td>
				</tr>
				<tr>
					<td>氏名(ひらがな)</td>
					<td><input type="text" name="nameHiragana" value="${ errVal.name_hiragana }"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type="text" name="birthday" value="${ errVal.birthday }"></td>
				</tr>
				<tr>
					<td>性別</td>
					<td>男<input type="radio" name="sex" value="0" ${ aeList.man }>  女<input type="radio" name="sex" value="1" ${ aeList.woman }>
					</td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text" class="mailAddress" name="mailAddress" value="${ errVal.mail_address }"></td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td><input type="text" name="telephoneNumber" value="${ errVal.telephone_number }"></td>
				</tr>
				<tr>
					<td>所属会社</td>
					<td>
						<select name="companyName">
							<option value=""></option>
							<c:forEach var="comlist" items="${ com }">
								<option value="${ comlist.abbreviation }" ${ comlist.selected }> ${ comlist.abbreviation } </option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>担当管理営業</td>
					<td><input type="text" name="businessManager" value="${ errVal.business_manager }"></td>
				</tr>
				<tr>
					<td>事業部</td>
					<td>
						<select name="department">
							<option value=""></option>
							<option value="DEVELOPMENT" ${ aeList.development }>開発</option>
							<option value="NETWORK" ${ aeList.network }>NW</option>
							<option value="VERIFICATION" ${ aeList.verification }>検証</option>
							<option value="OFFICE" ${ aeList.office }>オフィス</option>
							<option value="MANAGEMENT" ${ aeList.management }>管理</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>稼働状況</td>
					<td>稼働<input type="radio" name="commissioningStatus" value="1" ${ aeList.commissioningStatusK }>  未稼働<input type="radio" name="commissioningStatus" value="0" ${ ajv.getCommissioningStatusM() } ${ aeList.commissioningStatusM }></td>
				</tr>
				<tr>
					<td>入社日</td>
					<td><input type="text" name="enterDate" value="${errVal.hire_date }"></td>
				</tr>
				<tr>
					<td>退社日</td>
					<td><input type="text" name="retireDate" value="${errVal.retire_date }"></td>
				</tr>
				<tr>
					<td>ステータス</td>
					<td>
						<select name="status">
							<option value=""></option>
							<option value="ENROLLMENT" ${ aeList.enrollment }>在籍</option>
							<option value="RETIREMENT" ${ aeList.retirement }>退職</option>
							<option value="JOINED_WAIT" ${ aeList.joined_wait }>入社待</option>
							<option value="JOINED_CANCELLATION" ${ aeList.joined_cancellation }>入社取り消し</option>
						</select>
					</td>
				</tr>
			</table>
				<div class="nextButton">
					<button class="nButton" name="val" value="${ val }" type="submit">${ val }</button>

				</div>
			</form>
				<div class="backButton">
					<button class="bButton" onClick="history.back(); return false;">戻る</button>
				</div>
	</body>
</html>