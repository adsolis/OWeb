/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author 
 */
public class CSicParamVO implements Serializable {

    private Integer numSic;
    private Integer usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the numSic
     */
    public Integer getNumSic() {
        return numSic;
    }

    /**
     * @param numSic the numSic to set
     */
    public void setNumSic(Integer numSic) {
        this.numSic = numSic;
    }

    /**
     * @return the usuario
     */
    public Integer getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Integer usuario) {
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
