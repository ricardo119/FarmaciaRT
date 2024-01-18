package farmaciart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static p1.P1App.println;

public class Listar extends Produto {
    
    public Listar(){
        
    }
    
 //************LISTAR  INDIFERENCIADOS VISIVEIS*******************************//
    
    public static void listarIndiferenciadosVisiveis() {
    String nomeArquivo = "indiferenciados.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Produtos\n");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);

                
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
    
 //************LISTAR PRODUTOS MEDICAMENTOS VISIVEIS**************************// 
    
   public static void listarMedicamentosVisiveis() {
    String nomeArquivo = "medicamentos.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Medicamentos:\n");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                
                String[] dateComponents = parts[5].split("/");
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
                Data validade = new Data(mes, ano);

                boolean isVisivel = Boolean.parseBoolean(parts[6]);

                
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
 //****************************LISTAR CLIENTES VISIVEIS***********************//
   
   public static void listarClientesVisiveis(){
        String nomeArquivo = "clientes.dat";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Clientes:\n");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 3) { 
                String nome = parts[0];
                String nif = parts[1];
                String rua = parts[2];
                String postal = parts[3];
                String localidade = parts[4];

                boolean isVisivel = Boolean.parseBoolean(parts[5]);

        
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
        println("Erro ao listar clientes: " + e.getMessage());
        }
    }
//************LISTAR PRODUTOS INDIFERENCIADOS *******************************//
   
    public static void listarIndiferenciados() {
    String nomeArquivo = "indiferenciados.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Produtos:\n");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) { 
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                
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
    
//*******************LISTAR MEDICAMENTOS **************************************//  
   
    public static void listarMedicamentos() {
    String nomeArquivo = "medicamentos.txt";

    try {
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        println("\nLista de Medicamentos:\n");

        while ((linha = leitor.readLine()) != null) {
            String[] parts = linha.split(";");

            if (parts.length >= 7) {  
                String nome = parts[0];
                String descricao = parts[1];
                int stock = Integer.parseInt(parts[2]);
                double preco = Double.parseDouble(parts[3]);
                double iva = Double.parseDouble(parts[4]);

                
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

            println("GESTAO DE CLIENTES\n");

            while ((linha = leitor.readLine()) != null) {
                println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            println("Erro ao listar clientes: " + e.getMessage());
        }
    }
 //*******************************LISTAR VENDAS ******************************//   
    
    public static void listarVendas() {
        String nomeArquivo = "vendas.dat";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            println("VENDAS\n");

            while ((linha = leitor.readLine()) != null) {
                println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            println("Erro ao listar clientes: " + e.getMessage());
        }
    }
}