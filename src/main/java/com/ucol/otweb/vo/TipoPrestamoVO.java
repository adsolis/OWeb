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
public class TipoPrestamoVO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int cve_tcr;
    private String nom_tcr;
    private int otorg_max;
    private Double monto_min;
    private Double prima_renov;
    private String factor_rango;
    private String factor_antig;
    private String desc_chq1;
    private String desc_chq2;
    private String desc_chq3;
    private String cod_autor;
    private String cod_can;
    private String stat_tcr;
    private String usuario;
    private Date fecha_aud;
    private String componente_cve;
    private String ip_equipo;

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
     * @return the nom_tcr
     */
    public String getNom_tcr() {
        return nom_tcr;
    }

    /**
     * @param nom_tcr the nom_tcr to set
     */
    public void setNom_tcr(String nom_tcr) {
        this.nom_tcr = nom_tcr;
    }

    /**
     * @return the otorg_max
     */
    public int getOtorg_max() {
        return otorg_max;
    }

    /**
     * @param otorg_max the otorg_max to set
     */
    public void setOtorg_max(int otorg_max) {
        this.otorg_max = otorg_max;
    }

    /**
     * @return the monto_min
     */
    public Double getMonto_min() {
        return monto_min;
    }

    /**
     * @param monto_min the monto_min to set
     */
    public void setMonto_min(Double monto_min) {
        this.monto_min = monto_min;
    }

    /**
     * @return the prima_renov
     */
    public Double getPrima_renov() {
        return prima_renov;
    }

    /**
     * @param prima_renov the prima_renov to set
     */
    public void setPrima_renov(Double prima_renov) {
        this.prima_renov = prima_renov;
    }

    /**
     * @return the factor_rango
     */
    public String getFactor_rango() {
        return factor_rango;
    }

    /**
     * @param factor_rango the factor_rango to set
     */
    public void setFactor_rango(String factor_rango) {
        this.factor_rango = factor_rango;
    }

    /**
     * @return the factor_antig
     */
    public String getFactor_antig() {
        return factor_antig;
    }

    /**
     * @param factor_antig the factor_antig to set
     */
    public void setFactor_antig(String factor_antig) {
        this.factor_antig = factor_antig;
    }

    /**
     * @return the desc_chq1
     */
    public String getDesc_chq1() {
        return desc_chq1;
    }

    /**
     * @param desc_chq1 the desc_chq1 to set
     */
    public void setDesc_chq1(String desc_chq1) {
        this.desc_chq1 = desc_chq1;
    }

    /**
     * @return the desc_chq2
     */
    public String getDesc_chq2() {
        return desc_chq2;
    }

    /**
     * @param desc_chq2 the desc_chq2 to set
     */
    public void setDesc_chq2(String desc_chq2) {
        this.desc_chq2 = desc_chq2;
    }

    /**
     * @return the desc_chq3
     */
    public String getDesc_chq3() {
        return desc_chq3;
    }

    /**
     * @param desc_chq3 the desc_chq3 to set
     */
    public void setDesc_chq3(String desc_chq3) {
        this.desc_chq3 = desc_chq3;
    }

    /**
     * @return the cod_autor
     */
    public String getCod_autor() {
        return cod_autor;
    }

    /**
     * @param cod_autor the cod_autor to set
     */
    public void setCod_autor(String cod_autor) {
        this.cod_autor = cod_autor;
    }

    /**
     * @return the cod_can
     */
    public String getCod_can() {
        return cod_can;
    }

    /**
     * @param cod_can the cod_can to set
     */
    public void setCod_can(String cod_can) {
        this.cod_can = cod_can;
    }

    /**
     * @return the stat_tcr
     */
    public String getStat_tcr() {
        return stat_tcr;
    }

    /**
     * @param stat_tcr the stat_tcr to set
     */
    public void setStat_tcr(String stat_tcr) {
        this.stat_tcr = stat_tcr;
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
