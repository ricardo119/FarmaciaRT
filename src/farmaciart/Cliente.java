
package farmaciart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cliente{
    
   public String nome;
   public String nif;
   
   public Cliente(){
       
   }
  
  
    public Cliente (String nome , String nif){
        
        this.nome = nome;
        this.nif = nif;
        
        
    }
    //*******************CRIAR FICHEIRO PARA CLIENTES*************************//
     public void salvarCliente() {
        String nomeArquivo = "Clientes"; // Nome do arquivo de dados

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
            bw.write("Nome: " + nome + ", NIF: " + nif);
            bw.newLine(); // Pula para a próxima linha para o próximo produto
            bw.close(); // Fecha o arquivo

            System.out.println("O cliente "+nome+" foi adicionado com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar cliente9"
                    + " " + e.getMessage());
        }
    }
   
    //*******************ADICIONAR CLIENTES***********************************//  
    
     static void adicionarCliente() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Nome do cliente:");
    String nome = scanner.nextLine();

    System.out.println("Digite o NIF:");
    String nif = scanner.nextLine();


    Cliente novoCliente = new Cliente(nome, nif);
    novoCliente.salvarCliente();

    scanner.nextLine(); // Limpar o buffer
    scanner.close();
}
    
}
    
    

