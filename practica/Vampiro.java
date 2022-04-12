package practica;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vampiro extends Personaje{
    private int sangre;
    private int edad;

    public Vampiro(String nombre, HabilidadEspecial special, ArrayList reservaArmas, ArrayList reservaArmadura, ArrayList armasActivas, Equipo armaduraActiva, ArrayList esbirro, ArrayList modList, int edad, int sangre){
        super(nombre, special, reservaArmas, reservaArmadura, armasActivas, armaduraActiva, esbirro, modList);
        
        Random rn = new Random();

        this.poder = rn.nextInt(6-1)+1;
        this.edad = edad;
        this.sangre = 0;
    }

    public void robarSangre(){
        Random rn = new Random(2);
        
        if (this.sangre < 10){
            this.sangre = this.sangre + rn.nextInt();
        }
    }

    public void puntosSangre(){
        System.out.println(this.sangre);
    }

    public void registrarEdad(){
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Edad del vampiro: ");
        int edad = reader.nextInt();
        this.edad = edad;
        reader.close();
    }

    public void mostrarDatos(){
        System.out.println("Salud: "+this.salud);
        System.out.println("Poder: "+this.poder);
        System.out.println("Sangre: "+this.sangre);
        System.out.println("Edad: "+this.edad);
    }
}
