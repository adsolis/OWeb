/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IDiferimientoDao;
import com.ucol.otweb.dao.jdbc.CDiferimientoExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CDiferimientoVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "diferimientoDao")
public class DiferimientoDaoImpl extends GenericDao implements IDiferimientoDao{
    private static final String BCAT_DIFERIMIENTO_SELECT="SELECT qna_emis, ramo_dif, pagad_dif, num_qna_dif  FROM c_diferimiento ";
    @Override
    public List<CDiferimientoVO> obtenerCatDiferimiento(CDiferimientoVO cDiferimientoVO){
        List<CDiferimientoVO> listaCDiferimiento = null;
        StringBuilder where = new StringBuilder();
        if(cDiferimientoVO.getRamoDif()>0){
            where.append(" where ramo_dif = ");
            where.append(cDiferimientoVO.getRamoDif());
            
        }
        if(cDiferimientoVO.getPagad()!=null){
            where.append(" AND pagad_dif = '");
            where.append(cDiferimientoVO.getPagad());
            where.append("' ");
            
        }
        if(cDiferimientoVO.getQnaEmis()>0){
            where.append(" AND qna_emis = ");
            where.append(cDiferimientoVO.getQnaEmis());
        }
        
        listaCDiferimiento = (List)super.getJdbcTemplate().query(BCAT_DIFERIMIENTO_SELECT+where.toString(), new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CDiferimientoExtractor extractor = new CDiferimientoExtractor();
                return extractor.extractData(rs);
            }
        });
        return listaCDiferimiento;
    } 
}
