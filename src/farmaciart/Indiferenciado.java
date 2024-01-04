package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Indiferenciado extends Produto implements Serializable {
    
    String categoria;
    
    public Indiferenciado(){
        
    }
    
    public Indiferenciado(String nome , String descricao, String categoria, int stock , double preco , double iva, int dia, int mes, int ano){
        
        super(nome, descricao, stock, preco, iva, dia, mes, ano);
        this.categoria = categoria;
    }
    
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getStock() {
        return stock;
    }
    
    public double getIva() {
        return iva;
    }
    
    public String getValidade() {
        return super.toString();
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
