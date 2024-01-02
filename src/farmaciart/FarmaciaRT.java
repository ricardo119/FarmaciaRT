
package farmaciart;

import java.util.Scanner;
import p1.P1App;

public class FarmaciaRT extends P1App {
    
    public static void main(String[] args) {
        
 
       Scanner scanner = new Scanner(System.in);

       
        int escolha;
        do {
            System.out.println(" Farmácia R&T!");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Atendimento");
            System.out.println("9. Menu Administrador");
            System.out.println("0. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    //menuAtendimento();
                    break;
                case 9:
                    menuAdministrador();
                    break;
                
                case 0:
                    System.out.println("Você saiu do sistema. Até breve!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione novamente.");
                    break;
            }
        } while (escolha != 0);
        
        scanner.close();
    }
    
    //*********************MENU ADMINISTRADOR ********************************//
    
    private static void menuAdministrador() {
    Scanner scanner = new Scanner(System.in);
    int escolha;
    do {
        System.out.println("Menu Administrador:");
        System.out.println("1.Adicionar Produto");
        System.out.println("2.Adicionar Medicamento");
        System.out.println("3.Adicionar Cliente");
        System.out.println("0.Voltar ao menu principal");

        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                Produto.adicionarProduto();
                break;
            case 2:
                //Medicamento.adicionarMedicamento();
                break;
            case 3:
                Cliente.adicionarCliente();       
                break;
            
            case 0:
                System.out.println("Voltar ao menu principal...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, selecione novamente.");
                break;
        }
    } while (escolha != 0);
    scanner.close();
}
   
}

    
    

