/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PrstamoOrigVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PrestamoOrigExtractor implements ResultSetExtractor<PrstamoOrigVO> {

    public PrstamoOrigVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrstamoOrigVO prestamo = new PrstamoOrigVO();
        prestamo.setLoanNbr(rs.getDouble(1));
        prestamo.setLoanTypeCd(rs.getInt(2));
        prestamo.setLoanStatCd(rs.getInt(3));
        prestamo.setLoanIssue_date(rs.getDate(4));
        prestamo.setOrigLoanPrin(rs.getDouble(5));
        prestamo.setOrigNbrPay(rs.getInt(6));
        prestamo.setFirstPayPerYrD(rs.getString(7));
        prestamo.setTnoCve(rs.getString(8));
        return prestamo;
    }
    
}
