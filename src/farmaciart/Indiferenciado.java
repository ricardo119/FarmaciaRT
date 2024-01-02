package farmaciart;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import static p1.P1App.println;

public class Indiferenciado extends Produto implements Serializable {
    
    String categoria;
    
    public Indiferenciado(){
        
    }
    
    public Indiferenciado(String nome , String descricao, String categoria, int stock , double preco , double iva, int dia, int mes, int ano){
        
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
        return super.toString();
    }
    
     public static void carregarIndiferenciados(ArrayList<Indiferenciado> listaIndiferenciados) {
        String nomeArquivo = "Indiferenciados.dat";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaIndiferenciados);
            println("Lista de indiferenciados salva com sucesso!");
        } catch (IOException e) {
            println("Erro ao salvar a lista de indiferenciados: " + e.getMessage());
        }
    }
     
    @SuppressWarnings("unchecked")
    public static ArrayList<Indiferenciado> carregarListaIndiferenciados() {
        String nomeArquivo = "Indiferenciados.dat";
        ArrayList<Indiferenciado> listaIndiferenciados = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaIndiferenciados = (ArrayList<Indiferenciado>) inputStream.readObject();
            println("Lista de indiferenciado carregada com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            println("Erro ao carregar a lista de medicamentos: " + e.getMessage());
        }

        return listaIndiferenciados;
    }
    
    public void guardarIndiferenciados(ArrayList<Indiferenciado> listaIndiferenciados) {
        listaIndiferenciados.add(this);
        carregarIndiferenciados(listaIndiferenciados);
    }
    
    public static void listarIndiferenciados() {
        ArrayList<Indiferenciado> listaIndiferenciados = carregarListaIndiferenciados();

        if (listaIndiferenciados.isEmpty()) {
            println("A lista de indiferenciados está vazia.");
        } else {
            println("Lista de Indiferenciado:");
            for (Indiferenciado indiferenciado : listaIndiferenciados) {
                println("Nome: " + indiferenciado.getNome() +
                                   ", Descrição: " + indiferenciado.getDescricao() +
                                   ", Categoria: " + indiferenciado.getCategoria() +
                                   ", Stock: " + indiferenciado.getStock() +
                                   ", Preço: " + indiferenciado.getPreco() +
                                   ", IVA: " + indiferenciado.getIva());
            }
        }
    }  
}

