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
public class OtorgamWebContad implements Serializable{
    private static final long serialVersionUID = 1L;
    private Date fecha;
    private Integer contador;
    private String usuario;
    private Date fecha_aud;
    private String componente_cve;
    private String ip_equipo;

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the contador
     */
    public Integer getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(Integer contador) {
        this.contador = contador;
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
     * @return the fecha_aud
     */
    public Date getFecha_aud() {
        return fecha_aud;
    }

    /**
     * @param fecha_aud the fecha_aud to set
     */
    public void setFecha_aud(Date fecha_aud) {
        this.fecha_aud = fecha_aud;
    }

    /**
     * @return the componente_cve
     */
    public String getComponente_cve() {
        return componente_cve;
    }

    /**
     * @param componente_cve the componente_cve to set
     */
    public void setComponente_cve(String componente_cve) {
        this.componente_cve = componente_cve;
    }

    /**
     * @return the ip_equipo
     */
    public String getIp_equipo() {
        return ip_equipo;
    }

    /**
     * @param ip_equipo the ip_equipo to set
     */
    public void setIp_equipo(String ip_equipo) {
        this.ip_equipo = ip_equipo;
    }
    
    
}
