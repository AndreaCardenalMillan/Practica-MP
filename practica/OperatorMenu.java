package PracticaMP.practica;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import PracticaMP.practica.Equipo.tipoEquipo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

class OperatorMenu {
    Administrador admin;

    public OperatorMenu(Administrador admin){
        this.admin =admin;
    }

    public void doOperation(Scanner sn) throws IOException{
        mostrarMenu(sn);
    }

    public void mostrarMenu(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Añadir");
            System.out.println("2. Validar");
            System.out.println("3. Gestionar baneo");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Añadir");
                        aniadir(sn);
                        break;
                    case 2:
                        System.out.println("Has seleccionado Validar");
                        validar(sn);
                        break;
                    case 3:
                        System.out.println("Has seleccionado gestionarBanear");
                        gestionarBaneo(sn);
                        break;
                    case 4:
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
        //sn.close();

    }

    public void aniadir(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras añadir parametros a su personaje");
        option = sn.nextInt();

        Personaje personajeSeleccionado = Game.guardado.cargarPersonaje(usuarios.get(option));

        boolean salir= false;

        while (!salir) {
            
            System.out.println("Elige parametros a modificar");

            System.out.println("1. Fortalezas");
            System.out.println("2. Armas");
            System.out.println("3. Armadura");
            System.out.println("4. Esbirros");
          
            List<String> listaEquipo= Game.guardado.listaEquipo();
            try {
 
                System.out.println("Escribe una de las opciones");
                int opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Seleccione nueva Fortaleza");

                        List<String> modificadores = Game.guardado.listaModificadores();
                            
                        for(int i=0;i<modificadores.size();i++){
                            Modificador modificador = Game.guardado.cargaModificador(modificadores.get(i));
                          
                            System.out.println(i+".-"+modificador.getNombre());
                          
                        }
                        int idModificador = sn.nextInt();

                        Modificador nuevoModificador = Game.guardado.cargaModificador(listaEquipo.get(idModificador));

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

                        System.out.println("1.Humano");
                        System.out.println("2.Ghoul");
                        System.out.println("3.Demonio");

                        int opMinion= sn.nextInt();

                        switch (opcion) {
                            case 1:
                                Humano humano= new Humano("Elon",Humano.lealtad.Alta);
                                personajeSeleccionado.addMinion(humano);
                            break;
                            case 2:
                                Ghoul ghoul= new Ghoul("Fastama",100);
                                personajeSeleccionado.addMinion(ghoul);
                            break;
                            case 3:
                                Demonio demonio= new Demonio("Mi madre con la clancla","Recoje la ropa",new ArrayList<Minion>());
                                personajeSeleccionado.addMinion(demonio);
                            break;
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
        //sn.close();
    }
 

    public void editar(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras modificar su personaje");
        option= sn.nextInt();

        Personaje personajeSeleccionado = Game.guardado.cargarPersonaje(usuarios.get(option));

        boolean salir= false;

        while (!salir) {
            
            System.out.println("Elige parametros a modificar");

            System.out.println("1. Nombre");
            System.out.println("2. Armas");
            System.out.println("3. Armadura");
            System.out.println("4. Habilidad Especial");
          
            List<String> listaEquipo= Game.guardado.listaEquipo();
            try {
 
                System.out.println("Escribe una de las opciones");
                int opcion = sn.nextInt();
 
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
                            personajeSeleccionado.Habilidad(Game.guardado.cargarTalento(talentos.get(idTalento))); 
                        }
                        else if(personajeSeleccionado instanceof Licantropo)
                        {
                            List<String> dones = Game.guardado.listaDones();
                            for(int i=0;i<dones.size();i++){
                                System.out.println(i+".-"+dones.get(i));
                            }
                            int idDon=sn.nextInt();
                            personajeSeleccionado.Habilidad(Game.guardado.cargarDon(dones.get(idDon))); 
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


    public void gestionarBaneo(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        int option;
        List<String> usuarios= Game.guardado.listaUsuarios();
        for(int i=0;i<usuarios.size();i++){
            Jugador j=Game.guardado.cargarJugador(usuarios.get(i));
            System.out.println(i+".- "+j.getNombre());
        }

        System.out.println("Elige el jugador al que quieras modificar");
        option= sn.nextInt();

        Jugador jugador= Game.guardado.cargarJugador(usuarios.get(option));

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
        //sn.close();
    }

    public void validar(Scanner sn) throws IOException{
        //Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        List<String> notificaciones = admin.getNotificaciones();

        for(int i=0;i<notificaciones.size();i++){
            String textoNotificacion="";
            
            String[] partesNot=notificaciones.get(i).split(":");
            if(Objects.equals(partesNot[0],"D")){//desafio
                textoNotificacion="El jugador: "+partesNot[4]+" con NR: "+partesNot[3]+" ha desafiado al jugador "+partesNot[2]+" con NR: "+partesNot[1]+" con una cantidad de oro de:"+partesNot[5];
            }
            System.out.println(i+"= "+textoNotificacion);
        }
        System.out.println("Selecciona que desafio quieres validar");
        int seleccion= sn.nextInt();

        while (!salir) {
 
            System.out.println("1. Rechazar");
            System.out.println("2. Permitir");

            String[] partes=notificaciones.get(seleccion).split(":");
           
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                    
                        admin.removeNotificacion(admin.getNotificaciones().get(seleccion));

                        String notificacionRechazo="Han rechazado tu desafio";
                        Game.guardado.addNotificacion(partes[3], notificacionRechazo);

                        System.out.println("Has cancelado el desafio");
                        salir=true;
                        break;
                    case 2:

                        List<String> usuariosSuscritos=Game.guardado.usuariosSuscritosNotificacion();

                        String notificacionSuscritos="N:"+partes[4]+":"+partes[3]+":"+partes[2]+":"+partes[1]+":"+partes[5];
                        for(int i =0;i<usuariosSuscritos.size();i++){
                            if(!Objects.equals(usuariosSuscritos.get(i), partes[1]) && !Objects.equals(usuariosSuscritos.get(i), partes[3])){
                                Game.guardado.addNotificacion(usuariosSuscritos.get(i),notificacionSuscritos);
                            }
                            
                        }

                        String notificacionDesafiado="DA:"+partes[4]+":"+partes[3]+":"+partes[2]+":"+partes[1]+":"+partes[5];
                        Game.guardado.addNotificacion(partes[1], notificacionDesafiado);

                        String notificacionValidado="V:Han validado tu desafio";
                        Game.guardado.addNotificacion(partes[3], notificacionValidado);

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
