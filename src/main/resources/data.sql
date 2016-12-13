insert into user(username, name, second_name, email, password)
values('ronaldo', 'Christiano', 'Ronaldo', 'ronaldo@gmail.com', '$2a$10$chkYYy3512kSzmgdKRkT6O8x7tV.DDn4E/fi8Vm1OOgHzxFbpOvRa');

insert into user(username, name, second_name, email, password)
values('messi', 'Leonel', 'Messi', 'messi@gmail.com', '$2a$10$ek7mLiU2ceVBFPOD7hmcVuVLwhJ8JODCbqpavROsZH/sQmd0xYNJm');

INSERT INTO user_roles (username, role)
VALUES ('ronaldo', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('ronaldo', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('messi', 'ROLE_USER');

