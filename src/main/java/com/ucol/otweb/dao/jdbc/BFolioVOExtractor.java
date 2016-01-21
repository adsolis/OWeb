/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.FolioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class BFolioVOExtractor implements ResultSetExtractor<FolioVO> {

    public FolioVO extractData(ResultSet rs) throws SQLException, DataAccessException {
        FolioVO folio = new FolioVO();
        folio.setAnio(rs.getInt(1));
        folio.setCveTcr(rs.getInt(2));
        folio.setNomTcr(rs.getString(3));
        folio.setCveEntidad(rs.getInt(4));
        folio.setCveDeleg(rs.getInt(5));
        folio.setCveUniad(rs.getInt(6));
        folio.setNumRamoAnt(rs.getInt(7));
        folio.setCveAfectaPresup(rs.getInt(8));
        return folio;
    }
    
}
