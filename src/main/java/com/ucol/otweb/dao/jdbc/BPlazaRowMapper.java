/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.BplazaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BPlazaRowMapper implements RowMapper<BplazaVO>{
        
    public BplazaVO mapRow(ResultSet resultSet, int line) throws SQLException {
        BPlazaExtractor queryExtractor = new BPlazaExtractor();
        return queryExtractor.extractData(resultSet);
    }
}
