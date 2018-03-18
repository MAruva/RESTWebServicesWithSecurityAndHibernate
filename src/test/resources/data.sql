INSERT INTO user (id, first_name, last_name, email, password)
VALUES (1, 'Memory', 'Not Found', 'codingisfun@maruva.com',
 '$codingisfun');

INSERT INTO role (id, name) VALUES (1, 'GUEST');
INSERT INTO role (id, name) VALUES (2, 'ADMIN');
INSERT INTO role (id, name) VALUES (3, 'BILLER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
