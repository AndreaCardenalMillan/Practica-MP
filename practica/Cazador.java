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
    @Override
    public void golpeAcertado(){
        
    }
    @Override
    public void recibirGolpe(){
        super.salud-=1;
        perderVoluntad();
    }
    @Override
    private int defensaHabilidad(){
        int cuantDef=0;
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            cuantDef+=habilidades.get(i).getDefensa();
        }
        return cuantDef;

    }
    @Override
    private int ataqueHabilidad(){
        int cuantAtaque=voluntad;
        List<HabilidadEspecial> habilidades=super.getHabilidades();
        for(int i=0;i<habilidades.size();i++){
            cuantAtaque+=habilidades.get(i).getAtaque();
        }
        return cuantAtaque;
    }


}
