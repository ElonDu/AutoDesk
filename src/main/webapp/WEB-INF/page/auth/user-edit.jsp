<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户信息</title>
</head>
<body>

	<form action="add" method="post">
		<input type="hidden" name="id" value="${userVO.id }"/>
		
		登录账号：<input type="text" name="loginId" maxlength="20"/>
		<br/>
		登录密码：<input type="text" name="passwd" maxlength="20"/>
		<br/>
		姓名：<input type="text" name="name" maxlength="20"/>
		<br/>
		身份证号码：<input type="text" name="identityNo" maxlength="20"/>
		<br/>
		手机号码：<input type="text" name="mobile" maxlength="11"/>
		<br/>
		
		<input type="submit" value="提交" />
	</form>

</body>
</html>