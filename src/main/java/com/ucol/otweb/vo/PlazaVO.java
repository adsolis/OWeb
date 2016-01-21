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
public class PlazaVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    private Double numRamo;
    private String numPagaduria;
    private Number numIssste;
    private String uVersion;
    private Number tnoCve;
    private String cpaCve;
    private String sinCve;
    private String ssnCve;
    private Number disCve;
    private Number ptoCve;
    private Number nsaCve;
    private Date fechaAlta;
    private Date fechaMs;
    private Double sueldoIssste;
    private Double sueldoSar;
    private Double remuneracnTotal;
    private String cobroCve;
    private String plzEstado;
    private String usuario;
    private Date fechaAud;
    private String horaAud;
    private String componenteCve;
    private String ipMaquina;
    private Number modCve;
    private Number ramoAnterior;

    /**
     * @return the numRamo
     */
    public Double getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(Double numRamo) {
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
     * @return the cpaCve
     */
    public String getCpaCve() {
        return cpaCve;
    }

    /**
     * @param cpaCve the cpaCve to set
     */
    public void setCpaCve(String cpaCve) {
        this.cpaCve = cpaCve;
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
     * @return the ptoCve
     */
    public Number getPtoCve() {
        return ptoCve;
    }

    /**
     * @param ptoCve the ptoCve to set
     */
    public void setPtoCve(Number ptoCve) {
        this.ptoCve = ptoCve;
    }

    /**
     * @return the nsaCve
     */
    public Number getNsaCve() {
        return nsaCve;
    }

    /**
     * @param nsaCve the nsaCve to set
     */
    public void setNsaCve(Number nsaCve) {
        this.nsaCve = nsaCve;
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
     * @return the fechaMs
     */
    public Date getFechaMs() {
        return fechaMs;
    }

    /**
     * @param fechaMs the fechaMs to set
     */
    public void setFechaMs(Date fechaMs) {
        this.fechaMs = fechaMs;
    }

    /**
     * @return the sueldoIssste
     */
    public Double getSueldoIssste() {
        return sueldoIssste;
    }

    /**
     * @param sueldoIssste the sueldoIssste to set
     */
    public void setSueldoIssste(Double sueldoIssste) {
        this.sueldoIssste = sueldoIssste;
    }

    /**
     * @return the sueldoSar
     */
    public Double getSueldoSar() {
        return sueldoSar;
    }

    /**
     * @param sueldoSar the sueldoSar to set
     */
    public void setSueldoSar(Double sueldoSar) {
        this.sueldoSar = sueldoSar;
    }

    /**
     * @return the remuneracnTotal
     */
    public Double getRemuneracnTotal() {
        return remuneracnTotal;
    }

    /**
     * @param remuneracnTotal the remuneracnTotal to set
     */
    public void setRemuneracnTotal(Double remuneracnTotal) {
        this.remuneracnTotal = remuneracnTotal;
    }

    /**
     * @return the cobroCve
     */
    public String getCobroCve() {
        return cobroCve;
    }

    /**
     * @param cobroCve the cobroCve to set
     */
    public void setCobroCve(String cobroCve) {
        this.cobroCve = cobroCve;
    }

    /**
     * @return the plzEstado
     */
    public String getPlzEstado() {
        return plzEstado;
    }

    /**
     * @param plzEstado the plzEstado to set
     */
    public void setPlzEstado(String plzEstado) {
        this.plzEstado = plzEstado;
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
     * @return the modCve
     */
    public Number getModCve() {
        return modCve;
    }

    /**
     * @param modCve the modCve to set
     */
    public void setModCve(Number modCve) {
        this.modCve = modCve;
    }

    /**
     * @return the ramoAnterior
     */
    public Number getRamoAnterior() {
        return ramoAnterior;
    }

    /**
     * @param ramoAnterior the ramoAnterior to set
     */
    public void setRamoAnterior(Number ramoAnterior) {
        this.ramoAnterior = ramoAnterior;
    }
    
    
    
}
