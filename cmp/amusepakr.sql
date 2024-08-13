CREATE TABLE parttime(
part_time VARCHAR(20) NOT NULL,
start_time TIME,
end_time TIME,
PRIMARY KEY(part_time)
)

CREATE TABLE alba(
alba_id VARCHAR(20) NOT NULL,
alba_pw VARCHAR(30) NOT NULL,
alba_name VARCHAR(20) NOT NULL,
alba_birthday DATETIME NOT NULL,
alba_phone VARCHAR(20) NOT NULL,
part_time VARCHAR(20) NOT NULL,
workcheack BOOLEAN NOT NULL,
totalwork INT NOT null,
PRIMARY KEY(alba_id),
FOREIGN KEY(part_time) REFERENCES parttime (part_time)
)

CREATE TABLE employee(
em_id VARCHAR(20) NOT NULL,
em_pw VARCHAR(30) NOT NULL,
em_name VARCHAR(20) NOT NULL,
em_birthday DATETIME NOT NULL,
em_phone VARCHAR(20) NOT NULL,
em_position VARCHAR(20) NOT NULL,
em_department VARCHAR(30) NOT NULL,
em_manage INT NOT NULL,
usable_vacation INT NOT NULL,
PRIMARY KEY(em_id)
)

CREATE TABLE vacation(
request_id VARCHAR(20) NOT NULL,
vacation_start DATETIME NOT NULL,
vacation_end DATETIME NOT NULL,
vacation_reason VARCHAR(100) NOT NULL,
PRIMARY KEY(request_id),
FOREIGN KEY(request_id) REFERENCES employee (em_id)
)

CREATE TABLE SCHEDULE(
schedule_num INT AUTO_INCREMENT,
writer_id VARCHAR(30) NOT NULL,
schedule_contents VARCHAR(100) NOT NULL,
schedule_start TIMESTAMP NOT NULL,
schedule_end TIMESTAMP NOT NULL,
PRIMARY KEY(schedule_num),
FOREIGN KEY(writer_id) REFERENCES employee (em_id)
)

CREATE TABLE todo(
todo_num INT AUTO_INCREMENT,
writer_id VARCHAR(20) NOT NULL,
todo_contents VARCHAR(100) NOT NULL,
PRIMARY KEY(todo_num),
FOREIGN KEY(writer_id) REFERENCES employee (em_id)
)

CREATE table alba_substitute(
sub_num INT AUTO_INCREMENT,
req_alba_id VARCHAR(20) NOT NULL,
sub_alba_id VARCHAR(20) NOT NULL,
sub_start TIMESTAMP NOT NULL,
sub_end TIMESTAMP NOT NULL,
PRIMARY KEY(sub_num),
FOREIGN KEY(req_alba_id) REFERENCES alba (alba_id),
FOREIGN KEY(sub_alba_id) REFERENCES alba (alba_id)
)

CREATE TABLE employee_work(
work_num INT AUTO_INCREMENT,
em_id VARCHAR(20) NOT null,
work_start TIMESTAMP NOT NULL,
work_ent TIMESTAMP NOT NULL,
PRIMARY KEY(work_num),
FOREIGN KEY(em_id) REFERENCES employee(em_id)
)

CREATE TABLE alba_inquire(
inquire_num INT AUTO_INCREMENT,
inquire_id VARCHAR(20) NOT NULL,
inquire_contents VARCHAR(100) NOT NULL,
reply_contents VARCHAR(100) NOT NULL,
PRIMARY KEY(inquire_num),
FOREIGN KEY(inquire_id) REFERENCES alba(alba_id)
)

CREATE TABLE chat(
chat_num INT AUTO_INCREMENT,
send_id VARCHAR(20) NOT NULL,
receive_id VARCHAR(20) NOT NULL,
cat_contents VARCHAR(1000) NOT NULL,
PRIMARY KEY(chat_num),
FOREIGN KEY(send_id) REFERENCES employee(em_id),
FOREIGN KEY(receive_id) REFERENCES employee(em_id)
)

INSERT INTO employee VALUES('asdf123', '12345', '홍길동', '20010101', '010-1234-1234', '대리', '인사팀', 0, 14);