<%@ include file="/init.jsp" %>

<%
	Task task = null;
	long taskId = ParamUtil.getLong(request, "taskId");
	if (taskId > 0) {
		task = TaskLocalServiceUtil.getTask(taskId);
	}
	
%>

<aui:model-context bean="<%= task %>" model="<%= Task.class %>" />

<portlet:renderURL var="viewTaskURL" />
<portlet:actionURL name='<%= task == null ? "addTask" : "updateTask" %>' var="editTaskURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewTaskURL %>"
	title='<%= (task != null) ? "taks.edit" : "task.new" %>'
/>

<aui:form action="<%= editTaskURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= viewTaskURL %>" />

		<aui:input name="taskId" type="hidden" value='<%= task == null ? "" : task.getTaskId() %>'/>

		<aui:input name="task" >
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="initDate" >
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="endDate">
			<aui:validator name="required" />
		</aui:input>
				
		<aui:input name="completed" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewTaskURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>