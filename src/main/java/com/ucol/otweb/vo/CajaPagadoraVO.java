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
public class CajaPagadoraVO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private Integer idEntidad;
    private Integer idDelegacion;
    private Integer idUniad;
    private Integer idOficina;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String usuario;
    private Date fechaAud;
    private String componente;
    private String ip_equipo;
    private Integer dia_cheque;
    private Integer id_estatus;
    private String entidad;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idEntidad
     */
    public Integer getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the idDelegacion
     */
    public Integer getIdDelegacion() {
        return idDelegacion;
    }

    /**
     * @param idDelegacion the idDelegacion to set
     */
    public void setIdDelegacion(Integer idDelegacion) {
        this.idDelegacion = idDelegacion;
    }

    /**
     * @return the idUniad
     */
    public Integer getIdUniad() {
        return idUniad;
    }

    /**
     * @param idUniad the idUniad to set
     */
    public void setIdUniad(Integer idUniad) {
        this.idUniad = idUniad;
    }

    /**
     * @return the idOficina
     */
    public Integer getIdOficina() {
        return idOficina;
    }

    /**
     * @param idOficina the idOficina to set
     */
    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
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
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
     * @return the componente
     */
    public String getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(String componente) {
        this.componente = componente;
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

    /**
     * @return the dia_cheque
     */
    public Integer getDia_cheque() {
        return dia_cheque;
    }

    /**
     * @param dia_cheque the dia_cheque to set
     */
    public void setDia_cheque(Integer dia_cheque) {
        this.dia_cheque = dia_cheque;
    }

    /**
     * @return the id_estatus
     */
    public Integer getId_estatus() {
        return id_estatus;
    }

    /**
     * @param id_estatus the id_estatus to set
     */
    public void setId_estatus(Integer id_estatus) {
        this.id_estatus = id_estatus;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
    
}
