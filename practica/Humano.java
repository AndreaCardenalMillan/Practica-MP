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
    
    public Humano (String nombre, lealtad lazoAfectivo){
        super(nombre);
        setLazoAfectivo(lazoAfectivo);
        super.tipo="_H";

    }
    @Override
    public String subEsbirros(){
        int indiceLealtad=0;//alta por defecto
        if(lazoAfectivo==lealtad.Media){
            indiceLealtad=1;
        }else if(lazoAfectivo==lealtad.Baja){
            indiceLealtad=2;
        }
        
        return tipo+"("+super.getNombre()+";"+indiceLealtad+")";
    }
}
