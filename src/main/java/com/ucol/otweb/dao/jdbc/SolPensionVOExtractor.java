/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.SolPensionVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class SolPensionVOExtractor implements ResultSetExtractor<SolPensionVO> {

    public SolPensionVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        SolPensionVO pensionVO = new SolPensionVO();
        pensionVO.setNumIssste(rs.getInt(1));
        pensionVO.setTbnCve(rs.getInt(2));
        pensionVO.setNumPension(rs.getInt(3));
        return pensionVO;
    }
    
}
