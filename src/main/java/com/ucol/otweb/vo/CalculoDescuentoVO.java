/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class CalculoDescuentoVO implements Serializable {

    private double descuento;
    private double fiva;
    private double intPagSdo;
    private double intOrigSIVA;
    private double ivaOrig;
    private double r;
    private double rPrim;
    private double intDif;
    private double ivaDif;

    /**
     * @return the ivaOrig
     */
    public double getIvaOrig() {
        return ivaOrig;
    }

    /**
     * @param ivaOrig the ivaOrig to set
     */
    public void setIvaOrig(double ivaOrig) {
        this.ivaOrig = ivaOrig;
    }

    /**
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * @return the rPrim
     */
    public double getrPrim() {
        return rPrim;
    }

    /**
     * @param rPrim the rPrim to set
     */
    public void setrPrim(double rPrim) {
        this.rPrim = rPrim;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the fiva
     */
    public double getFiva() {
        return fiva;
    }

    /**
     * @param fiva the fiva to set
     */
    public void setFiva(double fiva) {
        this.fiva = fiva;
    }

    /**
     * @return the intPagSdo
     */
    public double getIntPagSdo() {
        return intPagSdo;
    }

    /**
     * @param intPagSdo the intPagSdo to set
     */
    public void setIntPagSdo(double intPagSdo) {
        this.intPagSdo = intPagSdo;
    }

    /**
     * @return the intOrigSIVA
     */
    public double getIntOrigSIVA() {
        return intOrigSIVA;
    }

    /**
     * @param intOrigSIVA the intOrigSIVA to set
     */
    public void setIntOrigSIVA(double intOrigSIVA) {
        this.intOrigSIVA = intOrigSIVA;
    }

    /**
     * @return the intDif
     */
    public double getIntDif() {
        return intDif;
    }

    /**
     * @param intDif the intDif to set
     */
    public void setIntDif(double intDif) {
        this.intDif = intDif;
    }

    /**
     * @return the ivaDif
     */
    public double getIvaDif() {
        return ivaDif;
    }

    /**
     * @param ivaDif the ivaDif to set
     */
    public void setIvaDif(double ivaDif) {
        this.ivaDif = ivaDif;
    }
}
