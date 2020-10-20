public class Funcionario extends Usuario {
    private java.util.Date contratacao;
    private float salario;
    private String status;
    private Ordenha[] ordenhas;
    private Plantio[] plantios;
    private Endereco endereco;
    private Contato[] contatos;
    private Tratamento[] tratamentos;

    public Funcionario(){

    }

    public void validar(){

    }

    public void cadastrar(){

    }

    public void demitir(){

    }

    public void atualizar(){

    }

    public void cancelar(){

    }

    public void contratar(){

    }

    public void recuperarFuncionario(){

    }

    // getters
    public java.util.Date getContratacao(){
        return this.contratacao;
    }

    public float getSalario(){
        return this.salario;
    }

    public String getStatus(){
        return this.status;
    }

    public Ordenha[] getOrdenhas(){
        return this.ordenhas;
    }

    public Plantio[] getPlantios(){
        return this.plantios;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public Contato[] getContatos(){
        return this.contatos;
    }

    public Tratamento[] getTratamentos(){
        return this.tratamentos;
    }

    // setters
    public void setContratacao(java.util.Date contratacao){
        this.contratacao = contratacao;
    }

    public void setSalario(float salario){
        this.salario = salario;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setOrdenhas(Ordenha ordenhas[]){
        this.ordenhas = ordenhas;
    }

    public void setPlantios(Plantio plantios[]){
        this.plantios = plantios;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public void setContatos(Contato contatos[]){
        this.contatos = contatos;
    }

    public void setTratamentos(Tratamento tratamentos[]){
        this.tratamentos = tratamentos;
    }
    
}
