<%--
  Created by IntelliJ IDEA.
  User: kenneth
  Date: 2017-03-04
  Time: 12:09 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <asset:stylesheet src="heatmap.scss"/>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="heat.js"/>
</head>

<body>
    <div class="bg">
        <g:each var="i" in="${ (0..<(heatmap.game.width as int)) }">
            <g:each var="j" in="${ (0..<(heatmap.game.height as int)) }">
                <div class="divbg">
                    <div class="block" data-heat="${heatmap.board[j*(heatmap.game.width as int)+i].heat}"></div>
                </div>
            </g:each>
            <br>
        </g:each>
    </div>
</body>
</html>