package PracticaMP.practica;
import java.util.InputMismatchException;
import java.util.Scanner;

import PracticaMP.practica.Jugador;
import PracticaMP.practica.Personaje;
import PracticaMP.practica.Equipo.tipoEquipo;
public class SystemMenu{
    Jugador user;

    public SystemMenu(Jugador user){
        this.user = user;
    }

    public void doOperation(){
        mostrarMenu();
    }
    
    public void mostrarMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Elegir");
            System.out.println("2. Desafiar");
            System.out.println("3. Consultar Oro");
            System.out.println("4. Consultar Ranking");
            System.out.println("5. Aceptar/Rechazar");
            System.out.println("6. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Elegir");
                        elegir();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Desafiar");
                        desafiar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado Consultar Oro");
                        consultarOro();
                        break;
                    case 4:
                        System.out.println("Has seleccionado Consultar Ranking");
                        consultarRanking();
                        break;
                    case 5:
                        System.out.println("Has seleccionado Aceptar / rechazar");
                        aceptarRechazar();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    
    Personaje personajeSeleccionado = Game.guardado.cargarPersonaje(user.getNR());


    public void elegir(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        System.out.println("Armadura");
        List<Equipo> listaArmaduras = personajeSeleccionado.getArmadura();
        for(int i=0;i<listaArmas.size();i++){
            if(listaArmaduras.get(i).getClaseEquipo()==tipoEquipo.armadura){
                System.out.println(i+".-"+listaArmaduras.get(i));
            }
        }
        
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
                            if(listaArmas.get(i).getClaseEquipo()==tipoEquipo.unaMano || listaArmas.getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+listaArmas.get(i));
                            }
                        }
                        int op1arma= sn.nextInt();

                        System.out.println("Por cual arma de tu inventario quieres cambiarla");

                        List<Equipo> inventarioArmas = personajeSeleccionado.getReservaArmas();
                        for(int i=0;i<inventarioArmas.size();i++){
                            if(inventarioArmas.get(i).getClaseEquipo()==tipoEquipo.unaMano || inventarioArmas.getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+inventarioArmas.get(i));
                            }
                        }
                        int op2arma= sn.nextInt();

                        personajeSeleccionado.cambiarArmaActiva(inventarioArmas.get(op2arma));
                        break;
                    case 2:
                        System.out.println("Has seleccionado cambiar armadura");

                        System.out.println("Armaduras:");
                        List<Equipo> listaArmaduras = personajeSeleccionado.getArmasActivas();
                        for(int i=0;i<listaArmaduras.size();i++){
                            if(listaArmaduras.get(i).getClaseEquipo()==tipoEquipo.armadura){
                                System.out.println(i+".-"+listaArmaduras.get(i));
                            }
                        }
                        int op1armadura= sn.nextInt();

                        System.out.println("Por cual arma de tu inventario quieres cambiarla");

                        List<Equipo> inventarioArmadura = personajeSeleccionado.getReservaArmas();
                        for(int i=0;i<inventarioArmadura.size();i++){
                            if(inventarioArmadura.get(i).getClaseEquipo()==tipoEquipo.armadura){
                                System.out.println(i+".-"+inventarioArmadura.get(i));
                            }
                        }
                        int op2armadura= sn.nextInt();

                        personajeSeleccionado.cambiarArmaduraActiva(inventarioArmadura.get(op1armadura));
                        
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
        System.out.println("El oro obtenido en el es: "+personajeSeleccionado.getOro());
    }

    public void desafiar(){

    }

    public void aceptarRechazar(){
        
    }
}
