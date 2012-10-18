<%@ page import="com.tomwallace.breadrater.Loaf" %>



<div class="fieldcontain ${hasErrors(bean: loafInstance, field: 'baker', 'error')} required">
	<label for="baker">
		<g:message code="loaf.baker.label" default="Baker" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="baker" required="required" value="${loafInstance?.baker}" />
</div>

<div class="fieldcontain ${hasErrors(bean: loafInstance, field: 'dateBaked', 'error')} required">
	<label for="dateBaked">
		<g:message code="loaf.dateBaked.label" default="Date Baked" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateBaked" precision="day" value="${loafInstance?.dateBaked}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: loafInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="loaf.comments.label" default="Comments" />
		
	</label>
	<g:textField name="comments" value="${loafInstance?.comments}" />
</div>

<div class="fieldcontain ${hasErrors(bean: loafInstance, field: 'evaluations', 'error')} ">
	<label for="evaluations">
		<g:message code="loaf.evaluations.label" default="Evaluations" />
		
	</label>
	<g:select name="evaluations" from="${com.tomwallace.breadrater.Evaluation.list()}" multiple="multiple" optionKey="id" size="5" value="${loafInstance?.evaluations*.id}" />
</div>

