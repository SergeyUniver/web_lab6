<%@ page import="actions.ShowOrderByClientAction" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Vector" %>
<%@ page import="entities.Order" %>
<%@ page import="actions.SessionHelper" %>
<%@ page import="action.Action" %><%--
  Created by IntelliJ IDEA.
  User: Serug
  Date: 21.05.2017
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://www.bootstrap-3.ru/assets/ico/favicon.ico">

    <title>Web</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/template.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style></style>
    <style type="text/css"></style>
</head>

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
            <%--<jsp:include page="body.jsp" flush="true"/>--%>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="TestServlet?action=SHOW_MENU">Menu</a></li>
                <li><a href="TestServlet?action=MAKE_ORDER">Make order</a></li>
                <li><a href="TestServlet?action=SHOW_ACCEPTED_ORDERS">Accepted orders</a></li>
                <li class="active"><a href="TestServlet?action=SHOW_ORDERS_BY_CLIENT&client_id=1">Order</a></li>
                <li><a href="TestServlet?action=LOG_OUT">Log out</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">

    <div class="starter-template">

        <form id="bootstrapSelectForm" method="post" class="form-horizontal">
            <div class="container">
                <h2>Info about your order</h2>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Products</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Vector<Order> orders = (Vector<Order>) session.getAttribute(ShowOrderByClientAction.ORDERS_PARAM);
                        for (Order order : orders) {
                    %>
                    <tr>
                        <td><%= order.getDishByDishId().getName()%>
                        </td>
                        <td><%= order.getDishCount()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>

                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>

<form action="FrontController">

    <% SessionHelper sessionHelper = (SessionHelper) session.getAttribute(Action.SESSION_PARAM);%>
    Время последнего сеанса: <%= sessionHelper.getLastAccessTime().toString()%>     <br>
    Количество посещений: <%= sessionHelper.getVisitCount()%>     <br>
</form>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>




