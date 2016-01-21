/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.AntiguedadVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class AntiguedadExtractor implements ResultSetExtractor<AntiguedadVO>{

    public AntiguedadVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        AntiguedadVO antiguedad=new AntiguedadVO();
        antiguedad.setNumRamo(rs.getInt(1));
        antiguedad.setFecIni(rs.getDate(2));
        antiguedad.setFecFin(rs.getDate(3));
        return antiguedad;
    }
    
}
