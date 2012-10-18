<%@ page import="com.tomwallace.breadrater.Evaluation" %>



<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'dateEvaluated', 'error')} required">
	<label for="dateEvaluated">
		<g:message code="evaluation.dateEvaluated.label" default="Date Evaluated" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateEvaluated" precision="day" value="${evaluationInstance?.dateEvaluated}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'score', 'error')} required">
	<label for="score">
		<g:message code="evaluation.score.label" default="Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="score" value="${fieldValue(bean: evaluationInstance, field: 'score')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: evaluationInstance, field: 'evaluator', 'error')} ">
	<label for="evaluator">
		<g:message code="evaluation.evaluator.label" default="Evaluator" />
		
	</label>
	<g:textField name="evaluator" value="${evaluationInstance?.evaluator}" />
</div>

