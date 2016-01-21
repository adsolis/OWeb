/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.FolioClaveVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.RecepcionVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IFolioDao {
    public List<FolioVO> consultaFolioXPrestamo(Integer cveTrc, Integer numFolio);
    public List<FolioVO> obtenerFolioSolicitud(FolioVO folioSolicitud);
    public Integer countFoliosBloqueados(RecepcionVO folioSolicitud);
    public Integer countFolioRamo(int ramFol, int ramPlz);
   /**
     * Con ciertos rangos de folios se van a poder otorgar créditos de un tipo préstamo 
     * aun cuando ya hayan hecho uso del máximo número de préstamos para ese tipo
     * @param folio numero de folio que se buscara entre los Folios especiales
     * @param cveTcr clave del tipo de prestamos
     * @param anio anio para cuando es valido el prestamo adicional
     * @return
     */
    public Integer obtenerNumeroPresAdicFoliosEspeciales(int folio, int cveTcr, int anio );
    public FolioVO obtenerFolios(int folioSol, int cveTcr, int anio);
    public Integer countFolios(FolioVO params, boolean sinCobertura);
    public Integer obtenerEstatusProc(String funcion);
    public List<FolioClaveVO> obtenerClaveFolio(FolioVO folioVO);
}
