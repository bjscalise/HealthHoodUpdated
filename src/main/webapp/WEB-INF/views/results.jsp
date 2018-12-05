<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/flatly/bootstrap.min.css" rel="stylesheet" integrity="sha384-gJWVjz180MvwCrGGkC4xE5FjhWkTxHIR/+GgT8j2B3KKMgh6waEjPgzzh7lL7JZT" crossorigin="anonymous">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</head>

<body>


<div class="container">
<h2>Your Health Hood Index (H2I) is:</h2>
<br>
<br>
${indexResults}/5 <br>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">See Why</a>
<a class="btn btn-primary" data-toggle="collapse" href="#areaResults" role="button" aria-expanded="false" aria-controls="areaResults">See Results</a>

<div class="collapse" id="collapseExample">
  <div class="card card-body">
   ${message}
  </div>




<div class = "collapse" id="areaResults">
<div class = "card card-body">
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
</div>
</div>
</body>
</html>