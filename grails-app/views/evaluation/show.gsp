
<%@ page import="com.tomwallace.breadrater.Evaluation" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'evaluation.label', default: 'Evaluation')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
		<div data-role="header" data-position="fixed">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<div data-role="navbar">
				<ul>
					<li><a data-icon="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link data-icon="grid" data-ajax="false" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<g:if test="${flash.message}">
			<div class="message">${flash.message}</div>
			</g:if>
			<dl>
			
				<dt><g:message code="evaluation.id.label" default="Id" /></dt>
				
					<dd><g:fieldValue bean="${evaluationInstance}" field="id"/></dd>
				
			
				<dt><g:message code="evaluation.dateEvaluated.label" default="Date Evaluated" /></dt>
				
					<dd><g:formatDate date="${evaluationInstance?.dateEvaluated}" /></dd>
				
			
				<dt><g:message code="evaluation.score.label" default="Score" /></dt>
				
					<dd><g:fieldValue bean="${evaluationInstance}" field="score"/></dd>
				
			
				<dt><g:message code="evaluation.evaluator.label" default="Evaluator" /></dt>
				
					<dd><g:fieldValue bean="${evaluationInstance}" field="evaluator"/></dd>
				
			
			</dl>
			<g:form>
				<g:hiddenField name="id" value="${evaluationInstance?.id}" />
				<g:actionSubmit data-icon="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
