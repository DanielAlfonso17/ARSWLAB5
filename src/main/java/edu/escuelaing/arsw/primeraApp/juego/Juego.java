package edu.escuelaing.arsw.primeraApp.juego;

import java.util.Random;

public class Juego {
    private int numero;
    private String resultado;
    private static boolean estado;
    private static int numeroRandom;
    private Integer[] numeroRandomArr;
    private Integer[] numeroArr;

    public Juego(){
        numeroRandomArr = new Integer[4];
        numeroArr = new Integer[4];
        estado = false;
    }


    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado(){
        return estado;
    }

    public static void setNumeroRandom(int numero){
        numeroRandom = numero;
    }

    public static int getNumeroRandom(){
        return numeroRandom;
    }

    public void prepararNumeros(){
        int numeroTmp =  numero;
        int numeroRandomTmp = numeroRandom;
        int pos = 3;
        while (numeroTmp > 0 && numeroRandomTmp > 0){
            numeroArr[pos] = numeroTmp % 10;
            numeroRandomArr[pos] = numeroRandomTmp % 10;
            pos --;
            numeroTmp /= 10;
            numeroRandomTmp /= 10;
        }
    }


    public void jugar(){
        int picas = 0;
        int famas = 0;
        if(estado != true){
            if(numero == numeroRandom){
                famas = 4;
                resultado = "picas: 0 Famas: 4";
            }else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (i == j) {
                            if (numeroArr[i] == numeroRandomArr[j]) {
                                famas++;
                                break;
                            }
                        } else {
                            if (numeroArr[i] == numeroRandomArr[j]) {
                                picas++;
                                break;
                            }
                        }
                    }
                }
                resultado = "picas: "+ picas + " " + "Famas: "+ famas;
            }
        }
    }
}
