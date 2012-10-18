<%@ page import="com.tomwallace.breadrater.BreadRecipe" %>



<div class="fieldcontain ${hasErrors(bean: breadRecipeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="breadRecipe.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="required" value="${breadRecipeInstance?.name}" />
</div>

<div class="fieldcontain ${hasErrors(bean: breadRecipeInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="breadRecipe.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="type" required="required" value="${breadRecipeInstance?.type}" />
</div>

<div class="fieldcontain ${hasErrors(bean: breadRecipeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="breadRecipe.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${breadRecipeInstance?.description}" />
</div>

<div class="fieldcontain ${hasErrors(bean: breadRecipeInstance, field: 'loaves', 'error')} ">
	<label for="loaves">
		<g:message code="breadRecipe.loaves.label" default="Loaves" />
		
	</label>
	<g:select name="loaves" from="${com.tomwallace.breadrater.Loaf.list()}" multiple="multiple" optionKey="id" size="5" value="${breadRecipeInstance?.loaves*.id}" />
</div>

