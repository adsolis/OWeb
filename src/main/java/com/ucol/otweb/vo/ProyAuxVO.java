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
public class ProyAuxVO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int liPrestamos;
    private double ldCappagado;
    private double ldIntganado;
    private double ldIntpagado;
    private double ldIvaganado;
    private double ldIvapagado;
    private int idPosicion;

    /**
     * @return the liPrestamos
     */
    public int getLiPrestamos() {
        return liPrestamos;
    }

    /**
     * @param liPrestamos the liPrestamos to set
     */
    public void setLiPrestamos(int liPrestamos) {
        this.liPrestamos = liPrestamos;
    }

    /**
     * @return the ldCappagado
     */
    public double getLdCappagado() {
        return ldCappagado;
    }

    /**
     * @param ldCappagado the ldCappagado to set
     */
    public void setLdCappagado(double ldCappagado) {
        this.ldCappagado = ldCappagado;
    }

    /**
     * @return the ldIntganado
     */
    public double getLdIntganado() {
        return ldIntganado;
    }

    /**
     * @param ldIntganado the ldIntganado to set
     */
    public void setLdIntganado(double ldIntganado) {
        this.ldIntganado = ldIntganado;
    }

    /**
     * @return the ldIntpagado
     */
    public double getLdIntpagado() {
        return ldIntpagado;
    }

    /**
     * @param ldIntpagado the ldIntpagado to set
     */
    public void setLdIntpagado(double ldIntpagado) {
        this.ldIntpagado = ldIntpagado;
    }

    /**
     * @return the ldIvaganado
     */
    public double getLdIvaganado() {
        return ldIvaganado;
    }

    /**
     * @param ldIvaganado the ldIvaganado to set
     */
    public void setLdIvaganado(double ldIvaganado) {
        this.ldIvaganado = ldIvaganado;
    }

    /**
     * @return the ldIvapagado
     */
    public double getLdIvapagado() {
        return ldIvapagado;
    }

    /**
     * @param ldIvapagado the ldIvapagado to set
     */
    public void setLdIvapagado(double ldIvapagado) {
        this.ldIvapagado = ldIvapagado;
    }

    /**
     * @return the idPosicion
     */
    public int getIdPosicion() {
        return idPosicion;
    }

    /**
     * @param idPosicion the idPosicion to set
     */
    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
    }

   
    
    
    
    
}
