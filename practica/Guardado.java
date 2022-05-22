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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PracticaMP.practica.Combate.resultadoCombate;
import PracticaMP.practica.Humano.lealtad;
import java.util.Objects;

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
            //System.out.println(data);
            if(datos.length==1)
            {
                datosMap.put(datos[0], "");
            }
            else
            {
                datosMap.put(datos[0], datos[1]);
            }
            
            data=buf.readLine();
        }
        buf.close();
        return datosMap;
    }

    private final String rutaEquipo="ficherosConfiguracion/equipo/";
    private final String rutaDones="ficherosConfiguracion/habilidades/dones/";
    private final String rutaTalentos="ficherosConfiguracion/habilidades/talentos/";
    private final String rutaDisciplinas="ficherosConfiguracion/habilidades/disciplinas/";
    private final String rutaModificadores="ficherosConfiguracion/modificadores/";

    private final String rutaPersonajes="guardado/personajes/";
    private final String rutaUsuarios="guardado/usuarios/";
    private final String rutaCombates="guardado/combates/";
    private final String rutaUsuariosNotificaciones="guardado/notificaciones.txt";

    //#region obtener elementos
    private List<String> listaArchivos(String ruta){
        File archivo=new File(ruta);
        File[] archivos= archivo.listFiles();
        List<String> resultados=new ArrayList<>();
        for(int i=0;i<archivos.length;i++){
            String nombre=archivos[i].getName();
            if(nombre.contains(".csv")){
                nombre=nombre.replace(".csv", "");
            }
            resultados.add(nombre);
        }
        return resultados;
    }

    public List<String> listaEquipo(){
        return listaArchivos(rutaEquipo);
    }
    public List<String> listaDones(){
        return listaArchivos(rutaDones);
    }
    public List<String> listaTalentos(){
        return listaArchivos(rutaTalentos);
    }
    public List<String> listaDisciplinas(){
        return listaArchivos(rutaDisciplinas);
    }
    public List<String> listaModificadores(){
        return listaArchivos(rutaModificadores);
    }
    public List<String> listaPersonajes(){
        return listaArchivos(rutaPersonajes);
    }
    public List<String> listaUsuarios(){
        return listaArchivos(rutaUsuarios);
    }
    public List<String> usuariosSuscritosNotificacion() throws IOException{

        List<String> usuarios=new ArrayList<>();
        File archivo=new File(rutaUsuariosNotificaciones);
        Reader csv=new FileReader(archivo);
        BufferedReader buf =new BufferedReader(csv);
        String data=buf.readLine();
        while(data!=null){
            usuarios.add(data);
            data=buf.readLine();
        }
        buf.close();
        return usuarios;
    }

    public void guardarCombate(resultadoCombate resultado) throws IOException{
        String nombreArchivo=resultado.fechaCombate+"_"+resultado.personaje1+"_"+resultado.personaje2+".log";
        File archivo=new File(rutaCombates+nombreArchivo);
        archivo.createNewFile();

        Writer log=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(log);
        buf.write("Fecha: "+resultado.fechaCombate);
        buf.newLine();
        buf.write("Personaje1: "+resultado.personaje1);
        buf.newLine();
        buf.write("Personaje2: "+resultado.personaje2);
        buf.newLine();
        buf.write("Oro en juego: "+resultado.oroDado);
        buf.newLine();
        buf.write("Ganador: "+resultado.ganandor);
        buf.newLine();
        buf.write("LOG del combate:");
        buf.newLine();
        for(int i=0;i<resultado.log.size();i++){
            buf.write(resultado.log.get(i));
            buf.newLine();
        }
        buf.close();
    }
    //#endregion
    public void addUsuarioNotificado(String user) throws IOException{
        File archivo=new File(rutaUsuariosNotificaciones);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        Writer txt=new FileWriter(archivo);
        BufferedWriter buf =new BufferedWriter(txt);
        buf.write(user);
        buf.newLine();

        buf.close();
    }

    //#region equipo
    private Equipo cargarEquipoDisco(String Id) throws IOException{
        File equipoF=new File(rutaEquipo+Id+".csv");//ID es id_nombre asi puedo saber que hay disponible
        Equipo e=null;
        if(equipoF.exists()){
            Map<String,String> equipoMap=lecturaFichero(equipoF);
            Equipo.tipoEquipo tipo=Equipo.tipoEquipo.unaMano;
            if(Objects.equals(equipoMap.get("Tipo"),"UnaMano"))
            {
                tipo=Equipo.tipoEquipo.unaMano;
            }
            else if(Objects.equals(equipoMap.get("Tipo"),"DosManos"))
            {
                tipo=Equipo.tipoEquipo.dosManos;
            }
            else if(Objects.equals(equipoMap.get("Tipo"),"Armadura"))
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
        File donF=new File(rutaDones+Id+".csv");
        Don d=null;
        if(donF.exists()){
            Map<String,String> mapaDatos=lecturaFichero(donF);
            
            if(Objects.equals(mapaDatos.get("Tipo"),"Don"))
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
        File archivo=new File(rutaTalentos+Id+".csv");
        Talento t=null;
        if(archivo.exists()){
            Map<String,String> mapaDatos=lecturaFichero(archivo);
            
            if(Objects.equals(mapaDatos.get("Tipo"),"Talento"))
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
        File archivo=new File(rutaDisciplinas+Id+".csv");
        Disciplina d=null;
        if(archivo.exists()){
            Map<String,String> mapaDatos=lecturaFichero(archivo);
            //System.out.println("cargar disciplina disco mapa:"+mapaDatos.get("Tipo").strip());
            //System.out.print(Objects.equals(mapaDatos.get("Tipo").strip(),"Disciplina"));
            if(Objects.equals(mapaDatos.get("Tipo").strip(),"Disciplina"))
            {
                d=new Disciplina(mapaDatos.get("Nombre"), Integer.parseInt(mapaDatos.get("Ataque")), Integer.parseInt(mapaDatos.get("Defensa")), Integer.parseInt(mapaDatos.get("Sangre")));
            }
            else
            {
                System.out.println("El fichero de configuracion correspondiente a la DISCIPLINA con nombre: "+Id+" no es del tipo correcto: -"+mapaDatos.get("Tipo")+"-");
                throw new FileNotFoundException();
            }
            
        }
        else
        {
            System.out.println("El fichero de configuracion correspondiente a la DISCIPLINA con nombre: "+Id+" no existe"+archivo.getPath());
            throw new FileNotFoundException();
        }
        //System.out.println("cargar disciplina disco return");
        return d;
    }
    /**
     * Habilidad de los vampiros
     */
    public Disciplina cargarDisciplina(String nombre) throws IOException{
        //System.out.println("cargar disciplina: "+nombre);
        if(!disciplinasCreadas.containsKey(nombre))
        {
            //System.out.println("cargar disciplina");
            disciplinasCreadas.put(nombre, cargarDisciplinaDisco(nombre));
            //System.out.println("cargar disciplina2");
        }
        //System.out.println("return");
        return disciplinasCreadas.get(nombre);
    }
    //#endregion

    //#region modificadores
    private Modificador cargaModificadorDisco(String nombre) throws IOException{
        File archivo=new File(rutaModificadores+nombre+".csv");
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
        File archivo=new File(rutaPersonajes+user+".csv");
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
            if(!Objects.equals(buffer,"")){
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
            if(!Objects.equals(buffer,""))
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
            if(!Objects.equals(buffer,""))
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
        List<Equipo> armasActivas=per.getArmasActivas();
        buffer="";
        for(int i=0;i<armasActivas.size();i++){
            String identificador=armasActivas.get(i).getID()+"_"+armasActivas.get(i).getNombre();
            if(!Objects.equals(buffer,""))
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
            if(!Objects.equals(buffer,""))
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
            if(!Objects.equals(buffer,""))
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


        buf.close();
        
    }
    private class infoMinion{
        String[] partes;
        int indiceLast;
    }
    private infoMinion atributrosMinions(String datos, int indice){
        int lastChar= indice;
        infoMinion partesMinion=new infoMinion();
        String posChar=String.valueOf(datos.charAt(indice));
        while(posChar!=")"){
            lastChar++;
            posChar=String.valueOf(datos.charAt(indice));
        }
        partesMinion.partes=datos.substring(indice,lastChar).split(";");
        partesMinion.indiceLast=lastChar+1;//se salta el parentesis de cierre
        return partesMinion;
    }

    private Minion crearMinion(String info,int indice){
        Minion mi=null;
        String identificador=info.substring(indice,indice+2);
        if(Objects.equals(identificador,"_D"))
        {
            indice+=2;//pasa de la barra baja, se salta la letra y va al parentesis
            infoMinion partesM=atributrosMinions(info, indice);
            String nombre=partesM.partes[0];
            String pacto=partesM.partes[1];
            
            List<Minion> esbirros=new ArrayList<>();
            
            
            indice=partesM.indiceLast;
            if(Objects.equals(String.valueOf(info.charAt(indice)),"[")){//tiene subesbirros
                int corchetes=1;
                while(corchetes!=0){
                    String idSig=String.valueOf(info.charAt(indice+1));
                    String id=String.valueOf(info.charAt(indice));
                    if(Objects.equals(idSig,"D") && Objects.equals(id,"_"))
                    {
                        esbirros.add(crearMinion(info, indice));
                    }
                    else if(Objects.equals(idSig,"G") && Objects.equals(id,"_"))
                    {
                        esbirros.add(crearMinion(info, indice));
                    }
                    else if(Objects.equals(idSig,"H") && Objects.equals(id,"_"))
                    {
                        esbirros.add(crearMinion(info, indice));
                    }
                    else if(Objects.equals(idSig,"["))
                    {
                        corchetes++;
                    }
                    else if(Objects.equals(idSig,"]"))
                    {
                        corchetes--;
                    }
                    indice++;
                }
            }
            Demonio demon=new Demonio(nombre, pacto, esbirros);
            mi=demon;
            //mi=new Demonio(nombre, salud, pacto, esbirros)
        }
        else if(Objects.equals(identificador,"_G"))
        {
            indice+=2;//pasa de la barra baja, se salta la letra y va al parentesis
            infoMinion partesM=atributrosMinions(info, indice);
            String nombre=partesM.partes[0];
            int dependencia=Integer.parseInt(partesM.partes[1]);
            
            indice=partesM.indiceLast;

            Ghoul ghoul=new Ghoul(nombre, dependencia);
            mi=ghoul;
        }
        else if(Objects.equals(identificador,"_H"))
        {
            indice+=2;//pasa de la barra baja, se salta la letra y va al parentesis
            infoMinion partesM=atributrosMinions(info, indice);
            String nombre=partesM.partes[0];
            lealtad lazoAfectivo=lealtad.values()[Integer.parseInt(partesM.partes[1])];
            
            indice=partesM.indiceLast;

            Humano human=new Humano(nombre, lazoAfectivo);
            mi=human;
        }


        return mi;

    }
    public Personaje cargarPersonaje(String user) throws IOException{
        Personaje per=null;

        File archivo=new File(rutaPersonajes+user+".csv");
        if(archivo.exists())
        {
            Map<String,String> datos=lecturaFichero(archivo);

            //precarga de los valores genericos
            List<HabilidadEspecial> habilidades=new ArrayList<>();
            String[] partesHa={datos.get("Habilidades")};
            
            if(datos.get("Habilidades").contains("|")){
                partesHa=datos.get("Habilidades").split("|");
            }
            
            //System.out.println(datos.get("Habilidades")+" habilidad============================="+partesHa[0]);
            
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


            List<Minion> minionsL = new ArrayList<>();
            if(datos.get("Minions").contains("|")){
                String[] minions=datos.get("Minions").split("|");
                for(int i=0;i<minions.length;i++){
                    minionsL.add(crearMinion(minions[i], 0));
                }
            }
            else if(datos.get("Minions").length()>=1){//1 minion, no tiene separador, pero no esta vacia
                minionsL.add(crearMinion(datos.get("Minions"), 0));
            }
            


            if(Objects.equals(datos.get("Tipo"),"Licantropo"))
            {
                for(int i =0;i<partesHa.length;i++){
                    habilidades.add(cargarDon(partesHa[i]));
                }
                Licantropo lican=new Licantropo(datos.get("Nombre"), habilidades, armasAc, armadura);
                per=lican;
            }
            else if(Objects.equals(datos.get("Tipo"),"Cazador"))
            {
                for(int i =0;i<partesHa.length;i++){
                    habilidades.add(cargarTalento(partesHa[i]));
                }
                Cazador cazador=new Cazador(datos.get("Nombre"), habilidades, armasAc, armadura);
                per=cazador;
            }
            else if(Objects.equals(datos.get("Tipo"),"Vampiro"))
            {
                for(int i =0;i<partesHa.length;i++){
                    //System.out.println(partesHa[i]);
                    habilidades.add(cargarDisciplina(partesHa[i]));
                }
                Vampiro vampire=new Vampiro(datos.get("Nombre"), habilidades, armasAc, armadura, Integer.parseInt(datos.get("Edad")));
                per=vampire;
            }
            per.addMinionList(minionsL);
            per.setNR(user);
            per.setOro(Integer.parseInt(datos.get("Oro")));

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
        File archivo=new File(rutaUsuarios+user+".csv");
        Writer write=new FileWriter(archivo);
        BufferedWriter buf=new BufferedWriter(write);
        buf.write(notificacion+"|");
        buf.close();
    }
    //#endregion

    //#region usuarios
    public Jugador cargarJugador(String NR) throws IOException{
        Jugador player=null;
        File archivo=new File(rutaUsuarios+NR+".csv");
        if(archivo.exists()){
            Map<String,String> datos=lecturaFichero(archivo);
            player=new Jugador(datos.get("Nombre"), datos.get("Nick"), datos.get("Password"));
            
            /*
            if (!Objects.equals(datos.get("Notificaciones"),"")){
            //if(datos.get("Notificaciones")!=""){//hay alguna notificacion
                String[] notificaciones=datos.get("Notificaciones").split("|");
                List<String> notList=Arrays.asList(notificaciones);
                notList.remove(notList.size()-1);
                player.setNotificaciones(notList);
            }*/
            player.setNR(datos.get("NR"));
        }
        else{
            System.out.println("El fichero correspondiente al jugador con NR: "+NR+" NO existe");
            throw new FileNotFoundException();
        }
        return player;
        
    }
    public void guardarJugador(Jugador jugador) throws IOException{
        File archivo=new File(rutaUsuarios+jugador.getNR()+".csv");
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
        
        //---------------------------NOTIFICACIONES
        //siempre tienen que ser las ultimas
        buf.write("Notificaciones;");
        buf.close();
    }

    public Administrador cargarAdmin(String nick) throws IOException{
        Administrador admin=null;
        File archivo=new File(rutaUsuarios+nick+".csv");
        if(archivo.exists()){
            Map<String,String> datos=lecturaFichero(archivo);
            admin=new Administrador(datos.get("Nombre"), datos.get("Nick"), datos.get("Password"));
            /*
            if(!Objects.equals(datos.get("Notificaciones"),"")){
            //if(datos.get("Notificaciones")!=""){//hay alguna notificacion
                String[] notificaciones=datos.get("Notificaciones").split("|");
                List<String> notList=Arrays.asList(notificaciones);
                notList.remove(notList.size()-1);//el ultimo va vacio siempre
                admin.setNotificaciones(notList);
            }*/
            
        }
        else{
            System.out.println("El fichero correspondiente al admin con nick: "+nick+" NO existe");
            throw new FileNotFoundException();
        }
        return admin;
        
    }
    public void guardarAdmin(Administrador admin) throws IOException{
        File archivo=new File(rutaUsuarios+admin.getNick()+".csv");
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
        
        //---------------------------NOTIFICACIONES
        //siempre tienen que ser las ultimas
        buf.write("Notificaciones;");
        buf.close();
    }

    //#endregion
}
