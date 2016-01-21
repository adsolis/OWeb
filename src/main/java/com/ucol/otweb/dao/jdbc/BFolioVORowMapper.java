/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.FolioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author 
 */
public class BFolioVORowMapper implements RowMapper<FolioVO> {

    public FolioVO mapRow(ResultSet rs, int i) throws SQLException {
        BFolioVOExtractor folioVoExtractor = new BFolioVOExtractor();
        return folioVoExtractor.extractData(rs);
    }
    
}
