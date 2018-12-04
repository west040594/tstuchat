insert into tb_user(username, password, first_name, last_name, email, status, role, created_at)
values ('admin','$2a$10$obBq7iGa/cdX07CSTj7XPeqFKPDBbKvc1giOjR69JBlSkcbCtj4S6','Admin','Admin','admin@example.com', 1, 1, CURRENT_TIMESTAMP);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Фильмы', 'Обсуждение фильмов', 1, 0, CURRENT_TIMESTAMP, 1);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Cериалы', 'Обсуждение сериалов', 1, 0, CURRENT_TIMESTAMP, 1);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Книги', 'Обсуждение книг', 1, 0, CURRENT_TIMESTAMP, 1);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Аниме', 'Обсуждение аниме', 1, 0, CURRENT_TIMESTAMP, 1);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Комиксы', 'Обсуждение комиксов', 1, 0, CURRENT_TIMESTAMP, 1);

insert into tb_chat(name, description, status, type, created_at, user_id)
values('Игры', 'Обсуждение игр', 1, 0, CURRENT_TIMESTAMP, 1);