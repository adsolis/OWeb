/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IAntiguedadDao;
import com.ucol.otweb.dao.jdbc.AntiguedadExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.AntiguedadVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "antiguedadDao")
public class AntigueadDaoImpl extends GenericDao implements IAntiguedadDao {

    private static final String BANTIGUEDAD_SELECT="Select Unique num_ramo, fec_ini, fec_fin From antiguedad Where num_issste = ? Order By 2, 1";

    /**
     * Obtener anitguedad por numero de ISSSTE
     * @param numIssste
     * @return
     */
    public AntiguedadVO obtenerAntiguedad(int numIssste) {
        AntiguedadVO antiguedad =null;
        List<Serializable> antiguedadList = super.getJdbcTemplate().query(BANTIGUEDAD_SELECT  ,new Object[]{new Integer(numIssste)}, new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                AntiguedadExtractor extractor= new AntiguedadExtractor();
                return extractor.extractData(rs);
            }
        });
        if(antiguedadList!=null && antiguedadList.size()>0){
            antiguedad=(AntiguedadVO) antiguedadList.get(0);
        }
        return antiguedad;
    }
}
