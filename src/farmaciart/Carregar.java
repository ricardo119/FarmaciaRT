package farmaciart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Carregar {

    public static List<Medicamento> carregarMedicamentos() {
        List<Medicamento> medicamentosList = new ArrayList<>();

        String nomeArquivo = "medicamentos.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] parts = linha.split(";");

                if (parts.length >= 7) {
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

                    Medicamento medicamento = new Medicamento(nome, descricao, "medicamento", stock, preco, iva, validade, isVisivel);
                    medicamentosList.add(medicamento);
                } else {
                    System.out.println("Invalid line format in " + nomeArquivo + ": " + linha);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading medicamentos: " + e.getMessage());
        }

        return medicamentosList;
    }

    public static List<Indiferenciado> carregarIndiferenciados() {
        List<Indiferenciado> indiferenciadosList = new ArrayList<>();

        String nomeArquivo = "indiferenciados.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] parts = linha.split(";");

                if (parts.length >= 7) {
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

                    Indiferenciado indiferenciado = new Indiferenciado(nome, descricao, "indiferenciado", stock, preco, iva, validade, isVisivel);
                    indiferenciadosList.add(indiferenciado);
                } else {
                    System.out.println("Invalid line format in " + nomeArquivo + ": " + linha);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading indiferenciados: " + e.getMessage());
        }

        return indiferenciadosList;
    }
    
    public static List<Cliente> carregarClientes(){
        List<Cliente> clientesList = new ArrayList<>();
        
        String nomeArquivo = "clientes.dat";

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] parts = linha.split(";");

                if (parts.length >= 4) {
                    String nome = parts[0];
                    String nif = parts[1];
                    String rua = parts[2];
                    String postal = parts[3];
                    String localidade = parts[4];

                    boolean isVisivel = Boolean.parseBoolean(parts[5]);

                    Cliente cliente = new Cliente(nome, nif, rua, postal, localidade, isVisivel);
                    clientesList.add(cliente);
                } else {
                    System.out.println("Invalid line format in " + nomeArquivo + ": " + linha);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading indiferenciados: " + e.getMessage());
        }

        return clientesList;
        
    }
}