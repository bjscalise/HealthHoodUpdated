<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-gJWVjz180MvwCrGGkC4xE5FjhWkTxHIR/+GgT8j2B3KKMgh6waEjPgzzh7lL7JZT" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="showsearchpage.css">
</head>
<body>

<center>
<h1>Search History</h1>
</center>

<div class="container">
        <table class="table">
        
         <thead>
            <tr style="font-weight:bold">
            	<td id="search"><h2>Searched Address</h2></td>
            	<td><h2>H2I</h2></td>
            	 </tr>
            </thead>
            <c:forEach var="t" items="${searchlist}">
           
           <tbody>
                <tr>
                    <!-- <tr> = table row <td> = table data -->
                    
                    <td id="results"><form action="results"> <input type="hidden" placeholder="${t.address}" value="${t.address}" class="btn btn-success" name="userSearch" target="_blank"> 
                    <input type="submit" value="${t.address}" name="${t.address}" class="btn btn-success"></form></td>
                    
                    <td id="index">${t.h2i}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table> 
        </div>
</body>
</html>