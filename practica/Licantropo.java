package PracticaMP.practica;

import java.util.List;
import java.util.Random;

public class Licantropo extends Personaje{
    private int rabia;

    public Licantropo(String nombre,List<HabilidadEspecial> special, List<Equipo> armasActivas, Equipo armaduraActiva){

        super(nombre,special, armasActivas, armaduraActiva);

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
    @Override
    public void golpeAcertado(){
        
    }
    @Override
    public void recibirGolpe(){
        super.salud-=1;
        incrementarRabia();
    }
    @Override
    public int defensaHabilidad(){
        int cuantDef=0;
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            int coste=((Don)(habilidades.get(i))).getRabia();
            if(coste<=rabia){
                cuantDef+=habilidades.get(i).getAtaque();
            }
        }
        return cuantDef;

    }
    @Override
    public int ataqueHabilidad(){
        int cuantAtaque=rabia;
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            int coste=((Don)(habilidades.get(i))).getRabia();
            if(coste<=rabia){
                cuantAtaque+=habilidades.get(i).getAtaque();
            }
        }
        return cuantAtaque;
    }
}
