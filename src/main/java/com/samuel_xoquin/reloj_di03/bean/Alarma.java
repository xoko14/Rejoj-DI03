/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samuel_xoquin.reloj_di03.bean;

/**
 *
 * @author xoquin
 */
public class Alarma {
    private int hora;
    private int minuto;

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

    public Alarma(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
}
