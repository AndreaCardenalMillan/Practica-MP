
package PracticaMP.practica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos
 */
public class Ghoul extends Minion{
    private int dependencia;
    
    public int getDependencia(){
        return dependencia;
    }
    public void setDependencia(int dependencia){
        this.dependencia = dependencia;
    }
    
    public Ghoul (String nombre, int salud, int dependencia){
        super(nombre, salud);
        setDependencia(dependencia);
    }
}
