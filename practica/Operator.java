package PracticaMP.practica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator extends Operation {

    public Operator(){

    }
    public void doOperation(){
        mostrarMenu();
    }

    public void register(){
        Scanner sn = new Scanner(System.in);
       
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contraseña= sn.nextLine();
 
        Administrador admin = new Administrador(nombre,nick,contraseña);

        Game.guardado.guardarAdmin(admin);
    }

    public void enter(){
        Scanner sn = new Scanner(System.in);
       
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contrasena= sn.nextLine();
 
        Administrador admin = null;

        List<String> administradores = Game.guardado.listaUsuarios();

        for(int i=0;administradores.size();i++){
            Administrador a= Game.guardado.cargarAdmin(administradores.get(i));
            if(a.getNick()== nick && a.getNombre()== nombre && a.getPassword()== contrasena){
                admin = a;
                break;
            }
        }
        if(admin==null){
            System.out.print("El admin no existe, registrese");
            register();
        }
        else{
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

    }    
}
