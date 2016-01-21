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
public class TransMovOtoWeb implements Serializable{
    private static final long serialVersionUID = 1L; 
    
    private String rfc;
    private String curp;
    private String nss;
    private Integer numIssste;
    private String nombre;
    private Integer folio;
    private int tipo_prst;
    private int cveEntidad;
    private int cveDeleg;
    private int cveUniad;
    private int cveOficina;
    private int ramo;
    private String pagad;
    private int status;
    private Date fechaMov;
    private Date fechaAud;
    private String horaAud;
    private String componente;
    private String operador;
    private String ip_equipo;

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the nss
     */
    public String getNss() {
        return nss;
    }

    /**
     * @param nss the nss to set
     */
    public void setNss(String nss) {
        this.nss = nss;
    }

    /**
     * @return the numIssste
     */
    public Integer getNumIssste() {
        return numIssste;
    }

    /**
     * @param numIssste the numIssste to set
     */
    public void setNumIssste(Integer numIssste) {
        this.numIssste = numIssste;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the folio
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * @return the tipo_prst
     */
    public int getTipo_prst() {
        return tipo_prst;
    }

    /**
     * @param tipo_prst the tipo_prst to set
     */
    public void setTipo_prst(int tipo_prst) {
        this.tipo_prst = tipo_prst;
    }

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
     * @return the cveUniad
     */
    public int getCveUniad() {
        return cveUniad;
    }

    /**
     * @param cveUniad the cveUniad to set
     */
    public void setCveUniad(int cveUniad) {
        this.cveUniad = cveUniad;
    }

    /**
     * @return the cveOficina
     */
    public int getCveOficina() {
        return cveOficina;
    }

    /**
     * @param cveOficina the cveOficina to set
     */
    public void setCveOficina(int cveOficina) {
        this.cveOficina = cveOficina;
    }

    /**
     * @return the ramo
     */
    public int getRamo() {
        return ramo;
    }

    /**
     * @param ramo the ramo to set
     */
    public void setRamo(int ramo) {
        this.ramo = ramo;
    }

    /**
     * @return the pagad
     */
    public String getPagad() {
        return pagad;
    }

    /**
     * @param pagad the pagad to set
     */
    public void setPagad(String pagad) {
        this.pagad = pagad;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the fechaMov
     */
    public Date getFechaMov() {
        return fechaMov;
    }

    /**
     * @param fechaMov the fechaMov to set
     */
    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
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
     * @return the componente
     */
    public String getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(String componente) {
        this.componente = componente;
    }

    /**
     * @return the operador
     */
    public String getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(String operador) {
        this.operador = operador;
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
