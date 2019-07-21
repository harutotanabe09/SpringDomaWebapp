CREATE TABLE IF NOT EXISTS users (
     user_name character varying(50) NULL
   , password character varying(255)
   , created_by character varying(50)
   , created_at timestamp
   , PRIMARY KEY (user_name)
);

INSERT INTO users(user_name,  password, created_by, created_at) VALUES
('john1' , '$2a$06$hY5MzfruCds1t5uFLzrlBuw3HcrEGeysr9xJE4Cml5xEOVf425pmK', 'none', NOW());

INSERT INTO users(user_name,  password, created_by, created_at) VALUES
('css1' , '$2a$10$vHuMFWsWzAccWlsJ6G6woOb4iXNPgAGKg.lJp9WPJT2drD.spuCrW', 'none', NOW());

INSERT INTO users(user_name,  password, created_by, created_at) VALUES
('sa1' , 'admin', 'none', NOW());
