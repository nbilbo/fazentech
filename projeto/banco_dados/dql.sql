-- visao geral funcionarios
select 
	funcionario.idfuncionario , funcionario.nome, funcionario.cpf,
	funcionario.salario as 'salario_R$', funcionario.contratacao,
	endereco.rua, endereco.bairro, endereco.cidade, endereco.estado

from funcionario
inner join endereco on funcionario.idfuncionario = endereco.id_funcionario;

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

-- visao geral de comercio
select
	varejista.idvarejista, varejista.nome,
	count(comercio.id_varejista) as 'quantidade_produtos_compradados', 
	ifnull( sum(produto.preco), 0.00 ) as 'R$'

from varejista
left join comercio on varejista.idvarejista = comercio.id_varejista
left join produto on produto.idproduto = comercio.id_produto
group by varejista.idvarejista;

-- visao geral de ordenha
select 
	ordenha.id_animal, ordenha.id_funcionario,
	funcionario.nome as 'funcionário',
	ordenha.litros, ordenha.temperatura_leite, ordenha.ocorrencia

from ordenha
inner join funcionario on funcionario.idfuncionario = ordenha.id_funcionario
inner join animal on animal.idanimal = ordenha.id_animal
order by ordenha.id_animal, ordenha.litros desc;

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







