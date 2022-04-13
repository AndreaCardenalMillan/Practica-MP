/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMP.practica;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

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
    public Disciplina cargarDisciplina(String nombre) throws IOException{
        if(!equipoCreado.containsKey(nombre))
        {
            disciplinasCreadas.put(nombre, cargarDisciplinaDisco(nombre));
        }
        return disciplinasCreadas.get(nombre);
    }
    //#endregion
}
