/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMP.practica;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ruben
 */
public class Guardado {
    private Map<String,Equipo> equipoCreado=new HashMap<>();
    private Map<String,HabilidadEspecial> habilidadesCreadas=new HashMap<>();

    private void cargarEquipo(String nombre){
        File equipo=new File("ficherosConfiguracion/equipo/"+nombre+".csv");
        if(equipo.exists()){
            
        }
    }
}
