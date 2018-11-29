CREATE TABLE IF NOT EXISTS tb_user (
  id serial NOT NULL,
  username character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  first_name character varying(255),
  last_name character varying(255),
  email character varying(255) NOT NULL,
  status smallint DEFAULT 1,
  role smallint DEFAULT 1,
  created_at timestamp,
  UNIQUE(id)
);

CREATE TABLE IF NOT EXISTS tb_chat (
  id serial NOT NULL,
  name character varying(255) NOT NULL,
  description text,
  status smallint DEFAULT 1,
  type smallint DEFAULT 0,
  created_at timestamp,
  closed_at timestamp,
  user_id integer,
  UNIQUE(id),
  constraint fk_user_id
    foreign key (user_id)
    references tb_user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS tb_message (
  id serial NOT NULL,
  text character varying(255) NOT NULL,
  created_at timestamp,
  user_id integer,
  chat_id integer,
  UNIQUE(id),

  constraint fk_user_id
    foreign key (user_id)
    references tb_user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    constraint fk_chat_id
    foreign key (chat_id)
    references tb_chat (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


