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
public class ProyeccionVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Double loanNbr;
private String firstPayPerDue;
private String lastPayPerDue;
private Double currPrinBal;
private Double intEarnedToDate;
private Double totIntPd;
private Double totIvaGan;
private Double totIvaPag;
private Date datePastPay;
private Double perIntEarned;
private Double perIntPd;
private Double perPrincPd;
private Double perIvaGan;
private Double perIvaPag;
private Double totIntMrtoGan;
private Double totIntMrtoPag;
private Double perIntMrtoGan;
private Double perIntMrtoPag;
private Double amtLastPmt;
private Double plazo;
private Double impPagoAntProy;
private int num_pagoAntProy;
private int num_difer;
private Double totPrinPaidToD;
private Double ivaPagProyOpt;
private Double ivaGanProyOpt;
private Double totIntProyOpt;
private Double intEarnedProOpt;
private Double saldoCapProyOpt;
private Date fechaStat;
private int statCobr;
private int numCitatorio;
private Date dtLastCitat;
private String statConvenio;
private Integer numConvenio;
private Date dtFirstConv;
private Integer numMesesConv;
private Date dtLastConv;
private String cveOperDtFinOn;
private String cve_operDtFinBt;
private Date dt_modDatFinOnl;
private Date dt_modDatFinBtc;
private String horaAud;
private String componenteCve;
private String ipEquipo;
private Double difInteres;
private Double difIvas;
private double mtoPago;
private int periodoDif;
private double intPer;
private double ivaPer;


    /**
     * @return the loanNbr
     */
    public Double getLoanNbr() {
        return loanNbr;
    }

    /**
     * @param loanNbr the loanNbr to set
     */
    public void setLoanNbr(Double loanNbr) {
        this.loanNbr = loanNbr;
    }

    /**
     * @return the firstPayPerDue
     */
    public String getFirstPayPerDue() {
        return firstPayPerDue;
    }

    /**
     * @param firstPayPerDue the firstPayPerDue to set
     */
    public void setFirstPayPerDue(String firstPayPerDue) {
        this.firstPayPerDue = firstPayPerDue;
    }

    /**
     * @return the lastPayPerDue
     */
    public String getLastPayPerDue() {
        return lastPayPerDue;
    }

    /**
     * @param lastPayPerDue the lastPayPerDue to set
     */
    public void setLastPayPerDue(String lastPayPerDue) {
        this.lastPayPerDue = lastPayPerDue;
    }

    /**
     * @return the currPrinBal
     */
    public Double getCurrPrinBal() {
        return currPrinBal;
    }

    /**
     * @param currPrinBal the currPrinBal to set
     */
    public void setCurrPrinBal(Double currPrinBal) {
        this.currPrinBal = currPrinBal;
    }

    /**
     * @return the intEarnedToDate
     */
    public Double getIntEarnedToDate() {
        return intEarnedToDate;
    }

    /**
     * @param intEarnedToDate the intEarnedToDate to set
     */
    public void setIntEarnedToDate(Double intEarnedToDate) {
        this.intEarnedToDate = intEarnedToDate;
    }

    /**
     * @return the totIntPd
     */
    public Double getTotIntPd() {
        return totIntPd;
    }

    /**
     * @param totIntPd the totIntPd to set
     */
    public void setTotIntPd(Double totIntPd) {
        this.totIntPd = totIntPd;
    }

    /**
     * @return the totIvaGan
     */
    public Double getTotIvaGan() {
        return totIvaGan;
    }

    /**
     * @param totIvaGan the totIvaGan to set
     */
    public void setTotIvaGan(Double totIvaGan) {
        this.totIvaGan = totIvaGan;
    }

    /**
     * @return the totIvaPag
     */
    public Double getTotIvaPag() {
        return totIvaPag;
    }

    /**
     * @param totIvaPag the totIvaPag to set
     */
    public void setTotIvaPag(Double totIvaPag) {
        this.totIvaPag = totIvaPag;
    }

    /**
     * @return the datePastPay
     */
    public Date getDatePastPay() {
        return datePastPay;
    }

    /**
     * @param datePastPay the datePastPay to set
     */
    public void setDatePastPay(Date datePastPay) {
        this.datePastPay = datePastPay;
    }

    /**
     * @return the perIntEarned
     */
    public Double getPerIntEarned() {
        return perIntEarned;
    }

    /**
     * @param perIntEarned the perIntEarned to set
     */
    public void setPerIntEarned(Double perIntEarned) {
        this.perIntEarned = perIntEarned;
    }

    /**
     * @return the perIntPd
     */
    public Double getPerIntPd() {
        return perIntPd;
    }

    /**
     * @param perIntPd the perIntPd to set
     */
    public void setPerIntPd(Double perIntPd) {
        this.perIntPd = perIntPd;
    }

    /**
     * @return the perPrincPd
     */
    public Double getPerPrincPd() {
        return perPrincPd;
    }

    /**
     * @param perPrincPd the perPrincPd to set
     */
    public void setPerPrincPd(Double perPrincPd) {
        this.perPrincPd = perPrincPd;
    }

    /**
     * @return the perIvaGan
     */
    public Double getPerIvaGan() {
        return perIvaGan;
    }

    /**
     * @param perIvaGan the perIvaGan to set
     */
    public void setPerIvaGan(Double perIvaGan) {
        this.perIvaGan = perIvaGan;
    }

    /**
     * @return the perIvaPag
     */
    public Double getPerIvaPag() {
        return perIvaPag;
    }

    /**
     * @param perIvaPag the perIvaPag to set
     */
    public void setPerIvaPag(Double perIvaPag) {
        this.perIvaPag = perIvaPag;
    }

    /**
     * @return the totIntMrtoGan
     */
    public Double getTotIntMrtoGan() {
        return totIntMrtoGan;
    }

    /**
     * @param totIntMrtoGan the totIntMrtoGan to set
     */
    public void setTotIntMrtoGan(Double totIntMrtoGan) {
        this.totIntMrtoGan = totIntMrtoGan;
    }

    /**
     * @return the totIntMrtoPag
     */
    public Double getTotIntMrtoPag() {
        return totIntMrtoPag;
    }

    /**
     * @param totIntMrtoPag the totIntMrtoPag to set
     */
    public void setTotIntMrtoPag(Double totIntMrtoPag) {
        this.totIntMrtoPag = totIntMrtoPag;
    }

    /**
     * @return the perIntMrtoGan
     */
    public Double getPerIntMrtoGan() {
        return perIntMrtoGan;
    }

    /**
     * @param perIntMrtoGan the perIntMrtoGan to set
     */
    public void setPerIntMrtoGan(Double perIntMrtoGan) {
        this.perIntMrtoGan = perIntMrtoGan;
    }

    /**
     * @return the perIntMrtoPag
     */
    public Double getPerIntMrtoPag() {
        return perIntMrtoPag;
    }

    /**
     * @param perIntMrtoPag the perIntMrtoPag to set
     */
    public void setPerIntMrtoPag(Double perIntMrtoPag) {
        this.perIntMrtoPag = perIntMrtoPag;
    }

    /**
     * @return the amtLastPmt
     */
    public Double getAmtLastPmt() {
        return amtLastPmt;
    }

    /**
     * @param amtLastPmt the amtLastPmt to set
     */
    public void setAmtLastPmt(Double amtLastPmt) {
        this.amtLastPmt = amtLastPmt;
    }

    /**
     * @return the plazo
     */
    public Double getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */
    public void setPlazo(Double plazo) {
        this.plazo = plazo;
    }

    /**
     * @return the impPagoAntProy
     */
    public Double getImpPagoAntProy() {
        return impPagoAntProy;
    }

    /**
     * @param impPagoAntProy the impPagoAntProy to set
     */
    public void setImpPagoAntProy(Double impPagoAntProy) {
        this.impPagoAntProy = impPagoAntProy;
    }

    /**
     * @return the num_pagoAntProy
     */
    public int getNum_pagoAntProy() {
        return num_pagoAntProy;
    }

    /**
     * @param num_pagoAntProy the num_pagoAntProy to set
     */
    public void setNum_pagoAntProy(int num_pagoAntProy) {
        this.num_pagoAntProy = num_pagoAntProy;
    }

    /**
     * @return the num_difer
     */
    public int getNum_difer() {
        return num_difer;
    }

    /**
     * @param num_difer the num_difer to set
     */
    public void setNum_difer(int num_difer) {
        this.num_difer = num_difer;
    }

    /**
     * @return the totPrinPaidToD
     */
    public Double getTotPrinPaidToD() {
        return totPrinPaidToD;
    }

    /**
     * @param totPrinPaidToD the totPrinPaidToD to set
     */
    public void setTotPrinPaidToD(Double totPrinPaidToD) {
        this.totPrinPaidToD = totPrinPaidToD;
    }

    /**
     * @return the ivaPagProyOpt
     */
    public Double getIvaPagProyOpt() {
        return ivaPagProyOpt;
    }

    /**
     * @param ivaPagProyOpt the ivaPagProyOpt to set
     */
    public void setIvaPagProyOpt(Double ivaPagProyOpt) {
        this.ivaPagProyOpt = ivaPagProyOpt;
    }

    /**
     * @return the ivaGanProyOpt
     */
    public Double getIvaGanProyOpt() {
        return ivaGanProyOpt;
    }

    /**
     * @param ivaGanProyOpt the ivaGanProyOpt to set
     */
    public void setIvaGanProyOpt(Double ivaGanProyOpt) {
        this.ivaGanProyOpt = ivaGanProyOpt;
    }

    /**
     * @return the totIntProyOpt
     */
    public Double getTotIntProyOpt() {
        return totIntProyOpt;
    }

    /**
     * @param totIntProyOpt the totIntProyOpt to set
     */
    public void setTotIntProyOpt(Double totIntProyOpt) {
        this.totIntProyOpt = totIntProyOpt;
    }

    /**
     * @return the intEarnedProOpt
     */
    public Double getIntEarnedProOpt() {
        return intEarnedProOpt;
    }

    /**
     * @param intEarnedProOpt the intEarnedProOpt to set
     */
    public void setIntEarnedProOpt(Double intEarnedProOpt) {
        this.intEarnedProOpt = intEarnedProOpt;
    }

    /**
     * @return the saldoCapProyOpt
     */
    public Double getSaldoCapProyOpt() {
        return saldoCapProyOpt;
    }

    /**
     * @param saldoCapProyOpt the saldoCapProyOpt to set
     */
    public void setSaldoCapProyOpt(Double saldoCapProyOpt) {
        this.saldoCapProyOpt = saldoCapProyOpt;
    }

    /**
     * @return the fechaStat
     */
    public Date getFechaStat() {
        return fechaStat;
    }

    /**
     * @param fechaStat the fechaStat to set
     */
    public void setFechaStat(Date fechaStat) {
        this.fechaStat = fechaStat;
    }

    /**
     * @return the statCobr
     */
    public int getStatCobr() {
        return statCobr;
    }

    /**
     * @param statCobr the statCobr to set
     */
    public void setStatCobr(int statCobr) {
        this.statCobr = statCobr;
    }

    /**
     * @return the numCitatorio
     */
    public int getNumCitatorio() {
        return numCitatorio;
    }

    /**
     * @param numCitatorio the numCitatorio to set
     */
    public void setNumCitatorio(int numCitatorio) {
        this.numCitatorio = numCitatorio;
    }

    /**
     * @return the dtLastCitat
     */
    public Date getDtLastCitat() {
        return dtLastCitat;
    }

    /**
     * @param dtLastCitat the dtLastCitat to set
     */
    public void setDtLastCitat(Date dtLastCitat) {
        this.dtLastCitat = dtLastCitat;
    }

    /**
     * @return the statConvenio
     */
    public String getStatConvenio() {
        return statConvenio;
    }

    /**
     * @param statConvenio the statConvenio to set
     */
    public void setStatConvenio(String statConvenio) {
        this.statConvenio = statConvenio;
    }

    /**
     * @return the numConvenio
     */
    public Integer getNumConvenio() {
        return numConvenio;
    }

    /**
     * @param numConvenio the numConvenio to set
     */
    public void setNumConvenio(Integer numConvenio) {
        this.numConvenio = numConvenio;
    }

    /**
     * @return the dtFirstConv
     */
    public Date getDtFirstConv() {
        return dtFirstConv;
    }

    /**
     * @param dtFirstConv the dtFirstConv to set
     */
    public void setDtFirstConv(Date dtFirstConv) {
        this.dtFirstConv = dtFirstConv;
    }

    /**
     * @return the numMesesConv
     */
    public Integer getNumMesesConv() {
        return numMesesConv;
    }

    /**
     * @param numMesesConv the numMesesConv to set
     */
    public void setNumMesesConv(Integer numMesesConv) {
        this.numMesesConv = numMesesConv;
    }

    /**
     * @return the dtLastConv
     */
    public Date getDtLastConv() {
        return dtLastConv;
    }

    /**
     * @param dtLastConv the dtLastConv to set
     */
    public void setDtLastConv(Date dtLastConv) {
        this.dtLastConv = dtLastConv;
    }

    /**
     * @return the cveOperDtFinOn
     */
    public String getCveOperDtFinOn() {
        return cveOperDtFinOn;
    }

    /**
     * @param cveOperDtFinOn the cveOperDtFinOn to set
     */
    public void setCveOperDtFinOn(String cveOperDtFinOn) {
        this.cveOperDtFinOn = cveOperDtFinOn;
    }

    /**
     * @return the cve_operDtFinBt
     */
    public String getCve_operDtFinBt() {
        return cve_operDtFinBt;
    }

    /**
     * @param cve_operDtFinBt the cve_operDtFinBt to set
     */
    public void setCve_operDtFinBt(String cve_operDtFinBt) {
        this.cve_operDtFinBt = cve_operDtFinBt;
    }

    /**
     * @return the dt_modDatFinOnl
     */
    public Date getDt_modDatFinOnl() {
        return dt_modDatFinOnl;
    }

    /**
     * @param dt_modDatFinOnl the dt_modDatFinOnl to set
     */
    public void setDt_modDatFinOnl(Date dt_modDatFinOnl) {
        this.dt_modDatFinOnl = dt_modDatFinOnl;
    }

    /**
     * @return the dt_modDatFinBtc
     */
    public Date getDt_modDatFinBtc() {
        return dt_modDatFinBtc;
    }

    /**
     * @param dt_modDatFinBtc the dt_modDatFinBtc to set
     */
    public void setDt_modDatFinBtc(Date dt_modDatFinBtc) {
        this.dt_modDatFinBtc = dt_modDatFinBtc;
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
     * @return the difInteres
     */
    public Double getDifInteres() {
        return difInteres;
    }
    
    /**
     * @param difInteres the difInteres to set
     */
    public void setDifInteres(Double difInteres) {
        this.difInteres = difInteres;
    }

    /**
     * @return the difIvas
     */
    public Double getDifIvas() {
        return difIvas;
    }
    
    /**
     * @param difIvas the difIvas to set
     */
    public void setDifIvas(Double difIvas) {
        this.difIvas = difIvas;
    }

    /**
     * @return the mtoPago
     */
    public double getMtoPago() {
        return mtoPago;
    }

    /**
     * @param mtoPago the mtoPago to set
     */
    public void setMtoPago(double mtoPago) {
        this.mtoPago = mtoPago;
    }

    /**
     * @return the periodoDif
     */
    public int getPeriodoDif() {
        return periodoDif;
    }

    /**
     * @param periodoDif the periodoDif to set
     */
    public void setPeriodoDif(int periodoDif) {
        this.periodoDif = periodoDif;
    }

    /**
     * @return the intPer
     */
    public double getIntPer() {
        return intPer;
    }

    /**
     * @param intPer the intPer to set
     */
    public void setIntPer(double intPer) {
        this.intPer = intPer;
    }

    /**
     * @return the ivaPer
     */
    public double getIvaPer() {
        return ivaPer;
    }

    /**
     * @param ivaPer the ivaPer to set
     */
    public void setIvaPer(double ivaPer) {
        this.ivaPer = ivaPer;
    }

    
}
