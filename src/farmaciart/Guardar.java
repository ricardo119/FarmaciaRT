package farmaciart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static p1.P1App.println;


public class Guardar extends Produto {
    
    public Guardar(){
        
    }
    
    
    //******************CRIAR FICHEIRO PARA INDIFERENCIADOS *************************//
     public void guardarIndiferenciado(Indiferenciado indiferenciado) {
        String nomeArquivo = "indiferenciados.txt";

        try {
            // Load existing products from the file
            List<Indiferenciado> existingIndiferenciados = Carregar.carregarIndiferenciados();

            // Check if the product already exists in the list
            boolean exists = false;
            for (int i = 0; i < existingIndiferenciados.size(); i++) {
                Indiferenciado existingIndiferenciado = existingIndiferenciados.get(i);
                if (existingIndiferenciado.getNome().equalsIgnoreCase(indiferenciado.getNome())) {
                    exists = true;
                    existingIndiferenciados.set(i, indiferenciado); // Update the existing product
                    break;
                }
            }

            // If the product does not exist, add a new one
            if (!exists) {
                existingIndiferenciados.add(indiferenciado);
            }

            // Save the updated list to the file
            guardarListaIndiferenciados(existingIndiferenciados);
        } catch (IOException e) {
            println("Erro ao salvar indiferenciado: " + e.getMessage());
        }
    }

    private void guardarListaIndiferenciados(List<Indiferenciado> indiferenciadosList) throws IOException {
        String nomeArquivo = "indiferenciados.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Indiferenciado indiferenciado : indiferenciadosList) {
                String indiferenciadoInfo = indiferenciado.getNome() + ";" + indiferenciado.getDescricao() + ";" +
                        indiferenciado.getStock() + ";" + indiferenciado.getPreco() + ";" + indiferenciado.getIva() + ";" +
                        indiferenciado.getValidade() + ";" + indiferenciado.getVisibilidade();
                bw.write(indiferenciadoInfo);
                bw.newLine();
            }
        }
    }
    
    //******************CRIAR FICHEIRO PARA MEDICAMENTOS *************************//
    public void guardarMedicamento(Medicamento medicamento) {
        String nomeArquivo = "medicamentos.txt";

        try {
            // Load existing products from the file
            List<Medicamento> existingMedicamentos = Carregar.carregarMedicamentos();

            // Check if the product already exists in the list
            boolean exists = false;
            for (Medicamento existingMedicamento : existingMedicamentos) {
                if (existingMedicamento.getNome().equalsIgnoreCase(medicamento.getNome())) {
                    exists = true;
                    break;
                }
            }

            // If the product already exists, update it; otherwise, add a new one
            if (exists) {
                for (int i = 0; i < existingMedicamentos.size(); i++) {
                    Medicamento existingMedicamento = existingMedicamentos.get(i);
                    if (existingMedicamento.getNome().equalsIgnoreCase(medicamento.getNome())) {
                        existingMedicamentos.set(i, medicamento);
                        break;
                    }
                }
            } else {
                // If the product does not exist, add a new one
                existingMedicamentos.add(medicamento);
            }

            // Save the updated list to the file
            guardarListaMedicamentos(existingMedicamentos);
        } catch (IOException e) {
            println("Erro ao salvar medicamento: " + e.getMessage());
        }
    }

    
    
    private void guardarListaMedicamentos(List<Medicamento> medicamentosList) throws IOException {
        String nomeArquivo = "medicamentos.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Medicamento medicamento : medicamentosList) {
                String medicamentoInfo = medicamento.getNome() + ";" + medicamento.getDescricao() + ";" +
                        medicamento.getStock() + ";" + medicamento.getPreco() + ";" + medicamento.getIva() + ";" +
                        medicamento.getValidade() + ";" + medicamento.getVisibilidade();
                bw.write(medicamentoInfo);
                bw.newLine();
            }
        }
    }
    
    public void guardarCliente(Cliente cliente) {
        String nomeArquivo = "clientes.dat";

        try {
            // Load existing products from the file
            List<Cliente> existingClientes = Carregar.carregarClientes();

            // Check if the product already exists in the list
            boolean exists = false;
            for (Cliente existingCliente : existingClientes) {
                if (existingCliente.getNome().equalsIgnoreCase(cliente.getNome())) {
                    exists = true;
                    break;
                }
            }

            // If the product already exists, update it; otherwise, add a new one
            if (exists) {
                for (int i = 0; i < existingClientes.size(); i++) {
                    Cliente existingCliente = existingClientes.get(i);
                    if (existingCliente.getNome().equalsIgnoreCase(cliente.getNome())) {
                        existingClientes.set(i, cliente);
                        break;
                    }
                }
            } else {
                // If the product does not exist, add a new one
                existingClientes.add(cliente);
            }

            // Save the updated list to the file
            guardarListaClientes(existingClientes);
        } catch (IOException e) {
            println("Erro ao salvar medicamento: " + e.getMessage());
        }
    }
    
    private void guardarListaClientes(List<Cliente> clientesList) throws IOException {
        String nomeArquivo = "clientes.dat";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Cliente cliente : clientesList) {
                String clienteInfo = cliente.getNome() + ";" + cliente.getNif() + ";" +
                        cliente.getRua() + ";" + cliente.getPostal() + ";" + cliente.getLocalidade() + ";" +
                        cliente.getVisibilidade();
                bw.write(clienteInfo);
                bw.newLine();
            }
        }
    }
}
