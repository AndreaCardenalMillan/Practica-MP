package PracticaMP.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Combate {
    
    public void iniciarCombate(Personaje per1, Personaje per2){
        //añadir log inicial
        List<String> log=new ArrayList<>();
        String comentario;
        int turno=1;
        while(per1.salud>=0 && per2.salud>=0){
            int ataque1=per1.calcularAtaque();
            int acAtaque1=0;

            int ataque2=per2.calcularAtaque();
            int acAtaque2=0;


            int def1=per1.calcularDefensa();
            int acDef1=0;

            int def2=per2.calcularDefensa();
            int acDef2=0;

            for(int i =0;i<ataque1;i++){
                int dado=randomInt(1, 6);
                if(dado>=5){
                    acAtaque1++;
                }
            }
            for(int i =0;i<ataque2;i++){
                int dado=randomInt(1, 6);
                if(dado>=5){
                    acAtaque2++;
                }
            }
            for(int i =0;i<def1;i++){
                int dado=randomInt(1, 6);
                if(dado>=5){
                    acDef1++;
                }
            }
            for(int i =0;i<def2;i++){
                int dado=randomInt(1, 6);
                if(dado>=5){
                    acDef2++;
                }
            }
            if(turno==1){
                comentario="El personaje 1 ha obtenido "+acAtaque1+ " puntos de ataque y el personaje 2 ha obtenido "+acDef2+" puntos de defensa";
                log.add(comentario);
                System.out.println(comentario);
                if(acAtaque1>acDef2){
                    comentario="El personaje 1 ha acertado el golpe";
                    log.add(comentario);
                }else{
                    comentario="El personaje 1 ha fallado el golpe, el personaje 2 se ha defendido con exito";
                    log.add(comentario); 
                }
            }else{
                comentario="El personaje 2 ha obtenido "+acAtaque2+ " puntos de ataque y el personaje 1 ha obtenido "+acDef1+" puntos de defensa";
                log.add(comentario);
                System.out.println(comentario);
                if(acAtaque2>acDef1){
                    comentario="El personaje 2 ha acertado el golpe";
                    log.add(comentario);
                }else{
                    comentario="El personaje 2 ha fallado el golpe, el personaje 1 se ha defendido con exito";
                    log.add(comentario);
                }
            }

            TimeUnit.SECONDS.sleep(5);
            turno=cambiarTurno(turno);
        }
        //añadir log final

    }
    private int cambiarTurno(int turno){
        if(turno==1)
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }
    private int randomInt(int minInclusive, int maxInclusive){
        Random rand;
        int randomNum = rand.nextInt((maxInclusive - minInclusive) + 1) + minInclusive;
        return randomNum;
    }
}
