/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao;

import com.ucol.otweb.vo.PrestamoProyeccionVO;
import com.ucol.otweb.vo.ProyeccionVO;
import com.ucol.otweb.vo.QnaVO;
import java.util.List;

/**
 *
 * @author 
 */
public interface IProyeccionDao {
    public List<ProyeccionVO> obtenerSaldoActualProy(Double numPrestamo);
    /**
     * regresa los datos de la proyeccion asociados al loan_nbr
     * @param loanNbr
     * @return
     */
    ProyeccionVO obtenerProyeccionByID(Double loanNbr);
    public List<PrestamoProyeccionVO> obtenerPrestamosCero();
    public List<PrestamoProyeccionVO> obtenerPrestamosVigentes(Double numPrestamo);
    public List<PrestamoProyeccionVO> obtenerProyeccionPrestamo(Double numPrestamo);
    public int existeRegularizaion(Double numPrestamo);
    public QnaVO ontieneRangoFechas();
    public Double tasaInteres(String qnaInteres);
    public void actualizaProy(PrestamoProyeccionVO proy);
    public void actualizaProyCU(PrestamoProyeccionVO proy);
    public void actualizaProyCD(PrestamoProyeccionVO proy);
    public void actualizaProyIVA(ProyeccionVO proy);

    public void insert(ProyeccionVO proyeccionVO);
}
