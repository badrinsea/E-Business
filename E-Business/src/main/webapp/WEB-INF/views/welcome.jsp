<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.trusty3pl.business.model.AppelOffre" %>
<%@ page import="org.hibernate.SessionFactory" %>


<html>
  <head>
    <title>E-Business</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <!-- styles -->
    <link href="<c:url value='/static/css/styles.css' />" rel="stylesheet"></link>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/static/bootstrap/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/static/js/custom.js" />"></script>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="index.html">E-Business</a></h1>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12">
	                
	                </div>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a class="dropdown-toggle" data-toggle="dropdown">My Account <b class="caret"></b></a>
	                        <ul class="dropdown-menu animated fadeInUp">
	                          <li><a href="profile.html">Profile</a></li>
	                          <li><a href="login.html">Logout</a></li>
	                        </ul>
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>

    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <!-- Main menu -->
                    <li class="current"><a href="home.html"><i class="glyphicon glyphicon-home"></i> Home</a></li>
                    <li><a href="calendar.html"><i class="glyphicon glyphicon-calendar"></i>Acheteur-Produit</a></li>
                    <li><a href="tables.html"><i class="glyphicon glyphicon-list"></i>Marches en cours</a></li>
                    <li><a href="buttons.html"><i class="glyphicon glyphicon-record"></i>Suivi</a></li>
                   
                </ul>
             </div>
		  </div>


		  <!--content-->

		  <div class="col-md-8" style="background-color: white;">
		  <div class="col-md-3"></div>
      <div class="col-md-6">
      <br>
      <form:form method="GET" commandName="produit">
      <p><strong>Choix de Categorie:</strong></p>
	<form:select class="form-control" path="idProduit">
        <form:option value="" label="....."/>
        <c:forEach items="${produitList}" var="produit">
 <form:option value="${produit.idProduit}" label="${produit.idProduit}"/>
 </c:forEach>
 </form:select>

 
  <input type="submit" class="btn btn-info" id="clik" value="Ajouter"/>
  </form:form>
  </div>
 <div class="col-md-m3"></div>
 <!--  
<%!

//SessionFactory ssFct=null;
//Session session = ssFct.openSession();%>
<%! 
//@SuppressWarnings("unchecked")
//List<AppelOffre> cartList = (List<AppelOffre>)session.createQuery("from AppelOffre where produitidProduit = 'PRD985' ").list();%>
<% //out.println("kkzsdke,s"); */%>-->

%>

		  </div>
		</div>




    <!--div marche-->

      <div class="row">
      <div class="col-md-2">
       
      </div>
      

      <!--content-->

    
  
      <div class="col-md-8" id="pere">
      <c:if test="${!empty marcheList}">
      <c:forEach items="${marcheList}" var="appeloffre">
<div class="col-md-6">
    <p>marcheList.acheteuridAcheteur</p>
    <p>marcheList.produitidProduit</p>
    <p>marcheList.ref</p>
</div>
</c:forEach>
</c:if>
  </div>
  
      

    <style type="text/css">
.floating-box {
    float: left;
    width: 400px;
    margin: 10px;
    border: 3px solid ;  
}

</style>
      </div>
      <div class="row">
       <center><input type="submit" class="btn btn-info" value="Passer au Centre Intelligent" onclick="location.href='button'"></center><br>
      </div>

    </div>

    <!--fini-->



 

 
  </body>
</html>