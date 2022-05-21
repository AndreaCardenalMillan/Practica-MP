/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos
 */
package PracticaMP.practica;
public abstract class Minion {
    private String nombre;
    protected String tipo;
    private int salud;  
    
    public String subEsbirros(){
        return tipo;
    }
    public int calcularVidaTotal (){
        return salud;
    }
    
    public String getNombre (){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getSalud (){
        return salud;
    }
    public void setSalud (int salud) {
        this.salud = salud;
    }
    
    public Minion (String nombre){
        this.salud = 3; 
        this.nombre = nombre;
    }
    
    
}
