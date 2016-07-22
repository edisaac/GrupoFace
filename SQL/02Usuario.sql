CREATE TABLE public."user"
(
    "USER_ID" serial,  
    "NAME" character varying(255) ,
    "FACEBOOK_ID" character varying(255) ,
    "URL_PICTURE" character varying(1000) 
)


ALTER TABLE public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY ("USER_ID");


ALTER TABLE public."user"
    ADD CONSTRAINT "user_FACEBOOK_ID_key" UNIQUE ("FACEBOOK_ID");
