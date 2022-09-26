<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Scopes</title>
    <meta name="layout" content="main"/>
</head>

<body>
    Result: ${params.result}
    <br><br>

    Add and get:
    <br>
    <g:link action="addAndGetFromApplicationScope">Get and add if not present from application scope</g:link>
    <br>
    <g:link action="addAndGetFromSessionScope">Get and add if not present from session scope</g:link>
    <br>
    <g:link action="addAndGetFromRequestScope">Get and add if not present from request scope</g:link>
    <br>
    <g:link action="addAndGetFromParamsScope">Get and add if not present from params scope</g:link>
    <br>

    Get:
    <br>
    <g:link action="getFromApplicationScope">Get from application scope</g:link>
    <br>
    <g:link action="getFromSessionScope">Get from session scope</g:link>
    <br>
    <g:link action="getFromRequestScope">Get from request scope</g:link>
    <br>
    <g:link action="getFromParamsScope">Get from params scope</g:link>
    <br>
</body>
</html>