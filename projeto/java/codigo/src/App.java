import java.util.Date;

public class App {
    public static void main(String[] args){
        Date data = new Date();
        
        // instanciando um novo funcionário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Beatriz Paiva");
        funcionario.setCpf("1234567890-12");
        funcionario.setContratacao(data);

        // instanciando um novo endereco
        Endereco endereco = new Endereco();
        endereco.setRua("Praça Maria Penha Calezani");
        endereco.setBairro("Mata da Praia");
        endereco.setCidade("Vitória");
        endereco.setEstado("ES");

        endereco.setFuncionario(funcionario);
        funcionario.setEndereco(endereco);

        // instanciando um novo contato
        Contato contatos[] = {
            new Contato("Cel", "+5535912345678", funcionario),
            new Contato("Res", "4000-0000", funcionario)
        };
        funcionario.setContatos(contatos);
        
        // instanciando um novo animal
        Animal animal = new Animal();
        animal.setEspecie("Holstein");
        animal.setInseminacao(false);
        animal.setPeso(789.54f);
        animal.setRuminacao(33);

        // instancia um novo ordenha
        Ordenha ordenha = new Ordenha();
        ordenha.setAnimal(animal);
        ordenha.setFuncionario(funcionario);
        ordenha.setLitros(20);
        ordenha.setTemperaturaLeite(20);
        
        Ordenha ordenhas[] = {ordenha};
        animal.setOrdenhas(ordenhas);
        funcionario.setOrdenhas(ordenhas);
        
        // instanciando um novo estoque
        Estoque estoque = new Estoque();
        estoque.setQuantidade(0);
        estoque.setNome("Leite");

        // instanciando um novo produto
        Produto produto = new Produto();
        produto.setValidez(data);
        produto.setPreco(20.00f);
        produto.setVendido(false);
        produto.setEstoque(estoque);

        Produto produtos[] = {produto};
        estoque.setProdutos(produtos);

        // instanciando um novo Varejista
        Varejista varejista = new Varejista();
        varejista.setNome("Paula Lima");
        varejista.setCpf("098765432-10");

        // instanciando um novo ContatoVarejista
        ContatoVarejista contatoVarejista = new ContatoVarejista();
        contatoVarejista.setTipo("Com");
        contatoVarejista.setNumero("4002-4002");
        contatoVarejista.setVarejista(varejista);

        ContatoVarejista contatosVarejista[] = {contatoVarejista};
        varejista.setContatos(contatosVarejista);

        // instanciando um novo Comercio
        Comercio comercio = new Comercio();
        comercio.setOcorrencia(data);
        comercio.setProduto(produto);
        comercio.setVarejista(varejista);
        produto.setComercio(comercio);

        Comercio comercios[] = {comercio};
        varejista.setComercios(comercios);

        // instanciando um novo Remedio
        Remedio remedio = new Remedio();
        remedio.setNome("Antiviotico");
        remedio.setValidez(data);

        // instanciando um novo Tratamento
        Tratamento tratamento = new Tratamento();
        tratamento.setAniamal(animal);
        tratamento.setFuncionario(funcionario);
        tratamento.setTipo("Prevenção");
        tratamento.setDiasNecessarios(14);

        // instanciando um novo Medicacao
        Medicacao medicacao = new Medicacao();
        medicacao.setRemedio(remedio);
        medicacao.setTratamento(tratamento);

        Medicacao[] medicacoes={medicacao};
        remedio.setMedicacoes(medicacoes);
        tratamento.setMedicacoes(medicacoes);

        Tratamento[] tratamentos = {tratamento};
        animal.setTratamentos(tratamentos);
        funcionario.setTratamentos(tratamentos);
        
        // instanciando um novo Planta
        Planta planta = new Planta();
        planta.setNome("Cajú");
        planta.setCategoria("Árvore Frutífera");

        Planta[] plantas = new Planta[10];
        plantas[0] = planta;

        // instanciando um novo Plantio
        Plantio plantio = new Plantio();
        plantio.setOcorrencia(data);
        plantio.setStatus("Cadastrado");
        plantio.setPlantas(plantas);
        planta.setPlantio(plantio);
        plantio.setFuncionario(funcionario);

        Plantio[] plantios={plantio};
        funcionario.setPlantios(plantios);

        // instanciando um novo Equipamento
        Equipamento equipamento = new Equipamento("Martelo", "Uso geral");
        System.out.println(equipamento.toString());
    }
}
