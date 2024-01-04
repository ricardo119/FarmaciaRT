package farmaciart;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Medicamento extends Produto implements Serializable{

    String categoria;
    
    public Medicamento(){
        
    }
    
    public Medicamento(String nome , String descricao, String categoria, int stock , double preco , double iva, int dia, int mes, int ano){
        
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
        return super.toString(); // Assuming Data class has a toString method
    }
    
    public void guardarMedicamentos() {
        Guardar guardar = new Guardar();
        guardar.salvarMedicamento(this);
    }
    
    public void listarMedicamentos(){
    Listar listar = new Listar();
    List<Medicamento> medicamentosList = new ArrayList<>();
    listar.listarMedicamentos(medicamentosList);
    }
}
