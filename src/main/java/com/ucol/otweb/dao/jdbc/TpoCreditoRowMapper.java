/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.TpoCreditoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class TpoCreditoRowMapper implements RowMapper<TpoCreditoVO>{

    public TpoCreditoVO mapRow(ResultSet rs, int i) throws SQLException {
        TpoCreditoextractor extractor = new TpoCreditoextractor();
        return extractor.extractData(rs);
    }
    
}
