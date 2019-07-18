CREATE TABLE IF NOT EXISTS code_category (
     code_category_id serial NOT NULL
   , category_key character varying(50)
   , category_name character varying(50)
   , created_by character varying(50)
   , created_at timestamp
   , updated_by character varying(50)
   , updated_at timestamp
   , PRIMARY KEY (code_category_id)
);