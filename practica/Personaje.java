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

    public Personaje(String nombre,List<HabilidadEspecial> special, List<Equipo> armasActivas, Equipo armaduraActiva) {
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
        
        Random rn = new Random();
        this.poder = rn.nextInt(6-1)+1;
    }

    public void golpeAcertado(){//en las clases hijas se define su comportamiento
        
    }

    public void recibirGolpe(){//en las clases hijas se define su comportamiento
        
    }

    public void CalcularVidaPersonaje(){//esto para que se usa?
        System.out.println(salud);
    }
    private int defensaHabilidad(){//en las clases hijas se define su comportamiento
        return 0;
    }
    private int ataqueHabilidad(){//en las clases hijas se define su comportamiento
        return 0;
    }
    public int calcularDefensa(){
        int def=armaduraActiva.getModDefensa();
        def+=defensaHabilidad();
        for(int i=0;i<armasActivas.size();i++){
            def+=armasActivas.get(i).getModDefensa();
        }
        for(int i=0;i<modList.size();i++){
            def+=modList.get(i).getModDefensa();
        }

        return def;
    }
    public int calcularAtaque(){
        int at=0;
        at+=ataqueHabilidad();
        at+=armaduraActiva.getModAtaque();
        for(int i=0;i<armasActivas.size();i++){
            at+=armasActivas.get(i).getModAtaque();
        }
        for(int i=0;i<modList.size();i++){
            at+=modList.get(i).getModAtaque();
        }
        return at;
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
    
    public String getNombre(){
        return nombre;
    }
    public List<HabilidadEspecial> getHabilidades(){
        return special;
    }
    public List<Equipo> getReservaArmas(){
        return reservaArmas;
    }
    public List<Equipo> getReservaArmaduras(){
        return reservaArmaduras;
    }
    public List<Equipo> getArmasActivas(){
        return armasActivas;
    }
    public Equipo getArmadura(){
        return armaduraActiva;
    }
    public List<Minion> getMinions(){
        return minion;
    }
    public int getOro(){
        return oro;
    }
    public List<Modificador> getMods(){
        return modList;
    }

}