package farmaciart;

import java.io.IOException;
import static p1.P1App.println;
import static p1.P1App.readDouble;
import static p1.P1App.readInt;
import static p1.P1App.readLine;
import java.io.Serializable;
import java.util.List;

public class Produto extends Data implements Serializable {
    
    String nome;
    String descricao;
    int stock;
    double preco;
    double iva;
    Data validade;
            
    public Produto(){
        super();
    }
    
    public Produto(String nome , String descricao, int stock , double preco , double iva, Data validade){
        
        this.nome = nome;
        this.descricao = descricao;
        this.stock = stock;
        this.preco = preco;
        this.iva = iva;
        this.validade = validade;
        
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
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
    
    public Data getValidade() {
        return validade;
    }
    
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public void setIva(double iva){
        this.iva = iva;
    }
    
    public void setValidade(Data novaValidade){
        this.validade = novaValidade;
    }
    
///*//************* MENU DE GESTÃO DOS PRODUTOS*******************************//    
    
    public static void menuGestaoProduto(List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList) throws IOException{ 
        
        int op = 0;
        
        do{
            println("*******************************");
            println("**Menu de Gestao de Produtos**");
            println("*******************************\n");
            println("1.Editar Produtos");
            println("2.Listar Medicamentos");
            println("3.Listar Indiferenciados");
            println("4.Listar todos os Medicamentos");
            println("5.Listar todos os Indiferenciados");
            
            op = readInt();
            
            switch(op){
                case 1:
                    Produto.editarProduto(medicamentosList, indiferenciadosList);
                    break;
                case 2:
                    Listar.listarMedicamentosVisiveis();
                    break;
                case 3:
                    Listar.listarIndiferenciadosVisiveis();
                    break;
                case 4:
                    Listar.listarMedicamentos();
                    break;
                case 5:
                    Listar.listarIndiferenciados();
                    break;
                case 0:
                    break;
                default:
                    println("Nenhuma opcao escolhida");
            }
            
        }while(op != 0);
    }
    
 //*//*****************ADICIONAR PRODUTO*************************************//
    
    public static void novoProduto(List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList) {
        
    String nome, descricao, categoria;
    int stock, op;
    double preco, iva;   

    println("Digite SAIR para voltar ao menu Atendimento");
    
    println("Digite o nome do produto:");
    nome = readLine();
    if (nome.equalsIgnoreCase("sair")) {
        return;
    }
    
    println("Digite a descrição do produto:");
    descricao = readLine();
    if (descricao.equalsIgnoreCase("sair")) {
        return;
    }
    println("Digite o stock do produto (0 para SAIR)");
    stock = readInt();
    if (stock==0) {
        return;
    }

    println("Digite o preço do produto (0 para SAIR)");
    preco = readDouble();
    if (preco==0) {
        return;
    }
    println("Digite o valor do IVA do produto (0 para SAIR)");
    iva = readDouble();
    if (iva==0) {
        return;
    }
    
    println("Digita a validade do produto (mm/aaaa)");
    String expirationDateInput = readLine();
    if (expirationDateInput.equalsIgnoreCase("sair")) {
        return;
    }
    
    String[] dateComponents = expirationDateInput.split("/");
    
    int mes = Integer.parseInt(dateComponents[0]);
    int ano = Integer.parseInt(dateComponents[1]);
    
    Data validade = new Data(mes,ano);
    
    println("Categoria:");
    println("1. Medicamento");
    println("2. Indiferenciado");
    
    op = readInt();
    
    switch(op){
        case 1:
            categoria  = "medicamento";
            Medicamento novoMedicamento = new Medicamento(nome, descricao, categoria, stock, preco, iva, validade, true);
            novoMedicamento.guardarMedicamentos();
            medicamentosList.add(novoMedicamento);
            break;
        case 2:
            categoria = "indeferenciado";
            Indiferenciado novoIndiferenciado = new Indiferenciado(nome, descricao, categoria, stock, preco, iva, validade, true);
            novoIndiferenciado.guardarIndiferenciados();
            indiferenciadosList.add(novoIndiferenciado);
            break;
        default:
            println("Categoria inexistente");
            break;
        }

    }
 
//*************************EDITAR PRODUTO*************************************//
    
    public static void editarProduto(List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList) throws IOException{
        
        int op = 0;
        
        do{
        println("Categoria do produto a editar:");
        println("1. Medicamento");
        println("2. Indiferenciado");
        println("0. Sair");
        
        op = readInt();
        
        switch(op){
            case 1:
                menuEditarMedicamento(medicamentosList);
                break;
            case 2:
                menuEditarIndiferenciado(indiferenciadosList);
                break;
            case 0: 
                break;
            default:
               println("Escolha uma opção válida");
        }
        }while (op != 0);
       
    }
   
 //********************* MENU EDITAR PRODUTO*************************************//
    
    public static void menuEditarMedicamento(List<Medicamento> medicamentosList) throws IOException{
        
        int op = 0;
        
        do{        
            println("Menu de Edicao de Medicamento");
            println("1. Remover da lista");
            println("2. Editar todas as informacoes");
            println("3. Editar informacao especefica");
            println("9. Voltar ao menu administrador");
            println("0. Voltar ao menu anterior");
            
            op = readInt();
            
            switch(op){
                case 1:
                    eliminarMedicamento(medicamentosList);
                    break;
                case 2:
                    editarMedicamentoGeral(medicamentosList);
                    break;
                case 3:
                    editarMedicamento(medicamentosList);
                    break;
                case 9:
                    FarmaciaRT.menuAdministrador();
                    break;
                case 0:
                    break;
                default:
                    println("Nenhuma opcao escolhida");
            }
        }while (op != 0);
    }
    
    //****************** MENU EDITAR INDIFERENCIADO *************************************//
    
    public static void menuEditarIndiferenciado(List<Indiferenciado> indiferenciadosList) throws IOException{
        
        int op = 0;
        
        do{        
            println("\n*********************************");
            println("**Menu de Edicao de Medicamento**");
            println("*********************************\n");
            println("1. Remover da lista");
            println("2. Editar todas as informacoes");
            println("3. Editar informacao especefica");
            println("9. Voltar ao menu administrador");
            println("0. Voltar ao menu anterior");
            
            op = readInt();
            
            switch(op){
                case 1:
                    eliminarIndiferenciado(indiferenciadosList);
                    break;
                case 2:
                    editarIndiferenciadoGeral(indiferenciadosList);
                    break;
                case 3:
                    editarIndiferenciado(indiferenciadosList);
                    break;
                case 9:
                    FarmaciaRT.menuAdministrador();
                    break;
                case 0:
                    break;
                default:
                    println("Nenhuma opcao escolhida");
            }
        }while (op != 0);
    }
    
    //****************** ELIMINAR MEDICAMENTO *************************************//
    
    public static void eliminarMedicamento(List<Medicamento> medicamentosList){
        
        String nomeProcura;
        boolean found = false;
        
        Listar listar = new Listar();
        listar.listarMedicamentos();
        
        println("Digita o nome do medicamento a editar");
        nomeProcura = readLine();
        
        for (Medicamento medicamento : medicamentosList) {
            println(medicamento.getNome());
            if (medicamento.getNome().trim().equalsIgnoreCase(nomeProcura)) {
                boolean isVisivel = medicamento.getVisibilidade();
                medicamento.setVisibilidade(!isVisivel);
                found = true;
            
                if (isVisivel) {
                    println("Medicamento removido da lista com sucesso.");
                } else {
                    println("Medicamento adicionado a lista com sucesso.");
                }
                
                medicamento.guardarMedicamentos();
                return;
            }
        }

        if (!found) {
            println("Medicamento não encontrado.");
        }
        
    }
    
    //****************** ELIMINAR INDIFERENCIADOS*****************************//
    
    public static void eliminarIndiferenciado(List<Indiferenciado> indiferenciadosList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarIndiferenciados();
        
        println("Digita o nome do produto a editar");
        nomeProcura = readLine();
        
        for (Indiferenciado indiferenciado : indiferenciadosList) {
            if (indiferenciado.getNome().equalsIgnoreCase(nomeProcura)) {
                boolean isVisivel = indiferenciado.getVisibilidade();
                indiferenciado.setVisibilidade(!isVisivel);
                encontrado = true;
            
                if (isVisivel) {
                    println("Produto removido da lista com sucesso.");
                } else {
                    println("Produto adicionado a lista com sucesso.");
                }
                
                indiferenciado.guardarIndiferenciados();
                return;
            }
        }

        if (!encontrado) {
            println("Produto não encontrado.");
            }  
        }
   
    //****************EDITAR INFORMAÇÕES GERAIS DE UM MEDICAMENTO*************//
    
    public static void editarMedicamentoGeral(List<Medicamento> medicamentosList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarMedicamentos();
        
        println("\nDigita o nome do medicamento a editar\n");
        nomeProcura = readLine();
        
        for (Medicamento medicamento : medicamentosList) {
            if (medicamento.getNome().equalsIgnoreCase(nomeProcura)) {
                
                encontrado = true;
                
                println("Digite a descrição do produto:");
                String novaDescricao = readLine();
                medicamento.setDescricao(novaDescricao);

                println("Digite o estoque do produto:");
                int novoStock = readInt();
                medicamento.setStock(novoStock);

                println("Digite o preço do produto:");
                double novoPreco = readDouble();
                medicamento.setPreco(novoPreco);

                println("Digite o valor do IVA do produto:");
                double novoIva = readDouble();
                medicamento.setIva(novoIva);
                
                println("Digita a validade do produto (dd/mm/aaaa)");
                String expirationDateInput = readLine();
    
                String[] dateComponents = expirationDateInput.split("/");
    
                int dia = Integer.parseInt(dateComponents[0]);
                int mes = Integer.parseInt(dateComponents[1]);
                int ano = Integer.parseInt(dateComponents[2]);
    
                Data novaValidade = new Data(mes,ano);
                medicamento.setValidade(novaValidade);
                
                medicamento.guardarMedicamentos();
                
                break;
            }
        }
        
        if(!encontrado){
            println("Medicamento nao encontrado");
        }
        
    }
   
    //*************EDITAR INFORMAÇÕES GERAIS DE UM INDIFERENCIADO*************//
    
    public static void editarIndiferenciadoGeral(List<Indiferenciado> indiferenciadosList){
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarIndiferenciados();
        
        println("\nDigita o nome do produto a editar");
        nomeProcura = readLine();
        
        for (Indiferenciado indiferenciado : indiferenciadosList) {
            if (indiferenciado.getNome().equalsIgnoreCase(nomeProcura)) {
                
                encontrado = true;
                
                println("Digite a descrição do produto:");
                String novaDescricao = readLine();
                indiferenciado.setDescricao(novaDescricao);

                println("Digite ostock do produto:");
                int novoStock = readInt();
                indiferenciado.setStock(novoStock);

                println("Digite o preço do produto:");
                double novoPreco = readDouble();
                indiferenciado.setPreco(novoPreco);

                println("Digite o valor do IVA do produto:");
                double novoIva = readDouble();
                indiferenciado.setIva(novoIva);
                
                println("Digita a validade do produto (mm/aaaa)");
                String expirationDateInput = readLine();
    
                String[] dateComponents = expirationDateInput.split("/");
    
                int mes = Integer.parseInt(dateComponents[0]);
                int ano = Integer.parseInt(dateComponents[1]);
    
                Data novaValidade = new Data(mes,ano);
                indiferenciado.setValidade(novaValidade);
                
                indiferenciado.guardarIndiferenciados();
                break;
            }
        }
        
        if(!encontrado){
            println("Nenhum produto encontrado");
        }
    }
    
   //*************EDITAR INFORMAÇÕES ESPECIFICAS DE UM MEDICAMENTO*************//
    
    public static void editarMedicamento(List<Medicamento> medicamentosList) {
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarMedicamentos();
    
        println("Digite o nome do medicamento a editar:");
        nomeProcura = readLine();
    

        for (Medicamento medicamento : medicamentosList) {
            if (medicamento.getNome().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                int opcao;

                do {
                    println("\nEscolha a informação a editar para o medicamento\n" + nomeProcura + "':");
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
 
    //*************EDITAR INFORMAÇÕES ESPECIFICAS DE UM INDIFERENCIADO*************//
    
    public static void editarIndiferenciado(List<Indiferenciado> indiferenciadosList) {
        
        String nomeProcura;
        boolean encontrado = false;
        
        Listar listar = new Listar();
        listar.listarIndiferenciados();
    
        println("Digite o nome do produto a editar:");
        nomeProcura = readLine();
    

        for (Indiferenciado indiferenciado : indiferenciadosList) {
            if (indiferenciado.getNome().equalsIgnoreCase(nomeProcura)) {
                encontrado = true;
                int opcao;

                do {
                    println("\nEscolha a informação a editar para o produto\n'" + nomeProcura + "':");
                    println("1. Descrição");
                    println("2. Estoque");
                    println("3. Preço");
                    println("4. Valor do IVA");
                    println("5. Validade");
                    println("0. Sair");

                    opcao = readInt();

                    switch (opcao) {
                        case 1:
                            println("Digite a nova descrição:");
                            String novaDescricao = readLine();
                            indiferenciado.setDescricao(novaDescricao);
                            break;
                        case 2:
                            println("Digita o novo stock:");
                            int novoStock = readInt();
                            indiferenciado.setStock(novoStock);
                            break;
                        case 3:
                            println("Digita o novo preco:");
                            double novoPreco = readDouble();
                            indiferenciado.setPreco(novoPreco);
                            break;
                        case 4:
                            println("Digita o novo IVA:");
                            double novoIva = readDouble();
                            indiferenciado.setIva(novoIva);
                            break;
                        case 5:
                            println("Digita a validade do produto (mm/aaaa)");
                            String expirationDateInput = readLine();
    
                            String[] dateComponents = expirationDateInput.split("/");
    
                            int mes = Integer.parseInt(dateComponents[0]);
                            int ano = Integer.parseInt(dateComponents[1]);
    
                            Data novaValidade = new Data(mes,ano);
                            indiferenciado.setValidade(novaValidade);
                            
                            indiferenciado.guardarIndiferenciados();
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
        println("Produto não encontrado.");
        }
    }
}