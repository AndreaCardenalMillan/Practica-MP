/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos
 */
package PracticaMP.practica;
public class Humano extends Minion{
    public enum lealtad{
        Alta,
        Media,
        Baja
    }
    private lealtad lazoAfectivo;
    
    public lealtad getLazoAfectivo (){
        return lazoAfectivo;
    }
    public void setLazoAfectivo (lealtad lazoAfectivo){
        this.lazoAfectivo = lazoAfectivo;
    }
    
    public Humano (String nombre, int salud, lealtad lazoAfectivo){
        super(nombre, salud);
        setLazoAfectivo(lazoAfectivo);
    
    }
}
