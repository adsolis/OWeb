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
public class FolioClaveVO implements Serializable {
    
    private Integer folio;
    private String clave;
    private int anio;
    private int tpoCred;

    /**
     * @return the folio
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @return the tpoCred
     */
    public int getTpoCred() {
        return tpoCred;
    }

    /**
     * @param tpoCred the tpoCred to set
     */
    public void setTpoCred(int tpoCred) {
        this.tpoCred = tpoCred;
    }
    
    
    
}
