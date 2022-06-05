package PracticaMP.practica;

public class InterpreteNoficaciones {
    public static String decodificarNotificacion(String not){
        String result="";
        String[] partes=not.split(":");
        switch(partes[0]){
            case "D":
                result=not_D(not);
            break;
            case "N":
                result=not_N(not);
            break;
            case "DA":
                result=not_DA(not);
            break;
            case "DR":
                result=not_DR(not);
            break;
            case "V":
                result=not_V(not);
            break;
            case "H":
                result=not_H(not);
            break;
            case "R":
                result=not_R(not);
            break;
            case "RE":
                result=not_RE(not);
            break;
        }
        return result;
    }
    private static String not_D(String not){
        String[] partes=not.split(":");
        return "El jugador: "+partes[4]+" con NR: "+partes[3]+" ha desafiado al jugador "+partes[2]+" con NR: "+partes[1]+" con una cantidad de oro de: "+partes[5];
    }
    private static String not_N(String not){
        String[] partes=not.split(":");
        return "El desafio entre el jugador: "+partes[4]+" con NR: "+partes[3]+" y el jugador "+partes[2]+" con NR: "+partes[1]+" por "+partes[5]+" de oro, ha sido aprobado por un administrador";
    }  
    private static String not_DA(String not){
        String[] partes=not.split(":");
        return "Has sido desafiado por el jugador: "+partes[4]+" con NR: "+partes[3]+" por "+partes[5]+" de oro";
    } 
    private static String not_DR(String not){//por parte de un admin
        String[] partes=not.split(":");
        return "Han cancelado tu desafio con: "+partes[1]; 
    } 
    private static String not_V(String not){//por parte de un admin
        String[] partes=not.split(":");
        return "Han validado tu desafio con: "+partes[1];
    } 
    private static String not_H(String not){//por parte de un usuario
        String[] partes=not.split(":");
        return "El jugador: "+partes[2]+" ha aceptado tu desafio";
    } 
    private static String not_R(String not){//por parte de un usuario
        String[] partes=not.split(":");
        return "El jugador: "+partes[2]+" ha rechazado tu desafio";
    }
    private static String not_RE(String not){//resultado
        String[] partes=not.split(":");
        return partes[1];
    }
}
