
package farmaciart;

import farmaciart.Indiferenciado;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readInt;
import static p1.P1App.readLine;




public class Atendimento extends Cliente implements Serializable{
    
    private static List<Medicamento> medicamentosList = new ArrayList<>();
    private static List<Indiferenciado> indiferenciadosList = new ArrayList<>();
    private static List<Cliente> clientesList = new ArrayList<>();
    
   
    public Atendimento(String nome, String nif, String rua, String postal, String localidade, boolean isVisivel){
    
        super(nome, nif, rua, postal, localidade, isVisivel);
}

    
      //********************* MENU ATENDIMENTO   ********************************//
    
    public static void menuAtendimento() throws IOException{
     
        
        int opcao;
        
        do {
        
        println("\nMenu de Atendimento:");
        println("1.Procurar cliente:");
        println("2.NIF do cliente:");
        println("3.Criar ficha de cliente:");
        println("0. Voltar ao menu principal");

        opcao = readInt();

        switch(opcao) {
            case 1:
                procuraCliente(clientesList, medicamentosList, indiferenciadosList, 1);
                break;
            case 2:
                //procuraCliente(clientesList,2);
                break;
            case 3:
                Cliente.adicionarCliente(clientesList);
                break;
            case 0:
                println("Voltar ao menu principal...");
                break;
            default:
                println("Opção inválida. Por favor, selecione novamente.");
                break;
        }
    } while (opcao != 0);
}
        
 
//****************************PROCURA/ADICIONAR CLIENTE **********************//   
    
    public static void procuraCliente (List<Cliente> clientesList, List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList, int menu) throws IOException{
      
        
        boolean found = false;
        
        clientesList = Carregar.carregarClientes();
        medicamentosList = Carregar.carregarMedicamentos();
        
        Listar.listarClientesVisiveis();
        
        if (menu == 1){ 
            String nomeProcura;    
            println("Digita o nome do Cliente:");
            nomeProcura = readLine();
        
            for (Cliente cliente : clientesList ) {
                if (cliente.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                    found = true;
                    String nome = cliente.getNome();
                    String nif = cliente.getNif();
                    Venda.novaVenda(medicamentosList, nome, nif);
                    
                    return;
                }
            }
            
            if(!found){
               println("Cliente nao encontrado. Rederiocinado para criar ficha"); 
               Cliente.adicionarClienteVendaNome(clientesList, nomeProcura);
            }
        }
        if (menu == 2){ 
            String nifProcura;    
            println("Digita o NIF do Cliente:");
            nifProcura = readLine();
        
            for (Cliente cliente : clientesList ) {
                println(cliente.getNif());
                if (cliente.getNif().trim().equalsIgnoreCase(nifProcura)) {
                    found = true;
                    String nome = cliente.getNome();
                    String nif = cliente.getNif();
                    Venda.novaVenda(medicamentosList, nome, nif);
                        
                    return;
                }
            }
            if(!found){
                
               Cliente.adicionarClienteVendaNif(clientesList, nifProcura);
            }
        }
   
    }
}
   

