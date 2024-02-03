package com.mycompany.fabricagalton.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    
    private File archivotxt;
    private FileWriter fileWriter;
    

    public Logger() throws IOException {
        
        archivotxt = new File("log.txt");
        fileWriter = new FileWriter(archivotxt,true);
        
    }

    public void info(String texto) throws IOException {
        String cadena = "INFO ";
        cadena += addTexto(texto);
        fileWriter.write(cadena + "\n");

    }

    public void error(String texto) throws IOException {
        String cadena = "ERROR ";
        cadena += addTexto(texto);
        fileWriter.write(cadena + "\n");

    }

    public void warning(String texto) throws IOException {
        String cadena = "WARNING ";
        cadena += addTexto(texto);
        fileWriter.write(cadena + "\n");

    }

    private String addTexto(String texto) throws IOException {
        String cadena = "";
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        cadena += "[" + fechaHoraActual + "] : ";
        cadena += texto;
        return cadena;
    }

    public void cerrar() throws IOException {
        fileWriter.close();
    }

}
