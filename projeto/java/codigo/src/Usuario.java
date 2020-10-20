public abstract class Usuario{
    private int id;
    private String nome;
    private String cpf;

    public Usuario(){

    }

    public Usuario(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    // gettes
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}