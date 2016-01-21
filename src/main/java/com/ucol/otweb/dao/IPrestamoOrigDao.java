/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.PrstamoOrigVO;
import com.ucol.otweb.vo.ReporteVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IPrestamoOrigDao {

    /**
     * obtiene el numero de prestamos pendientes (estatus del credito 1) por
     * numero de ISSSTE
     *
     * @param numIssste
     * @return
     */
    Integer countNumeroPrestamosByEstatus(int numIssste,int estatus) ;
    List<PrstamoOrigVO> obtenerPrestamosVigentesXNumIssste(Integer numIssste);
    List<PrstamoOrigVO> obtenerLoanAuthCdXNumIssste(Integer numIssste);
    Integer countLoanAuthCdXNumIssste(Integer numIssste,int cveTcr);
    List<PrstamoOrigVO> obtenerPrestamoOrigenXNumIssste(Integer numIssste);
    List<PrstamoOrigVO> obtenerNumPrestamo(Integer numIssste, boolean adicional);
    List<PrstamoOrigVO> bucarPrestamoWeb(Integer numIssste);
    Integer countNumeroPrestamosByEstatusType(int numIssste, String estatus, int tipoCred);

    public List<PrstamoOrigVO> obtenerPrestamosVigentes(int numIssste);
    /**
     * Obtiene el numero de prestamos no cancelados para el folio
     *
     * @param folio
     * @param typeCd
     * @return
     */
    public Integer countNumeroPrestamosNoCancelados(int folio, int typeCd);

    /**
     * Obtener el numero de prestamos para refinanciamiento
     *
     * @param numIssste
     * @return
     */
    public Integer countPrestamosRefininanciamiento(int numIssste);
    public void insertarProcTes(Double prestamo) ;
    public void updatePrestamo(Double prestamo, int faltaMod, int tipoCred, String ipMaquina);

    public void insert(PrstamoOrigVO prstamoOrigVO);

    public void updateEstatusCd(PrstamoOrigVO prestamo);

    public ReporteVO getPrestamosAnterior(Double numIssste);
}
