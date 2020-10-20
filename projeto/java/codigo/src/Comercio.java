public class Comercio {
    private int id;
    private java.util.Date ocorrencia;
    private Varejista varejista;
    private Produto produto;

    public Comercio(){
        
    }

    public void validar(){

    }

    public void cancelar(){

    }

    public void atualizar(){

    }

    public void cadastrar(){

    }

    public void gerarComprovante(){
        
    }

    // getters
    public int getId(){
        return this.id;
    }

    public java.util.Date getOcorrencia(){
        return this.ocorrencia;
    }

    public Varejista getVarejista(){
        return this.varejista;
    }

    public Produto getProduto(){
        return this.produto;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setOcorrencia(java.util.Date ocorrencia){
        this.ocorrencia = ocorrencia;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public void setVarejista(Varejista varejista){
        this.varejista = varejista;
    }
}
