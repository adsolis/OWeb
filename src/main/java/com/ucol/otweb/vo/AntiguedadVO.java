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
public class AntiguedadVO implements Serializable{
    private static final long serialVersionUID = 1L; 

    private Number numIssste;
    private int numRamo;
    private Date fecIni;
    private Date fecFin;
    private String usuario;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the numIssste
     */
    public Number getNumIssste() {
        return numIssste;
    }

    /**
     * @param numIssste the numIssste to set
     */
    public void setNumIssste(Number numIssste) {
        this.numIssste = numIssste;
    }

    /**
     * @return the numRamo
     */
    public int getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(int numRamo) {
        this.numRamo = numRamo;
    }

    /**
     * @return the fecIni
     */
    public Date getFecIni() {
        return fecIni;
    }

    /**
     * @param fecIni the fecIni to set
     */
    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    /**
     * @return the fecFin
     */
    public Date getFecFin() {
        return fecFin;
    }

    /**
     * @param fecFin the fecFin to set
     */
    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the horaAud
     */
    public String getHoraAud() {
        return horaAud;
    }

    /**
     * @param horaAud the horaAud to set
     */
    public void setHoraAud(String horaAud) {
        this.horaAud = horaAud;
    }

    /**
     * @return the componenteCve
     */
    public String getComponenteCve() {
        return componenteCve;
    }

    /**
     * @param componenteCve the componenteCve to set
     */
    public void setComponenteCve(String componenteCve) {
        this.componenteCve = componenteCve;
    }

    /**
     * @return the ipEquipo
     */
    public String getIpEquipo() {
        return ipEquipo;
    }

    /**
     * @param ipEquipo the ipEquipo to set
     */
    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }
    
    
}
