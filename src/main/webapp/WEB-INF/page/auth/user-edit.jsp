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
		<input type="hidden" name="${userVO.id }"/>
		
		登录账号：<input type="text" name="${userVO.loginId}" maxlength="20"/>
		<br/>
		登录密码：<input type="text" name="${userVO.passwd }" maxlength="20"/>
		<br/>
		姓名：<input type="text" name="${userVO.name }" maxlength="20"/>
		<br/>
		身份证号码：<input type="text" name="${userVO.identityNo }" maxlength="20"/>
		<br/>
		
		<input type="submit" value="提交" />
	</form>

</body>
</html>