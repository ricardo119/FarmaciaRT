
package farmaciart;

import java.io.Serializable;


public class Data implements Serializable {
    
    public int mes;
    public int ano;
    
    public Data() {
        
    }
    
    
    public Data(int mes, int ano){
        this.mes = mes;
        this.ano = ano;    
    }
    
    
    public int getMes(){
        return mes;
    }
    
    public int getAno(){
        return ano;
    }
    
    
    public String toString() {
        return String.format("%02d/%04d",mes, ano);
    }
    
    public void setValidade(int mes, int ano){
        this.mes = mes;
        this.ano = ano;
    }
}
