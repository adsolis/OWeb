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
public class DeduccionesVO implements Serializable{
    private static final long serialVersionUID = 1L; 
    
    private Integer isssteNbr202;
    private Integer ramo;
    private String pagaduria;
    private Double dsctoFovissste;
    private Double loanNbrSityf;
    private Double dsctoSityf;
    private Double loanNbrIssste;
    private Double dsctoIssste;
    private String usuario;
    private Date fechaAud;
    private String componenteCve;
    private String ipEquipo;
    private boolean banderaGuardar;

    
    /**
     * @return the ramo
     */
    public Integer getRamo() {
        return ramo;
    }

    /**
     * @param ramo the ramo to set
     */
    public void setRamo(Integer ramo) {
        this.ramo = ramo;
    }

    /**
     * @return the pagaduria
     */
    public String getPagaduria() {
        return pagaduria;
    }

    /**
     * @param pagaduria the pagaduria to set
     */
    public void setPagaduria(String pagaduria) {
        this.pagaduria = pagaduria;
    }

    /**
     * @return the dsctoFovissste
     */
    public Double getDsctoFovissste() {
        return dsctoFovissste;
    }

    /**
     * @param dsctoFovissste the dsctoFovissste to set
     */
    public void setDsctoFovissste(Double dsctoFovissste) {
        this.dsctoFovissste = dsctoFovissste;
    }

    /**
     * @return the loanNbrSityf
     */
    public Double getLoanNbrSityf() {
        return loanNbrSityf;
    }

    /**
     * @param loanNbrSityf the loanNbrSityf to set
     */
    public void setLoanNbrSityf(Double loanNbrSityf) {
        this.loanNbrSityf = loanNbrSityf;
    }

    /**
     * @return the dsctoSityf
     */
    public Double getDsctoSityf() {
        return dsctoSityf;
    }

    /**
     * @param dsctoSityf the dsctoSityf to set
     */
    public void setDsctoSityf(Double dsctoSityf) {
        this.dsctoSityf = dsctoSityf;
    }

    /**
     * @return the loanNbrIssste
     */
    public Double getLoanNbrIssste() {
        return loanNbrIssste;
    }

    /**
     * @param loanNbrIssste the loanNbrIssste to set
     */
    public void setLoanNbrIssste(Double loanNbrIssste) {
        this.loanNbrIssste = loanNbrIssste;
    }

    /**
     * @return the dsctoIssste
     */
    public Double getDsctoIssste() {
        return dsctoIssste;
    }

    /**
     * @param dsctoIssste the dsctoIssste to set
     */
    public void setDsctoIssste(Double dsctoIssste) {
        this.dsctoIssste = dsctoIssste;
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
     * @return the isssteNbr202
     */
    public Integer getIsssteNbr202() {
        return isssteNbr202;
    }

    /**
     * @param isssteNbr202 the isssteNbr202 to set
     */
    public void setIsssteNbr202(Integer isssteNbr202) {
        this.isssteNbr202 = isssteNbr202;
    }

    /**
     * @return the banderaGuardar
     */
    public boolean isBanderaGuardar() {
        return banderaGuardar;
    }

    /**
     * @param banderaGuardar the banderaGuardar to set
     */
    public void setBanderaGuardar(boolean banderaGuardar) {
        this.banderaGuardar = banderaGuardar;
    }
    
    
}
