# fazentech

## Introdução
Um sistema para controlar o processo de criação animal e o planejamento de plantio das diferentes culturas da fazenda.

------------

## Sumário
1. Diagramas
    1. [Caso de uso](#use_case_diagram)
    2. [Entidade reliacionamento](#mer_diagram)
    3. [Classe](#class_diagram)
    4. [Máquina de Estados](#state_diagram)
    5. [Atividades](#activity_diagram)
    6. [Sequência](#sequence_diagram)
    
2. Banco de dados
    1. [Comandos (DDL)](#ddl_code)
    2. [Comandos (DML) ](#dml_code)
    3. Comandos (DQL)
    
3. Programação para web
    1. Sistema simples, utilizanando html e css.
    
4. Programação Orientada a Objetos
    1. Código utilizando linguagem java

------------

## Diagramas

### <a name="use_case_diagram"></a>Caso de uso
![use_case_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_use_case/diagrama_use_case.jpg)

### <a name="mer_diagram"></a>Entidade Realacionamento
![mer_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_entidade_relacionamento/diagrama_entidade_relacionamento.jpg)

### <a name="class_diagram"></a>Classes
![class_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_classe/diagrama_de_classe.jpg)

### <a name="state_diagram"></a>Máquina de Estados
![state_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_maquina_estado/maquina_estado_plantio.jpg)

### <a name="activity_diagram">Atividade
![activity_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_atividade/diagrama_atividade_cadastrar_animal.jpg)

### <a name="sequence_diagram">Sequência
![sequence_diagram](https://github.com/nbilbo/fazentech/blob/master/projeto/analise_orientada_objeto/diagrama_sequencia/diagrama_sequencia_cadastrar_animal.jpg)

------------

## Banco de dados

### <a name="ddl_code"></a>DDL
```sql
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
```

### <a name="dml_code"></a>DML
```sql
#atualizar estoque.quantidade sempre que for adicionando um novo produto
delimiter $
drop trigger if exists incrementar_estoque $
create trigger incrementar_estoque
after insert on produto
for each row
begin 
	update estoque
	set quantidade = quantidade + 1
	where idestoque = new.id_estoque;
end $
delimiter ;

# inserir dados na tabela comercio e atualizar produto.vendido e estoque.quantidade
delimiter $
drop procedure if exists realizar_comercio $
create procedure realizar_comercio(param_idvarejista int, param_idproduto int)
begin
	start transaction;
	
	insert into comercio 
	(id_varejista, id_produto, ocorrencia)
	values
	( param_idvarejista, param_idproduto, ( select now() ) );
	
	update produto
	set vendido = true
	where idproduto = param_idproduto;
	
	update estoque
	set quantidade = quantidade - 1
	where idestoque = ( select id_estoque from produto where idproduto = param_idproduto );
	
	commit;	
end $
delimiter ;

```

![desc_funcionario](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_funcionario.jpg)
```sql
#dml funcionario
insert into funcionario
(nome, cpf, salario, contratacao, cargo)
values
('Marta Moura', '111111111-11', 1400.00, '2019-07-25', 'administrador');
```

![desc_contato](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_contato.jpg)
```sql
#dml contato
insert into contato
(tipo, numero, id_funcionario)
values
('cel', '(011)11111-1111', 1);
```

![desc_endereco](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_endereco.jpg)
```sql
#dml endereco 
insert into endereco
(rua, bairro, cidade, estado, complemento, id_funcionario)
values
('Rua Cândido Portinari', 'Real Parque', 'São José', 'SC', 'Rua sem saida', 1);
```

![desc_equipamento](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_equipamento.jpg)
```sql
#dml equipamento
insert into equipamento
(nome, categoria)
values
('martelo', 'uso geral');
```

![desc_animal](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_animal.jpg)
```sql
#dml animal
insert into animal
(especie, peso, inseminacao, ruminacao, estimativa_parto)
values
('Holstein', 650, true, 15, '2020-12-21');
```

![desc_planta](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_planta.jpg)
```sql
#dml planta
insert into planta
(nome, categoria)
values
('Caju', 'Árvores Frutíferas');
```

![desc_plantio](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_plantio.jpg)
```sql
#dml plantio
insert into plantio
(id_funcionario, id_planta, ocorrencia)
values
(1, 1, '2020-03-05 14:11:22');
```

![desc_ordenha](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_ordenha.jpg)
```sql
#dml ordenha
insert into ordenha
(litros, ocorrencia, temperatura_leite, id_animal, id_funcionario)
values
(15.00, '2020-05-20 15:05:21', 7, 1, 1);
```

![desc_remedio](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_remedio.jpg)
```sql
#dml remedio
insert into remedio
(nome, validez)
values
('antibiotico', '2021-08-20');
```

![dec_tratamento]()
```sql
#dml tratamento
insert into tratamento
(tipo_tratamento, descricao, dias_necessarios, id_animal, id_funcionario)
values
('prevenção mastite bovina', 'prevenir o animal de  inflamação na glândula mamária', 14, 1, 1);
```

![desc_medicacao](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_medicacao.jpg)
```sql
#dml medicacao
insert into medicacao
(id_tratamento, id_remedio)
values
(1, 1);
```

![desc_estoque](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_estoque.jpg)
```sql
#dml estoque
insert into estoque
(nome, quantidade)
values
('leite', 0);
```

![desc_produto](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_produto.jpg)
```sql
insert into produto
(preco, validez, vendido, id_estoque)
values
(20.00, '2020-12-05', false, 1);
```

![desc_varejista](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_varejista.jpg)
```sql
#dml varejista
insert into varejista
(nome, cpf)
values
('Rafael Lima', '000000000-11');
```

![desc_contatovarejista](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_contatovarejista.jpg)
```sql
#dml contatovarejista
insert into contatovarejista
(tipo, numero, id_varejista)
values
('com', '(011) 91234-5678', 1);
```

```sql
#dml comercio
call realizar_comercio(1, 1);
```

-favor, não copiar, utilize como referencia.
