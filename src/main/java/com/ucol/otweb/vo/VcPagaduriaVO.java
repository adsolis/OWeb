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
public class VcPagaduriaVO implements Serializable{
    
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    private Integer numRamo;
    private String numPagaduria;
    private Double ramAnt;
    private Double disCve;
    private String entCve;
    private String entDis;
    private Double secCve;
    private Double modCve;
    private String mbaCve;
    private String resCve;
    private String resCCve;
    private Double codigoPostal;
    private Double ncoCve;
    private String pagEstado;
    private String tAseguramiento;
    private String tInterInf;
    private String distribucion;
    private Date fechaIniciaACt;
    private Date fechaAlta;
    private Date fechaBaja;
    private Float porcentAporSm;
    private Float porcentAporCre;
    private Float porcentAporSar;
    private Float porcentAporPen;
    private Float porcentAporEst;
    private Float porcentAporFov;
    private Float porcentAporGa;
    private Float porcentAporRt;
    private Float porcentCuoGa;
    private Float porcentCuoCre;
    private Float porcentCuoPen;
    private Float porcentCuoSm;
    private Float porcentCuoEst;
    private String numExterior;
    private String numInterior;
    private String telefono;
    private String calle;
    private String nombre;
    private String tPagoAportacn;
    private String tPagoCuota;
    private String tPagoRetencn;

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
     * @return the ramAnt
     */
    public Double getRamAnt() {
        return ramAnt;
    }

    /**
     * @param ramAnt the ramAnt to set
     */
    public void setRamAnt(Double ramAnt) {
        this.ramAnt = ramAnt;
    }

    /**
     * @return the disCve
     */
    public Double getDisCve() {
        return disCve;
    }

    /**
     * @param disCve the disCve to set
     */
    public void setDisCve(Double disCve) {
        this.disCve = disCve;
    }

    /**
     * @return the entCve
     */
    public String getEntCve() {
        return entCve;
    }

    /**
     * @param entCve the entCve to set
     */
    public void setEntCve(String entCve) {
        this.entCve = entCve;
    }

    /**
     * @return the entDis
     */
    public String getEntDis() {
        return entDis;
    }

    /**
     * @param entDis the entDis to set
     */
    public void setEntDis(String entDis) {
        this.entDis = entDis;
    }

    /**
     * @return the secCve
     */
    public Double getSecCve() {
        return secCve;
    }

    /**
     * @param secCve the secCve to set
     */
    public void setSecCve(Double secCve) {
        this.secCve = secCve;
    }

    /**
     * @return the modCve
     */
    public Double getModCve() {
        return modCve;
    }

    /**
     * @param modCve the modCve to set
     */
    public void setModCve(Double modCve) {
        this.modCve = modCve;
    }

    /**
     * @return the mbaCve
     */
    public String getMbaCve() {
        return mbaCve;
    }

    /**
     * @param mbaCve the mbaCve to set
     */
    public void setMbaCve(String mbaCve) {
        this.mbaCve = mbaCve;
    }

    /**
     * @return the resCve
     */
    public String getResCve() {
        return resCve;
    }

    /**
     * @param resCve the resCve to set
     */
    public void setResCve(String resCve) {
        this.resCve = resCve;
    }

    /**
     * @return the codigoPostal
     */
    public Double getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(Double codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the ncoCve
     */
    public Double getNcoCve() {
        return ncoCve;
    }

    /**
     * @param ncoCve the ncoCve to set
     */
    public void setNcoCve(Double ncoCve) {
        this.ncoCve = ncoCve;
    }

    /**
     * @return the pagEstado
     */
    public String getPagEstado() {
        return pagEstado;
    }

    /**
     * @param pagEstado the pagEstado to set
     */
    public void setPagEstado(String pagEstado) {
        this.pagEstado = pagEstado;
    }

    /**
     * @return the tAseguramiento
     */
    public String gettAseguramiento() {
        return tAseguramiento;
    }

    /**
     * @param tAseguramiento the tAseguramiento to set
     */
    public void settAseguramiento(String tAseguramiento) {
        this.tAseguramiento = tAseguramiento;
    }

    /**
     * @return the tInterInf
     */
    public String gettInterInf() {
        return tInterInf;
    }

    /**
     * @param tInterInf the tInterInf to set
     */
    public void settInterInf(String tInterInf) {
        this.tInterInf = tInterInf;
    }

    /**
     * @return the distribucion
     */
    public String getDistribucion() {
        return distribucion;
    }

    /**
     * @param distribucion the distribucion to set
     */
    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    /**
     * @return the fechaIniciaACt
     */
    public Date getFechaIniciaACt() {
        return fechaIniciaACt;
    }

    /**
     * @param fechaIniciaACt the fechaIniciaACt to set
     */
    public void setFechaIniciaACt(Date fechaIniciaACt) {
        this.fechaIniciaACt = fechaIniciaACt;
    }

    /**
     * @return the fechaAlta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta the fechaAlta to set
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * @return the fechaBaja
     */
    public Date getFechaBaja() {
        return fechaBaja;
    }

    /**
     * @param fechaBaja the fechaBaja to set
     */
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     * @return the porcentAporSm
     */
    public Float getPorcentAporSm() {
        return porcentAporSm;
    }

    /**
     * @param porcentAporSm the porcentAporSm to set
     */
    public void setPorcentAporSm(Float porcentAporSm) {
        this.porcentAporSm = porcentAporSm;
    }

    /**
     * @return the porcentAporCre
     */
    public Float getPorcentAporCre() {
        return porcentAporCre;
    }

    /**
     * @param porcentAporCre the porcentAporCre to set
     */
    public void setPorcentAporCre(Float porcentAporCre) {
        this.porcentAporCre = porcentAporCre;
    }

    /**
     * @return the porcentAporSar
     */
    public Float getPorcentAporSar() {
        return porcentAporSar;
    }

    /**
     * @param porcentAporSar the porcentAporSar to set
     */
    public void setPorcentAporSar(Float porcentAporSar) {
        this.porcentAporSar = porcentAporSar;
    }

    /**
     * @return the porcentAporPen
     */
    public Float getPorcentAporPen() {
        return porcentAporPen;
    }

    /**
     * @param porcentAporPen the porcentAporPen to set
     */
    public void setPorcentAporPen(Float porcentAporPen) {
        this.porcentAporPen = porcentAporPen;
    }

    /**
     * @return the porcentAporEst
     */
    public Float getPorcentAporEst() {
        return porcentAporEst;
    }

    /**
     * @param porcentAporEst the porcentAporEst to set
     */
    public void setPorcentAporEst(Float porcentAporEst) {
        this.porcentAporEst = porcentAporEst;
    }

    /**
     * @return the porcentAporFov
     */
    public Float getPorcentAporFov() {
        return porcentAporFov;
    }

    /**
     * @param porcentAporFov the porcentAporFov to set
     */
    public void setPorcentAporFov(Float porcentAporFov) {
        this.porcentAporFov = porcentAporFov;
    }

    /**
     * @return the porcentAporGa
     */
    public Float getPorcentAporGa() {
        return porcentAporGa;
    }

    /**
     * @param porcentAporGa the porcentAporGa to set
     */
    public void setPorcentAporGa(Float porcentAporGa) {
        this.porcentAporGa = porcentAporGa;
    }

    /**
     * @return the porcentAporRt
     */
    public Float getPorcentAporRt() {
        return porcentAporRt;
    }

    /**
     * @param porcentAporRt the porcentAporRt to set
     */
    public void setPorcentAporRt(Float porcentAporRt) {
        this.porcentAporRt = porcentAporRt;
    }

    /**
     * @return the porcentCuoGa
     */
    public Float getPorcentCuoGa() {
        return porcentCuoGa;
    }

    /**
     * @param porcentCuoGa the porcentCuoGa to set
     */
    public void setPorcentCuoGa(Float porcentCuoGa) {
        this.porcentCuoGa = porcentCuoGa;
    }

    /**
     * @return the porcentCuoCre
     */
    public Float getPorcentCuoCre() {
        return porcentCuoCre;
    }

    /**
     * @param porcentCuoCre the porcentCuoCre to set
     */
    public void setPorcentCuoCre(Float porcentCuoCre) {
        this.porcentCuoCre = porcentCuoCre;
    }

    /**
     * @return the porcentCuoPen
     */
    public Float getPorcentCuoPen() {
        return porcentCuoPen;
    }

    /**
     * @param porcentCuoPen the porcentCuoPen to set
     */
    public void setPorcentCuoPen(Float porcentCuoPen) {
        this.porcentCuoPen = porcentCuoPen;
    }

    /**
     * @return the porcentCuoSm
     */
    public Float getPorcentCuoSm() {
        return porcentCuoSm;
    }

    /**
     * @param porcentCuoSm the porcentCuoSm to set
     */
    public void setPorcentCuoSm(Float porcentCuoSm) {
        this.porcentCuoSm = porcentCuoSm;
    }

    /**
     * @return the porcentCuoEst
     */
    public Float getPorcentCuoEst() {
        return porcentCuoEst;
    }

    /**
     * @param porcentCuoEst the porcentCuoEst to set
     */
    public void setPorcentCuoEst(Float porcentCuoEst) {
        this.porcentCuoEst = porcentCuoEst;
    }

    /**
     * @return the numExterior
     */
    public String getNumExterior() {
        return numExterior;
    }

    /**
     * @param numExterior the numExterior to set
     */
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * @return the numInterior
     */
    public String getNumInterior() {
        return numInterior;
    }

    /**
     * @param numInterior the numInterior to set
     */
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
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
     * @return the tPagoAportacn
     */
    public String gettPagoAportacn() {
        return tPagoAportacn;
    }

    /**
     * @param tPagoAportacn the tPagoAportacn to set
     */
    public void settPagoAportacn(String tPagoAportacn) {
        this.tPagoAportacn = tPagoAportacn;
    }

    /**
     * @return the tPagoCuota
     */
    public String gettPagoCuota() {
        return tPagoCuota;
    }

    /**
     * @param tPagoCuota the tPagoCuota to set
     */
    public void settPagoCuota(String tPagoCuota) {
        this.tPagoCuota = tPagoCuota;
    }

    /**
     * @return the tPagoRetencn
     */
    public String gettPagoRetencn() {
        return tPagoRetencn;
    }

    /**
     * 
     * @param tPagoRetencn
     */
    public void settPagoRetencn(String tPagoRetencn) {
        this.tPagoRetencn = tPagoRetencn;
    }

    /**
     * @return the resCCve
     */
    public String getResCCve() {
        return resCCve;
    }

    /**
     * @param resCCve the resCCve to set
     */
    public void setResCCve(String resCCve) {
        this.resCCve = resCCve;
    }
    
    
}
