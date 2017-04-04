<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Task task = (Task) row.getObject();
	long groupId = task.getGroupId();
	String name = Task.class.getName();
	long taskId = task.getTaskId();
	//String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<% if (task.getCompleted()) { %>
	<span class="glyphicon glyphicon-ok"></span>
<% } else { %>
	<liferay-ui:icon-menu>
		<portlet:actionURL name="successTask" var="successURL">
			<portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>
	
		<aui:form action="<%= successURL %>" method="POST" name="fm">
			<aui:fieldset>
				<%-- <aui:input name="redirect" type="hidden" value="<%= viewTaskURL %>" /> --%>
				<input type="hidden" name="taskId" value="<%= taskId %>" />
				<input type="checkbox" name="completed" onclick="$(this).closest('form').submit();" />
			</aui:fieldset>
		</aui:form>
	</liferay-ui:icon-menu>
<% } %>