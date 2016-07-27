CREATE TABLE public."detail_group"
(	"id" serial,
    "group_id" integer not null,  
    "user_id" integer not null,
   "position" integer not null,
  rol character(1) not null, -- A=Admin...
  state character(1) not null, -- P=Invited...
     
)

ALTER TABLE public."detail_group"
    ADD CONSTRAINT detail_group_pkey PRIMARY KEY ("id");

ALTER TABLE public.detail_group
  ADD CONSTRAINT group_detail_group_fkey FOREIGN KEY (group_id)
      REFERENCES public."group" (group_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
      
ALTER TABLE public.detail_group
  ADD CONSTRAINT user_detail_group_fkey FOREIGN KEY (user_id)
      REFERENCES public."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE public.detail_group
  ADD CONSTRAINT detail_group_group_id_user_id_key UNIQUE(group_id, user_id);
ALTER TABLE public.detail_group
  ADD CONSTRAINT "rol_CK" CHECK (rol = ANY (ARRAY['A'::bpchar, 'N'::bpchar]));

  ALTER TABLE public.detail_group
  ADD CONSTRAINT state_ck CHECK (state = ANY (ARRAY['A'::bpchar, 'P'::bpchar, 'C'::bpchar]));

  COMMENT ON COLUMN public.detail_group.rol IS 'A=Admin
N=Normal';
COMMENT ON COLUMN public.detail_group.state IS 'P=Invited
A=active
C=closed';
