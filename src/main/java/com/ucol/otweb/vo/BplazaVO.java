/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 */
public class BplazaVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer numRamo;
    private String numPagaduria;
    private Integer numIssste;
    private Date fechaAud;
    private int tnoCve;
    private Double sueldoDer;

    /**
     * @return the numIssste
     */
    public Integer getNumIssste() {
        return numIssste;
    }

    /**
     * @param numIssste the numIssste to set
     */
    public void setNumIssste(Integer numIssste) {
        this.numIssste = numIssste;
    }

    /**
     * @return the numRamo
     */
    public Integer getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(Integer numRamo) {
        this.numRamo = numRamo;
    }

    /**
     * @return the numPagaduria
     */
    public String getNumPagaduria() {
        return numPagaduria;
    }

    /**
     * @param numPagaduria the numPagaduria to set
     */
    public void setNumPagaduria(String numPagaduria) {
        this.numPagaduria = numPagaduria;
    }

    /**
     * @return the fechaAud
     */
    public Date getFechaAud() {
        return fechaAud;
    }

    /**
     * @param fechaAud the fechaAud to set
     */
    public void setFechaAud(Date fechaAud) {
        this.fechaAud = fechaAud;
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
     * @return the sueldoDer
     */
    public Double getSueldoDer() {
        return sueldoDer;
    }

    /**
     * @param sueldoDer the sueldoDer to set
     */
    public void setSueldoDer(Double sueldoDer) {
        this.sueldoDer = sueldoDer;
    }
}
