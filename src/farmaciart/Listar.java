package farmaciart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static p1.P1App.println;

public class Listar extends Produto {
    
    public Listar(){
        
    }
    
    
    public static void listarIndiferenciadosVisiveis() {
    String nomeArquivo = "indiferenciados.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Produtos:");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  // Assuming a minimum number of parts
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                // Parse the date components
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);

                // Check if isVisivel is true before listing
                if (isVisivel) {
                    StringBuilder output = new StringBuilder();
                    output.append("Nome: ").append(nome);
                    output.append(" Descrição: ").append(descricao);
                    output.append(" Stock: ").append(stock);
                    output.append(" Preço: ").append(preco);
                    output.append(" IVA: ").append(iva);
                    output.append(" Validade:").append(validade);

                    println(output.toString());
                }
            } else {
                println("Invalid line format: " + linha);
            }
        }

        leitor.close();
        } catch (IOException | NumberFormatException e) {
        println("Erro ao listar indiferenciados: " + e.getMessage());
        }
    }
    
    
   public static void listarMedicamentosVisiveis() {
    String nomeArquivo = "medicamentos.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Medicamentos:");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  // Assuming a minimum number of parts
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                // Parse the date components
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);

                // Check if isVisivel is true before listing
                if (isVisivel) {
                    StringBuilder output = new StringBuilder();
                    output.append("Nome: ").append(nome);
                    output.append(" Descrição: ").append(descricao);
                    output.append(" Stock: ").append(stock);
                    output.append(" Preço: ").append(preco);
                    output.append(" IVA: ").append(iva);
                    output.append(" Validade:").append(validade);

                    println(output.toString());
                }
            } else {
                println("Invalid line format: " + linha);
            }
        }

        leitor.close();
        } catch (IOException | NumberFormatException e) {
        println("Erro ao listar medicamentos: " + e.getMessage());
        }
    }
   
    public static void listarClientesVisiveis(){
        String nomeArquivo = "clientes.dat";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Clientes:");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 3) { 
                String nome = parts[0];
                String nif = parts[1];
                String rua = parts[2];
                String postal = parts[3];
                String localidade = parts[4];

                boolean isVisivel = Boolean.parseBoolean(parts[5]);

                // Check if isVisivel is true before listing
                if (isVisivel) {
                    StringBuilder output = new StringBuilder();
                    output.append("Nome: ").append(nome);
                    output.append(" NIF: ").append(nif);
                    output.append(" Rua: ").append(rua);
                    output.append(" Código Postal: ").append(postal);
                    output.append(" Localidade: ").append(localidade);

                    println(output.toString());
                }
            } else {
                println("Invalid line format: " + linha);
            }
        }

        leitor.close();
        } catch (IOException | NumberFormatException e) {
        println("Erro ao listar medicamentos: " + e.getMessage());
        }
    }

    public static void listarIndiferenciados() {
    String nomeArquivo = "indiferenciados.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Produtos:");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  // Assuming a minimum number of parts
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                // Parse the date components
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);

                StringBuilder output = new StringBuilder();
                output.append("Nome: ").append(nome);
                output.append(" Descrição: ").append(descricao);
                output.append(" Stock: ").append(stock);
                output.append(" Preço: ").append(preco);
                output.append(" IVA: ").append(iva);
                output.append(" Validade:").append(validade);

                 println(output.toString());
                
            } else {
                println("Invalid line format: " + linha);
            }
        }

        leitor.close();
        } catch (IOException | NumberFormatException e) {
        println("Erro ao listar indiferenciados: " + e.getMessage());
        }
    }   
    
    
   public static void listarMedicamentos() {
    String nomeArquivo = "medicamentos.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Medicamentos:");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  // Assuming a minimum number of parts
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                // Parse the date components
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);


                StringBuilder output = new StringBuilder();
                output.append("Nome: ").append(nome);
                output.append(" Descrição: ").append(descricao);
                output.append(" Stock: ").append(stock);
                output.append(" Preço: ").append(preco);
                output.append(" IVA: ").append(iva);
                output.append(" Validade:").append(validade);

                println(output.toString());
            
            } else {
                println("Invalid line format: " + linha);
            }
        }

        leitor.close();
        } catch (IOException | NumberFormatException e) {
        println("Erro ao listar medicamentos: " + e.getMessage());
        }
    }
   //****************LISTAR CLIENTE**********************************************//
    public static void listarClientes() {
        String nomeArquivo = "clientes.dat";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            println("\nGESTAO DE CLIENTES\n");

            while ((linha = leitor.readLine()) != null) {
                println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            println("Erro ao listar clientes: " + e.getMessage());
        }
    }
}