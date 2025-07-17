
alter session set "_ORACLE_SCRIPT"=true;


CREATE USER planetwars IDENTIFIED BY planetwars;
GRANT ALL PRIVILEGES TO planetwars;

COMMIT;