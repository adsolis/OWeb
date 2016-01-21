/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.ProyeccionVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class ProyeccionExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        ProyeccionVO vo = new ProyeccionVO();
        vo.setCurrPrinBal(rs.getDouble(1));
        vo.setIntEarnedToDate(rs.getDouble(2));
        vo.setTotIntPd(rs.getDouble(3));
        vo.setTotIvaGan(rs.getDouble(4));
        vo.setTotIvaPag(rs.getDouble(5));
        vo.setCurrPrinBal(rs.getDouble(6));
        vo.setDatePastPay(rs.getDate(7));
        vo.setAmtLastPmt(rs.getDouble(8));
        vo.setLastPayPerDue(rs.getString(9));
        vo.setLoanNbr(rs.getDouble(10));
        return vo;
    }
    
}
