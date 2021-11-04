package com.samuel_xoquin.reloj_di03;

import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.Timer;

public class RelojBean extends JFrame implements Serializable {
    public static final boolean FORMATO_24 = false;
    public static final boolean FORMATO_12 = true;
    
    private boolean formato;
    private boolean hayAlarma;
    private int hora;
    private int minuto;
    private String mensaje;

    public boolean isFormato() {
        return formato;
    }

    public void setFormato(boolean formato) {
        this.formato = formato;
    }

    public boolean isHayAlarma() {
        return hayAlarma;
    }

    public void setHayAlarma(boolean hayAlarma) {
        this.hayAlarma = hayAlarma;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    private Timer tHora;
    private Timer tMin;

    public RelojBean() {
    }
    
    
}
