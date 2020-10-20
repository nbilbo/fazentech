public class Medicacao {
    private int id;
    private Tratamento tratamento;
    private Remedio remedio;

    public Medicacao(){
        
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

    public Tratamento geTratamento(){
        return this.tratamento;
    }

    public Remedio getRemedio(){
        return this.remedio;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setTratamento(Tratamento tratamento){
        this.tratamento = tratamento;
    }

    public void setRemedio(Remedio remedio){
        this.remedio = remedio;
    }
}
