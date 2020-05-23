<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
    <link rel="stylesheet" href="./index.css">
</head>
<body>
    <div class="form-display">
        <h1>Define password to be verified:</h1>
        <form action="verify" method="post">
            <input type="text" name="senha" id="senha" placeholder="Type your password">
            <input class="button" type="submit" value="Verify">
        </form>
    </div>
    <jsp:include page="result.jsp"></jsp:include>
</body>
</html>
