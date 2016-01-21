/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CtnoCveVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CtnoCveVOExtractor implements ResultSetExtractor<CtnoCveVO> {

    public CtnoCveVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CtnoCveVO ctnoCveVO = new CtnoCveVO();
        ctnoCveVO.setTnoCveSic(rs.getInt(1));
        ctnoCveVO.setTnoCve(rs.getInt(2));
        ctnoCveVO.setDescripcionSic(rs.getString(3));
        ctnoCveVO.setDescripcion(rs.getString(4));
        return ctnoCveVO;
    }
    
}
