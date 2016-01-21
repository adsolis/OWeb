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
public class PrestamoOrigExtractorWeb implements ResultSetExtractor<PrstamoOrigVO> {

    public PrstamoOrigVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrstamoOrigVO prstamoOrigVO = new PrstamoOrigVO();
        prstamoOrigVO.setLoanNbr(rs.getDouble(1));
        prstamoOrigVO.setLoanStatCd(rs.getInt(2));
        prstamoOrigVO.setLoanTypeCd(rs.getInt(3));
        prstamoOrigVO.setFirstPayPerYrD(rs.getString(4));
        prstamoOrigVO.setLastPayPerYrDu(rs.getString(5));
        prstamoOrigVO.setLoanIssue_date(rs.getDate(6));
        prstamoOrigVO.setNbrFolio(rs.getInt(7));
        return prstamoOrigVO;
    }
    
}
