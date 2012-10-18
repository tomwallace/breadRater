

<%@ page import="com.tomwallace.breadrater.Loaf" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'loaf.label', default: 'Loaf')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
		<div data-role="header" data-position="fixed">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
			<g:hasErrors bean="${loafInstance}">
			<div class="errors" role="alert">
				<g:renderErrors bean="${loafInstance}" as="list" />
			</div>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${loafInstance?.id}" />
				<g:hiddenField name="version" value="${loafInstance?.version}" />
			
				<div data-role="fieldcontain">
					<label for="baker"><g:message code="loaf.baker.label" default="Baker" /></label>
					<g:textField name="baker" required="required" value="${loafInstance?.baker}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="dateBaked"><g:message code="loaf.dateBaked.label" default="Date Baked" /></label>
					<g:datePicker name="dateBaked" precision="day" value="${loafInstance?.dateBaked}"  />
				</div>
			
				<div data-role="fieldcontain">
					<label for="comments"><g:message code="loaf.comments.label" default="Comments" /></label>
					<g:textField name="comments" value="${loafInstance?.comments}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="evaluations"><g:message code="loaf.evaluations.label" default="Evaluations" /></label>
					<g:select name="evaluations" from="${com.tomwallace.breadrater.Evaluation.list()}" multiple="multiple" optionKey="id" size="5" value="${loafInstance?.evaluations*.id}" />
				</div>
			
				<g:actionSubmit data-icon="check" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
