package PracticaMP.practica;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import PracticaMP.practica.Jugador;
import PracticaMP.practica.Personaje;
import PracticaMP.practica.Equipo.tipoEquipo;
import java.io.IOException;
public class SystemMenu{
    Jugador user;
    Personaje personajeSeleccionado = null;

    public SystemMenu(Jugador user) throws IOException{
        this.user = user;
        personajeSeleccionado = Game.guardado.cargarPersonaje(user.getNR());
    }

    public void doOperation(Scanner sn) throws IOException, InterruptedException{
        mostrarMenu(sn);
    }
    
    public void mostrarMenu(Scanner sn) throws IOException, InterruptedException{
        
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Elegir");
            System.out.println("2. Desafiar");
            System.out.println("3. Consultar Oro");
            System.out.println("4. Aceptar/Rechazar");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Elegir");
                        elegir(sn);
                        break;
                    case 2:
                        System.out.println("Has seleccionado Desafiar");
                        desafiar(sn);
                        break;
                    case 3:
                        System.out.println("Has seleccionado Consultar Oro");
                        consultarOro();
                        break;
                    case 4:
                        System.out.println("Has seleccionado Aceptar / rechazar");
                        aceptarRechazar(sn);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    
    


    public void elegir(Scanner sn){
        //Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
 
            System.out.println("1. cambiar arma");
            System.out.println("2. cambiar armadura");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado cambiar arma");

                        System.out.println("Armas:");
                        List<Equipo> listaArmas = personajeSeleccionado.getArmasActivas();
                        for(int i=0;i<listaArmas.size();i++){
                            if(listaArmas.get(i).getClaseEquipo()==tipoEquipo.unaMano || listaArmas.get(i).getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+listaArmas.get(i).getNombre());
                            }
                        }
                        int op1arma= sn.nextInt();

                        System.out.println("Por cual arma de tu inventario quieres cambiarla");

                        List<Equipo> inventarioArmas = personajeSeleccionado.getReservaArmas();
                        for(int i=0;i<inventarioArmas.size();i++){
                            if(inventarioArmas.get(i).getClaseEquipo()==tipoEquipo.unaMano || inventarioArmas.get(i).getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+inventarioArmas.get(i).getNombre());
                            }
                        }
                        int op2arma= sn.nextInt();

                        personajeSeleccionado.cambiarArmaActiva(inventarioArmas.get(op2arma));
                        break;
                    case 2:
                        System.out.println("Has seleccionado cambiar armadura");

                        System.out.println("Armadura:");
                        Equipo armadura = personajeSeleccionado.getArmadura();
                        
                        System.out.println(armadura);

                        System.out.println("Por cual armadura de tu inventario quieres cambiarla");

                        List<Equipo> inventarioArmadura = personajeSeleccionado.getReservaArmaduras();
                        for(int i=0;i<inventarioArmadura.size();i++){
                            if(inventarioArmadura.get(i).getClaseEquipo()==tipoEquipo.armadura){
                                System.out.println(i+".-"+inventarioArmadura.get(i).getNombre());
                            }
                        }
                        int op2armadura= sn.nextInt();

                        personajeSeleccionado.cambiarArmaduraActiva(inventarioArmadura.get(op2armadura));
                        
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    public void consultarOro(){
        System.out.println("El oro obtenido en el combate es: "+personajeSeleccionado.getOro());
    }

    public void desafiar(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        int opcion;

        List<String> usuarios = Game.guardado.listaUsuarios();

        for(int i=0;i<usuarios.size();i++){
            String id=usuarios.get(i);
            if(Pattern.matches("[A-Z]{1}[0-9]{2}[A-Z]{2}", id) && !Objects.equals(user.getNR(), id)){//es un jugador no un admin
                System.out.println(i+".-"+Game.guardado.cargarJugador(usuarios.get(i)).getNick());
            }
            
        }
        Personaje per=Game.guardado.cargarPersonaje(user.getNR());
        if(per.getOro()!=0){

            System.out.println("Elige al usuario que quieras desafiar");
            int opcionD=sn.nextInt();

            boolean valido=false;

            while(!valido){
                System.out.println("Dispones de esta cantidad de oro: "+ per.getOro()+" cuanto quieres apostar");
                int cantidad=sn.nextInt();

                if (per.getOro()-cantidad >=0){
                    Jugador jugadorDesafiado=Game.guardado.cargarJugador(usuarios.get(opcionD));
                    String notificacion="D:"+jugadorDesafiado.getNR()+":"+jugadorDesafiado.getNick()+":"+user.getNR()+":"+user.getNick()+":"+cantidad;
                    List<String> usuariosSuscritos=Game.guardado.usuariosSuscritosNotificacion();
                    for(int i =0;i<usuariosSuscritos.size();i++){
                        Game.guardado.addNotificacion(usuariosSuscritos.get(i),notificacion);
                        
                    }
                    valido=true;

                }else{
                    System.out.println("No dispones de esa cantidad de oro");
                }
            }
        }else{
            System.out.println("No dispones del suficiente oro para desafiar a un jugador");
        }
        //sn.close();
    }

    public void aceptarRechazar(Scanner sn) throws IOException, InterruptedException{
        //Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        List<String> notificaciones = user.getNotificaciones();
        
        for(int i=0;i<notificaciones.size();i++){
            System.out.println(i+"= "+notificaciones.get(i));
        }
        System.out.println("Seleccione una notificacion");
        
        int seleccion= sn.nextInt();

        while (!salir) {
 
            System.out.println("1. Aceptar");
            System.out.println("2. Rechazar");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                int op = sn.nextInt();


                String[] parte=notificaciones.get(seleccion).split(":");
                Personaje per=Game.guardado.cargarPersonaje(user.getNR());
                switch (op) {
                    case 1:
                        // sacar el oro de la notificacion
                        if(per.getOro()>=Integer.parseInt(parte[5])){
                            System.out.println("Has aceptado el desafio");

                            Game.guardado.addNotificacion(user.getNR(),"H:"+parte[3]+":"+parte[2]);
                            
                            Combate combate = new Combate();

                            Personaje prota = Game.guardado.cargarPersonaje(parte[2]);

                            Personaje rival = Game.guardado.cargarPersonaje(parte[4]);

                            combate.iniciarCombate(prota,rival,Integer.parseInt(parte[5]));
                        }
                        
                        break;
                    case 2:
                        user.removeNotificacion(user.getNotificaciones().get(seleccion));
                        System.out.println("Has rechazado el desafio");

                        Game.guardado.addNotificacion(user.getNR(),"R:"+parte[3]+":"+parte[2]);

                        Personaje personaje = Game.guardado.cargarPersonaje(user.getNR());

                        personaje.setOro(Math.round(personaje.getOro()*.9f));
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

        
    }
}
