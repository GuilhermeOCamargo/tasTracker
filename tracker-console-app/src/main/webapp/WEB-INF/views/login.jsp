<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TAS Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/signin.css'/>">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body class="text-center">
	<div id="content"
		class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<div id="header" class="masthead mb-auto">
			<h1><img class="imagem_logo" src="<c:url value='/resources/img/taz.png'/>"/> TAS Tracker</h1>
		</div>

		<div id="div_body">
			<form class="form-signin" id="form_login" action="<c:url value='/login'/>" method="POST">
				<h1 class="h3 mb-3 font-weight-normal">Login</h1>
				<input type="text" id="username" name="username"
					class="form-control" placeholder="E-mail" required="true"
					autofocus=""> 
				<input type="password" id="password"
					name="password" class="form-control" placeholder="Senha">
				<c:if test="${param.regError == true}">
				    <div id="error">
				        <spring:message code="message.regError">   
				        </spring:message>
				    </div>
				</c:if>
				<c:if test="${param.error != null}">
				    <div class="alert alert-danger" id="error">
				        <spring:message code="message.badCredentials">  
				        <strong id="errorText"></strong>
				        </spring:message>
				    </div>
				</c:if>
				<input class="btn btn-lg btn-primary btn-block " type="submit"
					id="btnSignin" value="Entrar">
			</form>
		</div>
		<div id="div_footer" class="mastfoot mt-auto">
		</div>
	</div>
	<script type="text/javascript">


	</script>
</body>
</body>
</html>
