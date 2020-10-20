public class Tratamento {
    private int id;
    private String tipo;
    private String descricao;
    private int diasNecessarios;
    private Medicacao medicacoes[];
    private Animal animal;
    private Funcionario funcionario;

    public Tratamento(){
        
    }

    public void validar(){

    }

    public void cancelar(){

    }

    public void atualizar(){

    }

    public void cadastrar(){

    }

    public void recuperar(){
        
    }

    // getters
    public int getId(){
        return this.id;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getDiasNecessarios(){
        return this.diasNecessarios;
    }

    public Medicacao[] getMedicacoes(){
        return this.medicacoes;
    }

    public Animal getAnimal(){
        return this.animal;
    }

    public Funcionario getFuncionario(){
        return this.funcionario;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setDiasNecessarios(int diasNecessarios){
        this.diasNecessarios = diasNecessarios;
    }

    public void setMedicacoes(Medicacao medicacoes[]){
        this.medicacoes = medicacoes;
    }

    public void setAniamal(Animal animal){
        this.animal = animal;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }



}
