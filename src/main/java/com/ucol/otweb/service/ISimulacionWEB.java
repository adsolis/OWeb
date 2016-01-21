/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.PresolicitudVO;
import com.ucol.otweb.vo.TransMovOtoWeb;
import java.util.List;

/**
 *
 * @author 
 */
public interface ISimulacionWEB {

    public List obtenerTiposCreditoWEB();
    public PresolicitudVO simulacionOtorgamiento(TransMovOtoWeb derechOtor, int altaMod, boolean simulado, String vehiculo);

    public PresolicitudVO simulacion(Integer numIssste, FolioVO folioVO, Integer tipoPrestamo,CajaPagadoraVO cajaPagadoraVO,String ipMaquina, String vehiculo);
}
