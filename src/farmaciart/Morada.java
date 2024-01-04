package farmaciart;

import java.io.Serializable;

public class Morada implements Serializable {
    
    public String local;
    public String localidade;
    public String postal;
    public String freguesia;
    public String rua;
    
    public Morada(){
    
}
    
    public Morada(String local, String localidade, String postal, String freguesia, String rua){
        
        this.local = local;
        this.localidade = localidade;
        this.postal = postal;
        this.freguesia = freguesia;
        this.rua = rua;
    }
    
    public String getLocal(){
        return local;
    }
    
     public String getLocalidade(){
        return localidade;
    }
     
      public String getPostal(){
        return postal;
    }
      
       public String getFreguesia(){
        return freguesia;
    }
       
        public String getRua(){
        return rua;
    }
}
