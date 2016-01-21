/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.AntiguedadVO;
import com.ucol.otweb.vo.PrestoAutoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class PrestoAutoExtractor implements ResultSetExtractor<PrestoAutoVO>{

    public PrestoAutoVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        PrestoAutoVO vo = new PrestoAutoVO();
        vo.setCveAfect(rs.getInt(1));
        vo.setCveTcr(rs.getInt(2));
        vo.setTnoCve(rs.getInt(3));
        vo.setCveEntidad(rs.getInt(4));
        vo.setCveDeleg(rs.getInt(5));
        vo.setCveUniad(rs.getInt(6));
        vo.setRamo(rs.getInt(7));
        vo.setCveUniadOri(rs.getInt(8));
        vo.setCveSubpartOri(rs.getInt(9));
        
        return vo;
    }
    
}
