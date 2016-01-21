/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.CramPagVO;
import com.ucol.otweb.vo.VcPagaduriaVO;
import com.ucol.otweb.vo.cRamEsp;
import java.util.List;

/**
 *
 * @author 
 */
public interface IRamoPagaduriaDao {

    /**
     * Recuprar los datos de el ramo-pagaduria por los ID
     * @param cveRamo
     * @param pagaduria
     * @return
     */
    CramPagVO obtenerRamoPagById(int cveRamo, String pagaduria);
    VcPagaduriaVO obtenerVCPagaduria (int cveRamo, String pagaduria);
    /**
     * Para la saber si es ramo especial
     * @param cveRamo
     * @return
     */
    public Integer countRamoEspecial(int cveRamo, String pagaduria);
     /**
     * obtener la informacion de los ramos especiales
     * @param ramoEsp
     * @return
     */
    public List<cRamEsp> obtenerRamosEspeciales(cRamEsp ramoEsp);
    
    public List<cRamEsp> obtenerRamoEspecial (Integer ramo, String pagaduria);
    /**
     * para obtener el ramo anterior de la plaza
     * @param numRamo
     * @param pagaduria
     * @param base
     * @return
     */
    public Integer obtenerRamoAnt(int numRamo, String pagaduria, String base) ;
    public List<cRamEsp> obtenerInfRamoEspecial(cRamEsp ramoEsp);
}
