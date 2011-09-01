CREATE TABLE employees
(
  employee_id character(5) NOT NULL,
  "password" character(64) NOT NULL,
  kanji_last_name character varying(10) NOT NULL,
  kanji_first_name character varying(10) NOT NULL,
  sex character(1) NOT NULL DEFAULT 'M'::bpchar,
  enter_date date NOT NULL,
  branch character(4) NOT NULL,
  email character varying(256),
  CONSTRAINT employees_pkey PRIMARY KEY (employee_id)
)