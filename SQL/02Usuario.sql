CREATE TABLE public."user"
(
    "user_id" serial,  
    "name" character varying(255) ,
    "facebook_id" character varying(255) ,
    "url_picture" character varying(1000) 
)


ALTER TABLE public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY ("user_id");


ALTER TABLE public."user"
    ADD CONSTRAINT "user_FACEBOOK_ID_key" UNIQUE ("facebook_id");
