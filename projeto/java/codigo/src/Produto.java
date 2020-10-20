public class Produto {
    private int id;
    private java.util.Date validez;
    private float preco;
    private boolean vendido;
    private Estoque estoque;
    private Comercio comercio;

    public Produto(){
        
    }

    // getters
    public int getId(){
        return this.id;
    }

    public java.util.Date getValidez(){
        return this.validez;
    }

    public float preco(){
        return this.preco;
    }

    public boolean isVendido(){
        return this.vendido;
    }

    public Estoque getEstoque(){
        return this.estoque;
    }

    public Comercio getComercio(){
        return this.comercio;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setValidez(java.util.Date validez){
        this.validez = validez;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public void setVendido(boolean vendido){
        this.vendido = vendido;
    }

    public void setEstoque(Estoque estoque){
        this.estoque = estoque;
    }

    public void setComercio(Comercio comercio){
        this.comercio = comercio;
    }

}
