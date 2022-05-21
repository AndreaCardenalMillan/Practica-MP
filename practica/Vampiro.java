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
    public void robarSangre(){//esto de donde ha salido?
        
        if (this.sangre < 10){
            sangre=Math.min(sangre+4, 10);
        }
    }
    @Override
    public void golpeAcertado(){
        robarSangre();
    }
    @Override
    public void recibirGolpe(){
        super.salud-=1;
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

    @Override
    public int defensaHabilidad(){
        int cuantDef=0;
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            int coste=((Disciplina)(habilidades.get(i))).getCoste();
            if(coste<=sangre){
                cuantDef+=habilidades.get(i).getAtaque();
                sangre-=coste;
            }
        }
        return cuantDef;

    }
    @Override
    public int ataqueHabilidad(){

        int cuantAtaque=0;
        if(sangre>=5){
            cuantAtaque+=2;
        }
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            int coste=((Disciplina)(habilidades.get(i))).getCoste();
            if(coste<=sangre){
                cuantAtaque+=habilidades.get(i).getAtaque();
                sangre-=coste;
            }
        }
        return cuantAtaque;
    }
}
