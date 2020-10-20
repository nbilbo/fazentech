public class Planta {
    private int id;
    private String nome;
    private String categoria;
    private Plantio plantio;

    public Planta(){
        
    }

    public Planta(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
    }

    public Planta(String nome, String categoria, Plantio plantio){
        this.nome = nome;
        this.categoria = categoria;
        this.plantio = plantio;
    }

    // getters
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public Plantio getPlantio(){
        return this.plantio;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setPlantio(Plantio plantio){
        this.plantio = plantio;
    }

}
