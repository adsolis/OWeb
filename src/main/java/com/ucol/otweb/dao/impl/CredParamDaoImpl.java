/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ICredParamDao;
import com.ucol.otweb.dao.jdbc.CCredParamExtractor;
import com.ucol.otweb.dao.jdbc.CCredParamVOExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CCredParamVO;
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
@Repository(value = "credParamDao")
public class CredParamDaoImpl extends GenericDao implements ICredParamDao  {
    private static final String MAX_ANT_FIN = "SELECT MAX(ant_fin) FROM c_cred_param  WHERE cve_tcr = ?  AND stat_condic = 1";
    private static final String BCRED_PARAM_SELEC = "SELECT monto_cre,plazo_cred,prima_garant,tasa_int FROM c_cred_param WHERE cve_tcr = ? AND stat_condic = ? ";
    private static final String PLAZO_DAMINIFICADOS ="SELECT FIRST 1 plazo_cred FROM c_cred_param WHERE (cve_tcr = 12 OR cve_tcr = 19) AND stat_condic = 1 ORDER BY plazo_cred";
    private static final String BPARAM_CREDITOS_SELEC = "SELECT UNIQUE(plazo_cred) FROM c_cred_param WHERE cve_tcr in (12,19) AND stat_condic = 1  ORDER BY plazo_cred" ;
    
    /**
     * 
     * @param cveTcr
     * @return
     */
    @Override
    public Integer obtenerMaxAntFin(int cveTcr){
        Integer max=super.getJdbcTemplate().queryForInt(MAX_ANT_FIN, new Object[]{cveTcr});
        return max;
    }
    
    /**
     * Metodo para obtener los parametros de credito 
     * y el rango de Sal y de antiguedad
     * @param cCredParamVO
     * @param rangoSal
     * @param ant
     * @return
     */
    @Override
    public List<CCredParamVO> obtenerCredParam(CCredParamVO cCredParamVO,double rangoSal,int ant){
        List<CCredParamVO> listaCParam=null;
        String query = BCRED_PARAM_SELEC;
        if(rangoSal>0){
            query+="  AND "+rangoSal+" BETWEEN rango_sal_ini AND rango_sal_fin ";
        }
        if(ant>0){
            query+="  AND "+ant+" BETWEEN ant_ini AND ant_fin ";
        }
       listaCParam =(List<CCredParamVO>)(List) super.getJdbcTemplate().query(query, new Object[]{cCredParamVO.getCveTcr(),cCredParamVO.getStatCondic()},
               new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CCredParamExtractor extractor=new CCredParamExtractor();
                return extractor.extractData(rs);
            }
        });
       return listaCParam;
    }
    
    /**
     * Se obtiene el plazo para los creditos 12 y 19 exclusivos para damnificados
     * @return plazo
     */
    public Integer obtenerPlazoDaminificados(){
        Integer plazo=super.getJdbcTemplate().queryForInt(PLAZO_DAMINIFICADOS);
        return plazo;
    }
    
     /**
     * Para los créditos Damnificados se obtiene el plazo del crédito
     */
    public List<Serializable> obtenerPlazoCredParaDamnificados(){
        List<Serializable> plazaCredDam = super.getJdbcTemplate().query(BPARAM_CREDITOS_SELEC , new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                 Integer plazo= rs.getInt(1);
                return plazo;
            }
        });
        
        return plazaCredDam;
    }
}
