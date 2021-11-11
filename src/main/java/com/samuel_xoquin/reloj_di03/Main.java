package com.samuel_xoquin.reloj_di03;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

/**
 *
 * @author Samuel González y Xoquín Pérez
 */
public class Main {

    public static void main(String[] args) {    
        //establecer tema
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar el tema");
        }
        
        //mostrar ventana
        FrameReloj fr = new FrameReloj();
        fr.setVisible(true);
    }
    
}
