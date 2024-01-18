
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
    
    public String getRua(){
        return rua;
    }
    
    public String getPostal(){
        return postal;
    }
    
    public String getLocalidade(){
        return localidade;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }
    
    public void setPostal(String postal){
        this.postal = postal;
    }
    
    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
}