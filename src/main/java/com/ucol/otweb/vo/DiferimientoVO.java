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
public class DiferimientoVO implements Serializable{
    private double saldoCapitalDesQna;
    private double intPagSdo;
    private double ivaPagadoSdo;
    private double sdoIntDesQna;
    private double sdoIvaDesQna;
    private int bndUltimoPagoRef;

    /**
     * @return the saldoCapitalDesQna
     */
    public double getSaldoCapitalDesQna() {
        return saldoCapitalDesQna;
    }

    /**
     * @param saldoCapitalDesQna the saldoCapitalDesQna to set
     */
    public void setSaldoCapitalDesQna(double saldoCapitalDesQna) {
        this.saldoCapitalDesQna = saldoCapitalDesQna;
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
     * @return the ivaPagadoSdo
     */
    public double getIvaPagadoSdo() {
        return ivaPagadoSdo;
    }

    /**
     * @param ivaPagadoSdo the ivaPagadoSdo to set
     */
    public void setIvaPagadoSdo(double ivaPagadoSdo) {
        this.ivaPagadoSdo = ivaPagadoSdo;
    }

    /**
     * @return the sdoIntDesQna
     */
    public double getSdoIntDesQna() {
        return sdoIntDesQna;
    }

    /**
     * @param sdoIntDesQna the sdoIntDesQna to set
     */
    public void setSdoIntDesQna(double sdoIntDesQna) {
        this.sdoIntDesQna = sdoIntDesQna;
    }

    /**
     * @return the sdoIvaDesQna
     */
    public double getSdoIvaDesQna() {
        return sdoIvaDesQna;
    }

    /**
     * @param sdoIvaDesQna the sdoIvaDesQna to set
     */
    public void setSdoIvaDesQna(double sdoIvaDesQna) {
        this.sdoIvaDesQna = sdoIvaDesQna;
    }

    /**
     * @return the bndUltimoPagoRef
     */
    public int getBndUltimoPagoRef() {
        return bndUltimoPagoRef;
    }

    /**
     * @param bndUltimoPagoRef the bndUltimoPagoRef to set
     */
    public void setBndUltimoPagoRef(int bndUltimoPagoRef) {
        this.bndUltimoPagoRef = bndUltimoPagoRef;
    }
}
