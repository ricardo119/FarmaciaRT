package farmaciart;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readLine;


public class Medicamento extends Produto implements Serializable{

    String categoria;
    
    public Medicamento(){
        
    }
    
    public Medicamento(String nome , String descricao, String categoria, int stock , double preco , double iva, Data validade){
        
        super(nome, descricao, stock, preco, iva, validade);
        this.categoria = categoria;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    
    public String setCategoria(String categoria){
        this.categoria = categoria;
        return categoria;
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
