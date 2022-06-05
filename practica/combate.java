package PracticaMP.practica;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Combate {
    
    public class resultadoCombate{
        List<String> log=new ArrayList<>();
        String fechaCombate;
        String personaje1;
        String personaje2;
        int oroDado;
        String ganandor;
    }

    public void iniciarCombate(Personaje per1, Personaje per2,int oro) throws InterruptedException, IOException{
        //añadir log inicial
        resultadoCombate resultado=new resultadoCombate();

        //====================INICIALIZACION DEL RESULTADO DEL COMBATE==================
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd_hh-mm-ss");  
        resultado.fechaCombate = dateFormat.format(date); 
        resultado.personaje1=per1.getNombre();
        resultado.personaje2=per2.getNombre();
        resultado.oroDado=oro;

        per1.CalcularVidaPersonaje();
        per2.CalcularVidaPersonaje();

        List<String> log=new ArrayList<>();
        String comentario;

        comentario="El combate entre "+per1.getNombre()+" contra "+per2.getNombre()+" da comienzo con "+oro+" de oro en juego";
        log.add(comentario);
        System.out.println(comentario);
        int turno=1;
        while(per1.salud>0 && per2.salud>0){
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
                comentario="El "+per1.getNombre()+" ha obtenido "+acAtaque1+ " puntos de ataque y el "+per2.getNombre()+" ha obtenido "+acDef2+" puntos de defensa";
                
                log.add(comentario);
                System.out.println(comentario);
                if(acAtaque1>acDef2){
                    comentario="El "+per1.getNombre()+" ha acertado el golpe";
                    per1.golpeAcertado();
                    per2.recibirGolpe();
                    log.add(comentario);
                    System.out.println(comentario);
                }else{
                    comentario="El "+per1.getNombre()+" ha fallado el golpe, el "+per2.getNombre()+" se ha defendido con exito";
                    log.add(comentario);
                    System.out.println(comentario); 
                }
            }else{
                comentario="El "+per2.getNombre()+" ha obtenido "+acAtaque2+ " puntos de ataque y el "+per1.getNombre()+" ha obtenido "+acDef1+" puntos de defensa";
                
                log.add(comentario);
                System.out.println(comentario);
                if(acAtaque2>acDef1){
                    comentario="El "+per2.getNombre()+" ha acertado el golpe";
                    per2.golpeAcertado();
                    per1.recibirGolpe();
                    log.add(comentario);
                    System.out.println(comentario);
                }else{
                    comentario="El "+per2.getNombre()+" ha fallado el golpe, el "+per1.getNombre()+" se ha defendido con exito";
                    log.add(comentario);
                    System.out.println(comentario);
                }
            }

            TimeUnit.SECONDS.sleep(2);
            turno=cambiarTurno(turno);
        }
        //añadir log final
        if(per1.salud<=0)
        {
            comentario=per1.getNombre()+" ha sucumbido al poder de "+per2.getNombre();
            log.add(comentario);
            System.out.println(comentario);
            comentario=per2.getNombre()+" gana el combate recibiendo "+oro+" de oro";
            log.add(comentario);
            System.out.println(comentario);
            per2.addOro(oro);
            resultado.ganandor=per2.getNombre();

            Jugador jugador1=Game.guardado.cargarJugador(per1.getNR());
            jugador1.clearNofiticaciones();

            Jugador jugador2=Game.guardado.cargarJugador(per2.getNR());
            jugador2.clearNofiticaciones();

            jugador1.addNotificacion("RE:Has perdido el combate contra: "+jugador2.getNick());
            jugador2.addNotificacion("RE:Has ganado el combate contra: "+jugador1.getNick());
            Game.guardado.guardarJugador(jugador1);
            Game.guardado.guardarJugador(jugador2);
        }
        else if(per2.salud<=0)
        {
            comentario=per2.getNombre()+" ha sucumbido al poder de "+per1.getNombre();
            log.add(comentario);
            System.out.println(comentario);
            comentario=per1.getNombre()+" gana el combate recibiendo "+oro+" de oro";
            log.add(comentario);
            System.out.println(comentario);
            per1.addOro(oro);
            resultado.ganandor=per1.getNombre();

            Jugador jugador1=Game.guardado.cargarJugador(per1.getNR());
            jugador1.clearNofiticaciones();

            Jugador jugador2=Game.guardado.cargarJugador(per2.getNR());
            jugador2.clearNofiticaciones();

            jugador2.addNotificacion("RE:Has perdido el combate contra: "+jugador1.getNick());
            jugador1.addNotificacion("RE:Has ganado el combate contra: "+jugador2.getNick());
            Game.guardado.guardarJugador(jugador1);
            Game.guardado.guardarJugador(jugador2);
        }
        //System.out.println(per1);
        
        Game.guardado.guardarPersonaje(per1.getNR(),per1);
        Game.guardado.guardarPersonaje(per2.getNR(),per2);

        resultado.log=log;
        Game.guardado.guardarCombate(resultado);

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
        Random rand = new Random();
        int randomNum = rand.nextInt((maxInclusive - minInclusive) + 1) + minInclusive;
        return randomNum;
    }
}
