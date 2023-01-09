<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach JSP tags etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
	<h1>Dashboard for Recipes</h1>
	<div>
		<table class="table table-dark">
			<thead>
				<tr>
			    	<th scope="col">Name</th>
			      	<th scope="col">Under</th>
			      	<th scope="col">Posted By</th>
			      	<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="recipe" items="${allRecipes}">
			    	<tr>
			      		<td> <c:out value="${recipe.name}" /> </td>
			    		<td> <c:out value="${recipe.under30Min}" /> </td>
			    		<td> <c:out value="${recipe.creator.firstName}" /> </td>
			    		<td> 
			      			<a href="/recipes/${recipe.id}"> View </a> 
 			      			<c:if test="${user_id == recipe.creator.id}">
				      			<a href="/recipes/${recipe.id}"> Edit </a> 
				      			<a href="/recipes/${recipe.id}"> Delete </a> 
			      			</c:if>
			      		</td>
			    	</tr>
			     </c:forEach>
			</tbody>
		</table>
	</div>
<!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>