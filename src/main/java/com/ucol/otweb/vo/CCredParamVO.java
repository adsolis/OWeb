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
public class CCredParamVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private int cveTcr;
    private int tnoCve;
    private Double tasaMin;
    private Double tasaMax;
    private String factPlazo;
    private int plazoCre;
    private String factMonto;
    private Double montoCre;
    private String statCre;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;
    private String statCondic;
    private Double primaGarant;
    private Double tasaInt;
    

    /**
     * @return the cveTcr
     */
    public int getCveTcr() {
        return cveTcr;
    }

    /**
     * @param cveTcr the cveTcr to set
     */
    public void setCveTcr(int cveTcr) {
        this.cveTcr = cveTcr;
    }

    /**
     * @return the tnoCve
     */
    public int getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(int tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the tasaMin
     */
    public Double getTasaMin() {
        return tasaMin;
    }

    /**
     * @param tasaMin the tasaMin to set
     */
    public void setTasaMin(Double tasaMin) {
        this.tasaMin = tasaMin;
    }

    /**
     * @return the tasaMax
     */
    public Double getTasaMax() {
        return tasaMax;
    }

    /**
     * @param tasaMax the tasaMax to set
     */
    public void setTasaMax(Double tasaMax) {
        this.tasaMax = tasaMax;
    }

    /**
     * @return the factPlazo
     */
    public String getFactPlazo() {
        return factPlazo;
    }

    /**
     * @param factPlazo the factPlazo to set
     */
    public void setFactPlazo(String factPlazo) {
        this.factPlazo = factPlazo;
    }

    /**
     * @return the plazoCre
     */
    public int getPlazoCre() {
        return plazoCre;
    }

    /**
     * @param plazoCre the plazoCre to set
     */
    public void setPlazoCre(int plazoCre) {
        this.plazoCre = plazoCre;
    }

    /**
     * @return the factMonto
     */
    public String getFactMonto() {
        return factMonto;
    }

    /**
     * @param factMonto the factMonto to set
     */
    public void setFactMonto(String factMonto) {
        this.factMonto = factMonto;
    }

    /**
     * @return the montoCre
     */
    public Double getMontoCre() {
        return montoCre;
    }

    /**
     * @param montoCre the montoCre to set
     */
    public void setMontoCre(Double montoCre) {
        this.montoCre = montoCre;
    }

    /**
     * @return the statCre
     */
    public String getStatCre() {
        return statCre;
    }

    /**
     * @param statCre the statCre to set
     */
    public void setStatCre(String statCre) {
        this.statCre = statCre;
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

    /**
     * @return the statCondic
     */
    public String getStatCondic() {
        return statCondic;
    }

    /**
     * @param statCondic the statCondic to set
     */
    public void setStatCondic(String statCondic) {
        this.statCondic = statCondic;
    }

    /**
     * @return the primaGarant
     */
    public Double getPrimaGarant() {
        return primaGarant;
    }

    /**
     * @param primaGarant the primaGarant to set
     */
    public void setPrimaGarant(Double primaGarant) {
        this.primaGarant = primaGarant;
    }

    /**
     * @return the tasaInt
     */
    public Double getTasaInt() {
        return tasaInt;
    }

    /**
     * @param tasaInt the tasaInt to set
     */
    public void setTasaInt(Double tasaInt) {
        this.tasaInt = tasaInt;
    }
    
    
}
