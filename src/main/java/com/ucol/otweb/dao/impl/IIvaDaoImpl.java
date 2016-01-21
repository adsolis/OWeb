/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IIvaDao;
import com.ucol.otweb.dao.jdbc.CIvaFrontVOExtractor;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.vo.CIvaFrontVO;
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
@Repository(value = "ivasDao")
public class IIvaDaoImpl extends GenericDao implements IIvaDao{
    
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BIVA_FRONT_SELEC ="SELECT ent_iva, cod_pos_iva, fecha_act_iva, cve_prog_iva, ip_iva, usuario, fecha_aud, componente_cve, ip_equipo FROM c_iva_front ";
    private static final String BCTIPO_IVA_SELECT = "SELECT porc_tiva FROM c_tipo_iva WHERE stat_tiva = 1 [BASE] order by cve_tiva desc ";
    
    public IIvaDaoImpl(){
    }
    
    /*
     * Se obtiene el iva_fronterizo con respecto a la entidad y el codigo postal
     */
    public CIvaFrontVO obtenerIvaFronterizo(Integer entidad, Integer codPostal){
        String sql = "";
        CIvaFrontVO cIvaFrontVO = null;
        if(entidad!=null && entidad>0 ){
            if(sql.equals("")){
                sql +=" where ent_iva = "+ entidad;
            }else{
                sql +=" and ent_iva = "+ entidad;
            }
        }
        if(codPostal!=null && codPostal>0 ){
            if(sql.equals("")){
                sql +=" where cod_pos_iva = "+ codPostal;
            }else{
                sql +=" and cod_pos_iva = "+ codPostal;
            }
        }
        List<Serializable> ivasFront= super.getJdbcTemplate().query(BIVA_FRONT_SELEC + sql, new SerializableRowMapper() {
            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CIvaFrontVOExtractor cIvaFrontVOExtractor = new CIvaFrontVOExtractor();
                return cIvaFrontVOExtractor.extractData(rs);
            }
        });
        if(ivasFront!=null && ivasFront.size()>0){
            cIvaFrontVO=(CIvaFrontVO)ivasFront.get(0);
        }
        return cIvaFrontVO;
    }
    
    /*
     * Se obtiene el porcentaje con respecto al tipo de iva
     */
    public Integer obtenerPorcTipIva(Integer cveTiva){
        Integer porcTipoIva = null;
        String sql = "";
        String query = "";
        if(cveTiva>0){
            sql=" AND cve_tiva = "+ cveTiva;
        }
        query = BCTIPO_IVA_SELECT.replace("[BASE]", sql);
        
        List<Integer> ivas = (List) super.getJdbcTemplate().query(query, new SerializableRowMapper(){

            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                int iva = rs.getInt(1);
                return iva ;
            }
        } );
        if(ivas!=null && ivas.size()>0){
            porcTipoIva=ivas.get(0);
        }
        return porcTipoIva;
    }
    
}
