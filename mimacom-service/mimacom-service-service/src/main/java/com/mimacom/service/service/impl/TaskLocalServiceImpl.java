/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mimacom.service.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mimacom.service.exception.NoSuchTaskException;
import com.mimacom.service.model.Task;
import com.mimacom.service.service.TaskLocalServiceUtil;
import com.mimacom.service.service.base.TaskLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.mimacom.service.service.TaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Michal Sobocinski
 * @see TaskLocalServiceBaseImpl
 * @see com.mimacom.service.service.TaskLocalServiceUtil
 */
@ProviderType
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	
	public Task addTask(long userId, String taskDescription, boolean completed, Date initDate, Date endDate, long groupId,
			ServiceContext serviceContext) throws PortalException {
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long taskId = counterLocalService.increment(Task.class.getName());

		Task task = taskPersistence.create(taskId);

		task.setTask(taskDescription);
		task.setInitDate(initDate);
		task.setEndDate(endDate);

		task.setGroupId(groupId);
		task.setCompanyId(user.getCompanyId());
		task.setUserId(user.getUserId());
		task.setCompleted(completed);
		task.setCreateDate(serviceContext.getCreateDate(now));
		task.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addTask(task);
		
		return task;
	}

	public Task deleteTask(Task task) {
		return taskPersistence.remove(task);
	}

	public Task deleteTask(long taskId) throws NoSuchTaskException {
		Task task = taskPersistence.findByPrimaryKey(taskId);

		return deleteTask(task);
	}

	public Task getTask(long taskId) throws NoSuchTaskException {

		return taskPersistence.findByPrimaryKey(taskId);
	}
	
	public List<Task> getTasksByUserId(long userId) {
		return taskPersistence.findByUserId(userId);
	}

	public int getTaskCount() {
		return taskPersistence.countAll();
	}

	public int getTaskCountByUserId(long userId) {
		return taskPersistence.countByUserId(userId);
	}
	
	public int getTaskByCompletedTask(boolean completed) {
		return taskPersistence.countByCompleted(completed);
	}
	
	public int getTaskByCompletedUserTasks(boolean completed, int userId) {
		return taskPersistence.countByCompletedByUser(completed, userId);
	}

	public Task updateTask(long taskId, long userId, String taskDescription, boolean completed, Date initDate,
			Date endDate, ServiceContext serviceContext) throws NoSuchUserException {

		//Check if user exist in the portal
		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		Task task = TaskLocalServiceUtil.fetchTask(taskId);
		
		//Only update if userId == task.userId
		if (task.getUserId() == userId) {
			task.setModifiedDate(serviceContext.getModifiedDate(now));
			task.setTask(taskDescription);
			task.setCompleted(completed);
			task.setInitDate(initDate);
			task.setEndDate(endDate);

			super.updateTask(task);
		} else {
			throw new NoSuchUserException("USER ID NOT EQUALS WITH TASK USER ID!");
		}

		return task;
	}
}