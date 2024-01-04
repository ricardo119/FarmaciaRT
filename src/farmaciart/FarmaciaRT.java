
package farmaciart;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import p1.P1App;

public class FarmaciaRT extends P1App {
    
    public static void main(String[] args) {
        
        int escolha;
        
        do {
            println(" Farmácia R&T!");
            println("Selecione uma opção:");
            println("1. Atendimento");
            println("9. Menu Administrador");
            println("0. Sair");

            escolha = readInt();

            switch(escolha) {
                case 1:
                    //menuAtendimento();
                    break;
                case 9:
                    menuAdministrador();
                    break;
                
                case 0:
                    println("Você saiu do sistema. Até breve!");
                    break;
                default:
                    println("Opção inválida. Por favor, selecione novamente.");
                    break;
            }
        } while (escolha != 0);
        
    }
    
    //********************* MENU ATENDIMENTO   ********************************//
    //********************* MENU ATENDIMENTO   ********************************//
    
    private static void menuAtendimento(){
     
        
        int opcao;
        
        do {
        
        println("\nMenu de Atendimento:\n");
        println("1.Procurar cliente:");
        println("2.NIF do cliente:");
        println("3.Criar ficha de cliente:");
        println("0. Voltar ao menu principal");

        opcao = readInt();

        switch(opcao) {
            case 1:
                //Cliente.();
                break;
            case 2:
                //atendimento.cliente();
                break;
            case 3:
                Cliente.adicionarCliente();
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
        
    
    
    //*********************MENU ADMINISTRADOR ********************************//
    
    private static void menuAdministrador() {
        
        List<Medicamento> medicamentosList = new ArrayList<>();
        List<Indiferenciado> indiferenciadosList = new ArrayList<>();
        Listar listar = new Listar();
        
        int admin;
    
        do {
            println("Menu Administrador:");
            println("1. Adicionar Produto");
            println("2. Adicionar Cliente");
            println("3. Listar Medicamentos");
            println("4. Listar Indiferenciados");
            println("0. Voltar ao menu principal");

        admin = readInt();

        switch(admin) {
            case 1:
                Produto.novoProduto(medicamentosList, indiferenciadosList);
                break;
            case 2:
                //Medicamento.adicionarMedicamento();
                break;
            case 3:
                listar.listarMedicamentos(medicamentosList);
                break;
            case 4:
                listar.listarIndiferenciados(indiferenciadosList);
                break;
            case 0:
                println("Voltar ao menu principal...");
                break;
            default:
                println("Opção inválida. Por favor, selecione novamente.");
                break;
        }
    } while (admin != 0);
}
   
}
