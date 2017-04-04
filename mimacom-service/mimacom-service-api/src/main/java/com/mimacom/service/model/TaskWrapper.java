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

package com.mimacom.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Task
 * @generated
 */
@ProviderType
public class TaskWrapper implements Task, ModelWrapper<Task> {
	public TaskWrapper(Task task) {
		_task = task;
	}

	@Override
	public Class<?> getModelClass() {
		return Task.class;
	}

	@Override
	public String getModelClassName() {
		return Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("task", getTask());
		attributes.put("completed", getCompleted());
		attributes.put("initDate", getInitDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Date initDate = (Date)attributes.get("initDate");

		if (initDate != null) {
			setInitDate(initDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public Task toEscapedModel() {
		return new TaskWrapper(_task.toEscapedModel());
	}

	@Override
	public Task toUnescapedModel() {
		return new TaskWrapper(_task.toUnescapedModel());
	}

	/**
	* Returns the completed of this task.
	*
	* @return the completed of this task
	*/
	@Override
	public boolean getCompleted() {
		return _task.getCompleted();
	}

	@Override
	public boolean isCachedModel() {
		return _task.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this task is completed.
	*
	* @return <code>true</code> if this task is completed; <code>false</code> otherwise
	*/
	@Override
	public boolean isCompleted() {
		return _task.isCompleted();
	}

	@Override
	public boolean isEscapedModel() {
		return _task.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _task.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _task.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Task> toCacheModel() {
		return _task.toCacheModel();
	}

	@Override
	public int compareTo(Task task) {
		return _task.compareTo(task);
	}

	@Override
	public int hashCode() {
		return _task.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _task.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TaskWrapper((Task)_task.clone());
	}

	/**
	* Returns the task of this task.
	*
	* @return the task of this task
	*/
	@Override
	public java.lang.String getTask() {
		return _task.getTask();
	}

	/**
	* Returns the user name of this task.
	*
	* @return the user name of this task
	*/
	@Override
	public java.lang.String getUserName() {
		return _task.getUserName();
	}

	/**
	* Returns the user uuid of this task.
	*
	* @return the user uuid of this task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _task.getUserUuid();
	}

	/**
	* Returns the uuid of this task.
	*
	* @return the uuid of this task
	*/
	@Override
	public java.lang.String getUuid() {
		return _task.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _task.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _task.toXmlString();
	}

	/**
	* Returns the create date of this task.
	*
	* @return the create date of this task
	*/
	@Override
	public Date getCreateDate() {
		return _task.getCreateDate();
	}

	/**
	* Returns the end date of this task.
	*
	* @return the end date of this task
	*/
	@Override
	public Date getEndDate() {
		return _task.getEndDate();
	}

	/**
	* Returns the init date of this task.
	*
	* @return the init date of this task
	*/
	@Override
	public Date getInitDate() {
		return _task.getInitDate();
	}

	/**
	* Returns the modified date of this task.
	*
	* @return the modified date of this task
	*/
	@Override
	public Date getModifiedDate() {
		return _task.getModifiedDate();
	}

	/**
	* Returns the company ID of this task.
	*
	* @return the company ID of this task
	*/
	@Override
	public long getCompanyId() {
		return _task.getCompanyId();
	}

	/**
	* Returns the group ID of this task.
	*
	* @return the group ID of this task
	*/
	@Override
	public long getGroupId() {
		return _task.getGroupId();
	}

	/**
	* Returns the primary key of this task.
	*
	* @return the primary key of this task
	*/
	@Override
	public long getPrimaryKey() {
		return _task.getPrimaryKey();
	}

	/**
	* Returns the task ID of this task.
	*
	* @return the task ID of this task
	*/
	@Override
	public long getTaskId() {
		return _task.getTaskId();
	}

	/**
	* Returns the user ID of this task.
	*
	* @return the user ID of this task
	*/
	@Override
	public long getUserId() {
		return _task.getUserId();
	}

	@Override
	public void persist() {
		_task.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_task.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this task.
	*
	* @param companyId the company ID of this task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_task.setCompanyId(companyId);
	}

	/**
	* Sets whether this task is completed.
	*
	* @param completed the completed of this task
	*/
	@Override
	public void setCompleted(boolean completed) {
		_task.setCompleted(completed);
	}

	/**
	* Sets the create date of this task.
	*
	* @param createDate the create date of this task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_task.setCreateDate(createDate);
	}

	/**
	* Sets the end date of this task.
	*
	* @param endDate the end date of this task
	*/
	@Override
	public void setEndDate(Date endDate) {
		_task.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_task.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_task.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_task.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this task.
	*
	* @param groupId the group ID of this task
	*/
	@Override
	public void setGroupId(long groupId) {
		_task.setGroupId(groupId);
	}

	/**
	* Sets the init date of this task.
	*
	* @param initDate the init date of this task
	*/
	@Override
	public void setInitDate(Date initDate) {
		_task.setInitDate(initDate);
	}

	/**
	* Sets the modified date of this task.
	*
	* @param modifiedDate the modified date of this task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_task.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_task.setNew(n);
	}

	/**
	* Sets the primary key of this task.
	*
	* @param primaryKey the primary key of this task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_task.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_task.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the task of this task.
	*
	* @param task the task of this task
	*/
	@Override
	public void setTask(java.lang.String task) {
		_task.setTask(task);
	}

	/**
	* Sets the task ID of this task.
	*
	* @param taskId the task ID of this task
	*/
	@Override
	public void setTaskId(long taskId) {
		_task.setTaskId(taskId);
	}

	/**
	* Sets the user ID of this task.
	*
	* @param userId the user ID of this task
	*/
	@Override
	public void setUserId(long userId) {
		_task.setUserId(userId);
	}

	/**
	* Sets the user name of this task.
	*
	* @param userName the user name of this task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_task.setUserName(userName);
	}

	/**
	* Sets the user uuid of this task.
	*
	* @param userUuid the user uuid of this task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_task.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this task.
	*
	* @param uuid the uuid of this task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_task.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskWrapper)) {
			return false;
		}

		TaskWrapper taskWrapper = (TaskWrapper)obj;

		if (Objects.equals(_task, taskWrapper._task)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _task.getStagedModelType();
	}

	@Override
	public Task getWrappedModel() {
		return _task;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _task.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _task.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_task.resetOriginalValues();
	}

	private final Task _task;
}