/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.ObjetoCajasVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.TpoCreditoVO;
import com.ucol.otweb.vo.TransMovOtoWeb;

/**
 *
 * @author 
 */
public interface IValidacionFolioWeb {
     ObjetoCajasVO validacionParaCajas(Integer numIssste, Integer numFolio, int tipoCred);
     TpoCreditoVO validacionFolioOtorWeb(Integer numIssste, Integer numFolio, String clave) ;
     int validaFolioGeneralSolicitud(TransMovOtoWeb movOtoWeb, int nombramiento);
     int obtenerEntidadPorFolio(Integer numIssste, Integer numFolio, Integer tipoPrestamo);
     FolioVO obtenerAfectTPrestoDeFolio(int tpoCve, Integer folioSol);
     boolean validarFolio(PresolicitudVO presolicitudVO, int nombramiento);
    
}
