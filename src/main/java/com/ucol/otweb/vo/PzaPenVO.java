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
public class PzaPenVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    
    private Number numRamo;
    private String numPagaduria;
    private Number numIssste;
    private Number numPension;
    private String uVersion;
    private String sinCve;
    private String ssnCve;
    private Number disCve;
    private Double imptPension;
    private Number numPensionista;
    private Number tPension;
    private String ppnEstado;
    private Date fechaAlta;
    private Date fechaBaja;
    private Date fechaMovto;
    private String usuario;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String ipMaquina;
    private Integer numRamoAnt;

    /**
     * @return the numRamo
     */
    public Number getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(Number numRamo) {
        this.numRamo = numRamo;
    }

    /**
     * @return the numPagaduria
     */
    public String getNumPagaduria() {
        return numPagaduria;
    }

    /**
     * @param numPagaduria the numPagaduria to set
     */
    public void setNumPagaduria(String numPagaduria) {
        this.numPagaduria = numPagaduria;
    }

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
     * @return the numPension
     */
    public Number getNumPension() {
        return numPension;
    }

    /**
     * @param numPension the numPension to set
     */
    public void setNumPension(Number numPension) {
        this.numPension = numPension;
    }

    /**
     * @return the uVersion
     */
    public String getuVersion() {
        return uVersion;
    }

    /**
     * @param uVersion the uVersion to set
     */
    public void setuVersion(String uVersion) {
        this.uVersion = uVersion;
    }

    /**
     * @return the sinCve
     */
    public String getSinCve() {
        return sinCve;
    }

    /**
     * @param sinCve the sinCve to set
     */
    public void setSinCve(String sinCve) {
        this.sinCve = sinCve;
    }

    /**
     * @return the ssnCve
     */
    public String getSsnCve() {
        return ssnCve;
    }

    /**
     * @param ssnCve the ssnCve to set
     */
    public void setSsnCve(String ssnCve) {
        this.ssnCve = ssnCve;
    }

    /**
     * @return the disCve
     */
    public Number getDisCve() {
        return disCve;
    }

    /**
     * @param disCve the disCve to set
     */
    public void setDisCve(Number disCve) {
        this.disCve = disCve;
    }

    /**
     * @return the imptPension
     */
    public Double getImptPension() {
        return imptPension;
    }

    /**
     * @param imptPension the imptPension to set
     */
    public void setImptPension(Double imptPension) {
        this.imptPension = imptPension;
    }

    /**
     * @return the numPensionista
     */
    public Number getNumPensionista() {
        return numPensionista;
    }

    /**
     * @param numPensionista the numPensionista to set
     */
    public void setNumPensionista(Number numPensionista) {
        this.numPensionista = numPensionista;
    }

    /**
     * @return the tPension
     */
    public Number gettPension() {
        return tPension;
    }

    /**
     * @param tPension the tPension to set
     */
    public void settPension(Number tPension) {
        this.tPension = tPension;
    }

    /**
     * @return the ppnEstado
     */
    public String getPpnEstado() {
        return ppnEstado;
    }

    /**
     * @param ppnEstado the ppnEstado to set
     */
    public void setPpnEstado(String ppnEstado) {
        this.ppnEstado = ppnEstado;
    }

    /**
     * @return the fechaAlta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta the fechaAlta to set
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * @return the fechaBaja
     */
    public Date getFechaBaja() {
        return fechaBaja;
    }

    /**
     * @param fechaBaja the fechaBaja to set
     */
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     * @return the fechaMovto
     */
    public Date getFechaMovto() {
        return fechaMovto;
    }

    /**
     * @param fechaMovto the fechaMovto to set
     */
    public void setFechaMovto(Date fechaMovto) {
        this.fechaMovto = fechaMovto;
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
     * @return the ipMaquina
     */
    public String getIpMaquina() {
        return ipMaquina;
    }

    /**
     * @param ipMaquina the ipMaquina to set
     */
    public void setIpMaquina(String ipMaquina) {
        this.ipMaquina = ipMaquina;
    }

    /**
     * @return the numRamoAnt
     */
    public Integer getNumRamoAnt() {
        return numRamoAnt;
    }
    
    /**
     * @param numRamoAnt the numRamoAnt to set
     */
    public void setNumRamoAnt(Integer numRamoAnt) {
        this.numRamoAnt = numRamoAnt;
    }
    
    
    
}
