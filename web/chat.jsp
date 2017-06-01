<%--
  Created by IntelliJ IDEA.
  User: Serug
  Date: 01.06.2017
  Time: 7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>

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
</body>

<script src="js/chat_script.js"></script>

</html>
