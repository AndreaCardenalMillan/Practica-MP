package PracticaMP.practica;
import java.util.InputMismatchException;
import java.util.Scanner;

import PracticaMP.practica.Jugador;
import PracticaMP.practica.Personaje;
public class SystemMenu{
    Jugador user;

    public SystemMenu(Jugador user){
        this.user =user;
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

    public void crearPersonaje(){
        

        //parametros del personaje
        //
        //
        //
        //Personaje personaje = new Personaje();

        //user.listaPersonajes.add(personaje);
    }

    public void elegir(){

    }

    public void desafiar(){

    }

    public void aceptarRechazar(){
        
    }

    public void consultarOro(){

    }

    public void consultarRanking(){

    }

}
