
package farmaciart;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readInt;
import static p1.P1App.readLine;


public class Venda implements Serializable {


    
   private List<Venda> vendasList = new ArrayList<>();
    private String nomeCliente;
    private String nifCliente;
    private int quantidade;
    private double total;
   
    public Venda(String nomeCliente, String nif, int quantidade, double total){
        this.nomeCliente = nomeCliente;
        this.nifCliente = nifCliente;
        this.quantidade = quantidade;
        this.total = total;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNifCliente() {
        return nifCliente;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public void setNifCliente(String nifCliente){
        this.nifCliente = nifCliente;
    }
     
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public void guardarVendas() throws IOException {
        Guardar guardar = new Guardar();
        //guardar.guardarVendas(vendasList);
    }
    
    public void listarVendas(){
        Listar listar = new Listar();
        List<Venda> vendasList = new ArrayList<>();
        //star.listarVendas();
    }
   
    public static void novaVenda(List<Medicamento> medicamentosList, String nomeCliente, String nifCliente) throws IOException{
        
        int op = 0;
        
        do{
            println("Menu Venda:");
            println("1. Venda de Medicamento");
            println("2. Venda de Indiferenciado");
            
            op = readInt();
            
            switch(op){
                case 1:
                    vendaMedicamento(medicamentosList,nomeCliente, nifCliente);
                    break;
            }
            
        }while(op != 0);
    }
    
    public static void vendaMedicamento(List<? extends Medicamento> medicamentosList, String nomeCliente, String nifCliente) throws IOException{
        
        String nomeProcura;
        boolean encontrado = false;
        
        medicamentosList = Carregar.carregarMedicamentos();

        Listar.listarMedicamentos();

        println("Digita o nome do medicamento a editar");
        nomeProcura = readLine();
        
        for (Medicamento medicamento : medicamentosList) {
            if (medicamento.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                
                println("Digita a quantidade a vender:");
                
                int quantidade = readInt();
                int stock = medicamento.getStock();
                
                if (quantidade > stock){
                    println("Venda não realizada por falta de stock");
                    println("Stock disponivel: " + stock);
                    break;
                }
                
                double total = quantidade * medicamento.getPreco();
                
                Venda novaVenda = new Venda(nomeCliente, nifCliente,quantidade,total);
                novaVenda.vendasList.add(novaVenda);  // Add the sale to the customer's list
                novaVenda.guardarVendas();  // Save the sale using the instance method

                 
                medicamento.setStock(stock - quantidade);
                medicamento.guardarMedicamentos();
                println("Venda realizada com sucesso!");
            }
        }
        
    }
}
