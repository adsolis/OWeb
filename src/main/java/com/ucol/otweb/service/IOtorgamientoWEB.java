/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service;

import com.ucol.otweb.vo.AgenciaAseguradoAutoVO;
import com.ucol.otweb.vo.BplazaVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.FolioVO;
import com.ucol.otweb.vo.PresolicitudVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IOtorgamientoWEB {
    public List<CajaPagadoraVO> obtenerCajasPagadoras( int cveEntidad);
    public List<CajaPagadoraVO> obtenerDetalleCajasPagadoras(int cveEntidad);
    public List<CajaPagadoraVO> obtenerCajasPAgadorasRamoDF(int ramoDF);
    public List<BplazaVO> BPlaza(Integer issste);
    public void insertData(EntidadVO ent);
    public void deleteData(Integer id);
    public void updateData(EntidadVO ent);
    public PresolicitudVO otorgamientoWeb(PresolicitudVO presolicitudVO,DirectoVO perOtorgW, FolioVO folioVO, boolean simulado, int altaMod, String vehiculo);
    public CajaPagadoraVO obtenerCajasPagadorasAuto(int cveEntidad);
    public List<AgenciaAseguradoAutoVO> obtenerAgenciasAutos();
    //eliminar es para pruebas de transacionalidad
        public void insertDataRecursivo();
}

