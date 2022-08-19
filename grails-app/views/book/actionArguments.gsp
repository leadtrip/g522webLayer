<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.book}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.book}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <p>Select a book then update it's title using an action argument</p>

    <table class="table table-bordered">
        <tr>
            <td>Title</td>
            <td>Author</td>
        </tr>
        <g:each in="${books}" var="book">
            <tr>
                <td><g:link action="actionArguments" id="${book.id}">${book.title}</g:link></td>
                <td>${book.author}</td>
            </tr>
        </g:each>
    </table>

    <g:if test="${book}">
        <g:form action="actionArguments">
            <g:hiddenField name="id" value="${book?.id}"/>
            <fieldset class="form">
                <div class="fieldcontain required">
                    <label for="title">Title *</label>
                    <g:field type="text" name="title" value="${book?.title}" minLength="2" maxlength="30"/>
                </div>
                <div class="fieldcontain required">
                    <label for="author">Author *</label>
                    <g:field type="text" name="author" value="${book?.author}" disabled="disabled"/>
                </div>
            </fieldset>
            <g:submitButton name="update" value="Update"/>
        </g:form>
    </g:if>
</body>
</html>