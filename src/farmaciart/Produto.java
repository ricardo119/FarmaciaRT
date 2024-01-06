package farmaciart;

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
    
    
    public double setPreco(double preco){
        this.preco = preco;
        return preco;
    }
    
    public int setIva(int iva){
        this.iva = iva;
        return iva;
    }
    
    public void setValidade(){
        println("Digita a validade do produto (dd/mm/aaaa)");
        String expirationDateInput = readLine();
    
        String[] dateComponents = expirationDateInput.split("/");
    
        int dia = Integer.parseInt(dateComponents[0]);
        int mes = Integer.parseInt(dateComponents[1]);
        int ano = Integer.parseInt(dateComponents[2]);
    
        Data validade = new Data(dia,mes,ano);
    }
    
 //******************ADICIONAR PRODUTO*************************************//
    
    public static void novoProduto(List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList) {
        
    String nome, descricao, categoria;
    int stock, op;
    double preco, iva;   

    println("Digite o nome do produto:");
    nome = readLine();

    println("Digite a descrição do produto:");
    descricao = readLine();

    println("Digite o stock do produto:");
    stock = readInt();

    println("Digite o preço do produto:");
    preco = readDouble();

    println("Digite o valor do IVA do produto:");
    iva = readDouble();
    
    println("Digita a validade do produto (dd/mm/aaaa)");
    String expirationDateInput = readLine();
    
    String[] dateComponents = expirationDateInput.split("/");
    
    int dia = Integer.parseInt(dateComponents[0]);
    int mes = Integer.parseInt(dateComponents[1]);
    int ano = Integer.parseInt(dateComponents[2]);
    
    Data validade = new Data(dia,mes,ano);
    
    println("Categoria:");
    println("1. Medicamento");
    println("2. Indiferenciado");
    
    op = readInt();
    
    switch(op){
        case 1:
            categoria  = "medicamento";
            Medicamento novoMedicamento = new Medicamento(nome, descricao, categoria, stock, preco, iva, validade);
            novoMedicamento.guardarMedicamentos();
            medicamentosList.add(novoMedicamento);
            break;
        case 2:
            categoria = "indeferenciado";
            Indiferenciado novoIndiferenciado = new Indiferenciado(nome, descricao, categoria, stock, preco, iva, validade);
            novoIndiferenciado.guardarIndiferenciados();
            indiferenciadosList.add(novoIndiferenciado);
            break;
        default:
            println("Categoria inexistente");
            break;
        }

    }
    
    public static void editarProduto(List<Medicamento> medicamentosList, List<Indiferenciado> indiferenciadosList){
        
        int op = 0;
        
        do{
        println("Categoria do produto a editar:");
        println("1. Medicamento");
        println("2. Indiferenciado");
        println("0. Sair");
        
        op = readInt();
        
        switch(op){
            case 1:
                editar.menuEditarMedicamento();
                break;
            case 2:
        }
        }while (op != 0);
       
    }
}