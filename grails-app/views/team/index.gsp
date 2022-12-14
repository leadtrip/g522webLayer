<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#list-team" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="list-team" class="col-12 content scaffold-list" role="main">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    %{--

                    The fields plugin isn't able to render the Map based hasMany relationship so we roll our own below
                    <f:table collection="${teamList}" />
                    --}%

                    <table class="table table-bordered">
                        <tr>
                            <th>Name</th>
                            <th>Members</th>
                        </tr>
                        <g:each in="${teamList}" var="team">
                            <tr>
                                <td>${team.name}</td>
                                <td>
                                    <ul>
                                        <g:each in="${team.members}" var="member">
                                            <li>${member.key.capitalize()} - ${member.value.name}</li>
                                        </g:each>
                                    </ul>
                                </td>
                            </tr>
                        </g:each>
                    </table>

                    <g:if test="${teamCount > params.int('max')}">
                    <div class="pagination">
                        <g:paginate total="${teamCount ?: 0}" />
                    </div>
                    </g:if>
                </div>
            </section>
        </div>
    </div>
    </body>
</html>