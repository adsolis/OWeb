/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CPagaduriaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class CPagaduriaVORowMapper implements RowMapper<CPagaduriaVO> {

    public CPagaduriaVO mapRow(ResultSet rs, int i) throws SQLException {
        CPagaduriaVOExtractor cPagaduriaVOExtractor = new CPagaduriaVOExtractor();
        return cPagaduriaVOExtractor.extractData(rs);
    }
    
}
