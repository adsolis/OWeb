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
public class CtnoCveVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 

    private Number tnoCve;
    private String descripcion;
    private Number tnoCveSic;
    private String descripcionSic;
    private String usuario;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String ipEquipo;

    /**
     * @return the tnoCve
     */
    public Number getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(Number tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tnoCveSic
     */
    public Number getTnoCveSic() {
        return tnoCveSic;
    }

    /**
     * @param tnoCveSic the tnoCveSic to set
     */
    public void setTnoCveSic(Number tnoCveSic) {
        this.tnoCveSic = tnoCveSic;
    }

    /**
     * @return the descripcionSic
     */
    public String getDescripcionSic() {
        return descripcionSic;
    }

    /**
     * @param descripcionSic the descripcionSic to set
     */
    public void setDescripcionSic(String descripcionSic) {
        this.descripcionSic = descripcionSic;
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
