# criando a base de dados
create database if not exists fazenda_db
character set utf8mb4
collate utf8mb4_general_ci;

use fazenda_db;

# criando tabela funcionario
create table if not exists funcionario(
	idfuncionario int primary key auto_increment,
	nome char(127) not null,
	cpf char(15) not null unique,
	salario float(10, 2) not null default 0.00,
	contratacao date not null,
	cargo char(50) not null 
);

# criando a tabela contato
create table if not exists contato(
	idcontato int primary key auto_increment,
	tipo enum('cel', 'com', 'res') not null,
	numero char(20) not null unique,
	-- foreign key
	id_funcionario int
);

# criando a tabela endereco
create table if not exists endereco(
	idendereco int primary key auto_increment,
	rua char(50) not null,
	bairro char(50) not null,
	cidade char(50) not null,
	estado char(2) not null,
	complemento char(127) not null default 'sem complemento',
	-- foreign key
	id_funcionario int unique
);

# criando a tabela animal
create table if not exists animal(
	idanimal int primary key auto_increment,
	especie char(50) not null default 'sem informação',
	peso float(10, 2) not null,
	inseminacao boolean not null,
	ruminacao int not null default 0,
	estimativa_parto date
);

# criando a tabela ordenha
create table if not exists ordenha(
	idordenha int primary key auto_increment,
	litros float(10, 2) not null,
	ocorrencia datetime not null,
	temperatura_leite float(10, 2) not null default 0.00,
	-- foreign key
	id_animal int,
	id_funcionario int
);

# criando a tabela tratamento
create table if not exists tratamento(
	idtratamento int primary key auto_increment,
	tipo_tratamento char(127) not null,
	descricao char(127) not null default 'sem descrição',
	dias_necessarios int not null default 1,
	-- foreign key
	id_animal int,
	id_funcionario int
);

# criando a tabela remedio
create table if not exists remedio(
	idremedio int primary key auto_increment,
	nome char(127) not null,
	validez date not null
);

# criando a tabela medicacao
create table if not exists medicacao(
	idmedicacao int primary key auto_increment,
	-- foreign key
	id_tratamento int,
	id_remedio int
);

# criando a tabela estoque
create table if not exists estoque(
	idestoque int primary key auto_increment,
	nome char(50) not null,
	quantidade int not null default 0
);

# criando a tabela produto
create table if not exists produto(
	idproduto int primary key auto_increment,
	preco float(10, 2) not null default 0.00,
	validez date not null,
	vendido boolean not null default false,
	-- foreign key
	id_estoque int unique
);

# criando a tabela varejista
create  table if not exists varejista(
	idvarejista int primary key auto_increment,
	nome char(127) not null,
	cpf char(15) not null unique
);

# criando a tabela contatovarejista
create table if not exists contatovarejista(
	idcontatovarejista int primary key auto_increment,
	tipo enum('cel', 'com', 'res') not null,
	numero char(20) not null unique,
	-- foreign key
	id_varejista int
);

# criando a tabela comercio
create table if not exists comercio(
	id_produto int,
	id_varejista int,
	ocorrencia datetime not null,
	-- foreign key
	primary key(id_produto, id_varejista)
);

# criando a tabela planta
create table if not exists planta(
	idplanta int primary key auto_increment,
	nome char(127) not null,
	categoria char(50) not null default 'sem informação'
);

# criando a tabela plantio
create table if not exists plantio(
	id_funcionario int,
	id_planta int,
	ocorrencia datetime,
	-- foreign key
	primary key(id_funcionario, id_planta)
);

# criando a tabela equipamento
create table if not exists equipamento(
	idequipamento int primary key auto_increment,
	nome char(50) not null,
	categoria char(50) not null default 'sem informação'
);

# constraints
alter table endereco add constraint fk_endereco_funcionario
foreign key (id_funcionario) references funcionario(idfuncionario);

alter table contato add constraint fk_contato_funcionario
foreign key (id_funcionario) references funcionario(idfuncionario);

alter table contatovarejista add constraint fk_contatovarejista_varejista
foreign key (id_varejista) references varejista(idvarejista);

alter table ordenha add constraint fk_ordenha_funcionario
foreign key (id_funcionario) references funcionario(idfuncionario);

alter table ordenha add constraint fk_ordenha_animal
foreign key (id_animal) references animal(idanimal);

alter table comercio add constraint fk_comercio_produto
foreign key (id_produto) references produto(idproduto);

alter table comercio add constraint fk_comercio_varejista
foreign key (id_varejista) references varejista(idvarejista);

alter table produto add constraint fk_produto_estoque
foreign key (id_estoque) references estoque(idestoque);

alter table tratamento add constraint fk_tratamento_animal
foreign key (id_animal) references animal(idanimal);

alter table tratamento add constraint fk_tratamento_funcionario
foreign key (id_funcionario) references funcionario(idfuncionario);

alter table medicacao add constraint fk_medicacao_tratamento
foreign key (id_tratamento) references tratamento(idtratamento);

alter table medicacao add constraint fk_medicacao_remedio
foreign key (id_remedio) references remedio(idremedio);

alter table plantio add constraint fk_plantio_funcionario
foreign key (id_funcionario) references funcionario(idfuncionario);

alter table plantio add constraint fk_plantio_planta
foreign key (id_planta) references planta(idplanta);
