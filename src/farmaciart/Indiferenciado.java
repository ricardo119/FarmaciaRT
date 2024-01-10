package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Indiferenciado extends Produto implements Serializable {
    
    private String categoria;
    private boolean isVisivel;
    
    public Indiferenciado(){
        
    }
    
    public Indiferenciado(String nome , String descricao, String categoria, int stock , double preco , double iva, Data validade, boolean isVisivel){
        
        super(nome, descricao, stock, preco, iva, validade);
        this.categoria = categoria;
        this.isVisivel = isVisivel;
    }
    
    
    public String getCategoria() {
        return categoria;
    }
    
    public String setCategoria(String categoria){
        this.categoria = categoria;
        return categoria;
    }
    
    public boolean getVisibilidade() {
        return isVisivel;
    }
    
    public void setVisibilidade(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    
    public void guardarIndiferenciados() {
        Guardar guardar = new Guardar();
        guardar.guardarIndiferenciado(this);
    }
    
    public void listarIndiferenciados(){
    Listar listar = new Listar();
    List<Indiferenciado> indiferenciadosList = new ArrayList<>();
    listar.listarIndiferenciados();
    }
}
