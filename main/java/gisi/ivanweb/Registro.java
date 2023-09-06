/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gisi.ivanweb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author isr10
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {

    private static final String enlace = "C:\\Users\\isr10\\Desktop\\Arquitectura Web Extraordinaria\\IvanWeb\\src\\main\\java\\gisi\\ivanweb\\logs\\log.txt";
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Registra un mensaje en el archivo de registro.
     * 
     * @param message el mensaje a registrar
     */
    public static void registroLog(String message) {
        String mensajeFormateado = String.format("[%s] %s%n", getCurrentTimestamp(), message);
        escribirArchivo(mensajeFormateado);
    }

    /**
     * Obtiene la marca de tiempo actual en el formato especificado.
     * 
     * @return la marca de tiempo actual formateada
     */
    private static String getCurrentTimestamp() {
        return LocalDateTime.now().format(formato);
    }

    /**
     * Escribe el mensaje en el archivo de registro.
     * 
     * @param message el mensaje a escribir
     */
    private static void escribirArchivo(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(enlace, true))) {
            writer.write(message);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de registro: " + e.getMessage());
        }
    }
}
