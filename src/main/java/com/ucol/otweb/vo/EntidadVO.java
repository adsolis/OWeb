/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.sql.Date;

/**
 *
 * @author 
 */
public class EntidadVO implements java.io.Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    private Integer cveEntidad;
    private String descEntidad;
    private String abvEntidad;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the cveEntidad
     */
    public Integer getCveEntidad() {
        return cveEntidad;
    }

    /**
     * @param cveEntidad the cveEntidad to set
     */
    public void setCveEntidad(Integer cveEntidad) {
        this.cveEntidad = cveEntidad;
    }

    /**
     * @return the descEntidad
     */
    public String getDescEntidad() {
        return descEntidad;
    }

    /**
     * @param descEntidad the descEntidad to set
     */
    public void setDescEntidad(String descEntidad) {
        this.descEntidad = descEntidad;
    }

    /**
     * @return the abvEntidad
     */
    public String getAbvEntidad() {
        return abvEntidad;
    }

    /**
     * @param abvEntidad the abvEntidad to set
     */
    public void setAbvEntidad(String abvEntidad) {
        this.abvEntidad = abvEntidad;
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
