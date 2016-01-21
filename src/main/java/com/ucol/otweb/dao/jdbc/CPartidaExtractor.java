/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CPartidaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CPartidaExtractor implements ResultSetExtractor<CPartidaVO> {

    public CPartidaVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CPartidaVO cPartidaVO = new CPartidaVO();
        cPartidaVO.setCvePartida(rs.getInt(1));
        return cPartidaVO;
    }
    
}
