/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PrestamoProyeccionVO;
import com.ucol.otweb.vo.ProyeccionVO;
import com.ucol.otweb.vo.PrstamoOrigVO;
import com.ucol.otweb.vo.QnaVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PrestamoProyeccionExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrestamoProyeccionVO vo = new PrestamoProyeccionVO();
        
        vo.setPrestamo(new PrstamoOrigVO());
        vo.setProyeccion(new ProyeccionVO());
        
        vo.getPrestamo().setLoanNbr(rs.getDouble(1));
        vo.getPrestamo().setLoanIssue_date(rs.getDate(2));
        vo.getPrestamo().setPayAmt(rs.getDouble(3));
        
        
        vo.getProyeccion().setStatConvenio(rs.getString(4));
        vo.getProyeccion().setCurrPrinBal(rs.getDouble(5));
        vo.getProyeccion().setStatCobr(rs.getInt(6));
        vo.getProyeccion().setDatePastPay(rs.getDate(7));
        vo.getProyeccion().setIntEarnedToDate(rs.getDouble(8));
        vo.getProyeccion().setTotIntPd(rs.getDouble(9));
        vo.getProyeccion().setTotIvaGan(rs.getDouble(10));
        vo.getProyeccion().setTotIvaPag(rs.getDouble(11));
        vo.getProyeccion().setNum_difer(rs.getInt(12));
        vo.getProyeccion().setAmtLastPmt(rs.getDouble(13));
        
        return vo;
    }
    
    public Serializable extractDataAll(ResultSet rs) throws SQLException, DataAccessException {
        PrestamoProyeccionVO vo = new PrestamoProyeccionVO();
        
        vo.setPrestamo(new PrstamoOrigVO());
        vo.setProyeccion(new ProyeccionVO());
        
        vo.getProyeccion().setDatePastPay(rs.getDate(1));
        vo.getProyeccion().setFirstPayPerDue(rs.getString(2));
        vo.getProyeccion().setCurrPrinBal(rs.getDouble(3));
        vo.getProyeccion().setIntEarnedToDate(rs.getDouble(4));
        vo.getProyeccion().setTotIntPd(rs.getDouble(5));
        vo.getProyeccion().setTotIvaGan(rs.getDouble(6));
        vo.getProyeccion().setTotIvaPag(rs.getDouble(7));
        vo.getProyeccion().setPerIntEarned(rs.getDouble(8));
        vo.getProyeccion().setPerIntPd(rs.getDouble(9));
        vo.getProyeccion().setPerPrincPd(rs.getDouble(10));
        vo.getProyeccion().setPerIvaGan(rs.getDouble(11));
        vo.getProyeccion().setPerIvaPag(rs.getDouble(12));
        vo.getProyeccion().setAmtLastPmt(rs.getDouble(13));
        vo.getProyeccion().setImpPagoAntProy(rs.getDouble(14));
        vo.getProyeccion().setNum_pagoAntProy(rs.getInt(15));
        vo.getProyeccion().setTotPrinPaidToD(rs.getDouble(16));
        vo.getPrestamo().setLoanIssue_date(rs.getDate(17));
        vo.getPrestamo().setTnoCve(rs.getString(18));
        vo.getPrestamo().setIntRate(rs.getDouble(19));
        vo.getPrestamo().setIvaRate(rs.getDouble(20));
        vo.getPrestamo().setLoanTypeCd(rs.getInt(21));
        vo.getPrestamo().setOrigLoanIntAmt(rs.getDouble(22));
        vo.getPrestamo().setOrigNbrPay(rs.getInt(23));
        vo.getPrestamo().setPayAmt(rs.getDouble(24));
        
        return vo;
    }
    
    public Serializable extractDataDate(ResultSet rs) throws SQLException, DataAccessException {
        QnaVO vo = new QnaVO();
        
        vo.setRango1(rs.getDate(1));
        vo.setRango2(rs.getDate(2));
        return vo;
    }
    
    public Serializable extractDataInteres(ResultSet rs) throws SQLException, DataAccessException {
        Double tasaInteres = 0.0;
        
        tasaInteres = rs.getDouble(1);
        
        return tasaInteres;
    }
    
}
