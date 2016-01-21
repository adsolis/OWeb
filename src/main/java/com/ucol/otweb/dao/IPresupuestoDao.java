/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.PrestoAnualVO;
import com.ucol.otweb.vo.PrestoAutoVO;
import com.ucol.otweb.vo.PrestoMensualVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPresupuestoDao {

    List<PrestoMensualVO> obtenerDatosPresupMensual(PrestoMensualVO prestoMensualVO);

    /**
     * obtenerPresupuestosTranAuto
     * Se obtiene el presupuesto para tranferencias automaticas
     * por cobertura, tipo de prestamo, nombramiento, afectacion y ramo
     * @return
     */
    List<PrestoAutoVO> obtenerPresupuestosTranAuto(PrestoAutoVO args);

    List<PrestoAnualVO> obtenerVersionPresAnu(PrestoAnualVO anualVO);

    void update(PrestoMensualVO presto);
    void updatePrestoDf(PrestoMensualVO presto);

    public void insert(PrestoMensualVO prestoMensualDestino);
    public void updatePresto(PrestoMensualVO presto);
    
}
