/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos
 */
package PracticaMP.practica;
public class Equipo {
    private int Id;
    private String nombre;
    private int modAtaque;
    private int modDefensa;
    public enum tipoEquipo {
        unaMano,
        dosManos,
        armadura
    };
    private tipoEquipo claseEquipo;
    public int getID(){
        return Id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getModAtaque() {
        return modAtaque;
    }
    public void setModAtaque(int modAtaque) {
        this.modAtaque = modAtaque;
    }

    public int getModDefensa() {
        return modDefensa;
    }
    public void setModDefensa(int modDefensa) {
        this.modDefensa = modDefensa;
    }

    public tipoEquipo getClaseEquipo() {
        return claseEquipo;
    }
    public void setClaseEquipo(tipoEquipo claseEquipo) {
        this.claseEquipo = claseEquipo;
    }   
    
    public Equipo (int idIn, String nombre, int modAtaque, int modDefensa, tipoEquipo claseEquipo){
        Id=idIn;
        setNombre(nombre);
        setModAtaque(modAtaque);
        setModDefensa(modDefensa);
        setClaseEquipo(claseEquipo);
    }       
}
