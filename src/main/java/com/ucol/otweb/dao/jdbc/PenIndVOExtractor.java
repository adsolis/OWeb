/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PenIndVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PenIndVOExtractor implements ResultSetExtractor<PenIndVO> {

    public PenIndVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PenIndVO penIndVO = new PenIndVO();
        penIndVO.setNumissste(rs.getInt(1));
        penIndVO.setNumisssted(rs.getInt(2));
        penIndVO.setSpeId(rs.getInt(3));
        return penIndVO;
    }
    
}
