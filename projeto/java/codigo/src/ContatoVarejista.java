public class ContatoVarejista {
    private int id;
    private String tipo;
    private String numero;
    private Varejista varejista;

    public ContatoVarejista(){
        
    }

    public ContatoVarejista(String tipo, String numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    public ContatoVarejista(String tipo, String numero, Varejista varejista){
        this.tipo = tipo;
        this.numero = numero;
        this.varejista = varejista;
    }

    // getters
    public int getId(){
        return this.id;
    }

    public  String getTipo(){
        return this.tipo;
    }

    public String getNumero(){
        return this.numero;
    }

    public Varejista getVarejista(){
        return this.varejista;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setVarejista(Varejista varejista){
        this.varejista = varejista;
    }
}
