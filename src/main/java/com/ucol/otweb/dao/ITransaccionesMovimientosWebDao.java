/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.OtorgamWebContad;
import com.ucol.otweb.vo.TransMovOtoWeb;
import com.ucol.otweb.vo.TransOtoVO;

/**
 *
 * @author 
 */
public interface ITransaccionesMovimientosWebDao {
    public TransMovOtoWeb  obtenerTransMovWeb(TransMovOtoWeb transMovOto);
    public OtorgamWebContad obtenerContadorVisitasWeb ();
    public OtorgamWebContad obtenerDiaFestivoAlDia ();
    public void update(TransMovOtoWeb transMovOtoWeb);
    public void insertData(TransMovOtoWeb transMovOtoWeb);
    public void updatePorIsssteFolio(TransMovOtoWeb transMovOtoWeb);
    public void insertContador(OtorgamWebContad contador);
    public void incrementaContador(OtorgamWebContad contador);

    public void insert(TransOtoVO transOto);
    
}
