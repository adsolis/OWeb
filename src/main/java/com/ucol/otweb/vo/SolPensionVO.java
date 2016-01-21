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
public class SolPensionVO implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer speId;
private String uVersion;
private Integer locId;
private Integer numIssste;
private int tbnCve;
private int indPrimB;
private String entCve;
private String rfc;
private Date fechaSolicitud;
private int speEstado;
private Date fechaEstado;
private int numGrupoFam;
private int disCve;
private int numCtrlMes;
private String numCtrlConsec;
private Integer tiempoCotizado;
private int tiempoLicencias;
private int tiempoTratoEsp;
private int semana;
private String compartida;
private String compatible;
private int numBeneficiario;
private Double cuotaDiariaOri;
private Double cuotaDiariaVig;
private String tratoEspecial;
private Date fechaFallec;
private Integer numPension;
private Date fechaCaptura;
private Date fechaProceso;
private Date fechaIniPen;
private Double montoLicencias;
private int errCve;
private Double porcentaje;
private String entCveOri;
private String usuario;
private Date fechaAud;
private String horaAud;
private String componenteCve;
private String ipMaquina;

    /**
     * @return the speId
     */
    public Integer getSpeId() {
        return speId;
    }

    /**
     * @param speId the speId to set
     */
    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    /**
     * @return the uVersion
     */
    public String getuVersion() {
        return uVersion;
    }

    /**
     * @param uVersion the uVersion to set
     */
    public void setuVersion(String uVersion) {
        this.uVersion = uVersion;
    }

    /**
     * @return the locId
     */
    public Integer getLocId() {
        return locId;
    }

    /**
     * @param locId the locId to set
     */
    public void setLocId(Integer locId) {
        this.locId = locId;
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
     * @return the tbnCve
     */
    public int getTbnCve() {
        return tbnCve;
    }

    /**
     * @param tbnCve the tbnCve to set
     */
    public void setTbnCve(int tbnCve) {
        this.tbnCve = tbnCve;
    }

    /**
     * @return the indPrimB
     */
    public int getIndPrimB() {
        return indPrimB;
    }

    /**
     * @param indPrimB the indPrimB to set
     */
    public void setIndPrimB(int indPrimB) {
        this.indPrimB = indPrimB;
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
     * @return the fechaSolicitud
     */
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * @param fechaSolicitud the fechaSolicitud to set
     */
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * @return the speEstado
     */
    public int getSpeEstado() {
        return speEstado;
    }

    /**
     * @param speEstado the speEstado to set
     */
    public void setSpeEstado(int speEstado) {
        this.speEstado = speEstado;
    }

    /**
     * @return the fechaEstado
     */
    public Date getFechaEstado() {
        return fechaEstado;
    }

    /**
     * @param fechaEstado the fechaEstado to set
     */
    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    /**
     * @return the numGrupoFam
     */
    public int getNumGrupoFam() {
        return numGrupoFam;
    }

    /**
     * @param numGrupoFam the numGrupoFam to set
     */
    public void setNumGrupoFam(int numGrupoFam) {
        this.numGrupoFam = numGrupoFam;
    }

    /**
     * @return the disCve
     */
    public int getDisCve() {
        return disCve;
    }

    /**
     * @param disCve the disCve to set
     */
    public void setDisCve(int disCve) {
        this.disCve = disCve;
    }

    /**
     * @return the numCtrlMes
     */
    public int getNumCtrlMes() {
        return numCtrlMes;
    }

    /**
     * @param numCtrlMes the numCtrlMes to set
     */
    public void setNumCtrlMes(int numCtrlMes) {
        this.numCtrlMes = numCtrlMes;
    }

    /**
     * @return the numCtrlConsec
     */
    public String getNumCtrlConsec() {
        return numCtrlConsec;
    }

    /**
     * @param numCtrlConsec the numCtrlConsec to set
     */
    public void setNumCtrlConsec(String numCtrlConsec) {
        this.numCtrlConsec = numCtrlConsec;
    }

    /**
     * @return the tiempoCotizado
     */
    public Integer getTiempoCotizado() {
        return tiempoCotizado;
    }

    /**
     * @param tiempoCotizado the tiempoCotizado to set
     */
    public void setTiempoCotizado(Integer tiempoCotizado) {
        this.tiempoCotizado = tiempoCotizado;
    }

    /**
     * @return the tiempoLicencias
     */
    public int getTiempoLicencias() {
        return tiempoLicencias;
    }

    /**
     * @param tiempoLicencias the tiempoLicencias to set
     */
    public void setTiempoLicencias(int tiempoLicencias) {
        this.tiempoLicencias = tiempoLicencias;
    }

    /**
     * @return the tiempoTratoEsp
     */
    public int getTiempoTratoEsp() {
        return tiempoTratoEsp;
    }

    /**
     * @param tiempoTratoEsp the tiempoTratoEsp to set
     */
    public void setTiempoTratoEsp(int tiempoTratoEsp) {
        this.tiempoTratoEsp = tiempoTratoEsp;
    }

    /**
     * @return the semana
     */
    public int getSemana() {
        return semana;
    }

    /**
     * @param semana the semana to set
     */
    public void setSemana(int semana) {
        this.semana = semana;
    }

    /**
     * @return the compartida
     */
    public String getCompartida() {
        return compartida;
    }

    /**
     * @param compartida the compartida to set
     */
    public void setCompartida(String compartida) {
        this.compartida = compartida;
    }

    /**
     * @return the compatible
     */
    public String getCompatible() {
        return compatible;
    }

    /**
     * @param compatible the compatible to set
     */
    public void setCompatible(String compatible) {
        this.compatible = compatible;
    }

    /**
     * @return the numBeneficiario
     */
    public int getNumBeneficiario() {
        return numBeneficiario;
    }

    /**
     * @param numBeneficiario the numBeneficiario to set
     */
    public void setNumBeneficiario(int numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    /**
     * @return the cuotaDiariaOri
     */
    public Double getCuotaDiariaOri() {
        return cuotaDiariaOri;
    }

    /**
     * @param cuotaDiariaOri the cuotaDiariaOri to set
     */
    public void setCuotaDiariaOri(Double cuotaDiariaOri) {
        this.cuotaDiariaOri = cuotaDiariaOri;
    }

    /**
     * @return the cuotaDiariaVig
     */
    public Double getCuotaDiariaVig() {
        return cuotaDiariaVig;
    }

    /**
     * @param cuotaDiariaVig the cuotaDiariaVig to set
     */
    public void setCuotaDiariaVig(Double cuotaDiariaVig) {
        this.cuotaDiariaVig = cuotaDiariaVig;
    }

    /**
     * @return the tratoEspecial
     */
    public String getTratoEspecial() {
        return tratoEspecial;
    }

    /**
     * @param tratoEspecial the tratoEspecial to set
     */
    public void setTratoEspecial(String tratoEspecial) {
        this.tratoEspecial = tratoEspecial;
    }

    /**
     * @return the fechaFallec
     */
    public Date getFechaFallec() {
        return fechaFallec;
    }

    /**
     * @param fechaFallec the fechaFallec to set
     */
    public void setFechaFallec(Date fechaFallec) {
        this.fechaFallec = fechaFallec;
    }

    /**
     * @return the numPension
     */
    public Integer getNumPension() {
        return numPension;
    }

    /**
     * @param numPension the numPension to set
     */
    public void setNumPension(Integer numPension) {
        this.numPension = numPension;
    }

    /**
     * @return the fechaCaptura
     */
    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    /**
     * @param fechaCaptura the fechaCaptura to set
     */
    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    /**
     * @return the fechaProceso
     */
    public Date getFechaProceso() {
        return fechaProceso;
    }

    /**
     * @param fechaProceso the fechaProceso to set
     */
    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    /**
     * @return the fechaIniPen
     */
    public Date getFechaIniPen() {
        return fechaIniPen;
    }

    /**
     * @param fechaIniPen the fechaIniPen to set
     */
    public void setFechaIniPen(Date fechaIniPen) {
        this.fechaIniPen = fechaIniPen;
    }

    /**
     * @return the montoLicencias
     */
    public Double getMontoLicencias() {
        return montoLicencias;
    }

    /**
     * @param montoLicencias the montoLicencias to set
     */
    public void setMontoLicencias(Double montoLicencias) {
        this.montoLicencias = montoLicencias;
    }

    /**
     * @return the errCve
     */
    public int getErrCve() {
        return errCve;
    }

    /**
     * @param errCve the errCve to set
     */
    public void setErrCve(int errCve) {
        this.errCve = errCve;
    }

    /**
     * @return the porcentaje
     */
    public Double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the entCveOri
     */
    public String getEntCveOri() {
        return entCveOri;
    }

    /**
     * @param entCveOri the entCveOri to set
     */
    public void setEntCveOri(String entCveOri) {
        this.entCveOri = entCveOri;
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


    
}
