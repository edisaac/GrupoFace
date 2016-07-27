CREATE OR REPLACE FUNCTION ftg_group_ai_detail() RETURNS TRIGGER
AS $ftg_group_ai_detail$
    
 BEGIN
	IF (TG_OP = 'INSERT') THEN
		INSERT INTO 
		public.detail_group(group_id,user_id,position,rol,state)
		 VALUES(new.group_id, new.user_id, 1,'A','A');	
		RETURN NEW;
        END IF;
        RETURN NULL;	    
 
   END;
$ftg_group_ai_detail$ LANGUAGE plpgsql;
   
 CREATE TRIGGER tg_group_ai_detail
AFTER INSERT on public.group
    FOR EACH ROW EXECUTE PROCEDURE ftg_group_ai_detail();