-- Table: public.profile

-- DROP TABLE public.profile;

CREATE TABLE public.profile
(
  id integer NOT NULL DEFAULT nextval('profile_id_seq'::regclass),
  name character varying(45),
  last_name character varying(45),
  email character varying(45),
  password character varying(45)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.profile
  OWNER TO postgres;