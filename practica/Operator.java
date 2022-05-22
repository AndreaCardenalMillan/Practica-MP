package PracticaMP.practica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Objects;

public class Operator extends Operation {

    public Operator(Scanner sn){

    }
    public void doOperation(Scanner sn){
        mostrarMenu(sn);
    }

    public void register(Scanner sn){
        System.out.println("Registro");
        sn.nextLine();
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contraseña= sn.nextLine();
 
        Administrador admin = new Administrador(nombre,nick,contraseña);

        System.out.println("Quieres recibir notificaciones si:1; no:cualquier otra tecla");
        int op = sn.nextInt();

        if (op==1){
            try {
                Game.guardado.addUsuarioNotificado(nick);
            } catch (IOException ex) {
                Logger.getLogger(Operator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            Game.guardado.guardarAdmin(admin);
        } catch (IOException ex) {
            Logger.getLogger(Operator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enter(Scanner sn){
        System.out.println("Login");
        sn.nextLine();
        System.out.println("1. Nombre");
        String nombre = sn.nextLine();
        System.out.println("2. Nick");
        String nick = sn.nextLine();
        System.out.println("3. Password");
        String contrasena= sn.nextLine();
 
        Administrador admin = null;

        List<String> administradores = Game.guardado.listaUsuarios();

        for(int i=0;i<administradores.size();i++){

            try {
                Administrador a = Game.guardado.cargarAdmin(administradores.get(i));
                if(Objects.equals(a.getNick(), nick) && Objects.equals(a.getNombre(), nombre) && Objects.equals(a.getPassword(), contrasena)){
                    admin = a;
                break;
            }
            } catch (IOException ex) {
                Logger.getLogger(Operator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(admin==null){
            System.out.print("El admin no existe, registrese");
            register(sn);
        }
        else{
            OperatorMenu menu=new OperatorMenu(admin);
            try {
                menu.doOperation(sn);
            } catch (IOException ex) {
                Logger.getLogger(Operator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //sn.close();
    }

    public void mostrarMenu(Scanner sn){
        //Scanner sn = new Scanner(System.in);
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
                        register(sn);
                        break;
                    case 2:
                        System.out.println("Has seleccionado Entrar");
                        enter(sn);
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
        //sn.close();

    }    
}
