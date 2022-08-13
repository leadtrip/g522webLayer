<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#create-book" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="create-book" class="col-12 content scaffold-create" role="main">
                    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
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
                    <g:form resource="${this.book}" method="POST">
                        <fieldset class="form">
                            <div class="fieldcontain required">
                                <label for="book.title">Title *</label>
                                <g:textField name="book.title" value="${params.title}" />
                            </div>
                            <div class="fieldcontain required">
                                <label for="book.author">Author *</label>
                                <g:textField name="book.author" value="${params.author}" />
                            </div>
                            <div class="fieldcontain">
                                <label for="book.reviews[0].stars">Review 1 stars</label>
                                <g:field type="number" min="0" max="10" name="book.reviews[0].stars" />
                            </div>
                            <div class="fieldcontain">
                                <label for="book.reviews[0].article">Review 1 article</label>
                                <g:textField name="book.reviews[0].article" />
                            </div>
                            <div class="fieldcontain">
                                <label for="book.reviews[1].stars">Review 2 stars</label>
                                <g:field type="number" min="0" max="10" name="book.reviews[1].stars" />
                            </div>
                            <div class="fieldcontain">
                                <label for="book.reviews[1].article">Review 2 article</label>
                                <g:textField name="book.reviews[1].article" />
                            </div>
                        </fieldset>
                        <fieldset class="buttons">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        </fieldset>
                    </g:form>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>
