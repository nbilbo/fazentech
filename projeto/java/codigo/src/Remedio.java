public class Remedio {
    private int id;
    private String nome;
    private java.util.Date validez;
    private Medicacao[] medicacoes;

    public Remedio(){
        
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

    public String getNome(){
        return this.nome;
    }

    public java.util.Date getValidez(){
        return this.validez;
    }

    public Medicacao[] getMedicacoes(){
        return this.medicacoes;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setValidez(java.util.Date validez){
        this.validez = validez;
    }

    public void setMedicacoes(Medicacao medicacoes[]){
        this.medicacoes = medicacoes;
    }
}
