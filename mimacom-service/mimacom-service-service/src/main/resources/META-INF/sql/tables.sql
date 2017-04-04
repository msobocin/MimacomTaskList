create table Task_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	task VARCHAR(75) null,
	completed BOOLEAN,
	initDate DATE null,
	endDate DATE null
);