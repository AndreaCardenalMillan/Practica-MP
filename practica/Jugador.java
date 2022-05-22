package PracticaMP.practica;

import java.util.List;

;

public class Jugador extends Usuario {
    private String NR;
    private boolean baneo = false;

    public Jugador(String pNombre,String pNick,String pPassword){
        super(pNombre,pNick,pPassword);

        
    }
    public void crearNR(){
        String id="";
        
        List<String> idsUsuarios=Game.guardado.listaUsuarios();
        while(id == "" || idsUsuarios.contains(id)){
            id=generateNR(5);
        }
        this.NR = id; 
    }
    private String generateNR(int i){
        String theAlphaNumericS;
        StringBuilder builder;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 

        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 

            int myindex 
                = (int)(theAlphaNumericS.length() 
                        * Math.random()); 

            builder.append(theAlphaNumericS 
                        .charAt(myindex)); 
        } 

        return builder.toString(); 
    } 

    public String getNR(){
        return this.NR;
    }

    public boolean getBaneo(){
        return this.baneo;
    }

    public void banear(){
        this.baneo=true;
    }

    public void desbanear(){
        this.baneo=false;
    }
}
