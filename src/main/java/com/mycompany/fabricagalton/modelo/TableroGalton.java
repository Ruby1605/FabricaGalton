package com.mycompany.fabricagalton.modelo;

import com.mycompany.fabricagalton.vista.VistaTableroGalton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TableroGalton {

    private Bola tablero[][];
    private int nFilas;
    private ArrayList<Bola> depositos[];
    private Random random;
    private VistaTableroGalton vistaTableroGalton = null;

    public TableroGalton(int nFilas) {
        this.nFilas = nFilas;
        tablero = new Bola[nFilas][];
        int nCeldas = 1;
        for (int i = 0; i < nFilas; i++) {
            tablero[i] = new Bola[nCeldas];
            for (int j = 0; j < nCeldas; j++) {
                tablero[i][j] = null;
            }
            nCeldas++;
        }
        depositos = new ArrayList[nCeldas];
        iniciarDepositos(nCeldas);
        for (int i = 0; i < nCeldas; i++) {
            depositos[i] = new ArrayList<>();
        }
        random = new Random();
    }

    public synchronized void caer(Bola bola) {
        int direccion = random.nextInt(2);
        int fila = bola.getFila();
        int celda = bola.getCelda();
        if (bola.estaEnEspera() && tablero[0][0] == null) {
            tablero[0][0] = bola;
            bola.entroEnTablero();
            bola.setFila(0);
            bola.setCelda(0);
            if (vistaTableroGalton != null) {
                vistaTableroGalton.actualizarDibujoTablero();
            } else {
                System.out.println("bola " + bola.getNumero() + " fila " + bola.getFila() + " celda " + bola.getCelda());
            }

        } else if (!bola.estaEnEspera() && fila < nFilas - 1) {
            if (direccion == 0) {
                if (tablero[fila + 1][celda] == null) {
                    tablero[fila][celda] = null;
                    tablero[fila + 1][celda] = bola;
                    bola.setFila(fila + 1);
                    bola.setCelda(celda);
                    if (vistaTableroGalton != null) {
                        vistaTableroGalton.actualizarDibujoTablero();
                    } else {
                        System.out.println("bola " + bola.getNumero() + " fila " + bola.getFila() + " celda " + bola.getCelda());
                    }

                }
            } else if (direccion == 1) {
                if (tablero[fila + 1][celda + 1] == null) {
                    tablero[fila][celda] = null;
                    tablero[fila + 1][celda + 1] = bola;
                    bola.setFila(fila + 1);
                    bola.setCelda(celda + 1);
                    if (vistaTableroGalton != null) {
                        vistaTableroGalton.actualizarDibujoTablero();
                    } else {
                        System.out.println("bola " + bola.getNumero() + " fila " + bola.getFila() + " celda " + bola.getCelda());
                    }

                }

            }
        } else if (!bola.estaEnEspera() && fila == nFilas - 1) {
            tablero[fila][celda] = null;
            if (direccion == 0) {
                depositos[celda].add(bola);
            } else if (direccion == 1) {
                depositos[celda + 1].add(bola);
            }
            bola.cayoFuera();
            bola.setFila(Bola.FUERA);
            bola.setCelda(Bola.FUERA);
            if (vistaTableroGalton != null) {
                vistaTableroGalton.actualizarDibujoTablero();
            } else {
                System.out.println("bola " + bola.getNumero() + " cayo al deposito un deposito");
            }

        }
    }

    public void mostrarDepositos() {
        for (int i = 0; i < depositos.length; i++) {
            System.out.println(depositos[i].size());
        }
    }

    public int getNFilas() {
        return nFilas;
    }

    public Bola getContenidoCelda(int fila, int celda) {
        return tablero[fila][celda];
    }

    public ArrayList<Bola> getDeposito(int i) {
        return depositos[i];
    }

    public final void iniciarDepositos(int nCeldas) {
        for (int i = 0; i < nCeldas; i++) {
            depositos[i] = new ArrayList<>();
        }
    }

    public void setVistaTableroGalton(VistaTableroGalton vistaTableroGalton) {
        this.vistaTableroGalton = vistaTableroGalton;
    }
}
