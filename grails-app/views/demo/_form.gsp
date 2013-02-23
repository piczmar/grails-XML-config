<%@ page import="test.Demo" %>



<div class="fieldcontain ${hasErrors(bean: demoInstance, field: 'text', 'error')} ">
	<label for="text">
		<g:message code="demo.text.label" default="Text" />
		
	</label>
	<g:textField name="text" value="${demoInstance?.text}"/>
</div>

