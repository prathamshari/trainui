<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello ${sessionScope.user_dtls.fName} ${sessionScope.user_dtls.lName}</h1>
<h5 align="center"><a href="<spring:url value='/admin/register'/>">Add New Admin</a></h5>
<h5 align="center"><a href="<spring:url value='/admin/register'/>">Add New Admin</a></h5>
<h5 align="center"><a href="<spring:url value='/admin/addTrain'/>">Add New Train</a></h5>
<h5 align="center"><a href="<spring:url value='/admin/trainList'/>">Display train details</a></h5>

</body>
</html>