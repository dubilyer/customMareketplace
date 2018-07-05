INSERT INTO users (id, username, encrypted_password) VALUES (1, 'superadmin@market.com', '$2a$11$cVLZ0xvw21g4.w6Fw2AX0.Hltxt6e1SRXmDuL5zdz1ipohQv9fr9G');
INSERT INTO roles (id, role) VALUES (1, 'ADMIN'), (2, 'USER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1), (1, 2);