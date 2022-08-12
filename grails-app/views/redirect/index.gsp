<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    params: ${params}
    <br>
        <ul>
        <g:each in="${actions}" var="anAction">
            <li><g:link action="${anAction}">${anAction}</g:link> </li>
        </g:each>
        </ul>
</body>
</html>