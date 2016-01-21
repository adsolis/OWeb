/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;

/**
 *  VO para contener la informacion de el calculo de la antiguedad
 * @author 
 */
public class CAntiguedadVO implements Serializable {

    private int anio;
    private int mes;
    private int dia;
    private int antiguedad;
    private boolean consistenciaParamOtorg;
    private boolean antiguedadPermitida;
    

    public CAntiguedadVO() {
    }

    public CAntiguedadVO(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the consistenciaParamOtorg
     */
    public boolean isConsistenciaParamOtorg() {
        return consistenciaParamOtorg;
    }

    /**
     * @param consistenciaParamOtorg the consistenciaParamOtorg to set
     */
    public void setConsistenciaParamOtorg(boolean consistenciaParamOtorg) {
        this.consistenciaParamOtorg = consistenciaParamOtorg;
    }

    /**
     * @return the antiguedadPermitida
     */
    public boolean isAntiguedadPermitida() {
        return antiguedadPermitida;
    }

    /**
     * @param antiguedadPermitida the antiguedadPermitida to set
     */
    public void setAntiguedadPermitida(boolean antiguedadPermitida) {
        this.antiguedadPermitida = antiguedadPermitida;
    }

    /**
     * @return the antiguedad
     */
    public int getAntiguedad() {
        return antiguedad;
    }

    /**
     * @param antiguedad the antiguedad to set
     */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
