
package farmaciart;

import java.util.Scanner;

public class FarmaciaRT {

    
    public static void main(String[] args) {
 
       Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println(" Farmácia R&T!");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Administrador");
            System.out.println("2. Lista de Produtos");
            System.out.println("3. Lista de Clientes");
            System.out.println("4. Realizar Venda");
            System.out.println("0. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    Produtos();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    realizarVendas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione novamente.");
                    break;
            }
        } while (escolha != 0);
        
        scanner.close();
    }

    
    
    

