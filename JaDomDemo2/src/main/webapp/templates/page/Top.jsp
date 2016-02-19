<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%  if(session.getAttribute("jquery")!=null && (Boolean)session.getAttribute("jquery")==true ||
	session.getAttribute("bootstrap")!=null && (Boolean)session.getAttribute("bootstrap")==true  ) {
%>
<script src="js/jquery-1.11.3.min.js"></script>
<%  } 
 if(session.getAttribute("jqueryUi")!=null && (Boolean)session.getAttribute("jqueryUi")==true){%>
<script src="js/jquery-ui.js"></script>
<%  } 
 if(session.getAttribute("bootstrap")!=null && (Boolean)session.getAttribute("bootstrap")==true) {
%> 
 
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]--> 
 <script src="bootstrap/js/bootstrap.min.js"></script>
 <% 
 }
 if(session.getAttribute("angular")!=null) {
%>
<script src="js/angular.min.js"></script>
<%}  
%>


<style>
.inline{
	display:inline;
} 
.inline-block{
	display:inline-block;
} 
<%=(session.getAttribute("style")!=null) ? session.getAttribute("style") : "" %>

<%=(session.getAttribute("generatedStyleSheet")!=null) ? String.valueOf(session.getAttribute("generatedStyleSheet")) : "" %>
</style>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  if(session.getAttribute("appNavigation")!=null) {
%>
<%=session.getAttribute("appNavigation") %>
<%} %>

<link rel="stylesheet" type="text/css" href="css/style.css">
 