/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.TpoCreditoVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface ITipoCreditoDAO {

    public List obtenerTiposCredito(boolean activaClave);
    public TpoCreditoVO obtenerTipoCredito(int cveTcr) ;
    public Double obtenerMontoMinTipoCred(int cveTcr) ;
}
