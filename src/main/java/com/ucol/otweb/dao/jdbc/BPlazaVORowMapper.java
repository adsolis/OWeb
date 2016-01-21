/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PlazaVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BPlazaVORowMapper implements RowMapper<PlazaVO> {

    public PlazaVO mapRow(ResultSet rs, int i) throws SQLException {
        BPlazaVOExtractor plazaVOExtractor = new BPlazaVOExtractor();
        return plazaVOExtractor.extractData(rs);
    }
    
}
