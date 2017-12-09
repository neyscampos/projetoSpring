drop database bd15;

create database bd15;

use bd15;

create table usuario(idUsuario int primary key auto_increment,
	nome varchar(50), login varchar(50) unique,
	senha varchar(255), perfil enum('ROLE_ADM','ROLE_USU'),
	ativo int);
	
insert into usuario values (null, 'carlos', 'carlos@gmail.com', sha1('123'),'ROLE_USU',1);
insert into usuario values (null, 'monster', 'monster@gmail.com', sha1('123'),'ROLE_USU',1);
insert into usuario values (null, 'lu', 'lu@gmail.com', sha1('123'),'ROLE_USU',1);
insert into usuario values (null, 'bira', 'bira@gmail.com', sha1('123'),'ROLE_USU',1);
insert into usuario values (null, 'ney', 'ney@gmail.com', sha1('123'),'ROLE_ADM',1);
commit;

select * from usuario;

create table produto(idProduto int primary key auto_increment,
	nomeProduto varchar(50), preco double);
	
insert into produto values (null, 'plistation', 150);
insert into produto values (null, 'karaoke', 50);
insert into produto values (null, 'walkman', 75);
insert into produto values (null, 'cd funk', 10);


