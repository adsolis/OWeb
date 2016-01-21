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
public class CDelegacionVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveEntidad;
    private int cveDeleg;
    private String descDeleg;
    private String statDeleg;
    private String usuario;
    private Date fechAud;
    private String componenteCve;
    private String ipEquipo;
    private String ipServidorDel;

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
     * @return the cveDeleg
     */
    public int getCveDeleg() {
        return cveDeleg;
    }

    /**
     * @param cveDeleg the cveDeleg to set
     */
    public void setCveDeleg(int cveDeleg) {
        this.cveDeleg = cveDeleg;
    }

    /**
     * @return the descDeleg
     */
    public String getDescDeleg() {
        return descDeleg;
    }

    /**
     * @param descDeleg the descDeleg to set
     */
    public void setDescDeleg(String descDeleg) {
        this.descDeleg = descDeleg;
    }

    /**
     * @return the statDeleg
     */
    public String getStatDeleg() {
        return statDeleg;
    }

    /**
     * @param statDeleg the statDeleg to set
     */
    public void setStatDeleg(String statDeleg) {
        this.statDeleg = statDeleg;
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
     * @return the fechAud
     */
    public Date getFechAud() {
        return fechAud;
    }

    /**
     * @param fechAud the fechAud to set
     */
    public void setFechAud(Date fechAud) {
        this.fechAud = fechAud;
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

    /**
     * @return the ipServidorDel
     */
    public String getIpServidorDel() {
        return ipServidorDel;
    }

    /**
     * @param ipServidorDel the ipServidorDel to set
     */
    public void setIpServidorDel(String ipServidorDel) {
        this.ipServidorDel = ipServidorDel;
    }
    
    
    
    
}
