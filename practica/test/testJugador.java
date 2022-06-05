/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMP.practica.test;

import PracticaMP.practica.Game;
import PracticaMP.practica.Jugador;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.management.Notification;

/**
 *
 * @author Ruben
 */
public class testJugador {
    public static void main(String[] args) throws IOException {
        Jugador j=new Jugador("Nombre", "pNick", "pPassword");
        int coincidencias=0;
        int casos=100;
        for(int i=0;i<casos;i++){
            j.crearNR();
            
            if(!Pattern.matches("[A-Z]{1}[0-9]{2}[A-Z]{2}", j.getNR())){
                //System.out.println("ERROR");
            }else{
                //System.out.println("BIEN :)");
                coincidencias++;
            }
        }
        if(coincidencias==casos){
            System.out.println("todos los casos de NR exitosos");
        }


        

        
    }
}
