<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-gJWVjz180MvwCrGGkC4xE5FjhWkTxHIR/+GgT8j2B3KKMgh6waEjPgzzh7lL7JZT" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Your Health Hood Index (H2I) is:</h2>
<br>
<br>
${indexResults }
<!-- <a href="yelp">What's in your Area?</a> -->
<div class = "container">
<h1>In Your Area</h1> 
<h3>Fitness Centers</h3>
<table class ="table">
<thead>
    <tr>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${fitnessResults}">
   <tbody>
    <tr>
    <td>${b.name}</td>
    <td>${b.location}</td>
    <td>${b.categories}</td>
    <td>${b.distance * 0.000621371}</td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Markets</h3>
<table class ="table">
<thead>
    <tr>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${groceryResults}">
  <tbody>  
    <tr>
    <td>${b.name}</td>
    <td>${b.location}</td>
    <td>${b.categories}</td>
    <td>${b.distance * 0.000621371}</td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Healthy Food OTG</h3>
<table class ="table">
<thead>
    <tr>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${otgResults}">
<tbody>    
    <tr>
    <td>${b.name}</td>
    <td>${b.location}</td>
    <td>${b.categories}</td>
    <td>${b.distance * 0.000621371}</td>
</tr>
</tbody>
</c:forEach>
</table>
 
</div>
</div>
</body>
</html>