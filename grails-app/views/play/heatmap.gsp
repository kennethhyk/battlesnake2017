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
    <g:each var="j" in="${ (0..<(heatmap.height as int)-1) }">
        <g:each var="i" in="${ (0..<(heatmap.width as int)-1) }">
        <div class="block" data-heat="#000"></div>
        </g:each>
        <br>
    </g:each>
</body>
</html>