/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IAfectacionDao;
import com.ucol.otweb.dao.jdbc.CAfectExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CAfectVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "afectacionDao")
public class AfectacionDaoImpl extends GenericDao implements IAfectacionDao{
    private static final String BCAT_AFECTACION_BY_ID = "  SELECT cve_afect, desc_afect, tpo_part, dist_pob FROM c_afect WHERE cve_afect = ?";
    
    /**
     * Obtener los datos de la afectacion por medio la clave
     * @param cveAfect
     * @return
     */
    @Override
    public CAfectVO obtenerCatAfectacionByID(int cveAfect){
        CAfectVO cAfectVO = (CAfectVO)super.getJdbcTemplate().queryForObject(BCAT_AFECTACION_BY_ID,new Object[]{cveAfect} ,new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CAfectExtractor extractor = new CAfectExtractor();
                return extractor.extractData(rs);
            }
        });
        return cAfectVO;
    }
}
