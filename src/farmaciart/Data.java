
package farmaciart;

import java.io.Serializable;


public class Data implements Serializable {
    
    public int dia;
    public int mes;
    public int ano;
    
    public Data() {
        
    }
    
    
     public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;    
    }
     
     @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
