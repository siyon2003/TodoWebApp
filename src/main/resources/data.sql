--It will execute at the start of the application
--It will start to execute before the Entity is being processed - before table is created
--It will only executed for in-memory database

INSERT INTO todo (ID, USER_NAME, DESCRIPTION, TARGET_DATE, DONE)
VALUES (1001,'siyo', 'Learn MLOps',CURRENT_DATE(), false);

INSERT INTO todo (ID, USER_NAME, DESCRIPTION, TARGET_DATE, DONE)
VALUES (1002,'siyo', 'Learn DevOps',CURRENT_DATE(), false);

INSERT INTO todo (ID, USER_NAME, DESCRIPTION, TARGET_DATE, DONE)
VALUES (1003,'siyo', 'Learn AWS',CURRENT_DATE(), false);



