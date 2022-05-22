package PracticaMP.practica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import PracticaMP.practica.Equipo.tipoEquipo;

public class Sistema extends Operation {


    public void doOperation(){
        mostrarMenu();
    }

    public void register(){
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Nombre");
        String nombre = sn.nextLine();
        System.out.println("Nick");
        String nick = sn.nextLine();
        System.out.println("Contraseña");
        String contraseña= sn.nextLine();

        Jugador jugador = new Jugador(nombre,nick,contraseña);
        jugador.crearNR();

        Game.guardado.guardarJugador(jugador);
        

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("Que tipo de personaje quieres tener?");
            System.out.println("1. Cazador");
            System.out.println("2. Vampiro");
            System.out.println("3. Licantropo");

            System.out.println("Nombra a tu personaje");
            String nombrePersonaje = sn.nextLine();
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                List<HabilidadEspecial> habilidad=new ArrayList<>();
                Equipo armadura=null;
                List<Equipo> arma=new ArrayList<>();
                List<String> equipos=new ArrayList<>();
                for(int i=0;i<equipos.size();i++){
                    Equipo eq=Game.guardado.cargarEquipo(equipos.get(i));
                    if(arma.size()==0){
                        if(eq.getClaseEquipo()==tipoEquipo.unaMano){
                            arma.add(eq);
                        }
                        else if(eq.getClaseEquipo()==tipoEquipo.dosManos){
                            arma.add(eq);
                        }
                    }else if(armadura==null){
                        if(eq.getClaseEquipo()==tipoEquipo.armadura){
                            armadura=eq;
                        }
                    }else{
                        break;
                    }
                }
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Cazador");
                        
                        habilidad.add(Game.guardado.cargarTalento(Game.guardado.listaTalentos().get(0)));
                        Cazador cazador = new Cazador(nombrePersonaje,habilidad,arma,armadura);
                        cazador.setNR(jugador.getNR());

                        Game.guardado.guardarPersonaje(jugador,cazador);
                        salir = true;
                        break;
                    case 2:
                        System.out.println("Has seleccionado Vampiro");
                        
                        habilidad.add(Game.guardado.cargarDisciplina(Game.guardado.listaDisciplinas().get(0)));
                        Vampiro vampiro = new Vampiro(nombrePersonaje,habilidad,arma,armadura);
                        vampiro.setNR(jugador.getNR());

                        Game.guardado.guardarPersonaje(jugador,vampiro);
                        salir = true;
                        break;
                    case 3:
                        System.out.println("Has seleccionado Licantropo");
                        habilidad.add(Game.guardado.cargarDon(Game.guardado.listaDones().get(0)));

                        Licantropo licantropo = new Licantropo(nombrePersonaje,habilidad,arma,armadura);
                        licantropo.setNR(jugador.getNR());

                        Game.guardado.guardarPersonaje(jugador,licantropo);
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

        sn.close();
    }

    public void enter(){
        Scanner sn = new Scanner(System.in);
       
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contrasena= sn.nextLine();
 
        Jugador user = null;

        List<String> usuarios= Game.guardado.listaUsuarios();


        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            if(j.getNick()==nick && j.getNombre()==nombre && j.getPassword()==contrasena){
                user=j;
                break;
            }
        }
        if(user==null)
        {
            System.out.print("El usuario no existe, registrese");
            register();
        }
        else
        {
            SystemMenu menu = new SystemMenu(user);
            menu.doOperation();
        }
        

        sn.close();
    }

    public void mostrarMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Registrarse");
            System.out.println("2. Entrar");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Registrarse");
                        register();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Entrar");
                        enter();
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
        sn.close();

    }    
 
}


