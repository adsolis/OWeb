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
public class DescuentoProcVO implements Serializable{
    private double r;
    private double rprim;
    private double tasaInt;
    private int cveTcr;
    private double capacidadPago;
    private double descuento;
    private double montoOtorg;
    private double plazoOtorg;
    private int dif;
    private int tnoCve;
    private int cveEntidad;
    private int cp;
    private int refinancia;
    private int qnasF;
    private double amtLastPmt;
    private double ultPagoRef;
    private String fechaFinRef;
    private double sdoCapDesQna;
    private double intPagSdo;
    private double ivaPagSdo;
    private double sdoIntdesQna;
    private double sdoIvadesQna;

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
     * @return the rprim
     */
    public double getRprim() {
        return rprim;
    }

    /**
     * @param rprim the rprim to set
     */
    public void setRprim(double rprim) {
        this.rprim = rprim;
    }

    /**
     * @return the tasaInt
     */
    public double getTasaInt() {
        return tasaInt;
    }

    /**
     * @param tasaInt the tasaInt to set
     */
    public void setTasaInt(double tasaInt) {
        this.tasaInt = tasaInt;
    }

    /**
     * @return the cveTcr
     */
    public int getCveTcr() {
        return cveTcr;
    }

    /**
     * @param cveTcr the cveTcr to set
     */
    public void setCveTcr(int cveTcr) {
        this.cveTcr = cveTcr;
    }

    /**
     * @return the capacidadPago
     */
    public double getCapacidadPago() {
        return capacidadPago;
    }

    /**
     * @param capacidadPago the capacidadPago to set
     */
    public void setCapacidadPago(double capacidadPago) {
        this.capacidadPago = capacidadPago;
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
     * @return the montoOtorg
     */
    public double getMontoOtorg() {
        return montoOtorg;
    }

    /**
     * @param montoOtorg the montoOtorg to set
     */
    public void setMontoOtorg(double montoOtorg) {
        this.montoOtorg = montoOtorg;
    }

    /**
     * @return the plazoOtorg
     */
    public double getPlazoOtorg() {
        return plazoOtorg;
    }

    /**
     * @param plazoOtorg the plazoOtorg to set
     */
    public void setPlazoOtorg(double plazoOtorg) {
        this.plazoOtorg = plazoOtorg;
    }

    /**
     * @return the dif
     */
    public int getDif() {
        return dif;
    }

    /**
     * @param dif the dif to set
     */
    public void setDif(int dif) {
        this.dif = dif;
    }

    /**
     * @return the tnoCve
     */
    public int getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(int tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the cveEntidad
     */
    public int getCveEntidad() {
        return cveEntidad;
    }

    /**
     * @param cveEntidad the cveEntidad to set
     */
    public void setCveEntidad(int cveEntidad) {
        this.cveEntidad = cveEntidad;
    }

    /**
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * @return the refinancia
     */
    public int getRefinancia() {
        return refinancia;
    }

    /**
     * @param refinancia the refinancia to set
     */
    public void setRefinancia(int refinancia) {
        this.refinancia = refinancia;
    }

    /**
     * @return the qnasF
     */
    public int getQnasF() {
        return qnasF;
    }

    /**
     * @param qnasF the qnasF to set
     */
    public void setQnasF(int qnasF) {
        this.qnasF = qnasF;
    }

    /**
     * @return the amtLastPmt
     */
    public double getAmtLastPmt() {
        return amtLastPmt;
    }

    /**
     * @param amtLastPmt the amtLastPmt to set
     */
    public void setAmtLastPmt(double amtLastPmt) {
        this.amtLastPmt = amtLastPmt;
    }

    /**
     * @return the ultPagoRef
     */
    public double getUltPagoRef() {
        return ultPagoRef;
    }

    /**
     * @param ultPagoRef the ultPagoRef to set
     */
    public void setUltPagoRef(double ultPagoRef) {
        this.ultPagoRef = ultPagoRef;
    }

    /**
     * @return the fechaFinRef
     */
    public String getFechaFinRef() {
        return fechaFinRef;
    }

    /**
     * @param fechaFinRef the fechaFinRef to set
     */
    public void setFechaFinRef(String fechaFinRef) {
        this.fechaFinRef = fechaFinRef;
    }

    /**
     * @return the sdoCapDesQna
     */
    public double getSdoCapDesQna() {
        return sdoCapDesQna;
    }

    /**
     * @param sdoCapDesQna the sdoCapDesQna to set
     */
    public void setSdoCapDesQna(double sdoCapDesQna) {
        this.sdoCapDesQna = sdoCapDesQna;
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
     * @return the ivaPagSdo
     */
    public double getIvaPagSdo() {
        return ivaPagSdo;
    }

    /**
     * @param ivaPagSdo the ivaPagSdo to set
     */
    public void setIvaPagSdo(double ivaPagSdo) {
        this.ivaPagSdo = ivaPagSdo;
    }

    /**
     * @return the sdoIntdesQna
     */
    public double getSdoIntdesQna() {
        return sdoIntdesQna;
    }

    /**
     * @param sdoIntdesQna the sdoIntdesQna to set
     */
    public void setSdoIntdesQna(double sdoIntdesQna) {
        this.sdoIntdesQna = sdoIntdesQna;
    }

    /**
     * @return the sdoIvadesQna
     */
    public double getSdoIvadesQna() {
        return sdoIvadesQna;
    }

    /**
     * @param sdoIvadesQna the sdoIvadesQna to set
     */
    public void setSdoIvadesQna(double sdoIvadesQna) {
        this.sdoIvadesQna = sdoIvadesQna;
    }
    
}
