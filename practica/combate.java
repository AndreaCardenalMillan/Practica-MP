package PracticaMP.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class combate {
    private List<String> log=new ArrayList<>();
    public void iniciarCombate(Personaje per1, Personaje per2){
        //añadir log inicial
        while(per1.salud>=0 && per2.salud>=0){
            int ataque1=per1.calcularAtaque();
            int ataque2=per2.calcularAtaque();

            int def1=per1.calcularDefensa();
            int def2=per2.calcularDefensa();

            TimeUnit.SECONDS.sleep(5);
        }
        //añadir log final

    }
}
