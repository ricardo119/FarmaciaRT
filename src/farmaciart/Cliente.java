package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
import static p1.P1App.readDouble;
import static p1.P1App.readInt;
import static p1.P1App.readLine;

public class Cliente extends Morada implements Serializable {

    public String nome;
    public String nif;
    private boolean isVisivel;
    
    public Cliente(){
        
    }

    public Cliente(String nome, String nif, String rua, String postal, String localidade, boolean isVisivel) {
        super(rua, postal, localidade);
        this.nome = nome;
        this.nif = nif;
        this.isVisivel = isVisivel;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getNif(){
        return nif;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNif(String nif){
        this.nif = nif;
    }
    
    public boolean getVisibilidade(){
        return isVisivel;
    }
    
    public void setVisibilidade(boolean isVisivel){
        this.isVisivel = isVisivel;
    }
    

    
//*************************INTRODUZIR NOVO CLIENTE****************************//
   
    public static void adicionarCliente(List<Cliente> clientesList) {
       
        String nome, nif, rua, postal, localidade;
        boolean isVisivel;

    println("Digite SAIR para voltar ao menu Atendimento");
    
    println("Nome do cliente:");
    nome = readLine();
    if (nome.equalsIgnoreCase("sair")) {
        return;
    }

    println("NIF:");
    nif = readLine();
    if (nif.equalsIgnoreCase("sair")) {
        Atendimento.menuAtendimento();
        return;
    }

    println("Rua:");
    rua = readLine();
    if (rua.equalsIgnoreCase("sair")) {
        Atendimento.menuAtendimento();
        return;
    }

    println("Codigo Postal:");
    postal = readLine();
    if (postal.equalsIgnoreCase("sair")) {
        Atendimento.menuAtendimento();
        return;
    }

    println("Localidade:");
    localidade = readLine();
    if (localidade.equalsIgnoreCase("sair")) {
        Atendimento.menuAtendimento();
        return;
    }
       
    
    Cliente novoCliente = new Cliente(nome, nif , rua, postal, localidade, true);
    novoCliente.guardarCliente(); 
    }

    
    public void guardarCliente(){
        Guardar guardar = new Guardar();
        guardar.guardarCliente(this);
    }
    
    public void listarClientes(){
        Listar listar = new Listar();
        List<Cliente> clientesList = new ArrayList<>();
        listar.listarClientes();
    }
    
    
    
    public static void eliminarCliente(List<Cliente> clientesList){
        
        String nomeProcura;
        boolean found = false;
        
        Listar listar = new Listar();
        listar.listarClientes();
        
        println("Digita o nome do cliente a remover da lista");
        nomeProcura = readLine();
        
        for (Cliente cliente : clientesList) {
            println(cliente.getNome());
            if (cliente.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                boolean isVisivel = cliente.getVisibilidade();
                cliente.setVisibilidade(!isVisivel);
                found = true;
            
                if (isVisivel) {
                    println("Medicamento removido da lista com sucesso.");
                } else {
                    println("Medicamento adicionado a lista com sucesso.");
                }
                
                cliente.guardarCliente();
                return;
            }
        }

        if (!found) {
            println("Medicamento não encontrado.");
        }
        
    }
    
    public static void editarClienteGeral(List<Cliente> clientesList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarClientes();
        
        println("Digita o nome do cliente a editar");
        nomeProcura = readLine();
        
        for (Cliente cliente : clientesList) {
            if (cliente.getNome().equalsIgnoreCase(nomeProcura)) {
                
                encontrado = true;
                
                println("Digite o NIF do cliente:");
                String novoNif = readLine();
                cliente.setNif(novoNif);

                println("Digite a rua:");
                String novaRua = readLine();
                cliente.setRua(novaRua);

                println("Digite o código postal:");
                String novoPostal = readLine();
                cliente.setPostal(novoPostal);

                println("Digite a localidade:");
                String novaLocalidade = readLine();
                cliente.setLocalidade(novaLocalidade);
                
                cliente.guardarCliente();
                
                break;
            }
        }
        
        if(!encontrado){
            println("Cliente nao encontrado");
        }
        
    }
//********************** EDITAR CLIENTE**************************************//
    
    public static void editarCliente(List<Cliente> clientesList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarClientes();
        
        println("Digita o nome do cliente a editar");
        nomeProcura = readLine();
        
        for (Cliente cliente : clientesList) {
            if (cliente.getNome().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                int opcao;

                do {
                    println("Escolha a informação a editar para o medicamento '" + nomeProcura + "':");
                    println("1. Descrição");
                    println("2. Stock");
                    println("3. Preço");
                    println("4. IVA");
                    println("5. Validade");
                    println("0. Sair");

                    opcao = readInt();

                    switch (opcao) {
                        case 1:
                            println("Digite a nova descrição:");
                            String novaDescricao = readLine();
                            medicamento.setDescricao(novaDescricao);
                            break;
                        case 2:
                            println("Digita o novo stock:");
                            int novoStock = readInt();
                            medicamento.setStock(novoStock);
                            break;
                        case 3:
                            println("Digita o novo preco:");
                            double novoPreco = readDouble();
                            medicamento.setPreco(novoPreco);
                            break;
                        case 4:
                            println("Digita o novo IVA:");
                            double novoIva = readInt();
                            medicamento.setIva(novoIva);
                            break;
                        case 5:
                            println("Digita a validade do produto (mm/aaaa)");
                            String expirationDateInput = readLine();
    
                            String[] dateComponents = expirationDateInput.split("/");
    
                            int mes = Integer.parseInt(dateComponents[0]);
                            int ano = Integer.parseInt(dateComponents[1]);
    
                            Data novaValidade = new Data(mes,ano);
                            medicamento.setValidade(novaValidade);
                            
                            medicamento.guardarMedicamentos();
                            
                            break;
                        case 0:
                            println("A sair da edicao");
                            break;
                        default:
                            println("Opção inválida. Tente novamente");
                    }
                } while (opcao != 0);

            break;
            }
        }

        if (!encontrado) {
        println("Medicamento não encontrado.");
        }
    }
    
}
