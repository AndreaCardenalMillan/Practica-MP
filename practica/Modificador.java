/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos
 */
package PracticaMP.practica;
public class Modificador {
    private String nombre;
    private int modAtaque;
    private int modDefensa;
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getModAtaque(){
        return modAtaque;
    }
    public void setModAtaque(int ataque){
        this.modAtaque = modAtaque;
    }
    
    public int getModDefensa(){
        return modDefensa;
    }
    public void setModDefensa(int defensa){
        this.modDefensa = modDefensa;
    }
    
    public Modificador (String nombre, int ataque, int defensa){
        setNombre(nombre);
        setModAtaque(ataque);
        setModDefensa(defensa);
    }
    
}
