package PracticaMP.practica;

import java.security.cert.PKIXCertPathValidatorResult;
import java.util.*;

public class Usuario {
    private String nombre;
    private String nick;
    private String password;
    private List<String> notificaciones=new ArrayList<>();
    
    
    public Usuario(String pNombre,String pNick,String pPassword){
        this.nombre = pNombre;
        this.nick = pNick;
        this.password =pPassword;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public String getNick(){
        return this.nick;
    }
    
    public String getPassword(){
        return this.password;
    }

    
    public List<String> getNotificaciones(){
        return this.notificaciones;
    }
    public void setNotificaciones(List<String> notificacionesIn){
        this.notificaciones=notificacionesIn;
    }
    public void clearNofiticaciones(){
        this.notificaciones=new ArrayList<>();
    }
    public void addNotificacion(String not){
        notificaciones.add(not);
    }

    public void removeNotificacion(String notificacion){
        this.notificaciones.remove(notificacion);
    }

    
}
