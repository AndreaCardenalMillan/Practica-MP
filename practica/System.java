package mp;

import java.util.ArrayList;
import java.util.Scanner;

public class System extends Operation {
    
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public System(){

    }

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
    }

    public void crearPersonaje(){
        String candidato = listaUsuarios.filter(function(nickname){
            Scanner sn = new Scanner(System.in);
       
            System.out.println("Inserte su Nick");
            String id = sn.nextLine();

            return nickname.nick == id;
        });

        //parametros del personaje
        //
        //
        //
        Personaje personaje = new Personaje();

        candidato.listaPersonajes.add(personaje);
    }

    public void enter(){
        
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
            System.out.println("6. Register");
            System.out.println("7. Enter");
            System.out.println("8. Salir");
 
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
                        System.out.println("Has seleccionado Register");
                        register();
                        break;
                    case 7:
                        System.out.println("Has seleccionado Enter");
                        enter();
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

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


