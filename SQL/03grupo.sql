CREATE TABLE public."group"
(
    "group_id" serial,  
    "name" character varying(255)  not null  ,
    begin_date date  not null,
	  amount numeric(15,2)  not null,
	  period character(1)  not null, -- D=Daily...
	  state character(1)  not null, -- C=closed...
	  user_id integer not null,
)

ALTER TABLE public."group"
    ADD CONSTRAINT group_pkey PRIMARY KEY ("group_id");

  ALTER TABLE public."group"
  ADD CONSTRAINT user_fkey FOREIGN KEY (user_id)
      REFERENCES public."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
      
 ALTER TABLE public."group"
  ADD CONSTRAINT period_ck CHECK (period = ANY (ARRAY['D'::bpchar, 'W'::bpchar, 'M'::bpchar, 'O'::bpchar]));

  ALTER TABLE public."group"
  ADD CONSTRAINT state_ck CHECK (state = ANY (ARRAY['C'::bpchar, 'A'::bpchar, 'P'::bpchar]));

ALTER TABLE public."group"
  OWNER TO quyuser;
COMMENT ON COLUMN public."group".period IS 'D=Daily
W=Weekly
M=Montly';
COMMENT ON COLUMN public."group".state IS 'C=closed
A=Active
P=Preparation';
