package com.ucol.otweb.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 */
public class CRechazoWebVO implements Serializable{
    private int cveMotivo;
    private String descRechazo;
    private String tipoMotivo;
    private String statMotivo;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;

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
     * @return the descRechazo
     */
    public String getDescRechazo() {
        return descRechazo;
    }

    /**
     * @param descRechazo the descRechazo to set
     */
    public void setDescRechazo(String descRechazo) {
        this.descRechazo = descRechazo;
    }

    /**
     * @return the tipoMotivo
     */
    public String getTipoMotivo() {
        return tipoMotivo;
    }

    /**
     * @param tipoMotivo the tipoMotivo to set
     */
    public void setTipoMotivo(String tipoMotivo) {
        this.tipoMotivo = tipoMotivo;
    }

    /**
     * @return the statMotivo
     */
    public String getStatMotivo() {
        return statMotivo;
    }

    /**
     * @param statMotivo the statMotivo to set
     */
    public void setStatMotivo(String statMotivo) {
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
