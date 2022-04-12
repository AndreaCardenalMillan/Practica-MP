/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * las habilidades de los licántropos
 * @author Carlos
 */
package PracticaMP.practica;
public class Don extends HabilidadEspecial{
    private int rabia;
    
    public int getRabia(){
        return rabia;
    }
    public void setRabia(int rabia) {
        this.rabia = rabia;
    }
    
    public Don (String nombre, int ataque, int defensa, int rabia){
        super(nombre, ataque, defensa);
        setRabia(rabia);
    }
}
