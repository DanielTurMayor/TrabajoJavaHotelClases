//Nombre:Daniel
//Apellidos:Tur Mayor
package PaqC03;

import java.io.Serializable;

public class Hotel implements Serializable {

    private final Cliente [][] hotel;

    public Hotel() {
        hotel = new Cliente[8][6];
    }



    public int reservarHab(Cliente cl, String opc, int cantHab) {
        int fila = 0;
        int columna = 0;
        int reservas = 0;
        switch (opc) {
            case "Estandar":
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (hotel[i][j] == null) {
                                hotel[i][j] = cl;
                                reservas++;
                                if(reservas == cantHab) return reservas;
                            }
                        }
                    }
                }
                return reservas;

            case "Balcon":
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int i = 5; i < 7; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (hotel[i][j] == null) {
                                hotel[i][j] = cl;
                                reservas++;
                                if(reservas == cantHab) return reservas;
                            }
                        }
                    }
                }

            case "Suite":
                fila = 7;
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int j = 0; j < 6; j++) {
                        if (hotel[fila][j] == null) {
                            hotel[fila][j] = cl;
                            reservas++;
                            if (reservas == cantHab) return reservas;
                        }
                    }
                }
        }
        return reservas;
    }



    public boolean anularReserva(Cliente cl, String opc, int cantHab) {
        int fila = 0;
        int columna = 0;
        int reservas = 0;
        switch (opc) {
            case "Estandar":
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (hotel[i][j] != null) {
                                if (hotel[i][j].equals(cl)) {
                                    hotel[i][j] = null;
                                    reservas++;
                                    if (reservas == cantHab) return true;
                                }
                            }
                        }
                    }
                }
                if (reservas == cantHab) return true;


            case "Balcon":
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int i = 5; i < 7; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (hotel[i][j] != null) {
                                if (hotel[i][j].equals(cl)) {
                                    hotel[i][j] = null;
                                    reservas++;
                                    if (reservas == cantHab) return true;
                                }
                            }
                        }
                    }
                }

            case "Suite":
                fila = 7;
                for (reservas = 0 ; reservas < cantHab;) {
                    for (int j = 0; j < 6; j++) {
                        if (hotel[fila][j] != null) {
                            if (hotel[fila][j].equals(cl)) {
                                hotel[fila][j] = null;
                                reservas++;
                                if (reservas == cantHab) return true;
                            }
                        }
                    }
                }
        }
        return true;
    }


    public String toString(){
        String disponible="";
        for(int i=0;i<8;i++){
            for(int j=0;j<6;j++){
                if(hotel[i][j]==null){
                    disponible = disponible + " [L] ";
                }
                else{
                    disponible = disponible + " [R] ";
                }
            }
            disponible = disponible + "\n";
        }
        return disponible;
    }

    public Cliente buscarClienteporDNI(int DNI){
        for (int i = 0; i < 8;) {
            for (int j = 0; j < 6;) {
                if (DNI == hotel[i][j].getDNI()){
                    Cliente cl = new Cliente(hotel[i][j].getNombre(),hotel[i][j].getApellidos(),hotel[i][j].getDNI(),hotel[i][j].getNumTelef(),hotel[i][j].getNumTarjet(),hotel[i][j].getFechaEntrada(),hotel[i][j].getFechaSalida(),hotel[i][j].getRegAlimenticio());
                    return cl;
                }else{
                    i++;
                    j++;
                }
            }
        }
        return null;
    }
}

