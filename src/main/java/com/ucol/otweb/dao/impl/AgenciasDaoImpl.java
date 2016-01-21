/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IAgenciasDao;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.AgenciaAseguradoAutoVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "agenciasDao")
public class AgenciasDaoImpl extends GenericDao implements IAgenciasDao{
    
    private static final String BAGENCIASAUTOS = " select nom_aseguradora, nom_img, url, 1 from c_agencia_seguros where url<>'' and url<>'null' union select nom_agencia, nom_img, url, 2 from c_agencia_autos where url<>''and url<>'null'   ";
    private static final String BASEGURADORAS = " select nom_aseguradora, nom_img, url from c_agencia_seguros ";
    
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AgenciaAseguradoAutoVO> buscarAgencias(){
        List<AgenciaAseguradoAutoVO> agencias=null;
        agencias  =(List) super.getJdbcTemplate().query(BAGENCIASAUTOS , new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                AgenciaAseguradoAutoVO autoVO= new AgenciaAseguradoAutoVO();
                autoVO.setNomAgencia(rs.getString(1));
                autoVO.setNomImagen(rs.getString(2));
                autoVO.setUrl(rs.getString(3));
                autoVO.setContante(rs.getInt(4));
                return autoVO;
            }
            
        });
        
        return  agencias;
    }
    
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AgenciaAseguradoAutoVO> buscarAseguradoras(){
        List<AgenciaAseguradoAutoVO> aseguradoras=null;
        aseguradoras =(List) super.getJdbcTemplate().query(BASEGURADORAS , new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                AgenciaAseguradoAutoVO autoVO= new AgenciaAseguradoAutoVO();
                autoVO.setNomAgencia(rs.getString(1));
                autoVO.setNomImagen(rs.getString(2));
                autoVO.setUrl(rs.getString(3));
                return autoVO;
            }
            
        });
        return  aseguradoras;
    }

}
