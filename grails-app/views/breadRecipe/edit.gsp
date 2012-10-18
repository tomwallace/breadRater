

<%@ page import="com.tomwallace.breadrater.BreadRecipe" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="mobile">
        <g:set var="entityName" value="${message(code: 'breadRecipe.label', default: 'BreadRecipe')}" />
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
			<g:hasErrors bean="${breadRecipeInstance}">
			<div class="errors" role="alert">
				<g:renderErrors bean="${breadRecipeInstance}" as="list" />
			</div>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${breadRecipeInstance?.id}" />
				<g:hiddenField name="version" value="${breadRecipeInstance?.version}" />
			
				<div data-role="fieldcontain">
					<label for="name"><g:message code="breadRecipe.name.label" default="Name" /></label>
					<g:textField name="name" required="required" value="${breadRecipeInstance?.name}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="type"><g:message code="breadRecipe.type.label" default="Type" /></label>
					<g:textField name="type" required="required" value="${breadRecipeInstance?.type}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="description"><g:message code="breadRecipe.description.label" default="Description" /></label>
					<g:textField name="description" value="${breadRecipeInstance?.description}" />
				</div>
			
				<div data-role="fieldcontain">
					<label for="loaves"><g:message code="breadRecipe.loaves.label" default="Loaves" /></label>
					<g:select name="loaves" from="${com.tomwallace.breadrater.Loaf.list()}" multiple="multiple" optionKey="id" size="5" value="${breadRecipeInstance?.loaves*.id}" />
				</div>
			
				<g:actionSubmit data-icon="check" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
			</g:form>
		</div>
		<div data-role="footer">
		</div>
    </body>
</html>
