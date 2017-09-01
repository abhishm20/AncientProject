<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="ducat" tagdir="/WEB-INF/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Profile</title>
</head>
<body>
	${name} ${id} ${branch}

	<form action="book_table">
		<input type="submit" value="Book" />
	</form>

	<form action="num_book">
		<input type="submit" value="Num" />
	</form>
</body>
</html>