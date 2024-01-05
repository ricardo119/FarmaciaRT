package farmaciart;

import static p1.P1App.println;

public class Editar extends Produto {
    
    
    public void menuEditarMedicamento(){
        
        int op = 0;
        
        do{
        
        println("Edição de medicamento");
        println("1. Eliminar");
        println("2. Ediçõa geral das informações");
        println("3. Edição específica de informação");
        
        switch(op){
            case 1:
                println("Digita o nome do produto a eliminar");
               //eliminarfuncao
            case 2:
                println("Digita o nome do produto a editar");
            }
        
        }while (op != 0);
    }
}
