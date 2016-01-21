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
public class PagoNomVO implements Serializable {

    private double loanNbr;
    private String qnaInicio;
    private Integer ramo;
    private String pagad;
    private String qnaFinal;
    private double importePago;
    private int tpoPago;
    private String operIdMant;
    private Date dtLastMant;
    private String horaAud;
    private String componente_cve;
    private String ipEquipo;

    /**
     * @return the loanNbr
     */
    public double getLoanNbr() {
        return loanNbr;
    }

    /**
     * @param loanNbr the loanNbr to set
     */
    public void setLoanNbr(double loanNbr) {
        this.loanNbr = loanNbr;
    }

    /**
     * @return the qnaInicio
     */
    public String getQnaInicio() {
        return qnaInicio;
    }

    /**
     * @param qnaInicio the qnaInicio to set
     */
    public void setQnaInicio(String qnaInicio) {
        this.qnaInicio = qnaInicio;
    }

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
     * @return the qnaFinal
     */
    public String getQnaFinal() {
        return qnaFinal;
    }

    /**
     * @param qnaFinal the qnaFinal to set
     */
    public void setQnaFinal(String qnaFinal) {
        this.qnaFinal = qnaFinal;
    }

    /**
     * @return the importePago
     */
    public double getImportePago() {
        return importePago;
    }

    /**
     * @param importePago the importePago to set
     */
    public void setImportePago(double importePago) {
        this.importePago = importePago;
    }

    /**
     * @return the tpoPago
     */
    public int getTpoPago() {
        return tpoPago;
    }

    /**
     * @param tpoPago the tpoPago to set
     */
    public void setTpoPago(int tpoPago) {
        this.tpoPago = tpoPago;
    }

    /**
     * @return the operIdMant
     */
    public String getOperIdMant() {
        return operIdMant;
    }

    /**
     * @param operIdMant the operIdMant to set
     */
    public void setOperIdMant(String operIdMant) {
        this.operIdMant = operIdMant;
    }

    /**
     * @return the dtLastMant
     */
    public Date getDtLastMant() {
        return dtLastMant;
    }

    /**
     * @param dtLastMant the dtLastMant to set
     */
    public void setDtLastMant(Date dtLastMant) {
        this.dtLastMant = dtLastMant;
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
