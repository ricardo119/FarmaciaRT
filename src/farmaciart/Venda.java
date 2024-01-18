
package farmaciart;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readInt;
import static p1.P1App.readLine;


public class Venda implements Serializable {


    private String nomeCliente;
    private String nifCliente;
    private String medicamentoVendido;
    private int quantidade;
    private double total;
   
    public Venda(String nomeCliente, String nifCliente, String medicamentoVendido, int quantidade, double total){
        this.nomeCliente = nomeCliente;
        this.nifCliente = nifCliente;
        this.medicamentoVendido = medicamentoVendido;
        this.quantidade = quantidade;
        this.total = total;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNifCliente() {
        return nifCliente;
    }
    
    public String getMedicamento(){
        return medicamentoVendido;
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
    
    public void setMedicamento(String medicamentoVendido){
        this.medicamentoVendido = medicamentoVendido;
    }
     
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public void guardarVendas(List<Venda> vendasList) throws IOException {
        Guardar guardar = new Guardar();
        vendasList.add(this);
        guardar.guardarListaVendas(vendasList);
    }
    
    public void listarVendas(){
        Listar listar = new Listar();
        List<Venda> vendasList = new ArrayList<>();
        Listar.listarVendas();
    }
  
 //*****************MENU GESTÃO DE VENDAS ************************************//
    
    public static void menuGestaoVenda(List<Venda> vendasList){
        
        int op = 0;
        
        do{
            println("\n***********************");
            println("**Menu Gestao de Vendas**");
            println("*************************");
            println("1. Listar Vendas");
            println("2. Verificar historico de cliente (Coming Soon)");
            println("3. Verificar maior venda (Coming Soon)");
            println("4. Verificar lucros (Coming Soon)");
            println("0. Sair");
            
            op = readInt();
            
            switch(op){
                case 1:
                    Listar.listarVendas();
                    break;
                case 0:
                    break;
                default:
                    println("Nenhuma opcao escolhida");
            }
        }while(op != 0);
    }
  
    public static void novaVenda(List<Medicamento> medicamentosList, String nomeCliente, String nifCliente) throws IOException{
        List<Venda> vendasList = new ArrayList<>();
        int op = 0;
        
        do{
            println("\n**************");
            println("**Menu Venda**");
            println("**************\n");
            println("1. Venda de Medicamento");
            println("2. Venda de Indiferenciado");
            
            println("0. Voltar ao menu");
            
            op = readInt();
            
            switch(op){
                case 1:
                    vendaMedicamento(medicamentosList,vendasList, nomeCliente, nifCliente);
                    break;
            }
            
        }while(op != 0);
    }

//******************VENDA DE UM MEDICAMENTO**********************************//
    
    public static void vendaMedicamento(List<Medicamento> medicamentosList,List<Venda> vendasList, String nomeCliente, String nifCliente) throws IOException{
        
        String nomeProcura;
        boolean encontrado = false;
        
        medicamentosList = Carregar.carregarMedicamentos();

        Listar.listarMedicamentos();

        println("Digita o nome do medicamento");
        nomeProcura = readLine();
        
        for (Medicamento medicamento : medicamentosList) {
            if (medicamento.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                
                println("Digita a quantidade a vender:");
                
                String medicamentoVendido = medicamento.getNome();
                int quantidade = readInt();
                int stock = medicamento.getStock();
                
                if (quantidade > stock){
                    println("Venda não realizada por falta de stock");
                    println("Stock disponivel: " + stock);
                    break;
                }
                
                double total = quantidade * medicamento.getPreco();
                println("Preço total:"+ total + "€");
                
                Venda novaVenda = new Venda(nomeCliente, nifCliente, medicamentoVendido, quantidade, total);
                vendasList.add(novaVenda);  
                
                Guardar guardar = new Guardar();
                guardar.guardarListaVendas(vendasList);
                 
                medicamento.setStock(stock - quantidade);
                medicamento.guardarMedicamentos();
                println("Venda realizada com sucesso!");
            }
        }
        
    }
}
