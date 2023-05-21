CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS notifications (
id UUID DEFAULT uuid_generate_v4(),
body text,
userId varchar(10),
tenant varchar(256),
hasRead boolean default false,
priority varchar(256) default 'MEDIUM',
create_time timestamp default now(),
read_at timestamp
);