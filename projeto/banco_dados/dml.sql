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

# inserir dados na tabela comercio e atualizar, produto.vendido e estoque.quantidade
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


#dml funcionario
insert into funcionario
(nome, cpf, salario, contratacao, cargo)
values
('Marta Moura', '111111111-11', 1400.00, '2019-07-25', 'administrador');

#dml contato
insert into contato
(tipo, numero, id_funcionario)
values
('cel', '(011)11111-1111', 1);

#dml endereco 
insert into endereco
(rua, bairro, cidade, estado, complemento, id_funcionario)
values
('Rua Cândido Portinari', 'Real Parque', 'São José', 'SC', 'Rua sem saida', 1);

#dml equipamento
insert into equipamento
(nome, categoria)
values
('martelo', 'uso geral');

#dml animal
insert into animal
(especie, peso, inseminacao, ruminacao, estimativa_parto)
values
('Holstein', 650, true, 15, '2020-12-21');

#dml planta
insert into planta
(nome, categoria)
values
('Caju', 'Árvores Frutíferas');

#dml plantio
insert into plantio
(id_funcionario, id_planta, ocorrencia)
values
(1, 1, '2020-03-05 14:11:22');

#dml ordenha
insert into ordenha
(litros, ocorrencia, temperatura_leite, id_animal, id_funcionario)
values
(15.00, '2020-05-20 15:05:21', 7, 1, 1);

#dml remedio
insert into remedio
(nome, validez)
values
('antibiotico', '2021-08-20');

#dml tratamento
insert into tratamento
(tipo_tratamento, descricao, dias_necessarios, id_animal, id_funcionario)
values
('prevenção mastite bovina', 'prevenir o animal de  inflamação na glândula mamária', 14, 1, 1);

#dml medicacao
insert into medicacao
(id_tratamento, id_remedio)
values
(1, 1);

#dml estoque
insert into estoque
(nome, quantidade)
values
('leite', 0);

#dml produto
insert into produto
(preco, validez, vendido, id_estoque)
values
(20.00, '2020-12-05', false, 1);

#dml varejista
insert into varejista
(nome, cpf)
values
('Rafael Lima', '000000000-11');

#dml contatovarejista
insert into contatovarejista
(tipo, numero, id_varejista)
values
('com', '(011) 91234-5678', 1);

#dml comercio
call realizar_comercio(1, 1);

