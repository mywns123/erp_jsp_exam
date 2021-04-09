<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<link rel="stylesheet" href="css/emplist.css"> 
</head>
<body>
	<h2>사원 목록</h2>
		<table>
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>직책</td>
					<td>직속상사</td>
					<td>급여</td>
					<td>부서</td>
					<td>입사일</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>${employee.eNo}</td>
					<td>${employee.eName}</td>
					<td>${employee.title}</td>
					<td>${employee.manager}</td>
					<td>${employee.salary}</td>
					<td>${employee.dep}</td>
					<td><fmt:formatDate value="${employee.hireDate}" pattern="yyyy-MM-dd"/></td>
				</tr>			
			</c:forEach>
			</tbody>			
		</table>
</body>
</html>