/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.CoberturaGlobVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoVO;

/**
 *
 * @author 
 */
public interface IValidacionesGeneralesWeb {
    int validacionUsuario(DatosLaboralesVO laboralesVO, String ipMaquina);
    DirectoVO buscarPersona(DatosLaboralesVO persona);
    CoberturaGlobVO validarCoberturaUsuarioOtorWeb(int cveEntidad, int cveDelegacion, int cveUniad, int cveOficina);
}
