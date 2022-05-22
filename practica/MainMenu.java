package PracticaMP.practica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu{

    public void start(){

        Sistema sistema = new Sistema();
        Scanner sn = new Scanner(System.in);
        Operator operador = new Operator(sn);

        
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Modo Sistema");
            System.out.println("2. Modo Admin");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Modo Sistema");
                        sistema.doOperation(sn);
                        salir = true;
                        break;
                    case 2:
                        System.out.println("Modo Admin");
                        operador.doOperation(sn);
                        salir = true;
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