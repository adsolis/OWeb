/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CDelegacionVO;
import com.ucol.otweb.vo.COficinaVO;
import com.ucol.otweb.vo.CUnidadVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.EntidadVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface ICoberturaDao {
    public List<CajaPagadoraVO> buscarCajasPagadorasPorEntidad(CajaPagadoraVO caja);
    public List<CajaPagadoraVO> buscarCajasPagadorasSimulacion(CajaPagadoraVO caja);
    public Integer buscarEntidadPorCodigoPostal(Integer codigoPostal);
    public Integer buscarRamoAnterior(Integer ramo, String pagaduria,String base);
    public Integer obtenerGrupoRamoAnt(Integer ramoAnt);
    /**
     * Se obtiene la oficina por los datos de la cobertura
     * @return
     */
    public COficinaVO obtenerOficinaPorCobertura(int cveEntidad, int cveDeleg, int cveUniad);
    public COficinaVO obtenerOficinaBPorCobertura(int cveEntidad, int cveDeleg, Integer cveUniad, Integer cveOficina);
    public CUnidadVO obtenerUnidadPorCobertura(int cveEntidad, int cveDeleg, int cveUniad);
    public CDelegacionVO obtenerDelegacionPorCobertura(int cveEntidad, int cveDeleg);
    public EntidadVO obtenerEntidadPorCobertura(int cveEntidad);
    public CajaPagadoraVO obtenerCajaPorEntidadAutos(int entidad);
    public List<CajaPagadoraVO> obtenerCajaRamoDF(int ramoDF);
}
