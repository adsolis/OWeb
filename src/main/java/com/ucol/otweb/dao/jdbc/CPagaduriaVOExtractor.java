/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CPagaduriaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CPagaduriaVOExtractor implements ResultSetExtractor<CPagaduriaVO> {

    public CPagaduriaVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        CPagaduriaVO cPagaduriaVO = new CPagaduriaVO();
        cPagaduriaVO.setRamAnt(rs.getInt(1));
        cPagaduriaVO.setNumRamo(rs.getInt(2));
        cPagaduriaVO.setNumPagaduria(rs.getString(3));
        cPagaduriaVO.setNombre(rs.getString(4));
        return cPagaduriaVO;
    }
    
}
