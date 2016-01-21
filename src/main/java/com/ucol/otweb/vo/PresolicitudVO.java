/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.vo;

import java.util.Date;

/**
 *
 * @author 
 */
public class PresolicitudVO {

    private int anioSol;
    private CoberturaGlobVO coberturaGlobVO;
    private DescuentoProcVO descuentoProcVO;
    private DirectoVO directo;
    private Integer folioSol;
    private TpoCreditoVO tpoCreditoVO;
    private int cveTrc;
    private Date fechaSol;
    private String usuario;
    private Date fechaAud;
    private String componenteCVE;
    private Integer numRamo;
    private String numPagaduria;
    private CramPagVO cramPagVO;
    private String descRamo;
    private CtnoCveVO ctnoCveVO;
    private double sueldoDer;
    private double montoMaximoCred;
    private CAfectVO cAfectVO;
    private int cveStatSol;
    private Date fecRechOto;
    private PrstamoOrigVO prstamoOrigVO;
    private Double saldoRef;
    private Double sueldoMensual;
    private double deduccionesVO;
    private int consulta;
    private int altaModFluj;
    private String nombreMonto;
    private String nombreImporte;
    private String descMontoSol;
    private String periodicidad;
    private CAntiguedadVO cAntiguedadVO;
    private CajaPagadoraVO cajaPagadoraVO;
    private String ipMaquina;
    private String descImporteCheque;
    private String descDtoAmt;
    private int cveRechazo;
    private RefinanciamientoVO refinanciamientoVO;
    private int refinancia;
    private int diaFec;
    private int mesFec;
    private int anioFEc;

    /**
     * @return the anioSol
     */
    public int getAnioSol() {
        return anioSol;
    }

    /**
     * @param anioSol the anioSol to set
     */
    public void setAnioSol(int anioSol) {
        this.anioSol = anioSol;
    }

    /**
     * @return the folioSol
     */
    public Integer getFolioSol() {
        return folioSol;
    }

    /**
     * @param folioSol the folioSol to set
     */
    public void setFolioSol(Integer folioSol) {
        this.folioSol = folioSol;
    }

    /**
     * @return the fechaSol
     */
    public Date getFechaSol() {
        return fechaSol;
    }

    /**
     * @param fechaSol the fechaSol to set
     */
    public void setFechaSol(Date fechaSol) {
        this.fechaSol = fechaSol;
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
     * @return the componenteCVE
     */
    public String getComponenteCVE() {
        return componenteCVE;
    }

    /**
     * @param componenteCVE the componenteCVE to set
     */
    public void setComponenteCVE(String componenteCVE) {
        this.componenteCVE = componenteCVE;
    }

    /**
     * @return the coberturaGlobVO
     */
    public CoberturaGlobVO getCoberturaGlobVO() {
        return coberturaGlobVO;
    }

    /**
     * @param coberturaGlobVO the coberturaGlobVO to set
     */
    public void setCoberturaGlobVO(CoberturaGlobVO coberturaGlobVO) {
        this.coberturaGlobVO = coberturaGlobVO;
    }

    /**
     * @return the tpoCreditoVO
     */
    public TpoCreditoVO getTpoCreditoVO() {
        return tpoCreditoVO;
    }

    /**
     * @param tpoCreditoVO the tpoCreditoVO to set
     */
    public void setTpoCreditoVO(TpoCreditoVO tpoCreditoVO) {
        this.tpoCreditoVO = tpoCreditoVO;
    }

    /**
     * @return the directo
     */
    public DirectoVO getDirecto() {
        return directo;
    }

    /**
     * @param directo the directo to set
     */
    public void setDirecto(DirectoVO directo) {
        this.directo = directo;
    }

    /**
     * @return the numRamo
     */
    public Integer getNumRamo() {
        return numRamo;
    }

    /**
     * @param numRamo the numRamo to set
     */
    public void setNumRamo(Integer numRamo) {
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
     * @return the cveTrc
     */
    public int getCveTrc() {
        return cveTrc;
    }

    /**
     * @param cveTrc the cveTrc to set
     */
    public void setCveTrc(int cveTrc) {
        this.cveTrc = cveTrc;
    }

    /**
     * @return the cramPagVO
     */
    public CramPagVO getCramPagVO() {
        return cramPagVO;
    }

    /**
     * @param cramPagVO the cramPagVO to set
     */
    public void setCramPagVO(CramPagVO cramPagVO) {
        this.cramPagVO = cramPagVO;
    }

    /**
     * @return the ctnoCveVO
     */
    public CtnoCveVO getCtnoCveVO() {
        return ctnoCveVO;
    }

    /**
     * @param ctnoCveVO the ctnoCveVO to set
     */
    public void setCtnoCveVO(CtnoCveVO ctnoCveVO) {
        this.ctnoCveVO = ctnoCveVO;
    }

    /**
     * @return the sueldoDer
     */
    public double getSueldoDer() {
        return sueldoDer;
    }

    /**
     * @param sueldoDer the sueldoDer to set
     */
    public void setSueldoDer(double sueldoDer) {
        this.sueldoDer = sueldoDer;
    }

    /**
     * @return the montoMaximoCred
     */
    public double getMontoMaximoCred() {
        return montoMaximoCred;
    }

    /**
     * @param montoMaximoCred the montoMaximoCred to set
     */
    public void setMontoMaximoCred(double montoMaximoCred) {
        this.montoMaximoCred = montoMaximoCred;
    }

    /**
     * @return the cAfectVO
     */
    public CAfectVO getcAfectVO() {
        return cAfectVO;
    }

    /**
     * @param cAfectVO the cAfectVO to set
     */
    public void setcAfectVO(CAfectVO cAfectVO) {
        this.cAfectVO = cAfectVO;
    }

    /**
     * @return the cveStatSol
     */
    public int getCveStatSol() {
        return cveStatSol;
    }

    /**
     * @param cveStatSol the cveStatSol to set
     */
    public void setCveStatSol(int cveStatSol) {
        this.cveStatSol = cveStatSol;
    }

    /**
     * @return the fecRechOto
     */
    public Date getFecRechOto() {
        return fecRechOto;
    }

    /**
     * @param fecRechOto the fecRechOto to set
     */
    public void setFecRechOto(Date fecRechOto) {
        this.fecRechOto = fecRechOto;
    }

    /**
     * @return the prstamoOrigVO
     */
    public PrstamoOrigVO getPrstamoOrigVO() {
        return prstamoOrigVO;
    }

    /**
     * @param prstamoOrigVO the prstamoOrigVO to set
     */
    public void setPrstamoOrigVO(PrstamoOrigVO prstamoOrigVO) {
        this.prstamoOrigVO = prstamoOrigVO;
    }

    /**
     * @return the saldoRef
     */
    public Double getSaldoRef() {
        return saldoRef;
    }

    /**
     * @param saldoRef the saldoRef to set
     */
    public void setSaldoRef(Double saldoRef) {
        this.saldoRef = saldoRef;
    }

    /**
     * @return the sueldoMensual
     */
    public Double getSueldoMensual() {
        return sueldoMensual;
    }

    /**
     * @param sueldoMensual the sueldoMensual to set
     */
    public void setSueldoMensual(Double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    /**
     * @return the deduccionesVO
     */
    public double getDeduccionesVO() {
        return deduccionesVO;
    }

    /**
     * @param deduccionesVO the deduccionesVO to set
     */
    public void setDeduccionesVO(double deduccionesVO) {
        this.deduccionesVO = deduccionesVO;
    }

    /**
     * @return the consulta
     */
    public int getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(int consulta) {
        this.consulta = consulta;
    }

    /**
     * @return the altaModFluj
     */
    public int getAltaModFluj() {
        return altaModFluj;
    }

    /**
     * @param altaModFluj the altaModFluj to set
     */
    public void setAltaModFluj(int altaModFluj) {
        this.altaModFluj = altaModFluj;
    }

    /**
     * @return the nombreMonto
     */
    public String getNombreMonto() {
        return nombreMonto;
    }

    /**
     * @param nombreMonto the nombreMonto to set
     */
    public void setNombreMonto(String nombreMonto) {
        this.nombreMonto = nombreMonto;
    }

    /**
     * @return the nombreImporte
     */
    public String getNombreImporte() {
        return nombreImporte;
    }

    /**
     * @param nombreImporte the nombreImporte to set
     */
    public void setNombreImporte(String nombreImporte) {
        this.nombreImporte = nombreImporte;
    }

    /**
     * @return the descMontoSol
     */
    public String getDescMontoSol() {
        return descMontoSol;
    }

    /**
     * @param descMontoSol the descMontoSol to set
     */
    public void setDescMontoSol(String descMontoSol) {
        this.descMontoSol = descMontoSol;
    }

    /**
     * @return the periodicidad
     */
    public String getPeriodicidad() {
        return periodicidad;
    }

    /**
     * @param periodicidad the periodicidad to set
     */
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    /**
     * @return the antiguedad
     */
    public CAntiguedadVO getAntiguedad() {
        return getcAntiguedadVO();
    }

    /**
     * @param antiguedad the antiguedad to set
     */
    public void setAntiguedad(CAntiguedadVO cAntiguedadVO) {
        this.setcAntiguedadVO(cAntiguedadVO);
    }

    /**
     * @return the cAntiguedadVO
     */
    public CAntiguedadVO getcAntiguedadVO() {
        return cAntiguedadVO;
    }

    /**
     * @param cAntiguedadVO the cAntiguedadVO to set
     */
    public void setcAntiguedadVO(CAntiguedadVO cAntiguedadVO) {
        this.cAntiguedadVO = cAntiguedadVO;
    }

    /**
     * @return the cajaPagadoraVO
     */
    public CajaPagadoraVO getCajaPagadoraVO() {
        return cajaPagadoraVO;
    }

    /**
     * @param cajaPagadoraVO the cajaPagadoraVO to set
     */
    public void setCajaPagadoraVO(CajaPagadoraVO cajaPagadoraVO) {
        this.cajaPagadoraVO = cajaPagadoraVO;
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
     * @return the importeCheque
     */
    public String getDescImporteCheque() {
        return descImporteCheque;
    }

    /**
     * @param importeCheque the importeCheque to set
     */
    public void setDescImporteCheque(String descImporteCheque) {
        this.descImporteCheque = descImporteCheque;
    }

    /**
     * @return the descDtoAmt
     */
    public String getDescDtoAmt() {
        return descDtoAmt;
    }

    /**
     * @param descDtoAmt the descDtoAmt to set
     */
    public void setDescDtoAmt(String descDtoAmt) {
        this.descDtoAmt = descDtoAmt;
    }

    /**
     * @return the descRamo
     */
    public String getDescRamo() {
        return descRamo;
    }

    /**
     * @param descRamo the descRamo to set
     */
    public void setDescRamo(String descRamo) {
        this.descRamo = descRamo;
    }

    /**
     * @return the cveRechazo
     */
    public int getCveRechazo() {
        return cveRechazo;
    }

    /**
     * @param cveRechazo the cveRechazo to set
     */
    public void setCveRechazo(int cveRechazo) {
        this.cveRechazo = cveRechazo;
    }

    /**
     * @return the descuentoProcVO
     */
    public DescuentoProcVO getDescuentoProcVO() {
        return descuentoProcVO;
    }

    /**
     * @param descuentoProcVO the descuentoProcVO to set
     */
    public void setDescuentoProcVO(DescuentoProcVO descuentoProcVO) {
        this.descuentoProcVO = descuentoProcVO;
    }

    /**
     * @return the refinanciamientoVO
     */
    public RefinanciamientoVO getRefinanciamientoVO() {
        return refinanciamientoVO;
    }

    /**
     * @param refinanciamientoVO the refinanciamientoVO to set
     */
    public void setRefinanciamientoVO(RefinanciamientoVO refinanciamientoVO) {
        this.refinanciamientoVO = refinanciamientoVO;
    }

    /**
     * @return the refinancia
     */
    public int getRefinancia() {
        return refinancia;
    }

    /**
     * @param refinancia the refinancia to set
     */
    public void setRefinancia(int refinancia) {
        this.refinancia = refinancia;
    }

    /**
     * @return the diaFec
     */
    public int getDiaFec() {
        return diaFec;
    }

    /**
     * @param diaFec the diaFec to set
     */
    public void setDiaFec(int diaFec) {
        this.diaFec = diaFec;
    }

    /**
     * @return the mesFec
     */
    public int getMesFec() {
        return mesFec;
    }

    /**
     * @param mesFec the mesFec to set
     */
    public void setMesFec(int mesFec) {
        this.mesFec = mesFec;
    }

    /**
     * @return the anioFEc
     */
    public int getAnioFEc() {
        return anioFEc;
    }

    /**
     * @param anioFEc the anioFEc to set
     */
    public void setAnioFEc(int anioFEc) {
        this.anioFEc = anioFEc;
    }
}
