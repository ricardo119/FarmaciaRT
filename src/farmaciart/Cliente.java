package farmaciart;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import static p1.P1App.println;
import static p1.P1App.readLine;

public class Cliente extends Morada implements Serializable {

    public String nome;
    public String nif;

    

//***********************CRIAR FICHEIRO CLIENTES******************************//
    public static void adicionarCliente(String nome, String nif) {
        String nomeArquivo = "clientes.dat";

        try {
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo, true);
            String clienteInfo ="Cliente:" + nome + "; NIF:" + nif + "\n";
            arquivo.write(clienteInfo.getBytes());
            arquivo.close();

            println("Novo cliente adicionado com sucesso ao arquivo " + nomeArquivo);
        } catch (IOException e) {
            println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

//*************************INTRODUZIR NOVO CLIENTE****************************//
    public static void adicionarCliente() {
        

        println("Nome do cliente:");
        String nome = readLine();

        println("Digite o NIF:");
        String nif = readLine();

        // Chama o método estático adicionarCliente definido na própria classe
        Cliente.adicionarCliente(nome, nif);

    }
//****************LISTAR CLIENTE**********************************************//
        public static void listarClientes() {
        String nomeArquivo = "clientes.dat";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            println("\nGestao de Clientes:");

            while ((linha = leitor.readLine()) != null) {
                println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    
}