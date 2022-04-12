/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Cada raza tiene una habilidad especial con sus características
 * @author Carlos
 */
package PracticaMP.practica;
public abstract class HabilidadEspecial {
    private String nombre;
    private int ataque;
    private int defensa;
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getAtaque(){
        return ataque;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    public int getDefensa(){
        return defensa;
    }
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    
    public HabilidadEspecial(String nombre, int ataque, int defensa){
        setNombre(nombre);
        setAtaque(ataque);
        setDefensa(defensa);
    }
   
}
