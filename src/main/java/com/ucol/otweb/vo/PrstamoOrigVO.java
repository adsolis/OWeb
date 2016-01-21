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
public class PrstamoOrigVO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    private Integer isssteNbr;
private Double loanNbr;
private int anioFolio;
private int loanTypeCd;
private Integer nbrFolio;
private Date loanIssue_date;
private int loanStatCd;
private Double numRefPmp;
private String badLoanFlg;
private Double origLoanPrin;
private Double impLiquido;
private Double origLoanIntAmt;
private Double origIva;
private Double deferredInt;
private Double warrantyPrem;
private Double renewalPrem;
private Double intRate;
private Double ivaRate;
private int origNbrPay;
private Integer loanAuthCd;
private Double payAmt;
private String firstPayPerYrD;
private String lastPayPerYrDu;
private Double numPrestRef1;
private Double numPrestRef2;
private Double numPrestRef3;
private Double totSdoCapRef;
private Double totSdoIntRef;
private Double totSdoIvaRef;
private Integer numCheque;
private Date dtCheque;
private int operIdIssuingCl;
private Integer operDisb;
private Date dateDisb;
private int delAds;
private String tipoPresup;
private int cveEntidad;
private int cveDeleg;
private int cveUniad;
private int cveOficina;
private int cveAfect;
private int cveGposind;
private int cvePart;
private String tnoCve;
private int ramoOtorg;
private String pagadOtorg;
private Date dt_lastStatusBtc;
private Date dtLastStatusOnl;
private String operIdBtch;
private String operIdOnline;
private String specialAprovalTe;
private int modoPago;
private int tipoCuenta;
private String numCtaBanc;
private Integer cveBanco;
private int tipoOd;
private Date fechaAud;
private String horaAud;
private String componenteCve;
private String ipEquipo;
private String auxNumPrestamo;
private String auxFechaPrestamo;

    /**
     * @return the isssteNbr
     */
    public Integer getIsssteNbr() {
        return isssteNbr;
    }

    /**
     * @param isssteNbr the isssteNbr to set
     */
    public void setIsssteNbr(Integer isssteNbr) {
        this.isssteNbr = isssteNbr;
    }

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
     * @return the anioFolio
     */
    public int getAnioFolio() {
        return anioFolio;
    }

    /**
     * @param anioFolio the anioFolio to set
     */
    public void setAnioFolio(int anioFolio) {
        this.anioFolio = anioFolio;
    }

    /**
     * @return the loanTypeCd
     */
    public int getLoanTypeCd() {
        return loanTypeCd;
    }

    /**
     * @param loanTypeCd the loanTypeCd to set
     */
    public void setLoanTypeCd(int loanTypeCd) {
        this.loanTypeCd = loanTypeCd;
    }

    /**
     * @return the nbrFolio
     */
    public Integer getNbrFolio() {
        return nbrFolio;
    }

    /**
     * @param nbrFolio the nbrFolio to set
     */
    public void setNbrFolio(Integer nbrFolio) {
        this.nbrFolio = nbrFolio;
    }

    /**
     * @return the loanIssue_date
     */
    public Date getLoanIssue_date() {
        return loanIssue_date;
    }

    /**
     * @param loanIssue_date the loanIssue_date to set
     */
    public void setLoanIssue_date(Date loanIssue_date) {
        this.loanIssue_date = loanIssue_date;
    }

    /**
     * @return the loanStatCd
     */
    public int getLoanStatCd() {
        return loanStatCd;
    }

    /**
     * @param loanStatCd the loanStatCd to set
     */
    public void setLoanStatCd(int loanStatCd) {
        this.loanStatCd = loanStatCd;
    }

    /**
     * @return the numRefPmp
     */
    public Double getNumRefPmp() {
        return numRefPmp;
    }

    /**
     * @param numRefPmp the numRefPmp to set
     */
    public void setNumRefPmp(Double numRefPmp) {
        this.numRefPmp = numRefPmp;
    }

    /**
     * @return the badLoanFlg
     */
    public String getBadLoanFlg() {
        return badLoanFlg;
    }

    /**
     * @param badLoanFlg the badLoanFlg to set
     */
    public void setBadLoanFlg(String badLoanFlg) {
        this.badLoanFlg = badLoanFlg;
    }

    /**
     * @return the origLoanPrin
     */
    public Double getOrigLoanPrin() {
        return origLoanPrin;
    }

    /**
     * @param origLoanPrin the origLoanPrin to set
     */
    public void setOrigLoanPrin(Double origLoanPrin) {
        this.origLoanPrin = origLoanPrin;
    }

    /**
     * @return the impLiquido
     */
    public Double getImpLiquido() {
        return impLiquido;
    }

    /**
     * @param impLiquido the impLiquido to set
     */
    public void setImpLiquido(Double impLiquido) {
        this.impLiquido = impLiquido;
    }

    /**
     * @return the origLoanIntAmt
     */
    public Double getOrigLoanIntAmt() {
        return origLoanIntAmt;
    }

    /**
     * @param origLoanIntAmt the origLoanIntAmt to set
     */
    public void setOrigLoanIntAmt(Double origLoanIntAmt) {
        this.origLoanIntAmt = origLoanIntAmt;
    }

    /**
     * @return the origIva
     */
    public Double getOrigIva() {
        return origIva;
    }

    /**
     * @param origIva the origIva to set
     */
    public void setOrigIva(Double origIva) {
        this.origIva = origIva;
    }

    /**
     * @return the deferredInt
     */
    public Double getDeferredInt() {
        return deferredInt;
    }

    /**
     * @param deferredInt the deferredInt to set
     */
    public void setDeferredInt(Double deferredInt) {
        this.deferredInt = deferredInt;
    }

    /**
     * @return the warrantyPrem
     */
    public Double getWarrantyPrem() {
        return warrantyPrem;
    }

    /**
     * @param warrantyPrem the warrantyPrem to set
     */
    public void setWarrantyPrem(Double warrantyPrem) {
        this.warrantyPrem = warrantyPrem;
    }

    /**
     * @return the renewalPrem
     */
    public Double getRenewalPrem() {
        return renewalPrem;
    }

    /**
     * @param renewalPrem the renewalPrem to set
     */
    public void setRenewalPrem(Double renewalPrem) {
        this.renewalPrem = renewalPrem;
    }

    /**
     * @return the intRate
     */
    public Double getIntRate() {
        return intRate;
    }

    /**
     * @param intRate the intRate to set
     */
    public void setIntRate(Double intRate) {
        this.intRate = intRate;
    }

    /**
     * @return the ivaRate
     */
    public Double getIvaRate() {
        return ivaRate;
    }

    /**
     * @param ivaRate the ivaRate to set
     */
    public void setIvaRate(Double ivaRate) {
        this.ivaRate = ivaRate;
    }

    /**
     * @return the origNbrPay
     */
    public int getOrigNbrPay() {
        return origNbrPay;
    }

    /**
     * @param origNbrPay the origNbrPay to set
     */
    public void setOrigNbrPay(int origNbrPay) {
        this.origNbrPay = origNbrPay;
    }

    /**
     * @return the loanAuthCd
     */
    public Integer getLoanAuthCd() {
        return loanAuthCd;
    }

    /**
     * @param loanAuthCd the loanAuthCd to set
     */
    public void setLoanAuthCd(Integer loanAuthCd) {
        this.loanAuthCd = loanAuthCd;
    }

    /**
     * @return the payAmt
     */
    public Double getPayAmt() {
        return payAmt;
    }

    /**
     * @param payAmt the payAmt to set
     */
    public void setPayAmt(Double payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * @return the firstPayPerYrD
     */
    public String getFirstPayPerYrD() {
        return firstPayPerYrD;
    }

    /**
     * @param firstPayPerYrD the firstPayPerYrD to set
     */
    public void setFirstPayPerYrD(String firstPayPerYrD) {
        this.firstPayPerYrD = firstPayPerYrD;
    }

    /**
     * @return the lastPayPerYrDu
     */
    public String getLastPayPerYrDu() {
        return lastPayPerYrDu;
    }

    /**
     * @param lastPayPerYrDu the lastPayPerYrDu to set
     */
    public void setLastPayPerYrDu(String lastPayPerYrDu) {
        this.lastPayPerYrDu = lastPayPerYrDu;
    }

    /**
     * @return the numPrestRef1
     */
    public Double getNumPrestRef1() {
        return numPrestRef1;
    }

    /**
     * @param numPrestRef1 the numPrestRef1 to set
     */
    public void setNumPrestRef1(Double numPrestRef1) {
        this.numPrestRef1 = numPrestRef1;
    }

    /**
     * @return the numPrestRef2
     */
    public Double getNumPrestRef2() {
        return numPrestRef2;
    }

    /**
     * @param numPrestRef2 the numPrestRef2 to set
     */
    public void setNumPrestRef2(Double numPrestRef2) {
        this.numPrestRef2 = numPrestRef2;
    }

    /**
     * @return the numPrestRef3
     */
    public Double getNumPrestRef3() {
        return numPrestRef3;
    }

    /**
     * @param numPrestRef3 the numPrestRef3 to set
     */
    public void setNumPrestRef3(Double numPrestRef3) {
        this.numPrestRef3 = numPrestRef3;
    }

    /**
     * @return the totSdoCapRef
     */
    public Double getTotSdoCapRef() {
        return totSdoCapRef;
    }

    /**
     * @param totSdoCapRef the totSdoCapRef to set
     */
    public void setTotSdoCapRef(Double totSdoCapRef) {
        this.totSdoCapRef = totSdoCapRef;
    }

    /**
     * @return the totSdoIntRef
     */
    public Double getTotSdoIntRef() {
        return totSdoIntRef;
    }

    /**
     * @param totSdoIntRef the totSdoIntRef to set
     */
    public void setTotSdoIntRef(Double totSdoIntRef) {
        this.totSdoIntRef = totSdoIntRef;
    }

    /**
     * @return the totSdoIvaRef
     */
    public Double getTotSdoIvaRef() {
        return totSdoIvaRef;
    }

    /**
     * @param totSdoIvaRef the totSdoIvaRef to set
     */
    public void setTotSdoIvaRef(Double totSdoIvaRef) {
        this.totSdoIvaRef = totSdoIvaRef;
    }

    /**
     * @return the numCheque
     */
    public Integer getNumCheque() {
        return numCheque;
    }

    /**
     * @param numCheque the numCheque to set
     */
    public void setNumCheque(Integer numCheque) {
        this.numCheque = numCheque;
    }

    /**
     * @return the dtCheque
     */
    public Date getDtCheque() {
        return dtCheque;
    }

    /**
     * @param dtCheque the dtCheque to set
     */
    public void setDtCheque(Date dtCheque) {
        this.dtCheque = dtCheque;
    }

    /**
     * @return the operIdIssuingCl
     */
    public int getOperIdIssuingCl() {
        return operIdIssuingCl;
    }

    /**
     * @param operIdIssuingCl the operIdIssuingCl to set
     */
    public void setOperIdIssuingCl(int operIdIssuingCl) {
        this.operIdIssuingCl = operIdIssuingCl;
    }

    /**
     * @return the operDisb
     */
    public Integer getOperDisb() {
        return operDisb;
    }

    /**
     * @param operDisb the operDisb to set
     */
    public void setOperDisb(Integer operDisb) {
        this.operDisb = operDisb;
    }

    /**
     * @return the dateDisb
     */
    public Date getDateDisb() {
        return dateDisb;
    }

    /**
     * @param dateDisb the dateDisb to set
     */
    public void setDateDisb(Date dateDisb) {
        this.dateDisb = dateDisb;
    }

    /**
     * @return the delAds
     */
    public int getDelAds() {
        return delAds;
    }

    /**
     * @param delAds the delAds to set
     */
    public void setDelAds(int delAds) {
        this.delAds = delAds;
    }

    /**
     * @return the tipoPresup
     */
    public String getTipoPresup() {
        return tipoPresup;
    }

    /**
     * @param tipoPresup the tipoPresup to set
     */
    public void setTipoPresup(String tipoPresup) {
        this.tipoPresup = tipoPresup;
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
     * @return the cveAfect
     */
    public int getCveAfect() {
        return cveAfect;
    }

    /**
     * @param cveAfect the cveAfect to set
     */
    public void setCveAfect(int cveAfect) {
        this.cveAfect = cveAfect;
    }

    /**
     * @return the cveGposind
     */
    public int getCveGposind() {
        return cveGposind;
    }

    /**
     * @param cveGposind the cveGposind to set
     */
    public void setCveGposind(int cveGposind) {
        this.cveGposind = cveGposind;
    }

    /**
     * @return the cvePart
     */
    public int getCvePart() {
        return cvePart;
    }

    /**
     * @param cvePart the cvePart to set
     */
    public void setCvePart(int cvePart) {
        this.cvePart = cvePart;
    }

    /**
     * @return the tnoCve
     */
    public String getTnoCve() {
        return tnoCve;
    }

    /**
     * @param tnoCve the tnoCve to set
     */
    public void setTnoCve(String tnoCve) {
        this.tnoCve = tnoCve;
    }

    /**
     * @return the ramoOtorg
     */
    public int getRamoOtorg() {
        return ramoOtorg;
    }

    /**
     * @param ramoOtorg the ramoOtorg to set
     */
    public void setRamoOtorg(int ramoOtorg) {
        this.ramoOtorg = ramoOtorg;
    }

    /**
     * @return the pagadOtorg
     */
    public String getPagadOtorg() {
        return pagadOtorg;
    }

    /**
     * @param pagadOtorg the pagadOtorg to set
     */
    public void setPagadOtorg(String pagadOtorg) {
        this.pagadOtorg = pagadOtorg;
    }

    /**
     * @return the dt_lastStatusBtc
     */
    public Date getDt_lastStatusBtc() {
        return dt_lastStatusBtc;
    }

    /**
     * @param dt_lastStatusBtc the dt_lastStatusBtc to set
     */
    public void setDt_lastStatusBtc(Date dt_lastStatusBtc) {
        this.dt_lastStatusBtc = dt_lastStatusBtc;
    }

    /**
     * @return the dtLastStatusOnl
     */
    public Date getDtLastStatusOnl() {
        return dtLastStatusOnl;
    }

    /**
     * @param dtLastStatusOnl the dtLastStatusOnl to set
     */
    public void setDtLastStatusOnl(Date dtLastStatusOnl) {
        this.dtLastStatusOnl = dtLastStatusOnl;
    }

    /**
     * @return the operIdBtch
     */
    public String getOperIdBtch() {
        return operIdBtch;
    }

    /**
     * @param operIdBtch the operIdBtch to set
     */
    public void setOperIdBtch(String operIdBtch) {
        this.operIdBtch = operIdBtch;
    }

    /**
     * @return the operIdOnline
     */
    public String getOperIdOnline() {
        return operIdOnline;
    }

    /**
     * @param operIdOnline the operIdOnline to set
     */
    public void setOperIdOnline(String operIdOnline) {
        this.operIdOnline = operIdOnline;
    }

    /**
     * @return the specialAprovalTe
     */
    public String getSpecialAprovalTe() {
        return specialAprovalTe;
    }

    /**
     * @param specialAprovalTe the specialAprovalTe to set
     */
    public void setSpecialAprovalTe(String specialAprovalTe) {
        this.specialAprovalTe = specialAprovalTe;
    }

    /**
     * @return the modoPago
     */
    public int getModoPago() {
        return modoPago;
    }

    /**
     * @param modoPago the modoPago to set
     */
    public void setModoPago(int modoPago) {
        this.modoPago = modoPago;
    }

    /**
     * @return the tipoCuenta
     */
    public int getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * @return the numCtaBanc
     */
    public String getNumCtaBanc() {
        return numCtaBanc;
    }

    /**
     * @param numCtaBanc the numCtaBanc to set
     */
    public void setNumCtaBanc(String numCtaBanc) {
        this.numCtaBanc = numCtaBanc;
    }

    /**
     * @return the cveBanco
     */
    public Integer getCveBanco() {
        return cveBanco;
    }

    /**
     * @param cveBanco the cveBanco to set
     */
    public void setCveBanco(Integer cveBanco) {
        this.cveBanco = cveBanco;
    }

    /**
     * @return the tipoOd
     */
    public int getTipoOd() {
        return tipoOd;
    }

    /**
     * @param tipoOd the tipoOd to set
     */
    public void setTipoOd(int tipoOd) {
        this.tipoOd = tipoOd;
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
     * @return the auxNumPrestamo
     */
    public String getAuxNumPrestamo() {
        return auxNumPrestamo;
    }

    /**
     * @param auxNumPrestamo the auxNumPrestamo to set
     */
    public void setAuxNumPrestamo(String auxNumPrestamo) {
        this.auxNumPrestamo = auxNumPrestamo;
    }

    /**
     * @return the auxFechaPrestamo
     */
    public String getAuxFechaPrestamo() {
        return auxFechaPrestamo;
    }

    /**
     * @param auxFechaPrestamo the auxFechaPrestamo to set
     */
    public void setAuxFechaPrestamo(String auxFechaPrestamo) {
        this.auxFechaPrestamo = auxFechaPrestamo;
    }
}
