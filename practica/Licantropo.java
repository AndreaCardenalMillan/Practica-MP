package practica;

import java.util.ArrayList;
import java.util.Random;

public class Licantropo extends Personaje{
    private int rabia;

    public Licantropo(String nombre, HabilidadEspecial special, ArrayList reservaArmas, ArrayList reservaArmadura, ArrayList armasActivas, Equipo armaduraActiva, ArrayList esbirro, int poder, ArrayList modList, int rabia, int don){

        super(nombre,special, reservaArmas, reservaArmadura, armasActivas, armaduraActiva, esbirro, modList);

        this.poder = poder;
        this.rabia = 0;
    }

    public int consultarRabia(){
        return this.rabia;
    }

    public void incrementarRabia(){
        if (rabia < 3){
            rabia = rabia + 1;
        }
    }

    public void reiniciarRabia(){
        this.rabia = 0;
    }

    public void cambiarForma(int estatura, int peso){
        Random rn = new Random();

        estatura = estatura + rn.nextInt(101-50)+50; //cm
        peso = peso + rn.nextInt(111-90)+90; //kg
    }

    public void mostrarDatos(){
        System.out.println("Salud: "+this.salud);
        System.out.println("Poder: "+this.poder);
        System.out.println("Rabia: "+this.rabia);
    }
}
