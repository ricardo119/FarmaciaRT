package farmaciart;

import java.util.List;
import static p1.P1App.println;

public class Listar extends Produto {
    
    public Listar(){
        
    }
    
    public void listarIndiferenciados(List<Indiferenciado> indiferenciados) {
        println("Lista de Indiferenciados:");
        for (Indiferenciado indiferenciado : indiferenciados) {
            println("Nome: " + indiferenciado.getNome() +
                               ", Descrição: " + indiferenciado.getDescricao() +
                               ", Categoria: " + indiferenciado.getCategoria() +
                               ", Stock: " + indiferenciado.getStock() +
                               ", Preço: " + indiferenciado.getPreco() +
                               ", IVA: " + indiferenciado.getIva() +
                               ", Validade:" + indiferenciado.getValidade());
        }
    }
    
    
    
    public void listarMedicamentos(List<Medicamento> medicamentos) {
        println("Lista de Indiferenciados:");
        for (Medicamento medicamento : medicamentos) {
             println("Nome: " + medicamento.getNome() +
                               ", Descrição: " + medicamento.getDescricao() +
                               ", Categoria: " + medicamento.getCategoria() +
                               ", Stock: " + medicamento.getStock() +
                               ", Preço: " + medicamento.getPreco() +
                               ", IVA: " + medicamento.getIva() +
                               ", Validade:" + medicamento.getValidade());
        }
    }
}