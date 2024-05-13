-- liquibase formatted sql

-- changeset chandantiwari:1715584481149-1
-- preconditions onFail:MARK_RAN onError:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_name='employee'
CREATE TABLE "employee" ("emp_id" INTEGER NOT NULL, "emp_company" VARCHAR(255), "emp_email" VARCHAR(255), "emp_name" VARCHAR(255), CONSTRAINT "employee_pkey" PRIMARY KEY ("emp_id"));
-- rollback DROP TABLE employee

-- changeset chandantiwari:1715584526242-1
-- precondition-sql-check expectedResult:0 select count(*) from employee
INSERT INTO "employee" ("emp_id", "emp_company", "emp_email", "emp_name") VALUES (1, 'Google', 'chandan.tiwari@google.com', 'Chandan Tiwari');
INSERT INTO "employee" ("emp_id", "emp_company", "emp_email", "emp_name") VALUES (2, 'Accenture', 'rajat.kumar@Accenture.com', 'Rajat Kumar');
-- rollback TRUNCATE TABLE employee

-- changeset chandantiwari:23123134
CREATE TABLE "student" ("stu_id" INTEGER NOT NULL, "stu_school" VARCHAR(255), "stu_email" VARCHAR(255), "stu_name" VARCHAR(255), CONSTRAINT "student_pkey" PRIMARY KEY ("stu_id"));
-- rollback DROP TABLE student

-- changeset cahndantiwari:564564354
ALTER TABLE "student" ADD COLUMN stu_marks INTEGER;