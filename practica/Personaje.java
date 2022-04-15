package PracticaMP.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personaje{
    private String nombre;
    private List<HabilidadEspecial> special = new ArrayList<>();
    private List<Equipo> reservaArmas=new ArrayList<>();
    private List<Equipo> reservaArmaduras=new ArrayList<>();
    private List<Equipo> armasActivas=new ArrayList<>();
    private Equipo armaduraActiva;
    private List<Minion> minion=new ArrayList<>();
    private List<Modificador> modList =new ArrayList<>();
    private int oro;

    public int salud;
    public int poder;

    public Personaje(String nombre,List<HabilidadEspecial> special, ArrayList armasActivas, Equipo armaduraActiva) {

        //por parámetro
        this.nombre = nombre;
        this.special = special;
        this.armasActivas = armasActivas;
        this.armaduraActiva = armaduraActiva;

        this.minion = new ArrayList<>();
        this.reservaArmaduras = new ArrayList<>();
        this.reservaArmas = new ArrayList<>();
        this.modList = new ArrayList<>();
        this.oro = 0;
        this.salud = 5;
        
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

    public void cambiarArmaduraActiva(Equipo armadura){
        this.armaduraActiva = armadura;
    }

    public void cambiarArmaActiva(List<Equipo> arma){
        this.armasActivas = arma;
    }

    public void addMinion(Minion m){
        this.minion.add(m);
    }
    
    public void addReservaArmaduras(Equipo reserva){
        this.reservaArmaduras.add(reserva);
    }

    public void addReservaArmas(Equipo reserva){
        this.reservaArmas.add(reserva);
    }

    public void addArmasActivas(Equipo arma){
        this.armasActivas.add(arma);
    }

    public void addModList(Modificador mod){
        this.modList.add(mod);
    }

}