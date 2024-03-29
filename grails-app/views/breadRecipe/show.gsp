
<%@ page import="com.tomwallace.breadrater.BreadRecipe" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'breadRecipe.label', default: 'BreadRecipe')}" />
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
			
				<dt><g:message code="breadRecipe.id.label" default="Id" /></dt>
				
					<dd><g:fieldValue bean="${breadRecipeInstance}" field="id"/></dd>
				
			
				<dt><g:message code="breadRecipe.name.label" default="Name" /></dt>
				
					<dd><g:fieldValue bean="${breadRecipeInstance}" field="name"/></dd>
				
			
				<dt><g:message code="breadRecipe.type.label" default="Type" /></dt>
				
					<dd><g:fieldValue bean="${breadRecipeInstance}" field="type"/></dd>
				
			
				<dt><g:message code="breadRecipe.description.label" default="Description" /></dt>
				
					<dd><g:fieldValue bean="${breadRecipeInstance}" field="description"/></dd>
				
			
				<dt><g:message code="breadRecipe.loaves.label" default="Loaves" /></dt>
				
					<g:each in="${breadRecipeInstance.loaves}" var="l">
						<dd><g:link controller="loaf" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></dd>
					</g:each>
				
			
			</dl>
			<g:form>
				<g:hiddenField name="id" value="${breadRecipeInstance?.id}" />
				<g:actionSubmit data-icon="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
