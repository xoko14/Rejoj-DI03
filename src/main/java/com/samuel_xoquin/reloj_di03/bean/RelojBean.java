package com.samuel_xoquin.reloj_di03.bean;

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

    /**
     * Establece el formato de la hora (24 o 12h) y actualiza el texto
     * del JLabel para que el cambio de formato tome efecto para el ususario.
     * @param formato 
     */
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

    /**
     * Cambia el valor de la alarma y actualiza la flag hayAlarma consecuentemente.
     * @param alarma 
     */
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

    /**
     * Constructor por defecto. Pone el formato de 24h. Instancia e inicia
     * el temporizador que actualiza la hora.
     */
    public RelojBean() {
        formato = FORMATO_24;
        
        //Puesto cada 100ms para minimizar el desfase con la hora real que se podría dar.
        horaFinder = new Timer(100, this);
        horaFinder.start();
    }
    
    /**
     * Obtiene la hora y minuto actuales. Actualiza el texto del JLabel.
     * Comprueba si la hora actual coincide con la de la alarma programada (si 
     * es que está activada), en cuyo caso lanza el evento de alarma.
     * @param e 
     */
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
    
    /**
     * Formatea la hora actual de acuerdo con el modo de formato
     * definido (24 o 12h).
     * @return String con la hora actual formateada
     */
    private String getStringHora(){
        int tHora = hora;
        if(hora>12 && formato == FORMATO_12) tHora=hora-12;
        return String.format("%02d:%02d", tHora, minuto);
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
    
    /**
     * Pone el texto del JLabel a la hora actual con formato.
     */
    public void pintar(){
        setText(getStringHora());
    }
}
