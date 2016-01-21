/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CParamOtorgaVO;
import com.ucol.otweb.vo.CSicParamVO;

/**
 *
 * @author 
 */
public interface IParametrosOtorgamientoDao {
    public CParamOtorgaVO obtenerParametroByID(int cveParamOtorga);

    public Integer insert(CSicParamVO cSicParamVO);
}
