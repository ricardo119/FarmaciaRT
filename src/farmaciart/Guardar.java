package farmaciart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static p1.P1App.println;


public class Guardar extends Produto {
    
    public Guardar(){
        
    }
    
    
    //******************CRIAR FICHEIRO PARA INDIFERENCIADOS *************************//
    public void salvarIndiferenciado(Indiferenciado indiferenciado) {
        String nomeArquivo = "indiferenciado"; // Nome do arquivo de dados

        try {
            File arquivo = new File(nomeArquivo);

            // Se o arquivo não existir, cria um novo
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            // Abre o arquivo para escrita
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escreve os detalhes do novo produto no arquivo
            String indiferenciadoInfo = "Nome:" + indiferenciado.getNome() + ", Descricao:" + indiferenciado.getNome()  + " Preço:" + indiferenciado.getNome() + " IVA:" + indiferenciado.getIva() + " Validade:" + indiferenciado.getValidade(); 
            bw.write(indiferenciadoInfo);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

           println("Produto adicionado com sucesso ao arquivo!");
        } catch (IOException e) {
            println("Erro ao salvar o produto: " + e.getMessage());
        }
    }
    
    //******************CRIAR FICHEIRO PARA MEDICAMENTOS *************************//
     public void salvarMedicamento(Medicamento medicamento) {
        String nomeArquivo = "medicamentos"; // Nome do arquivo de dados

        try {
            File arquivo = new File(nomeArquivo);

            // Se o arquivo não existir, cria um novo
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            // Abre o arquivo para escrita
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String medicamentoInfo = "Nome:" + medicamento.getNome() + ", Descricao:" + medicamento.getNome()  + " Preço:" + medicamento.getNome() + " IVA:" + medicamento.getIva() + " Validade:" + medicamento.getValidade(); 
            bw.write(medicamentoInfo);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

            println("Produto adicionado com sucesso ao arquivo!");
        } catch (IOException e) {
            println("Erro ao salvar o produto: " + e.getMessage());
        }
    }
    
}
