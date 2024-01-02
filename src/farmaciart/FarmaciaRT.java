
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
    
    //*********************MENU ADMINISTRADOR ********************************//
    
    private static void menuAdministrador() {
    int admin;
    do {
        println("Menu Administrador:");
        println("1.Adicionar Produto");
        println("2.Adicionar Medicamento");
        println("3.Adicionar Cliente");
        println("0.Voltar ao menu principal");

        admin = readInt();

        switch(admin) {
            case 1:
                Produto.novoProduto();
                break;
            case 2:
                //Medicamento.adicionarMedicamento();
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
    } while (admin != 0);
}
   
}

    
    

