CREATE TABLE public."detail_group"
(	"id" serial,
    "group_id" integer,  
    "user_id" integer,
    "user_order" integer 
     
)

ALTER TABLE public."detail_group"
    ADD CONSTRAINT detail_group_pkey PRIMARY KEY ("id");

