

package farmaciart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Produto {
    
    String nome;
    String descricao;
    int stock;
    double preco;
    double iva;
    
    
    public Produto(String nome , String descricao, int stock , double preco , double iva){
        
        this.nome = nome;
        this.descricao = descricao;
        this.stock = stock;
        this.preco = preco;
        this.iva = iva;
        
    }
    
    
    public void salvarProduto() {
        String nomeArquivo = "produtos.txt"; // Nome do arquivo de dados

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
            bw.write("Nome: " + nome + ", Preço: " + preco);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

            System.out.println("Produto adicionado com sucesso ao arquivo!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o produto: " + e.getMessage());
        }
    }
}
    
    

