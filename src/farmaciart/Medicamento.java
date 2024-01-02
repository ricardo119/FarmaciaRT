package farmaciart;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import static p1.P1App.println;


public class Medicamento extends Produto implements Serializable{

    String categoria;
    
    public Medicamento(){
        
    }
    
    public Medicamento(String nome , String descricao, String categoria, int stock , double preco , double iva, int dia, int mes, int ano){
        
        super(nome, descricao, stock, preco, iva, dia, mes, ano);
        this.categoria = categoria;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getStock() {
        return stock;
    }
    
    public double getIva() {
        return iva;
    }
    
    public String getValidade() {
        return super.toString(); // Assuming Data class has a toString method
    }
    
 
    public static void carregarMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
        String nomeArquivo = "Medicamentos.dat";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaMedicamentos);
            println("Lista de medicamentos salva com sucesso!");
        } catch (IOException e) {
            println("Erro ao salvar a lista de medicamentos: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static ArrayList<Medicamento> carregarListaMedicamentos() {
        String nomeArquivo = "Medicamentos.dat";
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaMedicamentos = (ArrayList<Medicamento>) inputStream.readObject();
            println("Lista de medicamentos carregada com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            println("Erro ao carregar a lista de medicamentos: " + e.getMessage());
        }

        return listaMedicamentos;
    }
    
    public void guardarMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
        listaMedicamentos.add(this);
        carregarMedicamentos(listaMedicamentos);
    }
    
    public static void listarMedicamentos() {
        ArrayList<Medicamento> listaMedicamentos = carregarListaMedicamentos();

        if (listaMedicamentos.isEmpty()) {
            println("A lista de medicamentos está vazia.");
        } else {
            println("Lista de Medicamentos:");
            for (Medicamento medicamento : listaMedicamentos) {
                println("Nome: " + medicamento.getNome() +
                                   ", Descrição: " + medicamento.getDescricao() +
                                   ", Categoria: " + medicamento.getCategoria() +
                                   ", Stock: " + medicamento.getStock() +
                                   ", Preço: " + medicamento.getPreco() +
                                   ", IVA: " + medicamento.getIva() +
                                   ", Validade: " + medicamento.getValidade());
            }
        }
    }  
}
