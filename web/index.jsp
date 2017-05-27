<%--
  Created by IntelliJ IDEA.
  User: Serug
  Date: 21.05.2017
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <link rel="shortcut icon" href="http://www.bootstrap-3.ru/assets/ico/favicon.ico">

  <title>Web</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/template.css" rel="stylesheet">
  <!-- Just for debugging purposes. Don't actually copy this line! -->
  <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style></style><style type="text/css"></style></head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
    <span class="sr-only">Toggle navigation</span>
<span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index.html">Restaurant</a>
    </div>
    <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li class="active" ><a href="index.jsp">Home</a></li>
        <li><a href="open_page?action=SHOW_MENU">Menu</a></li>
        <li><a href="open_page?action=MAKE_ORDER">Make order</a></li>
        <li><a href="open_page?action=SHOW_ACCEPTED_ORDERS">Accepted orders</a></li>
        <li><a href="open_page?action=SHOW_ORDERS_BY_CLIENT&client_id=1">Order</a></li>
    </ul>
    </div><!--/.nav-collapse -->
    </div>
    </div>

    <div class="container">

    <div class="starter-template">
    <h1>Online restaurant menu</h1>
<p class="lead">Click "Make order" to make your choice.</p>
</div>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body></html>
