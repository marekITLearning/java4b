CREATE TABLE public.rating (ID BIGINT NOT NULL, AVERAGERATING FLOAT, NUMVOTES INTEGER, TCONST VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE public.title (TCONST VARCHAR(255) NOT NULL, PRIMARYTITLE VARCHAR(255), STARTYEAR INTEGER, PRIMARY KEY (TCONST));
ALTER TABLE public.rating ADD CONSTRAINT FK_rating_TCONST FOREIGN KEY (TCONST) REFERENCES public.title (TCONST);
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0);
