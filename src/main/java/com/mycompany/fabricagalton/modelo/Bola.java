package com.mycompany.fabricagalton.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bola implements Runnable {

    public static int FUERA = -1;
    private int numero;
    private int fila;
    private int celda;
    private boolean enEspera;
    private boolean fuera;

    private TableroGalton tableroGalton;

    public Bola(int numero, TableroGalton tableroGalton) {
        this.numero = numero;
        this.tableroGalton = tableroGalton;
        enEspera = true;
        fuera = false;
        fila = FUERA;
        celda = FUERA;

    }

    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public int getCelda() {
        return celda;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setCelda(int celda) {
        this.celda = celda;
    }

    public void cayoFuera() {
        fuera = true;
    }

    public void entroEnTablero() {
        enEspera = false;
    }

    public boolean estaEnEspera() {
        return enEspera;
    }

    @Override
    public void run() {
        while (!fuera) {

            tableroGalton.caer(this);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
