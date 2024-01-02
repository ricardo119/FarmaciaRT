package farmaciart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static p1.P1App.println;
import static p1.P1App.readDouble;
import static p1.P1App.readInt;
import static p1.P1App.readLine;


public class Medicamento extends Produto{


    
    String categoria;
    
    public Medicamento(String nome , String descricao, int stock , double preco , double iva){
        
        super(nome, descricao, stock, preco, iva);
        this.categoria = categoria;
    }
    
    
    public void salvarMedicamento() {
        String nomeArquivo = "Medicamentos"; // Nome do arquivo de dados

        try {
            File arquivo = new File(nomeArquivo);

            // Se o arquivo não existir, cria um novo
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            // Abre o arquivo para escrita
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String produtoInfo = "Nome:" + nome + " Descrição:" +  descricao + " Categoria:" + categoria + " Stock:" + stock + " Preço:" + preco + " IVA:" + iva;
            bw.write(produtoInfo);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

            System.out.println("Produto adicionado com sucesso ao arquivo!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o produto: " + e.getMessage());
        }
    }
    
    public static void novoMedicamento(){
        
        String nome, descricao, categoria;
        int stock;
        double preco, iva;
        
        println("Insira o nome:");
        nome = readLine();
        
        println("Insira a descricao:");
        descricao = readLine();
        
        println("Insira a categoria:");
        categoria = readLine();
        
        println("Insira o stock:");
        stock = readInt();
        
        println("Insira o preco:");
        preco = readDouble();
        
        println("Insira o IVA:");
        iva = readDouble();
        
        Medicamento novoMedicamento = new Medicamento(nome, descricao, stock, preco, iva);
        
        novoMedicamento.salvarMedicamento();
        
        println("Novo medicamento adicionado com sucesso");
    }
}
