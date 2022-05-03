package PracticaMP.practica;

import java.util.*;

public class Usuario {
    public String nombre;
    public String nick;
    public String password;
    public ArrayList<Notificacion> notificaciones;

    public Usuario(String pNombre,String pNick,String pPassword){
        this.nombre = pNombre;
        this.nick = pNick;
        this.password =pPassword;
        this.notificaciones =new ArrayList<>();
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

    public void addNotificaciones(Notificacion pNotificacion){
        this.notificaciones.append(pNotificacion);
    }
    public ArrayList<Notificacion> getNotificaciones(){
        return this.notificaciones;
    }
}
