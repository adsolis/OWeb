/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

/**
 *
 * @author 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class RefinanciamientoVO implements Serializable{
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    private PrstamoOrigVO prstamoOrigVO;
    private ProyeccionVO proyeccionVO;
    private DirectoVO directoVO;
    private ProyeccionVO proyeccion;
    private int periodoDif;
    private Double mtoPago;
    private double ldSaldoRef;
    private Double ldCapRefinanc;
    private Double ldIntRefinanc;
    private Double ldIvaRefinanc;
    private int lsQnasf;
    private double ldAmtLastPmt;
    //lr_prstamo_ref.*,
    private double pagoRef1;
    private double pagoRef2;
    private double pagoRef3;
    private List<Double> numPresRef = new ArrayList<Double>();
    private boolean bandera;

    /**
     * @return the prstamoOrigVO
     */
    public PrstamoOrigVO getPrstamoOrigVO() {
        return prstamoOrigVO;
    }

    /**
     * @param prstamoOrigVO the prstamoOrigVO to set
     */
    public void setPrstamoOrigVO(PrstamoOrigVO prstamoOrigVO) {
        this.prstamoOrigVO = prstamoOrigVO;
    }

    /**
     * @return the proyeccionVO
     */
    public ProyeccionVO getProyeccionVO() {
        return proyeccionVO;
    }

    /**
     * @param proyeccionVO the proyeccionVO to set
     */
    public void setProyeccionVO(ProyeccionVO proyeccionVO) {
        this.proyeccionVO = proyeccionVO;
    }

    /**
     * @return the directoVO
     */
    public DirectoVO getDirectoVO() {
        return directoVO;
    }

    /**
     * @param directoVO the directoVO to set
     */
    public void setDirectoVO(DirectoVO directoVO) {
        this.directoVO = directoVO;
    }

    /**
     * @return the proyeccion
     */
    public ProyeccionVO getProyeccion() {
        return proyeccion;
    }

    /**
     * @param proyeccion the proyeccion to set
     */
    public void setProyeccion(ProyeccionVO proyeccion) {
        this.proyeccion = proyeccion;
    }

    /**
     * @return the periodoDif
     */
    public int getPeriodoDif() {
        return periodoDif;
    }

    /**
     * @param periodoDif the periodoDif to set
     */
    public void setPeriodoDif(int periodoDif) {
        this.periodoDif = periodoDif;
    }

    /**
     * @return the mtoPago
     */
    public Double getMtoPago() {
        return mtoPago;
    }

    /**
     * @param mtoPago the mtoPago to set
     */
    public void setMtoPago(Double mtoPago) {
        this.mtoPago = mtoPago;
    }

    /**
     * @return the ldSaldoRef
     */
    public double getLdSaldoRef() {
        return ldSaldoRef;
    }

    /**
     * @param ldSaldoRef the ldSaldoRef to set
     */
    public void setLdSaldoRef(double ldSaldoRef) {
        this.ldSaldoRef = ldSaldoRef;
    }

    /**
     * @return the ldCapRefinanc
     */
    public Double getLdCapRefinanc() {
        return ldCapRefinanc;
    }

    /**
     * @param ldCapRefinanc the ldCapRefinanc to set
     */
    public void setLdCapRefinanc(Double ldCapRefinanc) {
        this.ldCapRefinanc = ldCapRefinanc;
    }

    /**
     * @return the ldIntRefinanc
     */
    public Double getLdIntRefinanc() {
        return ldIntRefinanc;
    }

    /**
     * @param ldIntRefinanc the ldIntRefinanc to set
     */
    public void setLdIntRefinanc(Double ldIntRefinanc) {
        this.ldIntRefinanc = ldIntRefinanc;
    }

    /**
     * @return the ldIvaRefinanc
     */
    public Double getLdIvaRefinanc() {
        return ldIvaRefinanc;
    }

    /**
     * @param ldIvaRefinanc the ldIvaRefinanc to set
     */
    public void setLdIvaRefinanc(Double ldIvaRefinanc) {
        this.ldIvaRefinanc = ldIvaRefinanc;
    }

    /**
     * @return the lsQnasf
     */
    public int getLsQnasf() {
        return lsQnasf;
    }

    /**
     * @param lsQnasf the lsQnasf to set
     */
    public void setLsQnasf(int lsQnasf) {
        this.lsQnasf = lsQnasf;
    }

    /**
     * @return the ldAmtLastPmt
     */
    public double getLdAmtLastPmt() {
        return ldAmtLastPmt;
    }

    /**
     * @param ldAmtLastPmt the ldAmtLastPmt to set
     */
    public void setLdAmtLastPmt(double ldAmtLastPmt) {
        this.ldAmtLastPmt = ldAmtLastPmt;
    }

    /**
     * @return the pagoRef1
     */
    public double getPagoRef1() {
        return pagoRef1;
    }

    /**
     * @param pagoRef1 the pagoRef1 to set
     */
    public void setPagoRef1(double pagoRef1) {
        this.pagoRef1 = pagoRef1;
    }

    /**
     * @return the pagoRef2
     */
    public double getPagoRef2() {
        return pagoRef2;
    }

    /**
     * @param pagoRef2 the pagoRef2 to set
     */
    public void setPagoRef2(double pagoRef2) {
        this.pagoRef2 = pagoRef2;
    }

    /**
     * @return the pagoRef3
     */
    public double getPagoRef3() {
        return pagoRef3;
    }

    /**
     * @param pagoRef3 the pagoRef3 to set
     */
    public void setPagoRef3(double pagoRef3) {
        this.pagoRef3 = pagoRef3;
    }

    /**
     * @return the bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * @param bandera the bandera to set
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * @return the numPresRef
     */
    public List<Double> getNumPresRef() {
        return numPresRef;
    }

    /**
     * @param numPresRef the numPresRef to set
     */
    public void setNumPresRef(List<Double> numPresRef) {
        this.numPresRef = numPresRef;
    }
    
}
