package PracticaMP.practica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * las habilidades de los vampiros
 * @author Carlos
 */
public class Disciplina extends HabilidadEspecial{
    private int coste;
    
    public int getCoste(){
        return coste;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }
    
    public Disciplina (String nombre, int defensa, int ataque, int coste){
        super(nombre, ataque, defensa);
        setCoste(coste);
        
    } 
    
}
