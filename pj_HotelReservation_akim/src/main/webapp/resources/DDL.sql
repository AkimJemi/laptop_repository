-- public.seq_booking definition

-- DROP SEQUENCE public.seq_booking;

CREATE SEQUENCE public.seq_booking
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.seq_notice definition

-- DROP SEQUENCE public.seq_notice;

CREATE SEQUENCE public.seq_notice
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.seq_option definition

-- DROP SEQUENCE public.seq_option;

CREATE SEQUENCE public.seq_option
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.seq_sample definition

-- DROP SEQUENCE public.seq_sample;

CREATE SEQUENCE public.seq_sample
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.seq_user definition

-- DROP SEQUENCE public.seq_user;

CREATE SEQUENCE public.seq_user
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.sql_room_info definition

-- DROP SEQUENCE public.sql_room_info;

CREATE SEQUENCE public.sql_room_info
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- public."notice" definition

-- Drop table

-- DROP TABLE public."notice";

CREATE TABLE public."notice" (
	id int4 NOT NULL DEFAULT nextval('seq_notice'::regclass),
	title varchar(200) NULL,
	"content" varchar(3000) NOT NULL,
	start_dt varchar(8) NOT NULL,
	end_dt varchar(8) NOT NULL,
	delete_flag bool NOT NULL DEFAULT false,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT notice_pkey PRIMARY KEY (id)
);


-- public."options" definition

-- Drop table

-- DROP TABLE public."options";

CREATE TABLE public."options" (
	id int4 NOT NULL DEFAULT nextval('seq_option'::regclass),
	room_cd varchar(2) NOT NULL DEFAULT '1'::character varying,
	booking_cd varchar(3) NOT NULL DEFAULT '100'::character varying,
	info varchar(100) NOT NULL,
	price int4 NOT NULL DEFAULT 0,
	delete_flag bool NOT NULL DEFAULT false,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT option_pkey PRIMARY KEY (id)
);


-- public.room_info definition

-- Drop table

-- DROP TABLE public.room_info;

CREATE TABLE public.room_info (
	id int4 NOT NULL DEFAULT nextval('sql_room_info'::regclass),
	room_name varchar(4) NOT NULL,
	max_count int4 NOT NULL DEFAULT 4,
	info varchar(2000) NOT NULL,
	"options" varchar(100) NOT NULL,
	images varchar(1000) NULL,
	price int4 NOT NULL DEFAULT 0,
	delete_flag bool NOT NULL DEFAULT false,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT room_pkey PRIMARY KEY (id)
);


-- public.sample definition

-- Drop table

-- DROP TABLE public.sample;

CREATE TABLE public.sample (
	id int4 NOT NULL DEFAULT nextval('seq_sample'::regclass),
	title varchar(200) NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT sample_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id int4 NOT NULL DEFAULT nextval('seq_user'::regclass),
	"name" varchar(30) NOT NULL,
	phone varchar(11) NOT NULL,
	email varchar(50) NOT NULL,
	"password" varchar(50) NULL,
	"temporary" bool NOT NULL DEFAULT true,
	"role" varchar(1) NOT NULL DEFAULT '2'::character varying,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	delete_flag bool NOT NULL DEFAULT false,
	CONSTRAINT user_pkey PRIMARY KEY (id)
);


-- public.bookings definition

-- Drop table

-- DROP TABLE public.bookings;

CREATE TABLE public.bookings (
	id int4 NOT NULL DEFAULT nextval('seq_booking'::regclass),
	user_id int4 NOT NULL,
	room_id int4 NOT NULL,
	price int4 NOT NULL DEFAULT 0,
	pay_flag bool NOT NULL DEFAULT false,
	cancel_flag bool NOT NULL DEFAULT false,
	adult_cnt int4 NOT NULL DEFAULT 1,
	children_cnt int4 NULL DEFAULT 0,
	start_dt varchar(8) NOT NULL,
	end_dt varchar(8) NOT NULL,
	"options" varchar(20) NULL,
	delete_flag bool NOT NULL DEFAULT false,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT booking_pkey PRIMARY KEY (id),
	CONSTRAINT root_fk FOREIGN KEY (room_id) REFERENCES public.room_info(id),
	CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id)
);