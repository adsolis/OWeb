/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.PzaPenVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BPlazaPenRowMapper implements RowMapper<PzaPenVO> {

    public PzaPenVO mapRow(ResultSet rs, int i) throws SQLException {
        BPlazaPenExtractor plazaPenExtractor = new BPlazaPenExtractor();
        return plazaPenExtractor.extractData(rs);
    }
    
}
