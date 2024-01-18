package farmaciart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p1.P1App;

public class FarmaciaRT extends P1App {
    
    private static List<Venda> vendasList = new ArrayList<>();
   
    //*************************MENU PRINCIPAL*********************************//
    
    public static void main(String[] args) throws IOException {
        
        int escolha;
        
        do {
            println("*****************");
            println("**Farmácia R&T!**");
            println("*****************\n");
         
            
            println("Selecione uma opção:\n");
            println("1. Atendimento");
            println("9. Menu Administrador");
            println("0. Sair");

            escolha = readInt();

            switch(escolha) {
                case 1:
                    Atendimento.menuAtendimento();
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
    
    public static void menuAdministrador() throws IOException {
        
        List<Medicamento> medicamentosList = new ArrayList<>();
        List<Indiferenciado> indiferenciadosList = new ArrayList<>();
        List<Cliente> clientesList = new ArrayList<>();
        
        int admin;
    
        do {
            println("\n***********************");
            println("**Menu de Administrador**");
            println("*************************\n");
            println("1. Adicionar Produto");
            println("2. Gestao de Clientes");
            println("3. Gestao Produtos");
            println("4. Gestao de Vendas");
            println("0. Voltar ao menu principal");

        admin = readInt();

        switch(admin) {
            case 1:
                Produto.novoProduto(medicamentosList, indiferenciadosList);
                break;
            case 2:
                Cliente.menuGestaoCliente(clientesList);
                break;
            case 3:
                Produto.menuGestaoProduto(medicamentosList, indiferenciadosList);
                break;
            case 4:
                Venda.menuGestaoVenda(vendasList);
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
