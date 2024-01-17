
package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readInt;
import static p1.P1App.readLine;




public class Atendimento extends Cliente implements Serializable{
    
   
    public Atendimento(String nome, String nif, String rua, String postal, String localidade, boolean isVisivel){
    
        super(nome, nif, rua, postal, localidade, isVisivel);
}

    
      //********************* MENU ATENDIMENTO   ********************************//
    
    public static void menuAtendimento(){
     
        List<Cliente> clientesList = new ArrayList<>();
        
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
                procuraCliente(clientesList,1);
                break;
            case 2:
                procuraCliente(clientesList,2);
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
    
    public static void procuraCliente (List<Cliente> clientesList, int menu){
      
        String nomeProcura;
        boolean found = false;
        
        Listar listar = new Listar();
        listar.listarClientes();
        
        if (menu == 1){ 
                
            println("Digita o nome do Cliente");
            nomeProcura = readLine();
        
            for (Cliente cliente : clientesList ) {
                println(cliente.getNome());
                if (cliente.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                    found = true;
                }
            }
            
            if(!found){
                
               Cliente.adicionarCliente(clientesList);
            }
        }
        if (menu == 2){ 
                
            println("Digita o NIF do Cliente");
            nomeProcura = readLine();
        
            for (Cliente cliente : clientesList ) {
                println(cliente.getNif());
                if (cliente.getNif().trim().equalsIgnoreCase(nomeProcura)) {
                    found = true;
                    //Venda.menuVenda();
        
                }
            }
            if(!found){
                
               Cliente.adicionarCliente(clientesList);
            }
        }
   
    }
}
   

