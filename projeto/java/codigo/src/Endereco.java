public class Endereco {
    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private Funcionario funcionario;

    public Endereco(){
        
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

    public String getRua(){
        return this.rua;
    }

    public String getBairro(){
        return this.bairro;
    }

    public String getCidade(){
        return this.cidade;
    }

    public String getEstado(){
        return this.estado;
    }

    public Funcionario getFuncionario(){
        return this.funcionario;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setRua(String rua){
        this.rua = rua;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
}
