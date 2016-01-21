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
public class MotivosSolVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    
    private int anioSol;
    private Integer folioSol;
    private int cveTcr;
    private int cveMotivo;
    private int statMotivo;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the anioSol
     */
    public int getAnioSol() {
        return anioSol;
    }

    /**
     * @param anioSol the anioSol to set
     */
    public void setAnioSol(int anioSol) {
        this.anioSol = anioSol;
    }

    /**
     * @return the folioSol
     */
    public Integer getFolioSol() {
        return folioSol;
    }

    /**
     * @param folioSol the folioSol to set
     */
    public void setFolioSol(Integer folioSol) {
        this.folioSol = folioSol;
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
     * @return the cveMotivo
     */
    public int getCveMotivo() {
        return cveMotivo;
    }

    /**
     * @param cveMotivo the cveMotivo to set
     */
    public void setCveMotivo(int cveMotivo) {
        this.cveMotivo = cveMotivo;
    }

    /**
     * @return the statMotivo
     */
    public int getStatMotivo() {
        return statMotivo;
    }

    /**
     * @param statMotivo the statMotivo to set
     */
    public void setStatMotivo(int statMotivo) {
        this.statMotivo = statMotivo;
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
