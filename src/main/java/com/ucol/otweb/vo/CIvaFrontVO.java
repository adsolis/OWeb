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
public class CIvaFrontVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer entIva;
    private Integer codPosIva;
    private Date fechaActIva;
    private String cveProgIva;
    private String ipIva;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the entIva
     */
    public Integer getEntIva() {
        return entIva;
    }

    /**
     * @param entIva the entIva to set
     */
    public void setEntIva(Integer entIva) {
        this.entIva = entIva;
    }

    /**
     * @return the codPosIva
     */
    public Integer getCodPosIva() {
        return codPosIva;
    }

    /**
     * @param codPosIva the codPosIva to set
     */
    public void setCodPosIva(Integer codPosIva) {
        this.codPosIva = codPosIva;
    }

    /**
     * @return the fechaActIva
     */
    public Date getFechaActIva() {
        return fechaActIva;
    }

    /**
     * @param fechaActIva the fechaActIva to set
     */
    public void setFechaActIva(Date fechaActIva) {
        this.fechaActIva = fechaActIva;
    }

    /**
     * @return the cveProgIva
     */
    public String getCveProgIva() {
        return cveProgIva;
    }

    /**
     * @param cveProgIva the cveProgIva to set
     */
    public void setCveProgIva(String cveProgIva) {
        this.cveProgIva = cveProgIva;
    }

    /**
     * @return the ipIva
     */
    public String getIpIva() {
        return ipIva;
    }

    /**
     * @param ipIva the ipIva to set
     */
    public void setIpIva(String ipIva) {
        this.ipIva = ipIva;
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
