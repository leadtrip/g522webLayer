<%@ page import="org.grails.web.servlet.mvc.SynchronizerTokensHolder" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Duplicate form submissions</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="container">
    <g:if test="${flash.badToken}">
        Bad token
    </g:if>

    <g:form useToken="true">
        <g:if test="${dupToken}">
            <g:hiddenField name="${SynchronizerTokensHolder.TOKEN_KEY}" value="${dupToken}"/>
        </g:if>
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" name="inputEmail3" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3"  name="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-2">Force invalid</div>
            <div class="col-sm-10">
                <div class="form-check">
                    <g:checkBox class="form-check-input" type="checkbox" id="forceInvalid" name="forceInvalid" checked="${dupToken != null}" />
                </div>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button name="signIn" id="signIn" value="signIn" type="submit" class="btn btn-primary" formaction="index">Sign in</button>
            </div>
        </div>
    </g:form>
</div>

</body>
</html>