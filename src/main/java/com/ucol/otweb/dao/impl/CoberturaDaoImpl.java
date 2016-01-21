/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.ICoberturaDao;
import com.ucol.otweb.dao.jdbc.BCajaPagadoraRowMapper;
import com.ucol.otweb.dao.jdbc.SerializableRowMapper;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.vo.CDelegacionVO;
import com.ucol.otweb.vo.COficinaVO;
import com.ucol.otweb.vo.CUnidadVO;
import com.ucol.otweb.vo.CajaPagadoraVO;
import com.ucol.otweb.vo.EntidadVO;
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
@Repository(value = "coberturaDao")
public class CoberturaDaoImpl extends GenericDao implements ICoberturaDao {

    /**
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BCAJA_PAGADORA_SELEC_X_ENTIDAD = "select  id, id_entidad, id_delegacion, id_uniad, id_oficina,ciudad  from caja_pagadora where  id_estatus=1"
            + " and id_entidad = ";
    private static final String BCAJA_PAGADORA_SELEC = "select  calle, colonia, codigo_postal, ciudad, entidad, dia_cheque  from caja_pagadora ";
    private static final String BENTIDAD_X_CODIGO_POSTAL = "select e.cve_entidad from vc_codigo_pos cp, c_entidades  e "
            + " where cp.ent_cve = e.abv_entidad and cp.codigo_postal = ?";
    private static final String BRAMO_ANTERIOR_SELECT = "select ram_ant from [BASE]c_pagaduria where pag_estado = 'A' ";
    private static final String BGRUPO_X_RAMO_ANT_SELECT = "SELECT UNIQUE(cve_gposind) FROM ram_gru WHERE num_ramo_ant = ?";
    private static final String BOFICINA = "SELECT cve_entidad, cve_deleg, cve_uniad, cve_oficina, desc_oficina "
            + "FROM c_oficina "
            + "WHERE cve_entidad = ? and cve_deleg = ? and cve_uniad = ? and stat_oficina=1 order by cve_oficina desc ";
    private static final String BOFICINAB = "SELECT cve_entidad, cve_deleg, cve_uniad, cve_oficina, desc_oficina "
            + "FROM c_oficina "
            + "WHERE cve_entidad = ? and cve_deleg = ?  and stat_oficina=1 ";
    private static final String BUNIDAD = "SELECT cve_entidad, cve_deleg, cve_uniad, desc_uniad  "
            + "FROM c_uniad "
            + "WHERE cve_entidad = ? and cve_deleg = ? and cve_uniad = ?  and stat_uniad=1 ";
    private static final String BDELEG = "SELECT cve_entidad, cve_deleg, desc_deleg "
            + "FROM c_deleg "
            + "WHERE cve_entidad = ? and cve_deleg = ? and stat_deleg =1 ";
    private static final String BENTIDAD = "SELECT cve_entidad, desc_entidad, abv_entidad "
            + "FROM c_entidades "
            + "WHERE cve_entidad = ? ";
    private static final String BCAJAPAGADORAUTOS = "select  id, id_entidad, id_delegacion, id_uniad, id_oficina,ciudad  from caja_pagadora where  id_estatus=1"
            + " and id_entidad = ? and id_oficina < 57";
    PropertyUtils properties = new PropertyUtils("config.properties");

    public CoberturaDaoImpl() {
    }

    /**
     *Se obtiene la ciudad correspondiente a la caja pagadora por entidad
     * @param caja 
     * @return 
     */
    public List<CajaPagadoraVO> buscarCajasPagadorasPorEntidad(CajaPagadoraVO caja) {
        List<CajaPagadoraVO> cajasPorEntidad = null;

        cajasPorEntidad = super.getJdbcTemplate().query(BCAJA_PAGADORA_SELEC_X_ENTIDAD + caja.getIdEntidad(), new BCajaPagadoraRowMapper() {

            public CajaPagadoraVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CajaPagadoraVO caja = new CajaPagadoraVO();
                caja.setId(rs.getInt(1));
                caja.setIdEntidad(rs.getInt(2));
                caja.setIdDelegacion(rs.getInt(3));
                caja.setIdUniad(rs.getInt(4));
                caja.setIdOficina(rs.getInt(5));
                caja.setCiudad(rs.getString(6));
                return caja;
            }
        });
        return cajasPorEntidad;
    }

    /**
     *Se obtiene la ciudad correspondiente a la caja pagadora por cobertura para Simulacion
     * @param caja 
     * @return 
     */
    public List<CajaPagadoraVO> buscarCajasPagadorasSimulacion(CajaPagadoraVO caja) {
        List<CajaPagadoraVO> cajasCobertura = null;
        String sql = "";

        if (caja.getIdEntidad() != null && caja.getIdEntidad() > 0) {
            if (sql.equals("")) {
                sql += " where id_entidad = " + caja.getIdEntidad();
            } else {
                sql += " and id_entidad = " + caja.getIdEntidad();
            }
        }
        if (caja.getIdDelegacion() != null && caja.getIdDelegacion() > 0) {
            if (sql.equals("")) {
                sql += " where id_delegacion = " + caja.getIdDelegacion();
            } else {
                sql += " and id_delegacion = " + caja.getIdDelegacion();
            }
        }
        if (caja.getIdUniad() != null) {
            if (sql.equals("")) {
                sql += " where id_uniad = " + caja.getIdUniad();
            } else {
                sql += " and id_uniad = " + caja.getIdUniad();
            }
        }
        if (caja.getIdOficina() != null && caja.getIdOficina() > 0) {
            if (sql.equals("")) {
                sql += " where id_oficina = " + caja.getIdOficina();
            } else {
                sql += " and id_oficina = " + caja.getIdOficina();
            }
        }

        System.out.println("BCAJA_PAGADORA_SELEC + sql" + BCAJA_PAGADORA_SELEC + sql);
        cajasCobertura = super.getJdbcTemplate().query(BCAJA_PAGADORA_SELEC + sql, new BCajaPagadoraRowMapper() {

            public CajaPagadoraVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CajaPagadoraVO caja = new CajaPagadoraVO();
                caja.setCalle(rs.getString(1));
                caja.setColonia(rs.getString(2));
                caja.setCodigoPostal(rs.getString(3));
                caja.setCiudad(rs.getString(4));
                caja.setEntidad(rs.getString(5));
                caja.setDia_cheque(rs.getInt(6));
                return caja;
            }
        });
        return cajasCobertura;
    }

    /**
     *Se obtiene la entidad del derechohabiente por Codigo Postal
     * @param codigoPostal
     * @return  
     */
    public Integer buscarEntidadPorCodigoPostal(Integer codigoPostal) {
        Integer cveEntidad = 0;
        List<Serializable> entidadesXCodPos = super.getJdbcTemplate().query(BENTIDAD_X_CODIGO_POSTAL, new Object[]{codigoPostal}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                EntidadVO vo = new EntidadVO();
                vo.setCveEntidad(rs.getInt(1));
                return vo;
            }
        });
        if (entidadesXCodPos != null && entidadesXCodPos.size() > 0) {
            cveEntidad = ((EntidadVO) entidadesXCodPos.get(0)).getCveEntidad();
        }
        return cveEntidad;
    }

    /**
     *Se obtiene el ramo anterior de acuerdo al ramo y la pagaduría
     * @param ramo 
     * @param base 
     * @param pagaduria 
     * @return 
     */
    public Integer buscarRamoAnterior(Integer ramo, String pagaduria, String base) {
        properties.cargaArchivo();
        Integer ramosAnt = null;
        String sql = "";
        String query = "";
        String from = "";
        if (ramo != null) {
            sql += " and num_ramo = " + ramo;
        }
        if (pagaduria != null && !pagaduria.equals("")) {
            sql += " and num_pagaduria ='" + pagaduria + "'";
        } else {
            sql += " and num_pagaduria is NULL";
        }
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }
        query = BRAMO_ANTERIOR_SELECT.replace("[BASE]", from);
        
        List<Integer> ramos = (List)super.getJdbcTemplate().query(query + sql, new SerializableRowMapper(){

            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer ramo = rs.getInt(1);
                return ramo;
                        
            }
        });
        if(ramos!=null && !ramos.isEmpty() && ramos.size()>0){
            ramosAnt= ramos.get(0);
        }
        return ramosAnt;
    }

    /**
     *Se obtiene el grupo de acuerdo al ramo anterior
     * @param ramoAnt
     * @return  
     */
    public Integer obtenerGrupoRamoAnt(Integer ramoAnt) {
        Integer grupo  = 0;

        List<Integer> grupoRamAnt =(List) super.getJdbcTemplate().query(BGRUPO_X_RAMO_ANT_SELECT, new Object[]{ramoAnt}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer grupo = rs.getInt(1);
                return grupo;
            }
        });
        if(grupoRamAnt!=null && grupoRamAnt.size()>0){
            grupo = grupoRamAnt.get(0);
        }
        return grupo;
    }

    /**
     * Se obtiene la oficina por los datos de la cobertura
     * @param cveEntidad 
     * @param cveUniad 
     * @param cveDeleg 
     * @return
     */
    public COficinaVO obtenerOficinaPorCobertura(int cveEntidad, int cveDeleg, int cveUniad) {
        COficinaVO oficina = null;
        List<Serializable> listaCajas = super.getJdbcTemplate().query(BOFICINA, new Object[]{cveEntidad, cveDeleg, cveUniad}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                COficinaVO vo = new COficinaVO();
                vo.setCveEntidad(rs.getInt(1));
                vo.setCveDeleg(rs.getInt(2));
                vo.setCveUniad(rs.getInt(3));
                vo.setCveOficina(rs.getInt(4));
                vo.setDescOficina(rs.getString(5));
                return vo;
            }
        });
        if (listaCajas != null && listaCajas.size() > 0) {
            oficina = (COficinaVO) listaCajas.get(0);
        }
        return oficina;
    }

    /**
     * Se obtiene que exista la oficina por los datos de la cobertura
     * @param cveEntidad 
     * @param cveUniad 
     * @param cveDeleg 
     * @param cveOficina 
     * @return
     */
    public COficinaVO obtenerOficinaBPorCobertura(int cveEntidad, int cveDeleg, Integer cveUniad, Integer cveOficina) {
        COficinaVO oficina = null;
        String sql = "";

        if (cveUniad != null) {
            sql += " and cve_uniad = " + cveUniad;
        }
        if (cveOficina != null) {
            sql += " and cve_oficina = " + cveOficina;
        }
        List<Serializable> lista = super.getJdbcTemplate().query(BOFICINAB + sql, new Object[]{cveEntidad, cveDeleg}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                COficinaVO vo = new COficinaVO();
                vo.setCveEntidad(rs.getInt(1));
                vo.setCveDeleg(rs.getInt(2));
                vo.setCveUniad(rs.getInt(3));
                vo.setCveOficina(rs.getInt(4));
                vo.setDescOficina(rs.getString(5));
                return vo;
            }
        });

        if (lista != null && lista.size() > 0) {
            oficina = (COficinaVO) lista.get(0);
        }
        return oficina;
    }

    /**
     * Se obtiene la unidadAdmin por los datos de la cobertura
     * @param cveEntidad 
     * @param cveDeleg 
     * @param cveUniad 
     * @return
     */
    public CUnidadVO obtenerUnidadPorCobertura(int cveEntidad, int cveDeleg, int cveUniad) {
        CUnidadVO unidad = null;
        unidad = (CUnidadVO) super.getJdbcTemplate().queryForObject(BUNIDAD, new Object[]{cveEntidad, cveDeleg, cveUniad}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CUnidadVO vo = new CUnidadVO();
                vo.setCveEntidad(rs.getInt(1));
                vo.setCveDeleg(rs.getInt(2));
                vo.setCveUniad(rs.getInt(3));
                vo.setDescUniad(rs.getString(4));
                return vo;
            }
        });
        return unidad;
    }

    /**
     * Se obtiene la Delegacion por los datos de la cobertura
     * @param cveEntidad 
     * @param cveDeleg 
     * @return
     */
    public CDelegacionVO obtenerDelegacionPorCobertura(int cveEntidad, int cveDeleg) {
        CDelegacionVO delegacion = null;
        delegacion = (CDelegacionVO) super.getJdbcTemplate().queryForObject(BDELEG, new Object[]{cveEntidad, cveDeleg}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CDelegacionVO vo = new CDelegacionVO();
                vo.setCveEntidad(rs.getInt(1));
                vo.setCveDeleg(rs.getInt(2));
                vo.setDescDeleg(rs.getString(3));
                return vo;
            }
        });
        return delegacion;
    }

    /**
     * Se obtiene la Entidad por los datos de la cobertura
     * @param cveEntidad 
     * @return
     */
    public EntidadVO obtenerEntidadPorCobertura(int cveEntidad) {
        EntidadVO entidad = null;
        entidad = (EntidadVO) super.getJdbcTemplate().queryForObject(BENTIDAD, new Object[]{cveEntidad}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                EntidadVO vo = new EntidadVO();
                vo.setCveEntidad(rs.getInt(1));
                vo.setDescEntidad(rs.getString(2));
                vo.setAbvEntidad(rs.getString(3));
                return vo;
            }
        });
        return entidad;
    }

    /**
     *Se obtiene la ciudad correspondiente a la caja pagadora por entidad para el caso de autos 
     * @param entidad 
     * @return 
     */
    public CajaPagadoraVO obtenerCajaPorEntidadAutos(int entidad) {
        CajaPagadoraVO cajasPorEntidad = super.getJdbcTemplate().queryForObject(BCAJAPAGADORAUTOS, new Object[]{entidad}, new BCajaPagadoraRowMapper() {

            public CajaPagadoraVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CajaPagadoraVO caja = new CajaPagadoraVO();
                caja.setId(rs.getInt(1));
                caja.setIdEntidad(rs.getInt(2));
                caja.setIdDelegacion(rs.getInt(3));
                caja.setIdUniad(rs.getInt(4));
                caja.setIdOficina(rs.getInt(5));
                caja.setCiudad(rs.getString(6));
                return caja;
            }
        });
        return cajasPorEntidad;
    }

    /**
     *Se obtiene la ciudad correspondiente a la caja pagadora por entidad para el caso de autos 
     * @param entidad 
     * @return 
     */
    public List<CajaPagadoraVO> obtenerCajaRamoDF(int ramoDF) {
        List<CajaPagadoraVO> cajasPagDF = null;
        String sql="";
        if (ramoDF == 26 || ramoDF == 226) {
            sql = "select cajp.id, cajp.id_entidad, cajp.id_delegacion, cajp.id_uniad, cajp.id_oficina, cof.desc_oficina, "
                    + " cajp.calle, cajp.colonia, cajp.codigo_postal, cajp.entidad, cajp.dia_cheque from caja_pagadora cajp ,c_oficina cof" +
            		" where cajp.id_entidad in (9)" +
            		" and cajp.id_estatus=1	" +
            		" and cajp.id_oficina in (18,1,11,20,12,19,17,21,10,23)" +
            		" and cajp.id_oficina = cof.cve_oficina" +
            		" and cajp.id_estatus=1";
        } else if (ramoDF == 23) {
             sql= " select cajp.id, cajp.id_entidad, cajp.id_delegacion, cajp.id_uniad, cajp.id_oficina, cof.desc_oficina, "
                    + " cajp.calle, cajp.colonia, cajp.codigo_postal, cajp.entidad, cajp.dia_cheque from caja_pagadora cajp ,c_oficina cof" +
                                " where cajp.id_entidad in (9)" +
        	   		" and cajp.id_estatus=1" +
        	   		" and cajp.id_oficina in (18,20,19,21)" +
        	   		" and cajp.id_oficina = cof.cve_oficina" +
        	   		" and cajp.id_estatus=1 "; 
        } else {
        	 sql= "select cajp.id, cajp.id_entidad, cajp.id_delegacion, cajp.id_uniad, cajp.id_oficina, cof.desc_oficina, "
                        + " cajp.calle, cajp.colonia, cajp.codigo_postal, cajp.entidad, cajp.dia_cheque from caja_pagadora cajp ,c_oficina cof" +
                                " where cajp.id_entidad in (0)" +
        	   		" and cajp.id_estatus=1" +
        	   		" and cajp.id_oficina in (0)" +
        	   		" and cajp.id_oficina = cof.cve_oficina" +
        	   		" and cajp.id_estatus=1 ";
        }
        cajasPagDF = super.getJdbcTemplate().query(sql, new BCajaPagadoraRowMapper());
        return cajasPagDF;
    }
}
