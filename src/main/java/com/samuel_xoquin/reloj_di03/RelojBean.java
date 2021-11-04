package com.samuel_xoquin.reloj_di03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.Timer;

public class RelojBean extends JLabel implements Serializable, ActionListener {
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
    
    private Timer horaFinder;

    public RelojBean() {
        formato = FORMATO_24;
        horaFinder = new Timer(100, this);
        horaFinder.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        hora = LocalTime.now().getHour();
        minuto = LocalTime.now().getMinute();
        setText(getStringHora());
    }
    
    private String getStringHora(){
        int tHora = hora;
        if(hora>12 && formato == FORMATO_12) tHora=hora-12;
        return tHora+":"+minuto;
    }
    
}
