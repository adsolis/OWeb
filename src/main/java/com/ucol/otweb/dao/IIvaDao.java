/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CIvaFrontVO;

/**
 *
 * @author 
 */
public interface IIvaDao {
    
    public CIvaFrontVO obtenerIvaFronterizo(Integer entidad, Integer codPostal);
    public Integer obtenerPorcTipIva(Integer cveTiva);
    
}
