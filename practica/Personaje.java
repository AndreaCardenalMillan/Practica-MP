package PracticaMP.practica;

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
    private List<Equipo> minion=new ArrayList<>();
    private int oro;
    public int salud;
    public int poder;
    private List<Modificador> modList =new ArrayList<>();


    public Personaje(String nombre, ArrayList reservaArmas, ArrayList reservaArmadura, ArrayList armasActivas, Equipo armaduraActiva, ArrayList modList) {

        this.nombre = nombre;
        this.special = new ArrayList<>();
        this.reservaArmas = new ArrayList<>();
        this.reservaArmaduras = new ArrayList<>();
        this.armasActivas = new ArrayList<>();
        this.armaduraActiva = armaduraActiva;
        this.minion = new ArrayList<>();
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

    public void Habilidad(HabilidadEspecial s){
        this.special.add(s);
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

    public void addMinion(Minion m){
        this.minion.add(m);
    }
}