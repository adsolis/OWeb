/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.BplazaVO;
import com.ucol.otweb.vo.CtnoCveVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoAVVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.PenIndVO;
import com.ucol.otweb.vo.PlazaVO;
import com.ucol.otweb.vo.PzaPenVO;
import com.ucol.otweb.vo.SolPensionVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IDatosLaborales {
    public List<DirectoAVVO> busquedaDerechohabienteAVDirecto(DatosLaboralesVO datosPersona, boolean dtoEstado);
    public List<DirectoVO> busquedaDerechohabienteDirecto(DatosLaboralesVO datosPersona);
    public List<PlazaVO> buscarPlazas(DatosLaboralesVO numIssste, String base, boolean modCvPlEs);
    public List<PzaPenVO> buscarPlazaPensionado(DatosLaboralesVO numIssste, String base,boolean fechaActual);
    public List<BplazaVO> busquedaRamoPagaduriaPlaza(Integer issste);
    public CtnoCveVO obtenerClaveSicNombramientoTrabajador(Integer tno_cve);
    public Integer countPlazasPorModCve(Integer numIssste, String base);
    public void insertData(EntidadVO ent);
    public void deleteData(Integer id);
    public void updateData(EntidadVO ent);
    public Integer countPlazas(Integer numIssste, String base);
    public Integer countPlazasPen(DatosLaboralesVO datosLaboralesVO, String base, boolean fechaActu);
    public List<PlazaVO> buscarPlazasAct(Integer numIssste, String base,boolean aLaFechaActual);
    public Double obtenerSumaSueldoPlaza(Integer numIssste, boolean simulado);
    public Double obtenerSumaSueldoPlazaPen(Integer numIssste, boolean simulado);
    public List<PenIndVO> obtenerPensionIndirecta(Integer numIssste);
    public List<SolPensionVO> obtenerSolicPension(Integer numIssste, Integer speId);
    public List<PenIndVO> obtenerIDPensionIndirecta(PenIndVO indVO) ;
    public List<CtnoCveVO> obtenerNombEnPlaza(DatosLaboralesVO datosLaboralesVO);
    public List<PzaPenVO> obtenerPlazaDeAcuedoRamoPen(Integer numIssste, Integer ramoPens,String base);
     /**
     * se obtiene la plaza de pensionado por el numero de ISSSTE con los filtros de ramo y t_pension
     * @param numIssste
     * @return
     */
    public List<PzaPenVO> obtenerPlzaPenByNumIsssteFiltrado(int numIssste);
    public CtnoCveVO obtenerObjCTCve(int ctnoCve);
    public boolean updatePlazaPen(PzaPenVO pzaPenVO, Double sueldo, String usuario, String componente, String ipMaquina);
    public boolean insertPlazaPen(PzaPenVO pzaPenVO);
    public boolean insertDirecto(DirectoAVVO directoAVVO);
    public boolean insertPlaza(PlazaVO plazaVO);
    public boolean updatePlaza(PlazaVO plazaVO, Double sueldo, String usuario, String componente, String ipMaquina);
    public boolean updateDirecto(DirectoVO directoAVVO);
    public void updateDirectoEntRec(DirectoVO directoAVVO) ;
    /**
     * conteo para saber si la antiguedad es la permitida
     * con respecto a la tabla de parametros de otorgamiento
     * @param numIssste
     * @return 
     */
    public Integer countAntiguedadPermitida(int numIssste);
}
