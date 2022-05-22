package PracticaMP.practica;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import PracticaMP.practica.Equipo.tipoEquipo;

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
                        System.out.println("Has seleccionado gestionarBanear");
                        gestionarBaneo();
                        break;
                    case 4:
                        System.out.println("Has seleccionado Validar");
                        validar();
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
        sn.close();

    }

    public void aniadir(){
        Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras añadir parametros a su personaje");
        option= sn.nextLine();

        Personaje personajeSeleccionado = Game.guardado.cargarPersonaje(usuarios.get(option));

        boolean salir= false;

        while (!salir) {
            
            System.out.println("Elige parametros a modificar");

            System.out.println("1. Fortalezas");
            System.out.println("2. Armas");
            System.out.println("3. Armadura");
            System.out.println("4. Esbirros");
          
            List<Equipo> listaEquipo= Game.guardardo.listaEquipo();
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Seleccione nueva Fortaleza");

                        List<String> modificadores = Game.guardado.listaModificadores();
                            
                        for(int i=0;i<modificadores.size();i++){
                            Modificador modificador = Game.guardado.cargar(modificadores.get(i));
                          
                            System.out.println(i+".-"+modificador.getNombre());
                          
                        }
                        int idModificador = sn.nextInt();

                        Modificador nuevoModificador = Game.guardado.cargarModificador(listaEquipo.get(idModificador));

                        personajeSeleccionado.addModList(nuevoModificador);
                        break;
                    case 2:
                        System.out.println("Seleccione nueva Armadura");

                        
                        for(int i=0;i<listaEquipo.size();i++){
                            Equipo equipo = Game.guardado.cargarEquipo(listaEquipo.get(i));
                            if(equipo.getClaseEquipo()==tipoEquipo.armadura){
                                System.out.println(i+".-"+equipo.getNombre());
                            }   
                        }
                        int idArmadura = sn.nextInt();

                        Equipo nuevaArmadura = Game.guardado.cargarEquipo(listaEquipo.get(idArmadura));
 
                        personajeSeleccionado.addReservaArmaduras(nuevaArmadura);
                        break;
                    case 3:
                        System.out.println("Seleccione nueva Arma");
                        for(int i=0;i<listaEquipo.size();i++){
                            Equipo equipo = Game.guardado.cargarEquipo(listaEquipo.get(i));
                            if(equipo.getClaseEquipo()==tipoEquipo.unaMano || equipo.getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+equipo.getNombre());
                            }   
                        }
                        int idArma = sn.nextInt();

                        Equipo nuevoArma = Game.guardado.cargarEquipo(listaEquipo.get(idArma));
 
                        personajeSeleccionado.addReservaArmas(nuevoArma);
                        break;
                    case 4:
                        System.out.println("Añada nuevo Esbirro");

                        List<String> esbirros = Game.guardado.lista// falta el metodo en guardado
                        
                        for(int i=0;i<esbirros.size();i++){
                            Minion minion = Game.guardado.cargarMinion(esbirros.get(i));
                           
                            System.out.println(i+".-"+minion.getNombre());
                             
                        }
                        int idMinion= sn.nextInt();

                        Minion nuevoMinion = Game.guardado.cargarMinion(esbirros.get(idMinion));
 
                        personajeSeleccionado.addMinion(nuevoMinion);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
 

    public void editar(){
        Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras modificar su personaje");
        option= sn.nextLine();

        Personaje personajeSeleccionado = Game.guardado.cargarPersonaje(usuarios.get(option));

        boolean salir= false;

        while (!salir) {
            
            System.out.println("Elige parametros a modificar");

            System.out.println("1. Nombre");
            System.out.println("2. Armas");
            System.out.println("3. Armadura");
            System.out.println("4. Habilidad Especial");
          
            List<Equipo> listaEquipo= Game.guardardo.listaEquipo();
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Inserte nuevo Nombre");
                        String nombre = sn.nextLine();

                        personajeSeleccionado.cambiarNombre(nombre);
                        break;
                    case 2:
                        System.out.println("Seleccione nueva Armadura");

                        
                        for(int i=0;i<listaEquipo.size();i++){
                            Equipo equipo = Game.guardado.cargarEquipo(listaEquipo.get(i));
                            if(equipo.getClaseEquipo()==tipoEquipo.armadura){
                                System.out.println(i+".-"+equipo.getNombre());
                            }   
                        }
                        int idArmadura = sn.nextInt();

                        Equipo nuevaArmadura = Game.guardado.cargarEquipo(listaEquipo.get(idArmadura));
 
                        personajeSeleccionado.cambiarArmaduraActiva(nuevaArmadura);
                        break;
                    case 3:
                        System.out.println("Seleccione nueva Armadura");
                        for(int i=0;i<listaEquipo.size();i++){
                            Equipo equipo = Game.guardado.cargarEquipo(listaEquipo.get(i));
                            if(equipo.getClaseEquipo()==tipoEquipo.unaMano || equipo.getClaseEquipo()==tipoEquipo.dosManos){
                                System.out.println(i+".-"+equipo.getNombre());
                            }   
                        }
                        int idArma = sn.nextInt();

                        Equipo nuevoArma = Game.guardado.cargarEquipo(listaEquipo.get(idArma));
 
                        personajeSeleccionado.cambiarArmaduraActiva(nuevoArma);
                        break;
                    case 4:
                        System.out.println("Seleccione nueva Habilidad Especial");
                        
                        if(personajeSeleccionado instanceof Vampiro)
                        {
                            List<String> disciplinas=Game.guardado.listaDisciplinas();
                            for(int i=0;i<disciplinas.size();i++){
                                System.out.print(i+".-"+disciplinas.get(i));
                            }
                            int idDisciplina=sn.nextInt();
                            personajeSeleccionado.Habilidad(Game.guardado.cargarDisciplina(disciplinas.get(idDisciplina))); 
                        }
                        else if(personajeSeleccionado instanceof Cazador)
                        {   
                            List<String> talentos = Game.guardado.listaTalentos();
                            for(int i=0;i<talentos.size();i++){
                                System.out.println(i+".-"+talentos.get(i));
                            }
                            int idTalento=sn.nextInt();
                            personajeSeleccionado.Habilidad(Game.guardado.cargarTalento(disciplinas.get(idTalento))); 
                        }
                        else if(personajeSeleccionado instanceof Licantropo)
                        {
                            List<String> dones = Game.guardado.listaDones();
                            for(int i=0;i<dones.size();i++){
                                System.out.println(i+".-"+dones.get(i));
                            }
                            int idDon=sn.nextInt();
                            personajeSeleccionado.Habilidad(Game.guardado.cargarDon(disciplinas.get(idDon))); 
                        }

                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }


    public void gestionarBaneo(){
        Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras modificar");
        option= sn.nextLine();

        Jugador jugador= Game.guardado.cargarJugador(usuarios.get(i));

        boolean salir = false;
        
        while (!salir) {
 
            System.out.println("Que quiere hacer?");
            System.out.println("1.Banear");
            System.out.println("2.Desbanear");
            System.out.println("3.Salir");

            try {
 
                System.out.println("Escribe una de las opciones");
                int op=sn.nextInt();
 
                switch (op) {
                    case 1:
                        System.out.println("Has seleccionado Banear");
                        jugador.banear();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Desbanear");
                        jugador.desbanear();
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

    public void validar(){

    }
}
