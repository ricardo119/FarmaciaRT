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

    


    // Método para adicionar um novo cliente a partir da entrada do usuário
    public static void adicionarCliente() {
        

        println("Nome do cliente:");
        String nome = readLine();

        println("Digite o NIF:");
        String nif = readLine();

    }

        public static void listarClientes() {
        String nomeArquivo = "clientes.dat";

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            println("\nClientes adicionados:");

            while ((linha = leitor.readLine()) != null) {
                println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    
}