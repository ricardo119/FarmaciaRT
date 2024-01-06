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

    public Cliente(String nome, String nif, String rua, String postal, String localidade) {
        
        super(rua, postal, localidade);
        this.nome = nome;
        this.nif = nif;
    }

//***********************CRIAR FICHEIRO CLIENTES******************************//
    public static void adicionarCliente(String nome, String nif, String rua, String postal, String localidade) {
        String nomeArquivo = "clientes.dat";

        try {
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo, true);
            String clienteInfo = "\nCliente:" + nome + ";\nNIF:" + nif + ";\nRua:" + rua + ";\nCodigo Postal:" + postal +";\nLocalidade:;" + localidade +""; 
            arquivo.write(clienteInfo.getBytes());
            arquivo.close();

            println("Novo cliente adicionado à Farmácia R&T " + nomeArquivo);
        } catch (IOException e) {
            println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }
//*************************INTRODUZIR NOVO CLIENTE****************************//
    public static void adicionarCliente() {
       
        
        println("Nome do cliente:");
        String nome = readLine();

        println("NIF:");
        String nif = readLine();

        println("Rua:");
        String rua = readLine();
        
        println("Codigo Postal:");
        String postal = readLine();
        
        println("Localidade:");
        String localidade = readLine();
        
        adicionarCliente(nome, nif , rua , postal ,localidade ); 
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
