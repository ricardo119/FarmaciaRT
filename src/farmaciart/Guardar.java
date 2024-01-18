package farmaciart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static p1.P1App.println;


public class Guardar extends Produto {
    
    public Guardar(){
        
    }
    
    
    //******************GUARDAR/ATUALIZAR FICHEIRO PARA INDIFERENCIADOS ******************//
   
    public void guardarIndiferenciado(Indiferenciado indiferenciado) {
        String nomeArquivo = "indiferenciados.txt";

        try {
            List<Indiferenciado> existingIndiferenciados = Carregar.carregarIndiferenciados();

            boolean exists = false;
            for (int i = 0; i < existingIndiferenciados.size(); i++) {
                Indiferenciado existingIndiferenciado = existingIndiferenciados.get(i);
                if (existingIndiferenciado.getNome().equalsIgnoreCase(indiferenciado.getNome())) {
                    exists = true;
                    existingIndiferenciados.set(i, indiferenciado); 
                    break;
                }
            }

            if (!exists) {
                existingIndiferenciados.add(indiferenciado);
            }

            guardarListaIndiferenciados(existingIndiferenciados);
        } catch (IOException e) {
            println("Erro ao guardar indiferenciado: " + e.getMessage());
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
    
    //******************GUARDAR/ATUALIZAR FICHEIRO PARA MEDICAMENTOS *************************//
    
    public void guardarMedicamento(Medicamento medicamento) {
        String nomeArquivo = "medicamentos.txt";

        try {
            List<Medicamento> existingMedicamentos = Carregar.carregarMedicamentos();

            boolean exists = false;
            for (Medicamento existingMedicamento : existingMedicamentos) {
                if (existingMedicamento.getNome().equalsIgnoreCase(medicamento.getNome())) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                for (int i = 0; i < existingMedicamentos.size(); i++) {
                    Medicamento existingMedicamento = existingMedicamentos.get(i);
                    if (existingMedicamento.getNome().equalsIgnoreCase(medicamento.getNome())) {
                        existingMedicamentos.set(i, medicamento);
                        break;
                    }
                }
            } else {
                existingMedicamentos.add(medicamento);
            }

            guardarListaMedicamentos(existingMedicamentos);
        } catch (IOException e) {
            println("Erro ao guardar medicamento: " + e.getMessage());
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
//**************************ATUALIZAR/GUARDAR CLIENTE*************************//
    
    public void guardarCliente(Cliente cliente) {
        String nomeArquivo = "clientes.dat";

        try {
            List<Cliente> existingClientes = Carregar.carregarClientes();

            boolean exists = false;
            for (Cliente existingCliente : existingClientes) {
                if (existingCliente.getNome().equalsIgnoreCase(cliente.getNome())) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                for (int i = 0; i < existingClientes.size(); i++) {
                    Cliente existingCliente = existingClientes.get(i);
                    if (existingCliente.getNome().equalsIgnoreCase(cliente.getNome())) {
                        existingClientes.set(i, cliente);
                        break;
                    }
                }
            } else {
                existingClientes.add(cliente);
            }

            guardarListaClientes(existingClientes);
        } catch (IOException e) {
            println("Erro ao salvar cliente: " + e.getMessage());
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
    
 //*****************GUARDAR INFORMAÇÃO DAS VENDAS*****************************//
    
    public void guardarListaVendas(List<Venda> vendasList) throws IOException {
    String nomeArquivo = "vendas.dat";

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
        for (Venda venda : vendasList) {
            String vendaInfo = venda.getNomeCliente() + ";" + venda.getNifCliente() + ";" + venda.getMedicamento() + ";" +
                    venda.getQuantidade() + ";" + venda.getTotal() + ";";
            bw.write(vendaInfo);
            bw.newLine();
        }
    }
}

}
