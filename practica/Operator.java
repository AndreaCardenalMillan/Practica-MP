package mp;

import java.util.ArrayList;
import java.util.Scanner;

public class Operator extends Operation {

    private ArrayList<Administrador> listaAdmins = new ArrayList<>();

    public Operator(){

    }

    public void doOperation(){
        mostrarMenu();
    }

    public void register(){
        Scanner sn = new Scanner(System.in);
       
        System.out.println("1. Elegir");
        String nombre = sn.nextLine();
        System.out.println("2. Desafiar");
        String nick = sn.nextLine();
        System.out.println("3. Consultar Oro");
        String contraseña= sn.nextLine();
 
        Administrador admin = new Administrador(nombre,nick,contraseña);

        listaAdmins.add(admin);
    }

    

    public void enter(){

    }

    public void mostrarMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Aniadir");
            System.out.println("2. Validar");
            System.out.println("3. Banear");
            System.out.println("4. Desbanear");
            System.out.println("5. Register");
            System.out.println("6. Enter");
            System.out.println("7. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Aniadir");
                        aniadir();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Validar");
                        validar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado Banear");
                        banear();
                        break;
                    case 4:
                        System.out.println("Has seleccionado Desbanear");
                        desbanear();
                        break;
                    case 5:
                        System.out.println("Has seleccionado Register");
                        register();
                        break;
                    case 6:
                        System.out.println("Has seleccionado Enter");
                        enter();
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 7");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
    
    public void aniadir(){

    }

    public void validar(){

    }

    public void banear(){

    }

    public void desbanear(){

    }
}
