package farmaciart;

import java.io.Serializable;
import static p1.P1App.println;
import static p1.P1App.readInt;

public class Procurar extends Produto implements Serializable {

 
//***************PROCURAR PRODUTOS*****************************************//
   
    public void procurarOpcoes() {
        int opcao;

        do {
            println("Procurar por:");
            println("1. Medicamento");
            println("2. Indiferenciado");
            println("0. Voltar ao menu principal");

            opcao = readInt();

            switch (opcao) {
                case 1:
                    Listar.listarMedicamentosVisiveis();
                    break;
                case 2:
                    Listar.listarIndiferenciadosVisiveis();
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



}
