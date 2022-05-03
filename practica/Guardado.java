/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMP.practica;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.Region;

/**
 *
 * @author Ruben
 */
public class Guardado {
    private Map<String,Equipo> equipoCreado=new HashMap<>();
    /**
     * Habilidad de los licantropos
     */
    private Map<String,Don> donesCreados=new HashMap<>();
    /**
     * Habilidad de los cazadores
     */
    private Map<String,Talento> talentosCreados=new HashMap<>();
    /**
     * Habilidad de los vampiros
     */
    private Map<String,Disciplina> disciplinasCreadas=new HashMap<>();
    private Map<String,Modificador> modificadoresCreados=new HashMap<>();

    private Map<String,String> lecturaFichero(File fichero) throws IOException{
        Map<String,String> datosMap=new HashMap<>();
        Reader csv=new FileReader(fichero);
        BufferedReader buf =new BufferedReader(csv);
        String data=buf.readLine();
        while(data!=null){
            String[] datos=data.split(";");
            datosMap.put(datos[0], datos[1]);
        }
        buf.close();
        return datosMap;
    }

    //#region equipo
    private Equipo cargarEquipoDisco(String Id) throws IOException{
        File equipoF=new File("ficherosConfiguracion/equipo/"+Id+".csv");//ID es id_nombre asi puedo saber que hay disponible
        Equipo e=null;
        if(equipoF.exists()){
            Map<String,String> equipoMap=lecturaFichero(equipoF);
            Equipo.tipoEquipo tipo=Equipo.tipoEquipo.unaMano;
            if(equipoMap.get("Tipo")=="UnaMano")
            {
                tipo=Equipo.tipoEquipo.unaMano;
            }
            else if(equipoMap.get("Tipo")=="DosManos")
            {
                tipo=Equipo.tipoEquipo.dosManos;
            }
            else if(equipoMap.get("Tipo")=="Armadura")
            {
                tipo=Equipo.tipoEquipo.armadura;
            }
            else
            {
                System.out.println("El tipo de equipo del equipo: "+Id+" Esta mal definido, se ha inicializado por defecto");
            }
            e=new Equipo(Integer.parseInt(equipoMap.get("ID")), equipoMap.get("Nombre"), Integer.parseInt(equipoMap.get("Ataque")), Integer.parseInt(equipoMap.get("Defensa")), tipo);
            equipoCreado.put(Id, e);
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente al equipo con ID: "+Id+" no existe");
            throw new FileNotFoundException();
        }
        return e;
    }
    public Equipo cargarEquipo(String Id) throws IOException{
        if(!equipoCreado.containsKey(Id))
        {
            equipoCreado.put(Id, cargarEquipoDisco(Id));
        }
        return equipoCreado.get(Id);
    }
    //#endregion

    //#region dones
    
    private Don cargarDonDisco(String Id) throws IOException{
        File donF=new File("ficherosConfiguracion/habilidades/dones/"+Id+".csv");
        Don d=null;
        if(donF.exists()){
            Map<String,String> mapaDatos=lecturaFichero(donF);
            
            if(mapaDatos.get("Tipo")=="Don")
            {
                d=new Don(mapaDatos.get("Nombre"), Integer.parseInt(mapaDatos.get("Ataque")), Integer.parseInt(mapaDatos.get("Defensa")), Integer.parseInt(mapaDatos.get("RabiaMin")));
            }
            else
            {
                System.out.println("El fichero de configuracion correspondiente al DON con nombre: "+Id+" no es del tipo correcto");
                throw new FileNotFoundException();
            }
            
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente al DON con nombre: "+Id+" no existe");
            throw new FileNotFoundException();
        }
        return d;
    }
    /**
     * Habilidad de los licantropos
     */
    public Don cargarDon(String nombre) throws IOException{
        if(!donesCreados.containsKey(nombre))
        {
            donesCreados.put(nombre, cargarDonDisco(nombre));
        }
        return donesCreados.get(nombre);
    }
    //#endregion

    //#region talentos
    private Talento cargarTalentoDisco(String Id) throws IOException{
        File archivo=new File("ficherosConfiguracion/habilidades/talentos/"+Id+".csv");
        Talento t=null;
        if(archivo.exists()){
            Map<String,String> mapaDatos=lecturaFichero(archivo);
            
            if(mapaDatos.get("Tipo")=="Talento")
            {
                t=new Talento(mapaDatos.get("Nombre"), Integer.parseInt(mapaDatos.get("Ataque")), Integer.parseInt(mapaDatos.get("Defensa")), Integer.parseInt(mapaDatos.get("Edad")));
            }
            else
            {
                System.out.println("El fichero de configuracion correspondiente al TALENTO con nombre: "+Id+" no es del tipo correcto");
                throw new FileNotFoundException();
            }
            
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente al TALENTO con nombre: "+Id+" no existe");
            throw new FileNotFoundException();
        }
        return t;
    }
    /**
     * Habilidad de los cazadores
     */
    public Talento cargarTalento(String nombre) throws IOException{
        if(!talentosCreados.containsKey(nombre))
        {
            talentosCreados.put(nombre, cargarTalentoDisco(nombre));
        }
        return talentosCreados.get(nombre);
    }
    //#endregion
    
    //#region disciplinas
    private Disciplina cargarDisciplinaDisco(String Id) throws IOException{
        File archivo=new File("ficherosConfiguracion/habilidades/disciplinas/"+Id+".csv");
        Disciplina d=null;
        if(archivo.exists()){
            Map<String,String> mapaDatos=lecturaFichero(archivo);
            if(mapaDatos.get("Tipo")=="Disciplina")
            {
                d=new Disciplina(mapaDatos.get("Nombre"), Integer.parseInt(mapaDatos.get("Ataque")), Integer.parseInt(mapaDatos.get("Defensa")), Integer.parseInt(mapaDatos.get("Sangre")));
            }
            else
            {
                System.out.println("El fichero de configuracion correspondiente a la DISCIPLINA con nombre: "+Id+" no es del tipo correcto");
                throw new FileNotFoundException();
            }
            
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente a la DISCIPLINA con nombre: "+Id+" no existe");
            throw new FileNotFoundException();
        }
        return d;
    }
    /**
     * Habilidad de los vampiros
     */
    public Disciplina cargarDisciplina(String nombre) throws IOException{
        if(!disciplinasCreadas.containsKey(nombre))
        {
            disciplinasCreadas.put(nombre, cargarDisciplinaDisco(nombre));
        }
        return disciplinasCreadas.get(nombre);
    }
    //#endregion

    //#region modificadores
    private Modificador cargaModificadorDisco(String nombre) throws IOException{
        File archivo=new File("ficherosConfiguracion/modificadores/"+nombre+".csv");
        Modificador mod=null;
        if(archivo.exists())
        {
            Map<String,String> datos=lecturaFichero(archivo);
            //beneficioso de marca a TRUE si el campo vale "True" en el resto de casos es FALSE
            mod=new Modificador(datos.get("Nombre"), Integer.parseInt(datos.get("ModAtaque")), Integer.parseInt(datos.get("ModDefensa")), Boolean.parseBoolean(datos.get("Beneficioso")));
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente al MODIFICADOR con nombre: "+nombre+" no existe");
            throw new FileNotFoundException();
        }
        return mod;
    }

    public Modificador cargaModificador(String nombre) throws IOException{
        if(!modificadoresCreados.containsKey(nombre)){
            modificadoresCreados.put(nombre, cargaModificadorDisco(nombre));
        }

        return modificadoresCreados.get(nombre);
    }

    //#endregion

    //#region personaje
    public void guardarPersonaje(String user, Personaje per) throws IOException{
        File archivo=new File("guardado/personajes/"+user+".csv");
        archivo.delete();
        archivo.createNewFile();
        Writer write=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(write);
        
        if(per instanceof Vampiro)
        {
            buf.write("Tipo;Vampiro");
            //buf.newLine();
            //buf.write("Sangre;"+((Vampiro)per).getSangre());
            buf.newLine();
            buf.write("Edad;"+((Vampiro)per).getEdad());
        }
        else if(per instanceof Cazador)
        {
            buf.write("Tipo;Cazador");
            //buf.newLine();
            //buf.write("Voluntad;"+((Cazador)per).getVoluntad());
        }
        else if(per instanceof Licantropo)
        {
            buf.write("Tipo;Licantropo");
            //buf.newLine();
            //buf.write("Rabia;"+((Licantropo)per).consultarRabia());
        }
        //------------------------NOMBRE
        buf.newLine();
        buf.write("Nombre;"+per.getNombre());
        //--------------------------HABILIDADES
        List<HabilidadEspecial> habilidades=per.getHabilidades();
        String buffer="";
        for(int i=0;i<habilidades.size();i++){
            if(buffer!=""){
                buffer+="|"+habilidades.get(i).getNombre();
            }else{
                buffer=habilidades.get(i).getNombre();
            }
        }
        buf.newLine();
        buf.write("Habilidades;"+buffer);
        //--------------------------RESERVA DE ARMAS
        List<Equipo> armasR=per.getReservaArmas();
        buffer="";
        for(int i=0;i<armasR.size();i++){
            String identificador=armasR.get(i).getID()+"_"+armasR.get(i).getNombre();
            if(buffer!="")
            {
                buffer+="|"+identificador;
            }
            else
            {
                buffer=identificador;
            }
        }
        buf.newLine();
        buf.write("ReservaArmas;"+buffer);
        //--------------------------RESERVA DE Armaduras
        List<Equipo> armadurasR=per.getReservaArmaduras();
        buffer="";
        for(int i=0;i<armadurasR.size();i++){
            String identificador=armadurasR.get(i).getID()+"_"+armadurasR.get(i).getNombre();
            if(buffer!="")
            {
                buffer+="|"+identificador;
            }
            else
            {
                buffer=identificador;
            }
        }
        buf.newLine();
        buf.write("ReservaArmaduras;"+buffer);
        //--------------------------ARMAS ACTIVAS
        List<Equipo> armasActivas=per.getReservaArmaduras();
        buffer="";
        for(int i=0;i<armasActivas.size();i++){
            String identificador=armasActivas.get(i).getID()+"_"+armasActivas.get(i).getNombre();
            if(buffer!="")
            {
                buffer+="|"+identificador;
            }
            else
            {
                buffer=identificador;
            }
        }
        buf.newLine();
        buf.write("ArmasActivas;"+buffer);
        //--------------------------ARMADURA ACTIVA
        buf.newLine();
        buffer=per.getArmadura().getID()+"_"+per.getArmadura().getNombre();
        buf.write("AmaduraActiva;"+buffer);
        //--------------------------MINIONS

        List<Minion> minions=per.getMinions();
        buffer="";
        for(int i=0;i<minions.size();i++){
            if(buffer!="")
            {
                buffer+="|"+minions.get(i).subEsbirros();
            }
            else
            {
                buffer=minions.get(i).subEsbirros();
            }
        }
        buf.newLine();
        buf.write("Minions;"+buffer);

        //--------------------------ORO
        buf.newLine();
        buf.write("Oro;"+per.getOro());
        //--------------------------MOD LIST
        List<Modificador> modificadores=per.getMods();
        buffer="";
        for(int i=0;i<modificadores.size();i++){
            if(buffer!="")
            {
                buffer+="|"+modificadores.get(i).getNombre();
            }
            else
            {
                buffer=modificadores.get(i).getNombre();;
            }
        }
        buf.newLine();
        buf.write("Modificadores;"+buffer);

        //---------------------------NOTIFICACIONES
        //siempre tienen que ser las ultimas
        buf.newLine();
        buf.write("Notificaciones;");

        buf.close();
        
    }


    public Personaje cargarPersonaje(String user) throws IOException{
        Personaje per=null;

        File archivo=new File("guardado/personajes/"+user+".csv");
        if(archivo.exists())
        {
            Map<String,String> datos=lecturaFichero(archivo);

            //precarga de los valores genericos
            List<HabilidadEspecial> habilidades=new ArrayList<>();
            String[] partesHa=datos.get("Habilidades").split("|");
            
            List<Equipo> armasAc=new ArrayList<>();
            if(datos.get("ArmasActivas").contains("|"))
            {
                String[] partesAr=datos.get("ArmasActivas").split("|");
                for(int i =0;i<partesAr.length;i++){
                    armasAc.add(cargarEquipo(partesAr[i]));
                }
            }
            else
            {
                armasAc.add(cargarEquipo(datos.get("ArmasActivas")));
            }

            Equipo armadura=cargarEquipo(datos.get("AmaduraActiva"));


            //============================FALTA CARGAR LOS MINIONS===============================

            if(datos.get("Tipo")=="Licantropo")
            {
                for(int i =0;i<partesHa.length;i++){
                    habilidades.add(cargarDon(partesHa[i]));
                }
                Licantropo lican=new Licantropo(datos.get("Nombre"), habilidades, armasAc, armadura);
                per=lican;
            }
            else if(datos.get("Tipo")=="Cazador")
            {
                for(int i =0;i<partesHa.length;i++){
                    habilidades.add(cargarTalento(partesHa[i]));
                }
                Cazador cazador=new Cazador(datos.get("Nombre"), habilidades, armasAc, armadura);
                per=cazador;
            }
            else if(datos.get("Tipo")=="Vampiro")
            {
                for(int i =0;i<partesHa.length;i++){
                    habilidades.add(cargarDisciplina(partesHa[i]));
                }
                Vampiro vampire=new Vampiro(datos.get("Nombre"), habilidades, armasAc, armadura, Integer.parseInt(datos.get("Edad")));
                per=vampire;
            }
            

        }
        else
        {
            System.out.println("El archivo de guardado referente al jugador con ID: "+user+" no existe");
            throw new FileNotFoundException();
        }

        return per;
    }


    public void addNotificacion(String user, String notificacion) throws IOException
    {
        File archivo=new File("guardado/personajes/"+user+".csv");
        Writer write=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(write);
        buf.write(notificacion+"|");
        buf.close();
    }
    //#endregion

    //#region usuarios
    public Jugador cargarJugador(String NR) throws IOException{
        Jugador player=null;
        File archivo=new File("guardado/usuarios/"+NR+".csv");
        if(archivo.exists()){
            Map<String,String> datos=lecturaFichero(archivo);
            player=new Jugador(datos.get("Nombre"), datos.get("Nick"), datos.get("Password"));
            //EL NR QUE HAGO CON EL?
        }
        else{
            System.out.println("El fichero correspondiente al jugador con NR: "+NR+" NO existe");
            throw new FileNotFoundException();
        }
        return player;
        
    }
    public void guardarJugador(Jugador jugador) throws IOException{
        File archivo=new File("guardado/usuarios/"+jugador.getNR()+".csv");
        archivo.delete();
        archivo.createNewFile();
        Writer write=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(write);
        
        //------------IDENTIFICADOR
        buf.write("NR;"+jugador.getNR());
        buf.newLine();
        //------------NOMBRE--------
        buf.write("Nombre;"+jugador.getNombre());
        buf.newLine();
        //------------NICK-------
        buf.write("Nick;"+jugador.getNick());
        buf.newLine();
        //------------PASSWORD-----
        buf.write("Password;"+jugador.getPassword());
        buf.newLine();
        buf.close();
    }

    public Administrador cargarAdmin(String nick) throws IOException{
        Administrador admin=null;
        File archivo=new File("guardado/usuarios/"+nick+".csv");
        if(archivo.exists()){
            Map<String,String> datos=lecturaFichero(archivo);
            admin=new Administrador(datos.get("Nombre"), datos.get("Nick"), datos.get("Password"));
            //EL NR QUE HAGO CON EL?
        }
        else{
            System.out.println("El fichero correspondiente al admin con nick: "+nick+" NO existe");
            throw new FileNotFoundException();
        }
        return admin;
        
    }
    public void guardarAdmin(Administrador admin) throws IOException{
        File archivo=new File("guardado/usuarios/"+admin.getNick()+".csv");
        archivo.delete();
        archivo.createNewFile();
        Writer write=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(write);
        
        //------------NOMBRE--------
        buf.write("Nombre;"+admin.getNombre());
        buf.newLine();
        //------------NICK-------
        buf.write("Nick;"+admin.getNick());
        buf.newLine();
        //------------PASSWORD-----
        buf.write("Password;"+admin.getPassword());
        buf.newLine();
        buf.close();
    }

    //#endregion
}
