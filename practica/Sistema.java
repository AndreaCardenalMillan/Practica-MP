package PracticaMP.practica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Sistema extends Operation {
    
    private List<Usuario> listaUsuarios = new ArrayList<>();


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
 
        Usuario usuario = new Usuario(nombre,nick,contraseña);

        listaUsuarios.add(usuario);
        sn.close();
    }

    public void enter(){
        Scanner sn = new Scanner(System.in);
       
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contraseña= sn.nextLine();
 
        Jugador user = new Jugador(nombre,nick,contraseña);

        if (Arrays.asList(listaUsuarios).contains(user)) {
            SystemMenu menu = new SystemMenu(user);

            menu.doOperation();
        }
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

    }    

    
}


