/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ICCompatibleDao;
import com.ucol.otweb.dao.jdbc.CCompatibleVOExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CCompatibleVO;
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
@Repository(value = "cCompatibleDao")
public class CCompatibleDaoImpl extends GenericDao implements ICCompatibleDao {
        
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BCOMPATIBLE_SELECT = "SELECT cve_tcr_sol, cve_tcr_ant, por_plazo, por_monto, num_sal_min, usuario, fecha_aud, componente_cve, ip_equipo  FROM c_compatible " ;
       
    public CCompatibleDaoImpl(){
    }
    
    /*
     * se obtiene la compatibilidad por el tipo de credito solicitado y anterior
     */
    public List<CCompatibleVO> obtenerCompatibilidadCredito(CCompatibleVO cCompatibleVO) {
        List<Serializable> listaCompatibilidad =null;
        String sql ="";
        if(cCompatibleVO.getCveTrcSol()!=null && cCompatibleVO.getCveTrcSol()>0){
            if(sql.equals("")){
                sql += " WHERE cve_tcr_sol = "+cCompatibleVO.getCveTrcSol();
            }else{
                sql += " AND cve_tcr_sol = "+cCompatibleVO.getCveTrcSol();
            }
        }
        if(cCompatibleVO.getCveTrcAnt()!=null && cCompatibleVO.getCveTrcAnt()>0){
            if(sql.equals("")){
                sql += " WHERE cve_tcr_ant = "+cCompatibleVO.getCveTrcAnt();
            }else{
                sql += " AND cve_tcr_ant = "+cCompatibleVO.getCveTrcAnt();
            }
        }
        listaCompatibilidad = super.getJdbcTemplate().query(BCOMPATIBLE_SELECT + sql , new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                 CCompatibleVOExtractor cCompatibleVOExtractor= new CCompatibleVOExtractor();
                return cCompatibleVOExtractor.extractData(rs);
            }
        });
        return (List<CCompatibleVO>)(List) listaCompatibilidad;
    }
    
}
