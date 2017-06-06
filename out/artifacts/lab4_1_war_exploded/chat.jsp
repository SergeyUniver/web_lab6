<%--
  Created by IntelliJ IDEA.
  User: Ionas
  Date: 21.05.2017
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
            <a class="navbar-brand" href="index.jsp">Restaurant</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="TestServlet?action=SHOW_MENU">Menu</a></li>
                <li><a href="TestServlet?action=MAKE_ORDER">Make order</a></li>
                <li><a href="TestServlet?action=SHOW_ACCEPTED_ORDERS">Accepted orders</a></li>
                <li><a href="TestServlet?action=SHOW_ORDERS_BY_CLIENT&client_id=1">Order</a></li>
                <li class="active"><a href="chat.jsp">Chat</a></li>
                <li><a href="TestServlet?action=LOG_OUT">Log out</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>


<table>
    <tr>
        <td colspan="2">
            <input type="text" id="username" placeholder="Username"/>
            <button type="button" onclick="connect();" >Connect</button>
        </td>
    </tr>
    <tr>
        <td>
            <textarea readonly="true" rows="10" cols="80" id="log"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" size="15" id="to" placeholder="To"/>
            <input type="text" size="51" id="msg" placeholder="Message"/>
            <button type="button" onclick="send();" >Send</button>
        </td>
    </tr>
</table>
<div id="messages"></div>
</body>

<script type="text/javascript">
    var ws;
    var messages = document.getElementById("messages");


    function connect() {
        writeResponse("try connect");
        var username = document.getElementById("username").value;
        ws = new WebSocket("ws://localhost:8080/lab4_1_war_exploded/chat/" + username);

        writeResponse("try connect2 " + username);
        ws.onopen = function(event){
            // For reasons I can't determine, onopen gets called twice
            // and the first time event.data is undefined.
            // Leave a comment if you know the answer.
            if(event.data === undefined)
                return;

            writeResponse(event.data);
        };

        ws.onmessage = function(event) {
            var log = document.getElementById("log");
            console.log(event.data);
            var message = JSON.parse(event.data);
            log.innerHTML += message.from + " : " + message.content + "\n";
            writeResponse(message.from + " : " + message.content + "\n");
        };
    }

    function send() {
        var content = document.getElementById("msg").value;
        var to = document.getElementById("to").value;
        var json = JSON.stringify({
            "to":to,
            "content":content
        });

        ws.send(json);
        log.innerHTML += "Me : " + content + "\n";
    }

    function writeResponse(text){
//        messages.innerHTML += "<br/>" + text;
    }
</script>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

