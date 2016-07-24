CREATE TABLE public."group"
(
    "group_id" serial,  
    "name" character varying(255)      
)

ALTER TABLE public."group"
    ADD CONSTRAINT group_pkey PRIMARY KEY ("group_id");

