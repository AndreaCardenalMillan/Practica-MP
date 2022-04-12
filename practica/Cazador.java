package PracticaMP.practica;

import java.util.ArrayList;

public class Cazador extends Personaje{
    private int voluntad;

    public Cazador(String nombre, HabilidadEspecial special, ArrayList reservaArmas, ArrayList reservaArmadura, ArrayList armasActivas, Equipo armaduraActiva, ArrayList esbirro, int poder, ArrayList modList, int voluntad){

        super(nombre,special, reservaArmas, reservaArmadura, armasActivas, armaduraActiva, esbirro, modList);

        this.poder = poder;
        this.voluntad = 3;
    }

    public void perderVoluntad(){
        if (voluntad > 0){
            voluntad = voluntad - 1;
        }
    }

    public void reiniciarVoluntad(){
        this.voluntad = 3;
    }

    public void mostrarDatos(){
        System.out.println("Salud: "+this.salud);
        System.out.println("Poder: "+this.poder);
        System.out.println("Voluntad: "+this.voluntad);
    }


}
