/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;

import com.ucol.otweb.vo.CramPagVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class CRamPagExtractor implements ResultSetExtractor<Serializable> {

    public Serializable extractData(ResultSet rs) throws SQLException, DataAccessException {
        CramPagVO vo=new CramPagVO();
        vo.setRamoCat(rs.getInt(1));
        vo.setPagaCat(rs.getString(2));
        vo.setNombCat(rs.getString(3));
        vo.setDomiCat(rs.getString(4));
        vo.setModaCat(rs.getString(5));
        vo.setEntiCat(rs.getInt(6));
        vo.setEntiDist(rs.getInt(7));
        vo.setCveDeleg(rs.getInt(8));
        vo.setCveUniad(rs.getInt(9));
        vo.setTipoNom(rs.getInt(10));
        vo.setDisponCat(rs.getString(11));
        return vo;        
    }
    
}
