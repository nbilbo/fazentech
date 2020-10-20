public class Varejista extends Usuario {
    private Comercio[] comercios;
    private ContatoVarejista[] contatos;

    public Varejista(){

    }

    public void validar(){

    }

    public void atualizar(){

    }

    public void cancelar(){

    }

    public void cadastrar(){

    }

    public void comprarProduto(){

    }

    public void recuperarVarejista(){

    }

    // getters
    public Comercio[] getComercios(){
        return this.comercios;
    }

    public ContatoVarejista[] getContatos(){
        return this.contatos;
    }

    // setters
    public void setComercios(Comercio comercios[]){
        this.comercios = comercios;
    }

    public void setContatos(ContatoVarejista contatos[]){
        this.contatos = contatos;
    }
}
