<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Insira uma senha para verificação:</h1>
	<form action="hello" method="post">
        <input type="text" name="senha" id="senha">
        <label for="senha"></label>
        <input type="submit" value="Verificar">
    </form>
    <jsp:include page="result.jsp"></jsp:include>
</body>
</html>
