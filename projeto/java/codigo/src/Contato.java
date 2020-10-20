public class Contato {
    private int id;
    private String tipo;
    private String numero;
    private Funcionario funcionario;

    public Contato(){

    }
    
    public Contato(String tipo, String numero, Funcionario funcionario){
        this.tipo = tipo;
        this.numero = numero;
        this.funcionario = funcionario;
    }

    public Contato(String tipo, String numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    // getters
    public int getId(){
        return this.id;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getNumero(){
        return this.numero;
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

    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
}
