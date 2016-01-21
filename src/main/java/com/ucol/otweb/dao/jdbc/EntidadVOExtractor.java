/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.jdbc;
import com.ucol.otweb.vo.EntidadVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author 
 */
public class EntidadVOExtractor implements ResultSetExtractor<EntidadVO> {

    public EntidadVO extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {
        EntidadVO entidad = new EntidadVO();
        entidad.setCveEntidad(resultSet.getInt(1));
        entidad.setDescEntidad(resultSet.getString(2));
        entidad.setAbvEntidad(resultSet.getString(3));
        return entidad;
    }
}
