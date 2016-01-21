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
public class TransOtoVO implements Serializable {

    private Date dtTrans;
    private String rfcTrans;
    private String nombreTrans;
    private double salarioTrans;
    private int tipoNombTrans;
    private String sexoTrans;
    private String edadTrans;
    private int antigTrans;
    private String entOperTrans;
    private int nbrOperTrans;
    private int isssteNbrTrans;
    private double loanNbrTrans;
    private int nbrFolioTrans;
    private Date loanIssueDate;
    private int loanTypePrs;
    private int loanStatPrs;
    private double origLoanPrin;
    private double loanDisbAmt;
    private double impRefinanc;
    private Double capRefinanc;
    private Double intRefinanc;
    private Double ivaRefinanc;
    private double origLoanIntAmt;
    private double origIva;
    private double deferredInt;
    private double warrantyPrem;
    private double renewalPrem;
    private double intRate;
    private double ivaRate;
    private int origNbrPay;
    private Integer loanAuthCd;
    private double payAmt;
    private String firstPayPerYrD;
    private String lastPayPerYrDu;
    private int modoPago;
    private int tipoCta;
    private Integer cveBanco;
    private Double numCtaBanc;
    private String tipoPresup;
    private int entidOtor;
    private int delegOtor;
    private int uniadOtor;
    private int offOtor;
    private int ramoOtor;
    private String pagadOtor;
    private int cveAfect;
    private int cvePart;
    private String horaAud;
    private String componenteCve;
    private String usuario;
    private String ipEquipo;

    /**
     * @return the dtTrans
     */
    public Date getDtTrans() {
        return dtTrans;
    }

    /**
     * @param dtTrans the dtTrans to set
     */
    public void setDtTrans(Date dtTrans) {
        this.dtTrans = dtTrans;
    }

    /**
     * @return the rfcTrans
     */
    public String getRfcTrans() {
        return rfcTrans;
    }

    /**
     * @param rfcTrans the rfcTrans to set
     */
    public void setRfcTrans(String rfcTrans) {
        this.rfcTrans = rfcTrans;
    }

    /**
     * @return the nombreTrans
     */
    public String getNombreTrans() {
        return nombreTrans;
    }

    /**
     * @param nombreTrans the nombreTrans to set
     */
    public void setNombreTrans(String nombreTrans) {
        this.nombreTrans = nombreTrans;
    }

    /**
     * @return the salarioTrans
     */
    public double getSalarioTrans() {
        return salarioTrans;
    }

    /**
     * @param salarioTrans the salarioTrans to set
     */
    public void setSalarioTrans(double salarioTrans) {
        this.salarioTrans = salarioTrans;
    }

    /**
     * @return the tipoNombTrans
     */
    public int getTipoNombTrans() {
        return tipoNombTrans;
    }

    /**
     * @param tipoNombTrans the tipoNombTrans to set
     */
    public void setTipoNombTrans(int tipoNombTrans) {
        this.tipoNombTrans = tipoNombTrans;
    }

    /**
     * @return the sexoTrans
     */
    public String getSexoTrans() {
        return sexoTrans;
    }

    /**
     * @param sexoTrans the sexoTrans to set
     */
    public void setSexoTrans(String sexoTrans) {
        this.sexoTrans = sexoTrans;
    }

    /**
     * @return the edadTrans
     */
    public String getEdadTrans() {
        return edadTrans;
    }

    /**
     * @param edadTrans the edadTrans to set
     */
    public void setEdadTrans(String edadTrans) {
        this.edadTrans = edadTrans;
    }

    /**
     * @return the antigTrans
     */
    public int getAntigTrans() {
        return antigTrans;
    }

    /**
     * @param antigTrans the antigTrans to set
     */
    public void setAntigTrans(int antigTrans) {
        this.antigTrans = antigTrans;
    }

    /**
     * @return the entOperTrans
     */
    public String getEntOperTrans() {
        return entOperTrans;
    }

    /**
     * @param entOperTrans the entOperTrans to set
     */
    public void setEntOperTrans(String entOperTrans) {
        this.entOperTrans = entOperTrans;
    }

    /**
     * @return the nbrOperTrans
     */
    public int getNbrOperTrans() {
        return nbrOperTrans;
    }

    /**
     * @param nbrOperTrans the nbrOperTrans to set
     */
    public void setNbrOperTrans(int nbrOperTrans) {
        this.nbrOperTrans = nbrOperTrans;
    }

    /**
     * @return the isssteNbrTrans
     */
    public int getIsssteNbrTrans() {
        return isssteNbrTrans;
    }

    /**
     * @param isssteNbrTrans the isssteNbrTrans to set
     */
    public void setIsssteNbrTrans(int isssteNbrTrans) {
        this.isssteNbrTrans = isssteNbrTrans;
    }

    /**
     * @return the loanNbrTrans
     */
    public double getLoanNbrTrans() {
        return loanNbrTrans;
    }

    /**
     * @param loanNbrTrans the loanNbrTrans to set
     */
    public void setLoanNbrTrans(double loanNbrTrans) {
        this.loanNbrTrans = loanNbrTrans;
    }

    /**
     * @return the nbrFolioTrans
     */
    public int getNbrFolioTrans() {
        return nbrFolioTrans;
    }

    /**
     * @param nbrFolioTrans the nbrFolioTrans to set
     */
    public void setNbrFolioTrans(int nbrFolioTrans) {
        this.nbrFolioTrans = nbrFolioTrans;
    }

    /**
     * @return the loanIssueDate
     */
    public Date getLoanIssueDate() {
        return loanIssueDate;
    }

    /**
     * @param loanIssueDate the loanIssueDate to set
     */
    public void setLoanIssueDate(Date loanIssueDate) {
        this.loanIssueDate = loanIssueDate;
    }

    /**
     * @return the loanTypePrs
     */
    public int getLoanTypePrs() {
        return loanTypePrs;
    }

    /**
     * @param loanTypePrs the loanTypePrs to set
     */
    public void setLoanTypePrs(int loanTypePrs) {
        this.loanTypePrs = loanTypePrs;
    }

    /**
     * @return the loanStatPrs
     */
    public int getLoanStatPrs() {
        return loanStatPrs;
    }

    /**
     * @param loanStatPrs the loanStatPrs to set
     */
    public void setLoanStatPrs(int loanStatPrs) {
        this.loanStatPrs = loanStatPrs;
    }

    /**
     * @return the origLoanPrin
     */
    public double getOrigLoanPrin() {
        return origLoanPrin;
    }

    /**
     * @param origLoanPrin the origLoanPrin to set
     */
    public void setOrigLoanPrin(double origLoanPrin) {
        this.origLoanPrin = origLoanPrin;
    }

    /**
     * @return the loanDisbAmt
     */
    public double getLoanDisbAmt() {
        return loanDisbAmt;
    }

    /**
     * @param loanDisbAmt the loanDisbAmt to set
     */
    public void setLoanDisbAmt(double loanDisbAmt) {
        this.loanDisbAmt = loanDisbAmt;
    }

    /**
     * @return the impRefinanc
     */
    public double getImpRefinanc() {
        return impRefinanc;
    }

    /**
     * @param impRefinanc the impRefinanc to set
     */
    public void setImpRefinanc(double impRefinanc) {
        this.impRefinanc = impRefinanc;
    }

    /**
     * @return the origLoanIntAmt
     */
    public double getOrigLoanIntAmt() {
        return origLoanIntAmt;
    }

    /**
     * @param origLoanIntAmt the origLoanIntAmt to set
     */
    public void setOrigLoanIntAmt(double origLoanIntAmt) {
        this.origLoanIntAmt = origLoanIntAmt;
    }

    /**
     * @return the origIva
     */
    public double getOrigIva() {
        return origIva;
    }

    /**
     * @param origIva the origIva to set
     */
    public void setOrigIva(double origIva) {
        this.origIva = origIva;
    }

    /**
     * @return the deferredInt
     */
    public double getDeferredInt() {
        return deferredInt;
    }

    /**
     * @param deferredInt the deferredInt to set
     */
    public void setDeferredInt(double deferredInt) {
        this.deferredInt = deferredInt;
    }

    /**
     * @return the warrantyPrem
     */
    public double getWarrantyPrem() {
        return warrantyPrem;
    }

    /**
     * @param warrantyPrem the warrantyPrem to set
     */
    public void setWarrantyPrem(double warrantyPrem) {
        this.warrantyPrem = warrantyPrem;
    }

    /**
     * @return the renewalPrem
     */
    public double getRenewalPrem() {
        return renewalPrem;
    }

    /**
     * @param renewalPrem the renewalPrem to set
     */
    public void setRenewalPrem(double renewalPrem) {
        this.renewalPrem = renewalPrem;
    }

    /**
     * @return the intRate
     */
    public double getIntRate() {
        return intRate;
    }

    /**
     * @param intRate the intRate to set
     */
    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    /**
     * @return the ivaRate
     */
    public double getIvaRate() {
        return ivaRate;
    }

    /**
     * @param ivaRate the ivaRate to set
     */
    public void setIvaRate(double ivaRate) {
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
    public double getPayAmt() {
        return payAmt;
    }

    /**
     * @param payAmt the payAmt to set
     */
    public void setPayAmt(double payAmt) {
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
     * @return the tipoCta
     */
    public int getTipoCta() {
        return tipoCta;
    }

    /**
     * @param tipoCta the tipoCta to set
     */
    public void setTipoCta(int tipoCta) {
        this.tipoCta = tipoCta;
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
     * @return the numCtaBanc
     */
    public Double getNumCtaBanc() {
        return numCtaBanc;
    }

    /**
     * @param numCtaBanc the numCtaBanc to set
     */
    public void setNumCtaBanc(Double numCtaBanc) {
        this.numCtaBanc = numCtaBanc;
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
     * @return the entidOtor
     */
    public int getEntidOtor() {
        return entidOtor;
    }

    /**
     * @param entidOtor the entidOtor to set
     */
    public void setEntidOtor(int entidOtor) {
        this.entidOtor = entidOtor;
    }

    /**
     * @return the delegOtor
     */
    public int getDelegOtor() {
        return delegOtor;
    }

    /**
     * @param delegOtor the delegOtor to set
     */
    public void setDelegOtor(int delegOtor) {
        this.delegOtor = delegOtor;
    }

    /**
     * @return the uniadOtor
     */
    public int getUniadOtor() {
        return uniadOtor;
    }

    /**
     * @param uniadOtor the uniadOtor to set
     */
    public void setUniadOtor(int uniadOtor) {
        this.uniadOtor = uniadOtor;
    }

    /**
     * @return the offOtor
     */
    public int getOffOtor() {
        return offOtor;
    }

    /**
     * @param offOtor the offOtor to set
     */
    public void setOffOtor(int offOtor) {
        this.offOtor = offOtor;
    }

    /**
     * @return the ramoOtor
     */
    public int getRamoOtor() {
        return ramoOtor;
    }

    /**
     * @param ramoOtor the ramoOtor to set
     */
    public void setRamoOtor(int ramoOtor) {
        this.ramoOtor = ramoOtor;
    }

    /**
     * @return the pagadOtor
     */
    public String getPagadOtor() {
        return pagadOtor;
    }

    /**
     * @param pagadOtor the pagadOtor to set
     */
    public void setPagadOtor(String pagadOtor) {
        this.pagadOtor = pagadOtor;
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
     * @return the capRefinanc
     */
    public Double getCapRefinanc() {
        return capRefinanc;
    }

    /**
     * @param capRefinanc the capRefinanc to set
     */
    public void setCapRefinanc(Double capRefinanc) {
        this.capRefinanc = capRefinanc;
    }

    /**
     * @return the intRefinanc
     */
    public Double getIntRefinanc() {
        return intRefinanc;
    }

    /**
     * @param intRefinanc the intRefinanc to set
     */
    public void setIntRefinanc(Double intRefinanc) {
        this.intRefinanc = intRefinanc;
    }

    /**
     * @return the ivaRefinanc
     */
    public Double getIvaRefinanc() {
        return ivaRefinanc;
    }

    /**
     * @param ivaRefinanc the ivaRefinanc to set
     */
    public void setIvaRefinanc(Double ivaRefinanc) {
        this.ivaRefinanc = ivaRefinanc;
    }
}
