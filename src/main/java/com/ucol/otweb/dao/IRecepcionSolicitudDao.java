/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.MotivosSolVO;
import com.ucol.otweb.vo.RecepcionVO;
import com.ucol.otweb.vo.SolicitudVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 
 */
public interface IRecepcionSolicitudDao {

    public Integer countRecepcionSolicitud(RecepcionVO recepcionVO);
    public List<RecepcionVO> obtenerCoberturaSolicitudCredito(RecepcionVO recepcionVO);
    public Integer countRechazosSolicitud(RecepcionVO recepcionVO);
    public Integer countRecepcionSolicitudesPorIssste(Integer numIssste);
    public Integer countRecepcionPorOperador(RecepcionVO recepcionVO);
    public Integer obtenerEstatusSolicitudOtorgada(int numIssste,String rfc);
    public Integer obtenerSolicitudOcupada(int folioSol,int tpoCr);
    public List<SolicitudVO> obtenerSolicitudCredito(SolicitudVO solicitudVO);
    public Integer countRecepcionSolicitudSim(TransMovOtoWeb movOtoWeb, int anio);
    public Integer countMotivosSolFolio(Integer folio, int tipoPrest);

    public void eliminarRecepcion(RecepcionVO recepcion);

    public boolean insert(RecepcionVO recepcion);

    public void insert(SolicitudVO sol);

    public void update(SolicitudVO sol);

    public Date rechazoVisual(int folio, int cveTcr);

    public Date obtenerFechaRec(int folio, int cveTcr);
    
    public boolean eliminarMotivoSol(MotivosSolVO motivosSolVO);
    
    public boolean eliminarSolicitud(SolicitudVO solicitudVO);

    public List<MotivosSolVO> obtenerClaveMotivoSol(MotivosSolVO motivosSolVO);

    public void update(MotivosSolVO motVO);

    public void insertMotSol(MotivosSolVO motivosSolVO);
}
