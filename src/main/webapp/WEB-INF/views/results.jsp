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
<link rel="stylesheet" type="text/css" href="results.css">
</head>
<body>

<center>
<div class="container">
<h1>Your Health Hood Index (H2I) is:</h1>
<br>
<br>
<h2>${address1}:</h2>
<br>
<h2>${indexResults}/5</h2>

<br>
<a class="btn btn-light" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">See Why</a>


<div class="collapse" id="collapseExample">
  <div class="card card-body">
   ${message}
   <a class="btn btn-success" data-toggle="collapse" href="#areaResults" role="button" aria-expanded="false" aria-controls="areaResults">See Results</a>
 </div> 
<div class = "collapse" id="areaResults">
<div class = "card card-body">
<h1>In Your Area</h1> 
<h3>Fitness Centers</h3>
<table class ="table">
<thead>
    <tr>
    	<td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${fitnessResults}">
   <tbody>
    <tr>
    <td><img src ="${b.image_url}" height="100" width="100" alt="Fitness Center"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
    <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
    <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Markets</h3>
<table class ="table">
<thead>
    <tr>
    	<td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${groceryResults}">
  <tbody>  
    <tr>
    <td><img src ="${b.image_url}" height="100" width="100" alt="Grocery Store"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
    <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
   <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Healthy Food OTG</h3>
<table class ="table">
<thead>
    <tr>
   	    <td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${otgResults}">
<tbody>    
    <tr>
    <td><img src ="${b.image_url}" height="100" width="100" alt="Healthy Fast Food"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
   <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
   <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table> 
</div>
</div>
${message2}
<div class = "collapse" id="areaResults">
<div class = "card card-body">
<h1>In Your Area</h1> 
<h3>Fitness Centers</h3>
<table class ="table">
<thead>
    <tr>
        <td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${fitnessResults2}">
   <tbody>
    <tr>
     <td><img src ="${b.image_url}" height="100" width="100" alt="Fitness Center"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
    <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
   <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Markets</h3>
<table class ="table">
<thead>
    <tr>
    	<td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${groceryResults2}">
  <tbody>  
    <tr>
    <td><img src ="${b.image_url}" height="100" width="100" alt="Grocery Store"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
    <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
    <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table>
<h3>Healthy Food OTG</h3>
<table class ="table">
<thead>
    <tr>
    	<td>Business Image</td>
        <td>Business Name</td>
        <td>Business Location</td>
        <td>Business Category</td>
        <td>Distance from You</td>
    </tr>
</thead>
    <c:forEach var = "b" items = "${otgResults2}">
<tbody>    
    <tr>
    <td><img src ="${b.image_url}" height="100" width="100" alt="Healthy Fast Food"></td>
    <td><a href="${b.url}" target="_blank">${b.name}</a></td>
    <td>${b.location.city}, ${b.location.state}</td>
    <td>
    <c:forEach var = "c" items = "${b.categories}">
   	 ${c.title}, ${c.alias} 
    </c:forEach>
    </td>
    <td>${b.formattedDistance} <p>mi</p></td>
</tr>
</tbody>
</c:forEach>
</table> 
</div>
</div>
</div>
</div>
</center>

<style>

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #d3d3d3;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: white;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: relative;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

#menu{
position: fixed;
top: 0;
left: 0;
padding-left: 10px;

}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="showsearches">History</a>
  <a href="newsearch">New Address</a>
  <a href="/">New User</a>
  
</div>

<span id="menu"style="font-size:30px;cursor:pointer; color: #d3d3d3" onclick="openNav()">&#9776; Menu</span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>

</body>
</html>