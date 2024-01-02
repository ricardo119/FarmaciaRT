

package farmaciart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    
    //******************CRIAR FICHEIRO PARA PRODUTOS *************************//
    public void salvarProduto() {
        String nomeArquivo = "produtos"; // Nome do arquivo de dados

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
            bw.write("Nome: " + nome + ", Descricao: " + descricao + " Preço: " + preco);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

            System.out.println("Produto adicionado com sucesso ao arquivo!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o produto: " + e.getMessage());
        }
    }
    
 //******************ADICIONAR PRODUTO*************************************//
    
    static void adicionarProduto() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o nome do produto:");
    String nome = scanner.nextLine();

    System.out.println("Digite a descrição do produto:");
    String descricao = scanner.nextLine();

    System.out.println("Digite o estoque do produto:");
    int stock = scanner.nextInt();

    System.out.println("Digite o preço do produto:");
    double preco = scanner.nextDouble();

    System.out.println("Digite o valor do IVA do produto:");
    double iva = scanner.nextDouble();

    Produto novoProduto = new Produto(nome, descricao, stock, preco, iva);
    novoProduto.salvarProduto();

    scanner.nextLine(); // Limpar o buffer
    scanner.close();
}
}
    

