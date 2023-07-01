<%@ page import="com.tictactoe.Sign" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>TIC-TAC-TOE</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
    <h1>TIC-TAC-TOE</h1>

    <script>
        function restart() {
            $.ajax({
                url: '/restart',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function () {
                    location.reload();
                }
            });
        }
    </script>

    <table>
        <tr>
            <td onclick="window.location='/logic?click=0'"><div class="sign${data.get(0).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=1'"><div class="sign${data.get(1).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=2'"><div class="sign${data.get(2).getSign()}">&nbsp;</div></td>
        </tr>
        <tr>
            <td onclick="window.location='/logic?click=3'"><div class="sign${data.get(3).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=4'"><div class="sign${data.get(4).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=5'"><div class="sign${data.get(5).getSign()}">&nbsp;</div></td>
        </tr>
        <tr>
            <td onclick="window.location='/logic?click=6'"><div class="sign${data.get(6).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=7'"><div class="sign${data.get(7).getSign()}">&nbsp;</div></td>
            <td onclick="window.location='/logic?click=8'"><div class="sign${data.get(8).getSign()}">&nbsp;</div></td>
        </tr>
    </table>

    <hr>
    <c:set var="CROSSES" value="<%=Sign.CROSS%>"/>
    <c:set var="NOUGHTS" value="<%=Sign.NOUGHT%>"/>

    <c:if test="${winner == CROSSES}">
        <h1>CROSSES WIN!</h1>
        <button onclick="restart()">Start again</button>
    </c:if>
    <c:if test="${winner == NOUGHTS}">
        <h1>NOUGHTS WIN!</h1>
        <button onclick="restart()">Start again</button>
    </c:if>
    <c:if test="${draw}">
        <h1>IT'S A DRAW</h1>
        <br>
        <button onclick="restart()">Start again</button>
    </c:if>

</body>
</html>