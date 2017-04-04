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

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/edit_task.jsp" />
		<portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteTask" var="deleteURL">
		<portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>