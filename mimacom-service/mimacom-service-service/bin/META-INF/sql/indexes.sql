create index IX_6DCD5C50 on Task_Task (completed, userId);
create index IX_A4A97B3F on Task_Task (userId);
create index IX_F14E62B9 on Task_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7652437B on Task_Task (uuid_[$COLUMN_LENGTH:75$], groupId);