public class Ordenha {
    private int id;
    private float litros;
    private float temperaturaLeite;
    private java.util.Date ocorrencia;
    private Animal animal;
    private Funcionario funcionario;

    public Ordenha(){
        
    }

    // getters
    public int getId(){
        return this.id;
    }

    public float getLitros(){
        return this.litros;
    }

    public float getTemperaturaLeite(){
        return this.temperaturaLeite;
    }

    public java.util.Date getOcorrencia(){
        return this.ocorrencia;
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

    public void setLitros(float litros){
        this.litros = litros;
    }

    public void setTemperaturaLeite(float temperaturaLeite){
        this.temperaturaLeite = temperaturaLeite;
    }

    public void setOcorrencia(java.util.Date ocorrencia){
        this.ocorrencia = ocorrencia;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
}
