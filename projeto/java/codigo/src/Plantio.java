public class Plantio {
    private int id;
    private java.util.Date ocorrencia;
    private String status;
    private Planta[] plantas;
    private Funcionario funcionario;

    public Plantio(){
        
    }

    public void validar(){

    }

    public void cancelar(){

    }

    public void cadastrar(){

    }

    public void atualizar(){

    }

    public void recuperar(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Date getOcorrencia() {
        return this.ocorrencia;
    }

    public void setOcorrencia(java.util.Date ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Planta[] getPlantas() {
        return this.plantas;
    }

    public void setPlantas(Planta[] plantas) {
        this.plantas = plantas;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
