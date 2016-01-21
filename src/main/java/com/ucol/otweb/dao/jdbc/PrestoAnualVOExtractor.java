/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PrestoAnualVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PrestoAnualVOExtractor implements ResultSetExtractor<PrestoAnualVO> {

    public PrestoAnualVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrestoAnualVO anualVO = new PrestoAnualVO();
        anualVO.setNumVersion(rs.getInt(1));
        return  anualVO;
    }
    
    
}
