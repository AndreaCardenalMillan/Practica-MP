package PracticaMP.practica;;

public class Jugador extends Usuario {
    private String NR;

    public Jugador(String pNombre,String pNick,String pPassword){
        super(pNombre,pNick,pPassword);

        this.NR = generateNR(5);
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
}
