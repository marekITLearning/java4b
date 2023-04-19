1. Visit https://www.imdb.com/interfaces/ 
 - download title.basics.tsv.gz and title.rating.tsv.gz
 - unzip title.basics.tsv.gz to C:\devel\projects\java4b\app_jee_jpa file name title.basics.tsv
 - unzip title.rating.tsv.gz to C:\devel\projects\java4b\app_jee_jpa with file name title.rating.tsv

2.
- opend cmd
- cd C:\devel\projects\java4b\app_jee_jpa
- run command (to create imdb database)
"C:\devel\PostgreSQL\15\bin\psql" -U postgres -a -q -f C:\devel\projects\java4b\app_jee_jpa\src\main\sql\app-db-postgres-create.sql

- run command (to create database schema (tablese))
"C:\devel\PostgreSQL\15\bin\psql" -U postgres -d imdb -a -q -f C:\devel\projects\java4b\app_jee_jpa\src\main\sql\app-db-schema-postgres-create.sql

- connect to db with command
"C:\devel\PostgreSQL\15\bin\psql" -d imdb -U postgres

\copy title(tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) FROM 'title.basics.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER NULL '\N' QUOTE E'\b'

\copy rating(tconst, averageRating, numVotes) FROM 'title.rating.tsv' DELIMITER E'\t' CSV ENCODING 'UTF8' HEADER
