

<%@ page import="com.tomwallace.breadrater.Evaluation" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'evaluation.label', default: 'Evaluation')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
		<div data-role="header" data-position="fixed">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<div data-role="navbar">
				<ul>
					<li><a data-icon="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link data-icon="grid" data-ajax="false" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<g:if test="${flash.message}">
			<div class="message" role="alert">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${evaluationInstance}">
			<div class="errors" role="alert">
				<g:renderErrors bean="${evaluationInstance}" as="list" />
			</div>
			</g:hasErrors>
			<g:form action="save" >
			
				<div data-role="fieldcontain">
					<label for="dateEvaluated"><g:message code="evaluation.dateEvaluated.label" default="Date Evaluated" /></label>
					<g:datePicker name="dateEvaluated" precision="day" value="${evaluationInstance?.dateEvaluated}"  />
				</div>
			
				<div data-role="fieldcontain">
					<label for="score"><g:message code="evaluation.score.label" default="Score" /></label>
					<g:field type="number" name="score" value="${fieldValue(bean: evaluationInstance, field: 'score')}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="evaluator"><g:message code="evaluation.evaluator.label" default="Evaluator" /></label>
					<g:textField name="evaluator" value="${evaluationInstance?.evaluator}" />
				</div>
			
				<g:submitButton name="create" data-icon="check" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
