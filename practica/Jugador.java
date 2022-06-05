package PracticaMP.practica;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Jugador extends Usuario {
    private String NR;
    private boolean baneado;

    public Jugador(String pNombre,String pNick,String pPassword){
        super(pNombre,pNick,pPassword);

        
    }
    public boolean getBan(){
        return baneado;
    }
    public void setBan(boolean banState){
        baneado=banState;
    }
    public void crearNR(){
        String id="";
        
        List<String> idsUsuarios=Game.guardado.listaUsuarios();
        while(Objects.equals(id,"") || idsUsuarios.contains(id)){
            id=generateNR();
        }
        this.NR = id; 
    }
    private String generateNR(){
        StringBuilder builder;
        
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        builder = new StringBuilder(); 

        //formato LNNLL
        builder.append(letras.charAt(randomInt(0, letras.length()-1)));// L
        builder.append(randomInt(0, 9));                //  N
        builder.append(randomInt(0, 9));                //  N
        builder.append(letras.charAt(randomInt(0, letras.length()-1)));// L
        builder.append(letras.charAt(randomInt(0, letras.length()-1)));// L

        return builder.toString(); 
    } 

    public String getNR(){
        return this.NR;
    }
    public void setNR(String nrIn){
        this.NR=nrIn;
    }

    
    private int randomInt(int minInclusive, int maxInclusive){
        Random rand = new Random();
        int randomNum = rand.nextInt((maxInclusive - minInclusive) + 1) + minInclusive;
        return randomNum;
    }
}
