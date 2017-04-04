package com.mimacom.task.portlet;

import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mimacom.service.model.Task;
import com.mimacom.service.service.TaskLocalServiceUtil;
import com.mimacom.task.portlet.utils.Constants;

/**
 * @author Michal Sobocinski
 */
@Component(
		immediate = true,
		property = { 
			"com.liferay.portlet.display-category=category.mimacom",
			"com.liferay.portlet.instanceable=true", 
			"javax.portlet.display-name=mimacom-task-portlet Portlet",
			"javax.portlet.init-param.template-path=/", 
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)

public class MimacomTaskPortlet extends MVCPortlet {
	
	/**
	 * Add new task function
	 * 
	 * @param request <- ActionRequest
	 * @param response <- ActionResponse
	 * @throws Exception <- generic Exception
	 */
	public void addTask(ActionRequest request, ActionResponse response) throws Exception {

		_updateTask(request);

		sendRedirect(request, response);
	}

	/**
	 * Delete task function
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void deleteTask(ActionRequest request, ActionResponse response) throws Exception {

		long taskId = ParamUtil.getLong(request, Constants.PARAM_TASK_ID);

		TaskLocalServiceUtil.deleteTask(taskId);

		sendRedirect(request, response);
	}

	/**
	 * Update task function
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateTask(ActionRequest request, ActionResponse response) throws Exception {

		_updateTask(request);

		sendRedirect(request, response);
	}

	/**
	 * Update success task function
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void successTask(ActionRequest request, ActionResponse response) throws Exception {

		long taskId = ParamUtil.getLong(request, Constants.PARAM_TASK_ID);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), request);
		long userId = serviceContext.getUserId();

		Task task = null;

		task = TaskLocalServiceUtil.getTask(taskId);

		task = TaskLocalServiceUtil.updateTask(taskId, userId, task.getTask(), true, task.getInitDate(),
				task.getEndDate(), serviceContext);

		sendRedirect(request, response);
	}

	/**
	 * Update/Add task helper
	 * 
	 * @param request
	 * @return Task
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Task _updateTask(ActionRequest request) throws PortalException, SystemException {

		long taskId = ParamUtil.getLong(request, Constants.PARAM_TASK_ID);
		String taskDescription = ParamUtil.getString(request, Constants.PARAM_TASK_DESCRIPTION);
		
		if (!Validator.isBlank(taskDescription)) {
			boolean completed = ParamUtil.getBoolean(request, Constants.PARAM_COMPLETED, false);

			int yearInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_YEAR);
			int monthInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_MONTH);
			int dayInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_DAY);
			int hourInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_HOUR);
			int minuteInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_MINUTE);
			int amPmInitDate = ParamUtil.getInteger(request, Constants.PARAM_INIT_DATE_AM_PM);

			int yearEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_YEAR);
			int monthEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_MONTH);
			int dayEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_DAY);
			int hourEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_HOUR);
			int minuteEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_MINUTE);
			int amPmEndDate = ParamUtil.getInteger(request, Constants.PARAM_END_DATE_AM_PM);

			if (amPmInitDate == Calendar.PM) {
				hourInitDate += 12;
			}
			
			if (amPmEndDate == Calendar.PM) {
				hourEndDate += 12;
			}

			Calendar calendarInit = Calendar.getInstance();
			Calendar calendarEnd = Calendar.getInstance();
			calendarInit.set(yearInitDate, monthInitDate, dayInitDate, hourInitDate, minuteInitDate);
			calendarInit.set(yearEndDate, monthEndDate, dayEndDate, hourEndDate, minuteEndDate);

			Date initDate = calendarInit.getTime();
			Date endDate = calendarEnd.getTime();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), request);
			long userId = serviceContext.getUserId();

			Task task = null;

			if (taskId <= 0) {
				task = TaskLocalServiceUtil.addTask(userId, taskDescription, completed, initDate, endDate,
						serviceContext.getScopeGroupId(), serviceContext);
			} else {
				task = TaskLocalServiceUtil.getTask(taskId);

				task = TaskLocalServiceUtil.updateTask(taskId, userId, taskDescription, completed, initDate, endDate,
						serviceContext);
			}

			return task;
		} else {
			SessionErrors.add(request, "error");
			return null;
		}
	}

	/**
	 * Log
	 */
	private static Log _log = LogFactoryUtil.getLog(MimacomTaskPortlet.class);
}