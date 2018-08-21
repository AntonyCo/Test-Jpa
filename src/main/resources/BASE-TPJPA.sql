CREATE DATABASE tpJPA;
USE tpJPA;


DROP TABLE IF EXISTS CLIENT ;
DROP TABLE IF EXISTS LIVRE ;
DROP TABLE IF EXISTS EMPRUNT ;
DROP TABLE IF EXISTS COMPO ;

create table CLIENT (ID integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, NOM varchar(50) NOT NULL, PRENOM varchar(50) NOT NULL); 
create table LIVRE (ID integer(10) NOT NULL PRIMARY KEY, TITRE varchar(255) NOT NULL, AUTEUR varchar(50) NOT NULL); 
create table EMPRUNT (ID integer(10) NOT NULL PRIMARY KEY, DATE_DEBUT DATETIME NOT NULL, DATE_FIN DATETIME,DELAI integer(10), ID_CLIENT integer(10) not null); 
CREATE TABLE COMPO (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ID_LIV integer(10) NOT NULL, ID_EMP integer(10) NOT NULL); 

insert into client (NOM, PRENOM) VALUES ('Brigand', 'Pierre');
insert into client (NOM, PRENOM) VALUES ('YU', 'Cheng');
insert into client (NOM, PRENOM) VALUES ('BERRAD', 'Hicham');

insert into LIVRE VALUES (1, 'Vingt mille lieues sous les mers', 'Jules Verne');
insert into LIVRE VALUES (2, 'Germinal', 'Emile Zola');
insert into LIVRE VALUES (3, 'Guerre et paix', 'Léon Tolstoï');
insert into LIVRE VALUES (4, 'Apprendre à parler aux animaux', 'Gaston Pouet');
insert into LIVRE VALUES (5, '1001 recettes de Cuisine', 'Jean-Pierre Coffe');

insert into emprunt VALUES (1, '2017-11-12', '2017-11-18', 15, 1);
insert into emprunt VALUES (2, '2017-12-08', '2017-12-23', 30, 2);
insert into emprunt VALUES (3, '2017-12-09', '2018-01-04', 30, 3);
insert into emprunt VALUES (4, '2018-01-03', NULL, 21, 1);
insert into emprunt VALUES (5, '2018-01-13', NULL, 21, 3);

insert into compo VALUES (1, 1, 1);
insert into compo VALUES (2, 4, 1);
insert into compo VALUES (3, 2, 2);
insert into compo VALUES (4, 3, 2);
insert into compo VALUES (5, 1, 3);
insert into compo VALUES (6, 5, 4);
insert into compo VALUES (7, 2, 4);
insert into compo VALUES (8, 3, 5);