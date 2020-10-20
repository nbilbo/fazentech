public class Animal {
    private int id;
    private String especie;
    private float peso;
    private int ruminacao;
    private boolean inseminacao;
    private java.util.Date estimativaParto;
    private Tratamento tratamentos[];
    private Ordenha ordenhas[];

    public Animal(){
        
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

    public void mediaLitrosLeite(){

    }

    public void mediaTemperaturaLeite(){

    }

    // getters
    public int getId(){
        return this.id;
    }

    public String getEspecie(){
        return this.especie;
    }

    public float getPeso(){
        return this.peso;
    }

    public int getRuminacao(){
        return this.ruminacao;
    }

    public boolean isInseminacao(){
        return this.inseminacao;
    }

    public java.util.Date getEstimativaParto(){
        return this.estimativaParto;
    }

    public Tratamento[] getTratamentos(){
        return this.tratamentos;
    }

    public Ordenha[] getOrdenhas(){
        return this.ordenhas;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public void setPeso(float peso){
        this.peso = peso;
    }

    public void setRuminacao(int ruminacao){
        this.ruminacao = ruminacao;
    }

    public void setInseminacao(boolean inseminacao){
        this.inseminacao = inseminacao;
    }

    public void setEstimativaParto(java.util.Date estimativaParto){
        this.estimativaParto = estimativaParto;
    }

    public void setTratamentos(Tratamento tratamentos[]){
        this.tratamentos = tratamentos;
    }

    public void setOrdenhas(Ordenha ordenhas[]){
        this.ordenhas = ordenhas;
    }

}
