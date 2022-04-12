package practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personaje{
    private String nombre;
    private HabilidadEspecial special;
    private List<Equipo> reservaArmas=new ArrayList<>();
    private List<Equipo> reservaArmaduras=new ArrayList<>();
    private List<Equipo> armasActivas=new ArrayList<>();
    private Equipo armaduraActiva;
    private List<Equipo> esbirro=new ArrayList<>();
    private int oro;
    public int salud;
    public int poder;
    private List<Modificador> modList =new ArrayList<>();


    public Personaje(String nombre, HabilidadEspecial special, ArrayList reservaArmas, ArrayList reservaArmadura, ArrayList armasActivas, Equipo armaduraActiva, ArrayList esbirro, ArrayList modList) {

        this.nombre = nombre;
        this.special = new HabilidadEspecial();
        this.reservaArmas = new ArrayList<>();
        this.reservaArmaduras = new ArrayList<>();
        this.armasActivas = new ArrayList<>();
        this.armaduraActiva = new Equipo();
        this.esbirro = new ArrayList<>();
        this.oro = 0;
        this.salud = 5;
        this.modList = new ArrayList<>();
    }

    public void Ataque(int ataque, Personaje p){
        p.salud = p.salud - ataque;
    }

    public void RecibirDanio(Personaje p){  
        salud = salud - p.poder;
    }

    public void CalcularVidaPersonaje(){
        System.out.println(salud);
    }

    public void Habilidad(){
        //this.special.cosaDeCarlos;
    }

    public boolean Esquivar(){
        boolean exito=false;

        Random rn = new Random();
        int numero = rn.nextInt(10-1)+1;
        
        if(numero >= 1 && numero <=5){
            exito = true;
        }
        return exito;
    }
}