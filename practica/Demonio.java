/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticaMP.practica;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class Demonio extends Minion{
    private String pacto;
    private List<Minion> esbirros = new ArrayList<Minion>();

    public String getPacto() {
        return pacto;
    }
    public void setPacto(String pacto) {
        this.pacto = pacto;
    }

    public List<Minion> getEsbirros(List<Minion> esbirros) {
        return esbirros;
    }
    public void setEsbirros(List<Minion> esbirros) {
        this.esbirros = esbirros;
    }
    
    
    /**
     * 
     * @param salud
     * @return
     */
    @Override
    public int calcularVidaTotal() {
        int salud = getSalud();
        
        for (int i=0; i < esbirros.size(); i++){
            salud += esbirros.get(i).calcularVidaTotal();
        }
        return salud;
    }
    
    public Demonio (String nombre, int salud, String pacto, List<Minion> esbirros){
        super(nombre, salud);
        setPacto(pacto);
        setEsbirros(esbirros);
    }
}
