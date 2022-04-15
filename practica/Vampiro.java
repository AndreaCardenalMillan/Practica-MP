package PracticaMP.practica;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Vampiro extends Personaje{
    private int sangre;
    private int edad;

    public Vampiro(String nombre, List<HabilidadEspecial> special, List<Equipo> armasActivas, Equipo armaduraActiva, int edad){
        super(nombre, special, armasActivas, armaduraActiva);
        

        this.edad = edad;
        this.sangre = 0;
    }
    public int getSangre(){
        return sangre;
    }
    public int getEdad(){
        return edad;
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
