<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#create-team" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="create-team" class="col-12 content scaffold-create" role="main">
                    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${this.team}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${this.team}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                    </g:hasErrors>
                    <g:form resource="${this.team}" method="POST">
                        <fieldset class="form">
                            <div class="fieldcontain required">
                                <label for="team.name">Name *</label>
                                <g:textField name="team.name" value="${params.name}" />
                            </div>
                            <div class="fieldcontain">
                                <label for="team.members[manager].name">Manager</label>
                                <g:textField name="team.members[manager].name" />
                            </div>
                            <div class="fieldcontain">
                                <label for="team.members[ds].name">Directeur sportif</label>
                                <g:textField name="team.members[ds].name" />
                            </div>
                            <div class="fieldcontain">
                                <label for="team.members[coach].name">Coach</label>
                                <g:textField name="team.members[coach].name" />
                            </div>
                            <div class="fieldcontain">
                                <label for="team.members[doctor].name">Doctor</label>
                                <g:textField name="team.members[doctor].name" />
                            </div>
                            <div class="fieldcontain">
                                <label for="team.members[soigneur].name">Soigneur</label>
                                <g:textField name="team.members[soigneur].name" />
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
