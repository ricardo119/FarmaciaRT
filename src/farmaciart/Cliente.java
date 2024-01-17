package farmaciart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static p1.P1App.println;
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
    
    public static void menuGestaoCliente(List<Cliente> clientesList){
        
        int op = 0;
        
        do{
            println("Menu de Gestaõ de Cliente");
            println("1. Eliminar cliente");
            println("2. Editar cliente geral");
            println("3. Editar cliente");
            println("0. Sair");
            
            op = readInt();
            
            switch(op){
                case 1:
                    eliminarCliente(clientesList);
                    break;
                case 2:
                    editarClienteGeral(clientesList);
                    break;
                case 3:
                    editarCliente(clientesList);
                    break;
                case 0:
                    break;
                default:
                    println("Escolha uma opção válida");       
            }
        }while (op != 0);
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
        
        clientesList = Carregar.carregarClientes();
        
        Listar.listarClientes();
        
        println("Digita o nome do cliente a remover da lista");
        nomeProcura = readLine();
        
        for (Cliente cliente : clientesList) {
            println(cliente.getNome());
            if (cliente.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                found = true;
                boolean isVisivel = cliente.getVisibilidade();
                cliente.setVisibilidade(!isVisivel);
            
                if (isVisivel) {
                    println("Cliente removido da lista com sucesso.");
                } else {
                    println("Cliente adicionado a lista com sucesso.");
                }
                
                cliente.guardarCliente();
                return;
            }
        }

        if (!found) {
            println("Cliente não encontrado.");
        }
        
    }
    
    public static void editarClienteGeral(List<Cliente> clientesList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Carregar.carregarClientes();
        
        Listar.listarClientes();
        
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
        
        Carregar.carregarClientes();
        
        Listar.listarClientes();
        
        println("Digita o nome do cliente a editar");
        nomeProcura = readLine();
        
        for (Cliente cliente : clientesList) {
            if (cliente.getNome().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                int opcao;

                do {
                    println("Escolha a informação a editar para o medicamento '" + nomeProcura + "':");
                    println("1. Nif");
                    println("2. Rua");
                    println("3. Código-Postal");
                    println("4. Localidade");
                    println("0. Sair");

                    opcao = readInt();

                    switch (opcao) {
                        case 1:
                            println("Digite o novo NIF");
                            String novoNif = readLine();
                            cliente.setNif(novoNif);
                            break;
                        case 2:
                            println("Digita a nova rua");
                            String novaRua = readLine();
                            cliente.setRua(novaRua);
                            break;
                        case 3:
                            println("Digita o novo código-postal");
                            String novoPostal = readLine();
                            cliente.setPostal(novoPostal);
                            break;
                        case 4:
                            println("Digita a nova localidade");
                            String novaLocalidade = readLine();
                            cliente.setLocalidade(novaLocalidade);
                            break;
                        default:
                            println("Opção inválida. Tente novamente");
                    }
                } while (opcao != 0);

            break;
            }
        }

        if (!encontrado) {
        println("Cliente não encontrado.");
        }
    }
    
}
