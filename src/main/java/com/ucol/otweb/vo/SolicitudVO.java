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
public class SolicitudVO implements Serializable{
    private static final long serialVersionUID = 1L; 

    private int anio_sol;
    private Integer folio_sol;
    private int cve_tcr;
    private Date fecha_sol;
    private Integer num_issste;
    private String rfc;
    private int cve_entidad;
    private int cve_deleg;
    private int cve_uniad;
    private int cve_oficina;
    private Number num_ramo;
    private String num_pagaduria;
    private Date fec_recepci;
    private Date fec_rechvis;
    private Date fec_rechoto;
    private Date fec_otorga;
    private Date fec_prscanc;
    private Date fec_cheqemi;
    private Date fec_cheqcan;
    private Date fec_cheqent;
    private Date fec_solcanc;
    private int cve_stat_sol;
    private String usuario;
    private Date fecha_aud;
    private String componente_cve;
    private String ip_equipo;

    /**
     * @return the anio_sol
     */
    public int getAnio_sol() {
        return anio_sol;
    }

    /**
     * @param anio_sol the anio_sol to set
     */
    public void setAnio_sol(int anio_sol) {
        this.anio_sol = anio_sol;
    }

    /**
     * @return the folio_sol
     */
    public Integer getFolio_sol() {
        return folio_sol;
    }

    /**
     * @param folio_sol the folio_sol to set
     */
    public void setFolio_sol(Integer folio_sol) {
        this.folio_sol = folio_sol;
    }

    /**
     * @return the cve_tcr
     */
    public int getCve_tcr() {
        return cve_tcr;
    }

    /**
     * @param cve_tcr the cve_tcr to set
     */
    public void setCve_tcr(int cve_tcr) {
        this.cve_tcr = cve_tcr;
    }

    /**
     * @return the fecha_sol
     */
    public Date getFecha_sol() {
        return fecha_sol;
    }

    /**
     * @param fecha_sol the fecha_sol to set
     */
    public void setFecha_sol(Date fecha_sol) {
        this.fecha_sol = fecha_sol;
    }

    /**
     * @return the num_issste
     */
    public Integer getNum_issste() {
        return num_issste;
    }

    /**
     * @param num_issste the num_issste to set
     */
    public void setNum_issste(Integer num_issste) {
        this.num_issste = num_issste;
    }

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
     * @return the cve_entidad
     */
    public int getCve_entidad() {
        return cve_entidad;
    }

    /**
     * @param cve_entidad the cve_entidad to set
     */
    public void setCve_entidad(int cve_entidad) {
        this.cve_entidad = cve_entidad;
    }

    /**
     * @return the cve_deleg
     */
    public int getCve_deleg() {
        return cve_deleg;
    }

    /**
     * @param cve_deleg the cve_deleg to set
     */
    public void setCve_deleg(int cve_deleg) {
        this.cve_deleg = cve_deleg;
    }

    /**
     * @return the cve_uniad
     */
    public int getCve_uniad() {
        return cve_uniad;
    }

    /**
     * @param cve_uniad the cve_uniad to set
     */
    public void setCve_uniad(int cve_uniad) {
        this.cve_uniad = cve_uniad;
    }

    /**
     * @return the cve_oficina
     */
    public int getCve_oficina() {
        return cve_oficina;
    }

    /**
     * @param cve_oficina the cve_oficina to set
     */
    public void setCve_oficina(int cve_oficina) {
        this.cve_oficina = cve_oficina;
    }

    /**
     * @return the num_ramo
     */
    public Number getNum_ramo() {
        return num_ramo;
    }

    /**
     * @param num_ramo the num_ramo to set
     */
    public void setNum_ramo(Number num_ramo) {
        this.num_ramo = num_ramo;
    }

    /**
     * @return the num_pagaduria
     */
    public String getNum_pagaduria() {
        return num_pagaduria;
    }

    /**
     * @param num_pagaduria the num_pagaduria to set
     */
    public void setNum_pagaduria(String num_pagaduria) {
        this.num_pagaduria = num_pagaduria;
    }

    /**
     * @return the fec_recepci
     */
    public Date getFec_recepci() {
        return fec_recepci;
    }

    /**
     * @param fec_recepci the fec_recepci to set
     */
    public void setFec_recepci(Date fec_recepci) {
        this.fec_recepci = fec_recepci;
    }

    /**
     * @return the fec_rechvis
     */
    public Date getFec_rechvis() {
        return fec_rechvis;
    }

    /**
     * @param fec_rechvis the fec_rechvis to set
     */
    public void setFec_rechvis(Date fec_rechvis) {
        this.fec_rechvis = fec_rechvis;
    }

    /**
     * @return the fec_rechoto
     */
    public Date getFec_rechoto() {
        return fec_rechoto;
    }

    /**
     * @param fec_rechoto the fec_rechoto to set
     */
    public void setFec_rechoto(Date fec_rechoto) {
        this.fec_rechoto = fec_rechoto;
    }

    /**
     * @return the fec_otorga
     */
    public Date getFec_otorga() {
        return fec_otorga;
    }

    /**
     * @param fec_otorga the fec_otorga to set
     */
    public void setFec_otorga(Date fec_otorga) {
        this.fec_otorga = fec_otorga;
    }

    /**
     * @return the fec_prscanc
     */
    public Date getFec_prscanc() {
        return fec_prscanc;
    }

    /**
     * @param fec_prscanc the fec_prscanc to set
     */
    public void setFec_prscanc(Date fec_prscanc) {
        this.fec_prscanc = fec_prscanc;
    }

    /**
     * @return the fec_cheqemi
     */
    public Date getFec_cheqemi() {
        return fec_cheqemi;
    }

    /**
     * @param fec_cheqemi the fec_cheqemi to set
     */
    public void setFec_cheqemi(Date fec_cheqemi) {
        this.fec_cheqemi = fec_cheqemi;
    }

    /**
     * @return the fec_cheqcan
     */
    public Date getFec_cheqcan() {
        return fec_cheqcan;
    }

    /**
     * @param fec_cheqcan the fec_cheqcan to set
     */
    public void setFec_cheqcan(Date fec_cheqcan) {
        this.fec_cheqcan = fec_cheqcan;
    }

    /**
     * @return the fec_cheqent
     */
    public Date getFec_cheqent() {
        return fec_cheqent;
    }

    /**
     * @param fec_cheqent the fec_cheqent to set
     */
    public void setFec_cheqent(Date fec_cheqent) {
        this.fec_cheqent = fec_cheqent;
    }

    /**
     * @return the fec_solcanc
     */
    public Date getFec_solcanc() {
        return fec_solcanc;
    }

    /**
     * @param fec_solcanc the fec_solcanc to set
     */
    public void setFec_solcanc(Date fec_solcanc) {
        this.fec_solcanc = fec_solcanc;
    }

    /**
     * @return the cve_stat_sol
     */
    public int getCve_stat_sol() {
        return cve_stat_sol;
    }

    /**
     * @param cve_stat_sol the cve_stat_sol to set
     */
    public void setCve_stat_sol(int cve_stat_sol) {
        this.cve_stat_sol = cve_stat_sol;
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
