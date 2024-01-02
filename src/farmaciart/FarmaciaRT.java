
package farmaciart;

import java.util.Scanner;
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
    
    private static void menuAtendimento(){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
        System.out.println("Menu de Atendimento:");
        System.out.println("1. Inserir nome ou NIF do cliente:");
        System.out.println("0. Voltar ao menu principal");

        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                //atendimento.cliente();
                break;
            case 0:
                System.out.println("Voltar ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, selecione novamente.");
                break;
        }
    } while (opcao != 0);
    scanner.close();
}
        
    
    
    //*********************MENU ADMINISTRADOR ********************************//
    
    private static void menuAdministrador() {
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
                Produto.novoProduto();
                break;
            case 2:
                //Medicamento.adicionarMedicamento();
                break;
            case 3:
                Medicamento.listarMedicamentos();
                break;
            case 4:
                Indiferenciado.listarIndiferenciados();
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

    
    

