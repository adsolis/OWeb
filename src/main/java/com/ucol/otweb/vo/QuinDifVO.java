/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */
public class QuinDifVO {
    private int quinDif;
    private QnaVO quinFin;
    private int dias;

    /**
     * @return the quinDif
     */
    public int getQuinDif() {
        return quinDif;
    }

    /**
     * @param quinDif the quinDif to set
     */
    public void setQuinDif(int quinDif) {
        this.quinDif = quinDif;
    }

    /**
     * @return the quinFin
     */
    public QnaVO getQuinFin() {
        return quinFin;
    }

    /**
     * @param quinFin the quinFin to set
     */
    public void setQuinFin(QnaVO quinFin) {
        this.quinFin = quinFin;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
    }
}
