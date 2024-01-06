package farmaciart;

import java.io.Serializable;

public class Morada implements Serializable {
    
    public String rua;
    public String postal;
    public String localidade;
    
   
    
    public Morada(){
    
}
    
    public Morada(String rua , String postal, String localidade){
        
        this.rua = rua;
        this.postal = postal;
        this.localidade = localidade;
            
    }
}