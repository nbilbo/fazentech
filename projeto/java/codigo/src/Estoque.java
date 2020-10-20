public class Estoque {
    private int id;
    private int quantidade;
    private String nome;
    private Produto produtos[];

    public Estoque(){
        
    }

    public void validar(){

    }

    public void cancelar(){

    }

    public void atualizar(){

    }

    public void cadastrar(){

    }

    // getters
    public Produto[] getProdutos(){
        return this.produtos;
    }

    public int getId(){
        return this.id;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public String getNome(){
        return this.nome;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setProdutos(Produto produtos[]){
        this.produtos = produtos;
        this.quantidade += produtos.length;
    }
}
