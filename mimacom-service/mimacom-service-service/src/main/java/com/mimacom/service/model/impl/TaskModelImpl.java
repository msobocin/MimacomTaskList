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

package com.mimacom.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.mimacom.service.model.Task;
import com.mimacom.service.model.TaskModel;
import com.mimacom.service.model.TaskSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Task service. Represents a row in the &quot;Task_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskImpl
 * @see Task
 * @see TaskModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TaskModelImpl extends BaseModelImpl<Task> implements TaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task model instance should use the {@link Task} interface instead.
	 */
	public static final String TABLE_NAME = "Task_Task";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "taskId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "task", Types.VARCHAR },
			{ "completed", Types.BOOLEAN },
			{ "initDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("task", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("completed", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("initDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table Task_Task (uuid_ VARCHAR(75) null,taskId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,task VARCHAR(75) null,completed BOOLEAN,initDate DATE null,endDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Task_Task";
	public static final String ORDER_BY_JPQL = " ORDER BY task.taskId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Task_Task.taskId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.mimacom.service.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.mimacom.service.model.Task"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.mimacom.service.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.mimacom.service.model.Task"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.mimacom.service.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.mimacom.service.model.Task"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long COMPLETED_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long TASKID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Task toModel(TaskSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Task model = new TaskImpl();

		model.setUuid(soapModel.getUuid());
		model.setTaskId(soapModel.getTaskId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTask(soapModel.getTask());
		model.setCompleted(soapModel.getCompleted());
		model.setInitDate(soapModel.getInitDate());
		model.setEndDate(soapModel.getEndDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Task> toModels(TaskSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Task> models = new ArrayList<Task>(soapModels.length);

		for (TaskSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.mimacom.service.service.util.ServiceProps.get(
				"lock.expiration.time.com.mimacom.service.model.Task"));

	public TaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public void setTaskId(long taskId) {
		_columnBitmask = -1L;

		_taskId = taskId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTask() {
		if (_task == null) {
			return StringPool.BLANK;
		}
		else {
			return _task;
		}
	}

	@Override
	public void setTask(String task) {
		_task = task;
	}

	@JSON
	@Override
	public boolean getCompleted() {
		return _completed;
	}

	@JSON
	@Override
	public boolean isCompleted() {
		return _completed;
	}

	@Override
	public void setCompleted(boolean completed) {
		_columnBitmask |= COMPLETED_COLUMN_BITMASK;

		if (!_setOriginalCompleted) {
			_setOriginalCompleted = true;

			_originalCompleted = _completed;
		}

		_completed = completed;
	}

	public boolean getOriginalCompleted() {
		return _originalCompleted;
	}

	@JSON
	@Override
	public Date getInitDate() {
		return _initDate;
	}

	@Override
	public void setInitDate(Date initDate) {
		_initDate = initDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Task.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Task.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Task toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Task)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskImpl taskImpl = new TaskImpl();

		taskImpl.setUuid(getUuid());
		taskImpl.setTaskId(getTaskId());
		taskImpl.setGroupId(getGroupId());
		taskImpl.setCompanyId(getCompanyId());
		taskImpl.setUserId(getUserId());
		taskImpl.setUserName(getUserName());
		taskImpl.setCreateDate(getCreateDate());
		taskImpl.setModifiedDate(getModifiedDate());
		taskImpl.setTask(getTask());
		taskImpl.setCompleted(getCompleted());
		taskImpl.setInitDate(getInitDate());
		taskImpl.setEndDate(getEndDate());

		taskImpl.resetOriginalValues();

		return taskImpl;
	}

	@Override
	public int compareTo(Task task) {
		int value = 0;

		if (getTaskId() < task.getTaskId()) {
			value = -1;
		}
		else if (getTaskId() > task.getTaskId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Task)) {
			return false;
		}

		Task task = (Task)obj;

		long primaryKey = task.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TaskModelImpl taskModelImpl = this;

		taskModelImpl._originalUuid = taskModelImpl._uuid;

		taskModelImpl._originalGroupId = taskModelImpl._groupId;

		taskModelImpl._setOriginalGroupId = false;

		taskModelImpl._originalCompanyId = taskModelImpl._companyId;

		taskModelImpl._setOriginalCompanyId = false;

		taskModelImpl._originalUserId = taskModelImpl._userId;

		taskModelImpl._setOriginalUserId = false;

		taskModelImpl._setModifiedDate = false;

		taskModelImpl._originalCompleted = taskModelImpl._completed;

		taskModelImpl._setOriginalCompleted = false;

		taskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Task> toCacheModel() {
		TaskCacheModel taskCacheModel = new TaskCacheModel();

		taskCacheModel.uuid = getUuid();

		String uuid = taskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			taskCacheModel.uuid = null;
		}

		taskCacheModel.taskId = getTaskId();

		taskCacheModel.groupId = getGroupId();

		taskCacheModel.companyId = getCompanyId();

		taskCacheModel.userId = getUserId();

		taskCacheModel.userName = getUserName();

		String userName = taskCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			taskCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			taskCacheModel.createDate = createDate.getTime();
		}
		else {
			taskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			taskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			taskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		taskCacheModel.task = getTask();

		String task = taskCacheModel.task;

		if ((task != null) && (task.length() == 0)) {
			taskCacheModel.task = null;
		}

		taskCacheModel.completed = getCompleted();

		Date initDate = getInitDate();

		if (initDate != null) {
			taskCacheModel.initDate = initDate.getTime();
		}
		else {
			taskCacheModel.initDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			taskCacheModel.endDate = endDate.getTime();
		}
		else {
			taskCacheModel.endDate = Long.MIN_VALUE;
		}

		return taskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", taskId=");
		sb.append(getTaskId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", task=");
		sb.append(getTask());
		sb.append(", completed=");
		sb.append(getCompleted());
		sb.append(", initDate=");
		sb.append(getInitDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.mimacom.service.model.Task");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskId</column-name><column-value><![CDATA[");
		sb.append(getTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>task</column-name><column-value><![CDATA[");
		sb.append(getTask());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completed</column-name><column-value><![CDATA[");
		sb.append(getCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initDate</column-name><column-value><![CDATA[");
		sb.append(getInitDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Task.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Task.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _taskId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _task;
	private boolean _completed;
	private boolean _originalCompleted;
	private boolean _setOriginalCompleted;
	private Date _initDate;
	private Date _endDate;
	private long _columnBitmask;
	private Task _escapedModel;
}