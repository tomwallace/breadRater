
<%@ page import="com.tomwallace.breadrater.Loaf" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'loaf.label', default: 'Loaf')}" />
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
			
				<dt><g:message code="loaf.id.label" default="Id" /></dt>
				
					<dd><g:fieldValue bean="${loafInstance}" field="id"/></dd>
				
			
				<dt><g:message code="loaf.baker.label" default="Baker" /></dt>
				
					<dd><g:fieldValue bean="${loafInstance}" field="baker"/></dd>
				
			
				<dt><g:message code="loaf.dateBaked.label" default="Date Baked" /></dt>
				
					<dd><g:formatDate date="${loafInstance?.dateBaked}" /></dd>
				
			
				<dt><g:message code="loaf.comments.label" default="Comments" /></dt>
				
					<dd><g:fieldValue bean="${loafInstance}" field="comments"/></dd>
				
			
				<dt><g:message code="loaf.evaluations.label" default="Evaluations" /></dt>
				
					<g:each in="${loafInstance.evaluations}" var="e">
						<dd><g:link controller="evaluation" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></dd>
					</g:each>
				
			
			</dl>
			<g:form>
				<g:hiddenField name="id" value="${loafInstance?.id}" />
				<g:actionSubmit data-icon="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
