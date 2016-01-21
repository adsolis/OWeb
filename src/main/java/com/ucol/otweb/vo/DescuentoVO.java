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
public class DescuentoVO implements Serializable{
    private double descuento;
    private double montoOtorgado;
    private double plazoOtorgado;
    private double numPagoAntProy;
    private double ultimoPagoProy;
    private int bndPrimas;
    private int bndUltimoPagoRef;
    private boolean validacionDscto;
    private CalculoDescuentoVO calculoDescuentoVO;
    private DescuentoProcVO descuentoProcVO;

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
     * @return the montoOtorgado
     */
    public double getMontoOtorgado() {
        return montoOtorgado;
    }

    /**
     * @param montoOtorgado the montoOtorgado to set
     */
    public void setMontoOtorgado(double montoOtorgado) {
        this.montoOtorgado = montoOtorgado;
    }

    /**
     * @return the plazoOtorgado
     */
    public double getPlazoOtorgado() {
        return plazoOtorgado;
    }

    /**
     * @param plazoOtorgado the plazoOtorgado to set
     */
    public void setPlazoOtorgado(double plazoOtorgado) {
        this.plazoOtorgado = plazoOtorgado;
    }

    /**
     * @return the numPagoAntProy
     */
    public double getNumPagoAntProy() {
        return numPagoAntProy;
    }

    /**
     * @param numPagoAntProy the numPagoAntProy to set
     */
    public void setNumPagoAntProy(double numPagoAntProy) {
        this.numPagoAntProy = numPagoAntProy;
    }

    /**
     * @return the ultimoPagoProy
     */
    public double getUltimoPagoProy() {
        return ultimoPagoProy;
    }

    /**
     * @param ultimoPagoProy the ultimoPagoProy to set
     */
    public void setUltimoPagoProy(double ultimoPagoProy) {
        this.ultimoPagoProy = ultimoPagoProy;
    }

    /**
     * @return the bndPrimas
     */
    public int getBndPrimas() {
        return bndPrimas;
    }

    /**
     * @param bndPrimas the bndPrimas to set
     */
    public void setBndPrimas(int bndPrimas) {
        this.bndPrimas = bndPrimas;
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

    /**
     * @return the validacionDscto
     */
    public boolean isValidacionDscto() {
        return validacionDscto;
    }

    /**
     * @param validacionDscto the validacionDscto to set
     */
    public void setValidacionDscto(boolean validacionDscto) {
        this.validacionDscto = validacionDscto;
    }

    /**
     * @return the calculoDescuentoVO
     */
    public CalculoDescuentoVO getCalculoDescuentoVO() {
        return calculoDescuentoVO;
    }

    /**
     * @param calculoDescuentoVO the calculoDescuentoVO to set
     */
    public void setCalculoDescuentoVO(CalculoDescuentoVO calculoDescuentoVO) {
        this.calculoDescuentoVO = calculoDescuentoVO;
    }

    /**
     * @return the descuentoProcVO
     */
    public DescuentoProcVO getDescuentoProcVO() {
        return descuentoProcVO;
    }

    /**
     * @param descuentoProcVO the descuentoProcVO to set
     */
    public void setDescuentoProcVO(DescuentoProcVO descuentoProcVO) {
        this.descuentoProcVO = descuentoProcVO;
    }
}
