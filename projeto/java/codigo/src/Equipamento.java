public class Equipamento {
    private int id;
    private String nome;
    private String categoria;

    public Equipamento(){

    }

    public Equipamento(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
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

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
