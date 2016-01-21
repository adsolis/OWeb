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
public class PrestoAnualVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer numVersion;
    private String tpoPresto;
    private int entTcr;
    private int numMes;
    private Double totalPresto;
    private Integer totCreditos;
    private Double ejerCosto;
    private Double compPorcent;
    private String status;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the numVersion
     */
    public Integer getNumVersion() {
        return numVersion;
    }

    /**
     * @param numVersion the numVersion to set
     */
    public void setNumVersion(Integer numVersion) {
        this.numVersion = numVersion;
    }

    /**
     * @return the tpoPresto
     */
    public String getTpoPresto() {
        return tpoPresto;
    }

    /**
     * @param tpoPresto the tpoPresto to set
     */
    public void setTpoPresto(String tpoPresto) {
        this.tpoPresto = tpoPresto;
    }

    /**
     * @return the entTcr
     */
    public int getEntTcr() {
        return entTcr;
    }

    /**
     * @param entTcr the entTcr to set
     */
    public void setEntTcr(int entTcr) {
        this.entTcr = entTcr;
    }

    /**
     * @return the numMes
     */
    public int getNumMes() {
        return numMes;
    }

    /**
     * @param numMes the numMes to set
     */
    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }

    /**
     * @return the totalPresto
     */
    public Double getTotalPresto() {
        return totalPresto;
    }

    /**
     * @param totalPresto the totalPresto to set
     */
    public void setTotalPresto(Double totalPresto) {
        this.totalPresto = totalPresto;
    }

    /**
     * @return the totCreditos
     */
    public Integer getTotCreditos() {
        return totCreditos;
    }

    /**
     * @param totCreditos the totCreditos to set
     */
    public void setTotCreditos(Integer totCreditos) {
        this.totCreditos = totCreditos;
    }

    /**
     * @return the ejerCosto
     */
    public Double getEjerCosto() {
        return ejerCosto;
    }

    /**
     * @param ejerCosto the ejerCosto to set
     */
    public void setEjerCosto(Double ejerCosto) {
        this.ejerCosto = ejerCosto;
    }

    /**
     * @return the compPorcent
     */
    public Double getCompPorcent() {
        return compPorcent;
    }

    /**
     * @param compPorcent the compPorcent to set
     */
    public void setCompPorcent(Double compPorcent) {
        this.compPorcent = compPorcent;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
