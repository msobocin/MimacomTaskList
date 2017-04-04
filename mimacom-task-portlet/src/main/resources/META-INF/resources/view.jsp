<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="mimacom-task-portlet.caption"/></b>
</p>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
%>

<aui:button-row>
	<portlet:renderURL var="addTaskURL">
		<portlet:param name="mvcPath" value="/edit_task.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addTaskURL.toString() %>" value="add-task" />
</aui:button-row>

<% if (themeDisplay.isSignedIn()) { %>
	<liferay-ui:search-container delta="10" emptyResultsMessage="No Tasks Found!!" iteratorURL="<%=iteratorURL%>">
	    <liferay-ui:search-container-results  results="<%= TaskLocalServiceUtil.getTasksByUserId(themeDisplay.getUserId()) %>" />
	    <liferay-ui:search-container-row className="com.mimacom.service.model.Task" keyProperty="taskId" modelVar="task">
	        <%-- <liferay-ui:search-container-column-text name="Completed" value="${task.completed}" /> --%>
	        <liferay-ui:search-container-column-jsp name="Completed" path="/task_success.jsp" align="left" />
	        <liferay-ui:search-container-column-text name="Task" value="${task.task}" />
	        <liferay-ui:search-container-column-text name="Init date" value="${task.initDate}" />
	        <liferay-ui:search-container-column-text name="End date" value="${task.endDate}" />
	        <liferay-ui:search-container-column-jsp path="/task_actions.jsp" align="right" />
	    </liferay-ui:search-container-row>
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
<% } else { %>
	<div class="alert alert-info " id="userNotLogged"><liferay-ui:message key="mimacom-task-portlet.user.not.logged"/></div>
<% } %>
