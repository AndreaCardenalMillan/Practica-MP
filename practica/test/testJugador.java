/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMP.practica.test;

import PracticaMP.practica.Jugador;
import java.util.regex.Pattern;

/**
 *
 * @author Ruben
 */
public class testJugador {
    public static void main(String[] args) {
        Jugador j=new Jugador("Nombre", "pNick", "pPassword");
        for(int i=0;i<100;i++){
            j.crearNR();
            
            if(!Pattern.matches("[A-Z]{1}[0-9]{2}[A-Z]{2}", j.getNR())){
                System.out.println("ERROR");
            }else{
                System.out.println("BIEN :)");
            }
        }
        
    }
}
