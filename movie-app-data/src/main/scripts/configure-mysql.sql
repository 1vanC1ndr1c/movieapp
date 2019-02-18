# connect to mysql and run as root user
#Create Databases
CREATE DATABASE bpif_dev;
CREATE DATABASE bpif_prod;

#Create database service accounts
CREATE USER 'bpif_dev_user'@'localhost' IDENTIFIED BY 'bpif';
CREATE USER 'bpif_prod_user'@'localhost' IDENTIFIED BY 'bpif';
CREATE USER 'bpif_dev_user'@'%' IDENTIFIED BY 'bpif';
CREATE USER 'bpif_prod_user'@'%' IDENTIFIED BY 'bpif';

#Database grants
GRANT SELECT ON bpif_dev.* to 'bpif_dev_user'@'localhost';
GRANT INSERT ON bpif_dev.* to 'bpif_dev_user'@'localhost';
GRANT DELETE ON bpif_dev.* to 'bpif_dev_user'@'localhost';
GRANT UPDATE ON bpif_dev.* to 'bpif_dev_user'@'localhost';
GRANT SELECT ON bpif_prod.* to 'bpif_prod_user'@'localhost';
GRANT INSERT ON bpif_prod.* to 'bpif_prod_user'@'localhost';
GRANT DELETE ON bpif_prod.* to 'bpif_prod_user'@'localhost';
GRANT UPDATE ON bpif_prod.* to 'bpif_prod_user'@'localhost';
GRANT SELECT ON bpif_dev.* to 'bpif_dev_user'@'%';
GRANT INSERT ON bpif_dev.* to 'bpif_dev_user'@'%';
GRANT DELETE ON bpif_dev.* to 'bpif_dev_user'@'%';
GRANT UPDATE ON bpif_dev.* to 'bpif_dev_user'@'%';
GRANT SELECT ON bpif_prod.* to 'bpif_prod_user'@'%';
GRANT INSERT ON bpif_prod.* to 'bpif_prod_user'@'%';
GRANT DELETE ON bpif_prod.* to 'bpif_prod_user'@'%';
GRANT UPDATE ON bpif_prod.* to 'bpif_prod_user'@'%';
GRANT ALL ON bpif_dev.* to 'bpif_dev_user'@'localhost';