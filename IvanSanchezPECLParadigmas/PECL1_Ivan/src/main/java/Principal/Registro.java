/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author isr10
 */
public class Registro {

    private Logger logger;
    FileHandler archivoManipulable;

    public Registro() {
        try {
            logger = Logger.getLogger("evolucionCartas");
            archivoManipulable = new FileHandler("C:\\Users\\isr10\\Documents\\NetBeansProjects\\PECL1_Ivan_Walter\\src\\main\\java\\Log\\evolucionCartas.txt");
            logger.addHandler(archivoManipulable);
            SimpleFormatter formato = new SimpleFormatter();
            archivoManipulable.setFormatter(formato);

        } catch (IOException ex) {

            logger.warning("ERROR:" + ex.getMessage());
        }
    }

    public void registroLog(String mensaje) {
        
        logger.info(mensaje);

    }

}
