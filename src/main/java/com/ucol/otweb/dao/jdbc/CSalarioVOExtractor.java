/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CSalarioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CSalarioVOExtractor implements ResultSetExtractor<CSalarioVO> {

    public CSalarioVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CSalarioVO cSalarioVO = new CSalarioVO();
        cSalarioVO.setSalMinDiario(rs.getDouble(1));
        cSalarioVO.setSalarioMin(rs.getDouble(2));
        cSalarioVO.setFechaSalario(rs.getDate(3));
        cSalarioVO.setUsuario(rs.getString(4));
        cSalarioVO.setFechaAud(rs.getDate(5));
        cSalarioVO.setComponenteCve(rs.getString(6));
        return  cSalarioVO;
    }
    
}
