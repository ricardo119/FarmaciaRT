package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Indiferenciado extends Produto implements Serializable {
    
    String categoria;
    
    public Indiferenciado(){
        
    }
    
    public Indiferenciado(String nome , String descricao, String categoria, int stock , double preco , double iva, Data validade){
        
        super(nome, descricao, stock, preco, iva, validade);
        this.categoria = categoria;
    }
    
    
    public String getCategoria() {
        return categoria;
    }
    
    
    public void guardarIndiferenciados() {
        Guardar guardar = new Guardar();
        guardar.salvarIndiferenciado(this);
    }
    
    public void listarIndiferenciados(){
    Listar listar = new Listar();
    List<Indiferenciado> indiferenciadosList = new ArrayList<>();
    listar.listarIndiferenciados(indiferenciadosList);
    }
}
