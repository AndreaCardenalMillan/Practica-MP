package PracticaMP.practica;

import java.util.List;

public class Cazador extends Personaje{
    private int voluntad;

    public Cazador(String nombre,List<HabilidadEspecial> special, List<Equipo> armasActivas, Equipo armaduraActiva){

        super(nombre,special, armasActivas, armaduraActiva);

        this.voluntad = 3;
    }

    public void perderVoluntad(){
        if (voluntad > 0){
            voluntad = voluntad - 1;
        }
    }
    public int getVoluntad(){
        return voluntad;
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
