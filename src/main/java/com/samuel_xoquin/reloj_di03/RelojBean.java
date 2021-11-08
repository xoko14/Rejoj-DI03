package com.samuel_xoquin.reloj_di03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class RelojBean extends JLabel implements Serializable, ActionListener {
    public static final boolean FORMATO_24 = false;
    public static final boolean FORMATO_12 = true;
    private AlarmaListener alarmaListener;
    
    private boolean formato;
    private boolean hayAlarma;
    private int hora;
    private int minuto;
    private String mensaje;
    private Alarma alarma;
    private String textoAlarma;

    // <editor-fold defaultstate="collapsed" desc="Getters y setters">    
    public boolean isFormato() {
        return formato;
    }

    public void setFormato(boolean formato) {
        this.formato = formato;
        pintar();
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

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
        if(alarma == null){
            hayAlarma = false;
        }
        else{
            hayAlarma = true;
        }
    }
    
    public String getTextoAlarma() {
        return textoAlarma;
    }

    public void setTextoAlarma(String textoAlarma) {
        this.textoAlarma = textoAlarma;
    }
    
    // </editor-fold>   
    
    
    private Timer horaFinder;
    private boolean sonoAlarma = false;

    public RelojBean() {
        formato = FORMATO_24;
        horaFinder = new Timer(100, this);
        horaFinder.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        hora = LocalTime.now().getHour();
        minuto = LocalTime.now().getMinute();
        pintar();
        
        if(hayAlarma && alarma.getHora()==hora && alarma.getMinuto()==minuto){
            if(!sonoAlarma ){
            alarmaListener.capturarAlarma(new AlarmaEvent(this));
            sonoAlarma = true;
            }
        }
        else{
            sonoAlarma = false;
        }
    }
    
    private String getStringHora(){
        int tHora = hora;
        if(hora>12 && formato == FORMATO_12) tHora=hora-12;
        return tHora+":"+minuto;
    }
    
    public interface AlarmaListener extends EventListener{
        public void capturarAlarma(AlarmaEvent ev);
    }
    
    public void addAlarmaListener(AlarmaListener alarmaListener){
        this.alarmaListener = alarmaListener;
    }

    public void removeAlarmaListener(AlarmaListener alarmaListener){
        this.alarmaListener=null;
    }
    
    public void pintar(){
        setText(getStringHora());
    }
}
