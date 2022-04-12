/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * las habilidades de los humanos
 * @author Carlos
 */
package PracticaMP.practica;
public class Talento extends HabilidadEspecial{
    private int edad;
    
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public Talento (String nombre, int ataque, int defensa, int edad){
        super(nombre, ataque, defensa);
        setEdad(edad);
    }
}
