package farmaciart;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Medicamento extends Produto implements Serializable{

    private String categoria;
    private boolean isVisivel;
    
    public Medicamento(){
        
    }
    
    public Medicamento(String nome , String descricao, String categoria, int stock , double preco , double iva, Data validade, boolean isVisivel){
        
        super(nome, descricao, stock, preco, iva, validade);
        this.categoria = categoria;
        this.isVisivel = isVisivel;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public boolean getVisibilidade() {
        return isVisivel;
    }
    
    public void setVisibilidade(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    public void guardarMedicamentos() {
        Guardar guardar = new Guardar();
        guardar.guardarMedicamento(this);
    }
    
    public void listarMedicamentos(){
    Listar listar = new Listar();
    List<Medicamento> medicamentosList = new ArrayList<>();
    listar.listarMedicamentos();
    }
}
