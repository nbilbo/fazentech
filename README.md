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
    3. [Comandos (DQL)](#dql_code)
    
3. Programação para web
    1. [html](#html_code)
    2. [css](#css_code)
    
4. Programação Orientada a Objetos
    1. [Código criação das classes](#java_criation)
    2. [Código instanciação](#java_instantiation)

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

### <a name="activity_diagram">Atividades
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

![dec_tratamento](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/descricoes/desc_tratamento.jpg)
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

### <a name="dql_code"></a>DQL

![proj_funcionarios](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/projecoes/projecao_funcionarios.jpg)
```sql
-- visao geral funcionarios
select 
	funcionario.idfuncionario , funcionario.nome, funcionario.cpf,
	funcionario.salario as 'salario_R$', funcionario.contratacao,
	endereco.rua, endereco.bairro, endereco.cidade, endereco.estado

from funcionario
inner join endereco on funcionario.idfuncionario = endereco.id_funcionario;
```

![proj_produtos](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/projecoes/projecao_produtos.jpg)
```sql
-- visão geral dos produtos.
select 
	estoque.nome as 'estoque',
	produto.idproduto, produto.validez,produto.preco as 'R$', 
	if(produto.vendido, 'sim', 'não') as 'vendido',
	ifnull(comercio.ocorrencia, '***') as 'ocorrencia',
	ifnull(varejista.idvarejista, '***') as 'idvarejista',
	ifnull(varejista.nome, '***') as 'varejista'
	
from estoque
inner join produto on estoque.idestoque = produto.id_estoque
left join comercio on produto.idproduto = comercio.id_produto
left join varejista on varejista.idvarejista = comercio.id_varejista
order by produto.vendido desc, varejista.nome, estoque.nome, produto.preco desc;
```

![proj_comercios](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/projecoes/projecao_comercios.jpg)
```sql
-- visao geral de comercio
select
	varejista.idvarejista, varejista.nome,
	count(comercio.id_varejista) as 'quantidade_produtos_compradados', 
	ifnull( sum(produto.preco), 0.00 ) as 'R$'

from varejista
left join comercio on varejista.idvarejista = comercio.id_varejista
left join produto on produto.idproduto = comercio.id_produto
group by varejista.idvarejista;
```

![proj_ordenhas](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/projecoes/projecao_ordenhas.jpg)
```sql
-- visao geral de ordenha
select 
	ordenha.id_animal, ordenha.id_funcionario,
	funcionario.nome as 'funcionário',
	ordenha.litros, ordenha.temperatura_leite, ordenha.ocorrencia

from ordenha
inner join funcionario on funcionario.idfuncionario = ordenha.id_funcionario
inner join animal on animal.idanimal = ordenha.id_animal
order by ordenha.id_animal, ordenha.litros desc;
```

![proj_animais](https://github.com/nbilbo/fazentech/blob/master/projeto/banco_dados/imgs/projecoes/projecao_animais.jpg)
```sql
-- visao geral do animal
select 
	animal.idanimal, animal.especie, animal.peso as 'peso(Kg)',
	if(animal.inseminacao, 'Sim', 'Não') as 'inseminação',
	(select count(*) from ordenha where ordenha.id_animal = animal.idanimal) as 'ordenhas',
	ifnull(truncate((select avg(ordenha.litros) from ordenha where id_animal = animal.idanimal), 3), '***') as 'média_litros_de_leite',
	animal.estimativa_parto, animal.ruminacao as 'minutos_de_ruminacao'

from animal
left join ordenha on animal.idanimal = ordenha.id_animal
group by animal.idanimal;
```

------------

## Página web

### <a name="html_code"></a>html
```html
<!DOCTYPE html><html lang="pt-br"><head><meta charset="utf-8"><meta name="viewpoint" content="inicial-scale=1"><link rel="stylesheet" href="index.css"><title>fazentech</title></head><body> <header class="header"><div class="container"> <nav> <a href="#">fazentech</a> </nav></div> </header> <section class="formulario"><div class="container"><h2>ordenha</h2><form" action=""> <label for="id_animal_ordenha">id animal</label> <input type="number" id="id_animal_ordenha"><label for="id_funcionario_ordenha">id funcionário</label> <input type="number" id="id_funcionario_ordenha"><label for="litro_leite">quantidade de leite (L)</label> <input type="number" id="litro_leite"><label for="horario_ordenha">horário</label> <input type="time" id="horario_ordenha"><button>enviar</button></form></div> </section> <section class="formulario"><div class="container"><h2>animais doentes</h2><form action=""> <label for="id_animal_doente">id animal</label> <input type="number" id="id_animal_doente"><label for="tipo_tratamento">tipo de tratamento</label> <input type="text" id="tipo_tratamento"><label for="descricao_animal_doente">descrição</label><textarea name="" id="descricao_animal_doente" cols="30" rows="10"></textarea><label for="dias_necessarios_doente">quantidade de dias necessários</label> <input type="number" id="dias_necessarios_doente"><button>enviar</button></form></div> </section><footer><div class="container"><p class="copyright">nenhum direito reservado</p></div> </footer></body></html>
```

### <a name="css_code"></a>css
```css
{padding:0;margin:0}.copyright,a,button,h2,input,label,textarea{color:#707070;font-family:Arial,Helvetica,sans-serif;line-height:1em}.copyright,a,button,input,label{font-size:1.2em}a{font-size:1.2em;font-weight:700;text-decoration:none;text-transform:uppercase}h2{font-size:1.6em;font-weight:400;text-transform:uppercase}textarea{font-size:1.125em}.container{background:0 0;border:solid 1px #707070;width:75%;margin:0 auto}.header{width:100%;margin-bottom:3.665%}.header .container{margin-top:2.0833%}.copyright,.header a{display:inline-block;margin-left:1.0416%;padding:2.9687% 0}.formulario{width:100%;margin-bottom:4%}.formulario h2{text-align:center;margin:2.96875% 0}.formulario label,input{display:block;margin-left:1.0416%}.formulario label{margin-bottom:1.09375%}.formulario input{padding:.5208% .1041%;width:47.9166%;margin-bottom:2.0833%}.formulario textarea{margin-left:1.0416%;width:47.9166%;padding-left:.5208%;margin-bottom:2.0833%}.formulario button{background:0 0;margin:2.0833% 0 2.0833% 1.0416%;width:19.2708%;padding:.625% 0;border:solid 1px #707070}footer{width:100%;margin-bottom:2.0833%}.copyright{margin-left:1.0416%}
```

------------

## <a name="java"></a>Java

### <a name="java_criation"></a>Criação
![criação_usuario](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/0_usuario.jpg)
![criação_funcionario](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/1_funcionario.jpg)
![criação_endereco](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/2_endereco.jpg)
![criação_contato](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/3_contato.jpg)
![criação_estoque](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/4_estoque.jpg)
![criação_produto](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/5_produto.jpg)
![criação_varejista](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/6_varejista.jpg)
![criação_contatovarejista](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/7_contatovarejista.jpg)
![criação_comercio](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/8_comercio.jpg)
![criação_animal](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/9_animal.jpg)
![criação_ordenha](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/10_ordenha.jpg)
![criação_remedio](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/11_remedio.jpg)
![criação_tratamento](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/12_tratamento.jpg)
![criação_medicação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/12_tratamento.jpg)
![criação_planta](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/14_planta.jpg)
![criação_plantio](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/15_plantio.jpg)
![criação_equipamento](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/16_equipamento.jpg)
![criação_administrador](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/classes/17_administrador.jpg)

### <a name="java_instantiation">Instanciação
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/0_contato_endereco_funcioanrio.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/1_animal_ordenha.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/2_estoque_produto.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/3_varejista_contatovarejista_comercio.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/4_remedio_tratamento_medicacao.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/5_planta_plantio.jpg)
![instanciação](https://github.com/nbilbo/fazentech/blob/master/projeto/java/imgs/instancias/6_equipamento.jpg)

<p><a href="https://github.com/nbilbo/fazentech/tree/master/projeto/java/codigo/src" target="_black">Código completo</a></p>

------------

-favor, não copiar, utilize como referencia.
