package PracticaMP.practica;

import java.util.InputMismatchException;
import java.util.Scanner;

class OperatorMenu {
    Administrador admin;

    public OperatorMenu(Administrador admin){
        this.admin =admin;
    }

    public void doOperation(){
        mostrarMenu();
    }

    public void mostrarMenu(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Añadir");
            System.out.println("2. Validar");
            System.out.println("3. Banear");
            System.out.println("4. Desbanear");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Añadir");
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

    public void aniadir(){

    }

    public void validar(){

    }

    public void banear(){

    }

    public void desbanear(){

    }
}
