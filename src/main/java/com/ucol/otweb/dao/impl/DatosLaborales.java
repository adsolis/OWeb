/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.dao.jdbc.*;
import com.ucol.otweb.utils.Constants;
import com.ucol.otweb.utils.DateUtils;
import com.ucol.otweb.utils.PropertyUtils;
import com.ucol.otweb.vo.BplazaVO;
import com.ucol.otweb.vo.CtnoCveVO;
import com.ucol.otweb.vo.DatosLaboralesVO;
import com.ucol.otweb.vo.DirectoAVVO;
import com.ucol.otweb.vo.DirectoVO;
import com.ucol.otweb.vo.EntidadVO;
import com.ucol.otweb.vo.PenIndVO;
import com.ucol.otweb.vo.PlazaVO;
import com.ucol.otweb.vo.PzaPenVO;
import com.ucol.otweb.vo.SolPensionVO;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Component
@Repository(value = "datosLaborales")
public class DatosLaborales extends GenericDao implements IDatosLaborales {

    private final static Logger logger = Logger.getLogger(DatosLaborales.class);
    /*
     * Se declaran las variables estaticas para las consultas requeridas
     */
    private static final String BPLAZA_RAMO_PAGAD_SELECT = "select num_ramo, num_pagaduria, num_issste from dsipe@aguila_sipe_tcp:plaza where num_issste = ?";
    private static final String BPLAZA__SELECT = "select num_ramo, num_pagaduria, num_issste, u_version, ssn_cve, fecha_alta, usuario, fecha_aud, hora_aud, componente_cve, "
            + " ip_maquina, sueldo_issste, tno_cve, cpa_cve, sin_cve, dis_cve, pto_cve, nsa_cve,fecha_ms, sueldo_sar, remuneracn_total, cobro_cve, "
            + " plz_estado, mod_cve from ";
    private static final String BPLAZA_PEN_SELECT = "select num_ramo, num_pagaduria, num_issste, num_pension, u_version, ssn_cve,impt_pension,t_pension,ppn_estado,"
            + " fecha_alta,fecha_baja,fecha_movto,usuario,fecha_aud,hora_aud,componente_cve, ip_maquina from ";
    private static final String BDERECHOHABIENTE_DIRECTO_AV = "select num_issste, u_version, codigo_postal, nco_cve, ent_cve, curp, nss, clinica, "
            + "dto_estado, sexo, estado_civil, t_directo, fecha_alta, fecha_baja, fecha_emi_vd1, "
            + "fecha_ingreso, num_exterior, num_interior, rfc, telefono, apellido_paterno, "
            + "apellido_materno, nombre, calle, poblacion, fec_nac, flag_homo, elig_proc, usuario, fecha_aud, hora_aud, componente_cve, ip_maquina from dsipe@aguila_sipe_tcp:DIRECTO ";
    private static final String BDERECHOHABIENTE_DIRECTO = "select num_issste, u_version, codigo_postal, nco_cve, ent_cve, curp, nss, clinica, "
            + "dto_estado, sexo, estado_civil, t_directo, fecha_alta, fecha_baja, fecha_emi_vd1, "
            + "fecha_ingreso, num_exterior, num_interior, rfc, telefono, apellido_paterno, "
            + "apellido_materno, nombre, calle, poblacion, fec_nac, flag_homo, elig_proc, usuario, fecha_aud, hora_aud, componente_cve, ip_maquina from DIRECTO ";
    private static final String BCLAVESIC_NOMBRAMIENTO = "select tno_cve_sic from  c_tno_cve where tno_cve = ?";
    private static final String CPLAZAS_PEN_ACT = "SELECT COUNT(*) FROM [BASE]pza_pen ";
    private static final String CPLAZAS_ACT = "SELECT COUNT(*) FROM [BASE]plaza WHERE plaza.num_issste = ? AND plaza.fecha_aud = to_date(?,'%d/%m/%Y')";
    private static final String SUMA_SUELDO_PLAZA = "SELECT SUM(sueldo_issste) FROM plaza WHERE num_issste = ? ";
    private static final String SUMA_SUELDO_PLAZA_PEN = "SELECT SUM(impt_pension) FROM pza_pen WHERE num_issste = ? ";
    private static final String BPENS_INDIR_SELECT = "SELECT num_issste, num_issste_d, spe_id FROM dsipe@aguila_sipe_tcp:pen_ind WHERE num_issste = ? AND codigo_deudo in (100,200,300,400,500,600,700,800,900) ";
    private static final String BSPEDID_PENS_INDIR_SELECT = "SELECT num_issste,num_issste_d,spe_id FROM dsipe@aguila_sipe_tcp:pen_ind WHERE ind_estado = 'A' ";
    private static final String BSOLIC_PENS_X_NUMISSSTE_SELECT = "SELECT num_issste, tbn_cve, num_pension FROM dsipe@aguila_sipe_tcp:sol_pension ";
    private static final String OBNOMBRAM_PLAZA_ISSSTE_RAM_PAG = "SELECT tno_cve FROM plaza ";
    private static final String BXNUM_ISSSTE_FILTRADO =
            "select num_ramo, num_pagaduria, num_issste, num_pension, u_version,  ssn_cve,impt_pension, "
            + "t_pension,ppn_estado,fecha_alta, fecha_baja,fecha_movto,usuario,fecha_aud,hora_aud,componente_cve, ip_maquina from dsipe@aguila_sipe_tcp:pza_pen"
            + " where num_issste=? "
            + " and (( num_ramo=19 and (t_pension in (101, 102, 103, 634))) "
            + "  or (num_ramo=6371 and (t_pension in (104, 105)))  "
            + " or (num_ramo=95000 and (t_pension in (101)))) order by fecha_aud desc ";
    private static final String CPLAZAPORMODCVE = "select count(*) from [BASE]plaza where num_issste= ? and plz_estado = 'A' and mod_cve in (1,2,8,11,18)";
    private static final String BTIPO_NOMINA_BY_CVE = "SELECT  DISTINCT tno_cve_sic,descripcion_sic FROM c_tno_cve WHERE  c_tno_cve.tno_cve_sic = ?";
    private static final String CDATOS_X_ANT_PERMITIDA = "select count(*) from directo a, c_param_otorga p where p.cve_param_otorga = ? and a.num_issste=? and a.fecha_ingreso>=p.val_param_otorga";

    public DatosLaborales() {
    }

    /*
     * Se hace la busqueda de los datos del trabajador en la tabla directo de AV 
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<DirectoAVVO> busquedaDerechohabienteAVDirecto(DatosLaboralesVO datosPersona, boolean dtoEstado) {
        List<DirectoAVVO> listadirectoAv = null;
        String sql = "";
        if (datosPersona.getNumIssste() != null) {
            if (sql.equals("")) {
                sql += " where num_issste = " + datosPersona.getNumIssste();
            } else {
                sql += " and num_issste = " + datosPersona.getNumIssste();
            }
        }

        if (datosPersona.getCurp() != null && !datosPersona.getCurp().equals("")) {
            if (sql.equals("")) {
                sql += " where curp = '" + datosPersona.getCurp() + "'";
            } else {
                sql += " and curp = '" + datosPersona.getCurp() + "'";
            }
        }

        if (datosPersona.getRfc() != null && !datosPersona.getRfc().equals("")) {
            if (sql.equals("")) {
                sql += " where rfc = '" + datosPersona.getRfc() + "'";
            } else {
                sql += " and rfc = '" + datosPersona.getRfc() + "'";
            }
        }
        //Parametro para la busqueda del derechohabiente si ha fallecido
        if (dtoEstado == true) {
            if (sql.equals("")) {
                sql += " where dto_estado = 'F'";
            } else {
                sql += " and dto_estado = 'F' ";
            }
        }
        listadirectoAv = super.getJdbcTemplate().query(BDERECHOHABIENTE_DIRECTO_AV + sql, new BDirectoAVRowMapper());

        return listadirectoAv;
    }

    /*
     * Se hace la busqueda de los datos del trabajador en la tabla directo de SIPESIC
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<DirectoVO> busquedaDerechohabienteDirecto(DatosLaboralesVO datosPersona) {
        List<DirectoVO> listadirectoAv = null;
        String sql = "";
        if (datosPersona.getNumIssste() != null) {
            if (sql.equals("")) {
                sql += " where num_issste = " + datosPersona.getNumIssste();
            } else {
                sql += " and num_issste = " + datosPersona.getNumIssste();
            }
        }

        if (datosPersona.getCurp() != null && !datosPersona.getCurp().equals("")) {
            if (sql.equals("")) {
                sql += " where curp = '" + datosPersona.getCurp() + "'";
            } else {
                sql += " and curp = '" + datosPersona.getCurp() + "'";
            }
        }

        if (datosPersona.getRfc() != null && !datosPersona.getRfc().equals("")) {
            if (sql.equals("")) {
                sql += " where rfc = '" + datosPersona.getRfc() + "'";
            } else {
                sql += " and rfc = '" + datosPersona.getRfc() + "'";
            }
        }
        listadirectoAv = super.getJdbcTemplate().query(BDERECHOHABIENTE_DIRECTO + sql, new BDirectoRowMapper());

        return listadirectoAv;
    }

    /*
     * Se obtiene el ramo y la pagaduría de la plaza del trabajador
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<BplazaVO> busquedaRamoPagaduriaPlaza(Integer issste) {
        List<BplazaVO> lstStr = null;

        lstStr = super.getJdbcTemplate().query(BPLAZA_RAMO_PAGAD_SELECT, new Object[]{issste}, new BPlazaRowMapper() {

            public BplazaVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                BplazaVO ui = new BplazaVO();
                ui.setNumRamo(rs.getInt(1));
                ui.setNumPagaduria(rs.getString(2));
                ui.setNumIssste(rs.getInt(3));
                return ui;
            }
        });

        logger.debug(lstStr.toString());
        return lstStr;
    }

    /*
     * Se hace la busqueda de la plaza del trabajador en AV o en SIPESIC ya sea el caso en el que se requiera
     */
    @Transactional(isolation=Isolation.READ_UNCOMMITTED)
    public List<PlazaVO> buscarPlazas(DatosLaboralesVO datosLaboralesVO, String base, boolean modCvPlEs) {
        List<PlazaVO> listaPlazas = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String from = "";
        String sql = "";
        String order = " order by fecha_aud desc ";
        if (datosLaboralesVO.getNumIssste() != null && datosLaboralesVO.getNumIssste() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_issste = " + datosLaboralesVO.getNumIssste();
            } else {
                sql += " and  num_issste = " + datosLaboralesVO.getNumIssste();
            }
        }
        if (datosLaboralesVO.getRamo() != null && datosLaboralesVO.getRamo() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_ramo = " + datosLaboralesVO.getRamo();
            } else {
                sql += " and  num_ramo = " + datosLaboralesVO.getRamo();
            }
        }
        if (datosLaboralesVO.getPagaduria() != null && !datosLaboralesVO.getPagaduria().equals("")) {
            if (sql.equals("")) {
                sql += " WHERE num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            } else {
                sql += " and  num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            }
        }

        if (modCvPlEs) {
            sql += " and plz_estado = 'A'  and mod_cve in (1,2,8,11,18) ";
        }

        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":plaza ";
            } else {
                from += " plaza ";
            }
        }

        listaPlazas = super.getJdbcTemplate().query(BPLAZA__SELECT + from + sql + order, new BPlazaVORowMapper());

        return listaPlazas;
    }

    /*
     * Se hace la busqueda de la plaza_pen del trabajador en AV o en SIPESIC ya sea el caso en el que se requiera
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PzaPenVO> buscarPlazaPensionado(DatosLaboralesVO datosLaboralesVO, String base, boolean aLaFechaActual) {
        List<PzaPenVO> listaPlazasPen = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();

        String from = "";
        String sql = "";
        String order = " order by fecha_aud desc ";
        if (datosLaboralesVO.getNumIssste() != null && datosLaboralesVO.getNumIssste() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_issste = " + datosLaboralesVO.getNumIssste();
            } else {
                sql += " and  num_issste = " + datosLaboralesVO.getNumIssste();
            }
        }
        if (datosLaboralesVO.getRamo() != null && datosLaboralesVO.getRamo() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_ramo = " + datosLaboralesVO.getRamo();
            } else {
                sql += " and  num_ramo = " + datosLaboralesVO.getRamo();
            }
        }
        if (datosLaboralesVO.getPagaduria() != null && !datosLaboralesVO.getPagaduria().equals("")) {
            if (sql.equals("")) {
                sql += " WHERE num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            } else {
                sql += " and  num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            }
        }

        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":pza_pen ";
            } else {
                from += " pza_pen ";
            }
        }
        
        if (aLaFechaActual) {
            sql += " AND fecha_aud = to_date('" + DateUtils.fechaActualToString() + "','%d/%m/%Y')";
        }else{
            sql += " AND fecha_aud = (SELECT MAX(fecha_aud)FROM " +from
                                        +  " WHERE num_issste = "+ datosLaboralesVO.getNumIssste() + ")";
        }
        listaPlazasPen = super.getJdbcTemplate().query(BPLAZA_PEN_SELECT + from + sql + order, new BPlazaPenRowMapper());
        return listaPlazasPen;
    }

    /**
     *Se obtiene el nombramiento del trabajador por su clave
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CtnoCveVO obtenerClaveSicNombramientoTrabajador(Integer tno_cve) {
        List<CtnoCveVO> listaClaveSic = null;
        CtnoCveVO ctnoCveVO = null;

        listaClaveSic = super.getJdbcTemplate().query(BCLAVESIC_NOMBRAMIENTO, new Object[]{tno_cve}, new CtnoCveVORowMapper() {

            public CtnoCveVO mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                CtnoCveVO ctnoCveVOAux = new CtnoCveVO();
                ctnoCveVOAux.setTnoCveSic(rs.getInt(1));
                return ctnoCveVOAux;
            }
        });
        if (listaClaveSic != null && listaClaveSic.size() > 0) {
            ctnoCveVO = listaClaveSic.get(0);
        }
        return ctnoCveVO;
    }

    /**
     *Se obtiene la suma del sueldo de la plaza por numero de Issste
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Double obtenerSumaSueldoPlaza(Integer numIssste, boolean simulado) {
        Double sueldoPlaza = null;
        String sql="";
        if(simulado){
            sql=" AND fecha_aud =to_date("+DateUtils.fechaActualToString()+",'%d/%m/%Y') ";
        }
        sueldoPlaza = (Double) super.getJdbcTemplate().queryForObject(SUMA_SUELDO_PLAZA+ sql, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                Double sueldo = 0.0;
                sueldo = rs.getDouble(1);
                return sueldo;
            }
        });

        return sueldoPlaza;
    }

    /**
     *Se obtiene la suma del sueldo de la pza_pen por numero de Issste
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Double obtenerSumaSueldoPlazaPen(Integer numIssste, boolean simulado) {
        Double sueldoPlazaPen = null;
        String sql="";
        if(simulado){
            sql=" AND fecha_aud = to_date("+DateUtils.fechaActualToString()+",'%d/%m/%Y') ";
        }
        
        sueldoPlazaPen = (Double) super.getJdbcTemplate().queryForObject(SUMA_SUELDO_PLAZA_PEN +sql, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                Double sueldo = 0.0;
                sueldo = rs.getDouble(1);
                return sueldo;
            }
        });
        return sueldoPlazaPen;
    }

    /**
     *Se obtiene la pension indirecta por numIssste
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PenIndVO> obtenerPensionIndirecta(Integer numIssste) {
        List<Serializable> pensionIndirecta = null;

        pensionIndirecta = super.getJdbcTemplate().query(BPENS_INDIR_SELECT, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PenIndVOExtractor extractor = new PenIndVOExtractor();
                return extractor.extractData(rs);
            }
        });

        return (List<PenIndVO>) (List) pensionIndirecta;
    }

    /**
     *Se obtiene el speId de la pension indirecta por numIssste y numIsssteD
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PenIndVO> obtenerIDPensionIndirecta(PenIndVO indVO) {
        List<Serializable> pensionIndirecta = null;
        String sql = "";
        if (indVO.getNumissste() != null && indVO.getNumissste() > 0) {
            sql += " AND num_issste = " + indVO.getNumissste();
        }
        if (indVO.getNumisssted() != null && indVO.getNumisssted() > 0) {
            sql += " num_issste_d = " + indVO.getNumisssted();
        }

        pensionIndirecta = super.getJdbcTemplate().query(BSPEDID_PENS_INDIR_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PenIndVOExtractor extractor = new PenIndVOExtractor();
                return extractor.extractData(rs);
            }
        });

        return (List<PenIndVO>) (List) pensionIndirecta;
    }

    /**
     *Se obtiene la solicitud de pension por numIssste y speID
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<SolPensionVO> obtenerSolicPension(Integer numIssste, Integer speId) {
        List<Serializable> solicitudPens = null;
        String sql = "";

        if (numIssste != null && numIssste > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_issste = " + numIssste;
            } else {
                sql += " and  num_issste = " + numIssste;
            }
        }
        if (speId != null && speId > 0) {
            if (sql.equals("")) {
                sql += " WHERE spe_id = " + speId;
            } else {
                sql += " and  spe_id = " + speId;
            }
        }
        solicitudPens = super.getJdbcTemplate().query(BSOLIC_PENS_X_NUMISSSTE_SELECT + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PenIndVOExtractor extractor = new PenIndVOExtractor();
                return extractor.extractData(rs);
            }
        });

        return (List<SolPensionVO>) (List) solicitudPens;
    }

    /**
     *Se obtiene el nombramiento de la plaza por numIssste, ramo, Pagaduria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<CtnoCveVO> obtenerNombEnPlaza(DatosLaboralesVO datosLaboralesVO) {
        List<Serializable> solicitudPens = null;
        String sql = "";

        if (datosLaboralesVO.getNumIssste() != null && datosLaboralesVO.getNumIssste() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_issste = " + datosLaboralesVO.getNumIssste();
            } else {
                sql += " and  num_issste = " + datosLaboralesVO.getNumIssste();
            }
        }
        if (datosLaboralesVO.getRamo() != null && datosLaboralesVO.getRamo() > 0) {
            if (sql.equals("")) {
                sql += " WHERE num_ramo = " + datosLaboralesVO.getRamo();
            } else {
                sql += " and  num_ramo = " + datosLaboralesVO.getRamo();
            }
        }
        if (datosLaboralesVO.getPagaduria() != null && !datosLaboralesVO.getPagaduria().equals("")) {
            if (sql.equals("")) {
                sql += " WHERE num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            } else {
                sql += " and  num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            }
        } /*else if(datosLaboralesVO.getPagaduria()==null) {
        if (sql.equals("")) {
        sql += " WHERE num_pagaduria is NULL ";
        } else {
        sql += " and  num_pagaduria  is NULL ";
        }
        }*/
        solicitudPens = super.getJdbcTemplate().query(OBNOMBRAM_PLAZA_ISSSTE_RAM_PAG + sql, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CtnoCveVO ccvo = new CtnoCveVO();
                ccvo.setTnoCve(rs.getInt(1));
                return ccvo;
            }
        });

        return (List<CtnoCveVO>) (List) solicitudPens;
    }

    /**
     *Se obtiene la plaza pensionado de acuerdo al ramoPensionado para el 26 =19 y para el 226 =6371
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PzaPenVO> obtenerPlazaDeAcuedoRamoPen(Integer numIssste, Integer ramoPens, String base) {
        List<Serializable> listaPlazasPen = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String from = "";
        String where = "";
        if (numIssste != null && numIssste > 0) {
            if (where.equals("")) {
                where += " WHERE num_issste = " + numIssste;
            } else {
                where += " AND num_issste = " + numIssste;
            }
        }
        if (ramoPens != null && ramoPens > 0) {
            if (ramoPens == 26) {
                if (where.equals("")) {
                    where += " WHERE num_ramo = 19 AND num_pagaduria[1,3] = '074' ";
                } else {
                    where += " AND num_ramo = 19 AND num_pagaduria[1,3] = '074' ";
                }
            } else if (ramoPens == 226) {
                if (where.equals("")) {
                    where += " WHERE num_ramo = 6371 ";
                } else {
                    where += " AND num_ramo = 6371 AND ";
                }
            }

        }
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":plaza ";
            } else {
                from += " plaza ";
            }
        }
        listaPlazasPen = super.getJdbcTemplate().query(BPLAZA__SELECT + from + where, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                BPlazaPenExtractor extractor = new BPlazaPenExtractor();
                return extractor.extractData(rs);
            }
        });

        return (List<PzaPenVO>) (List) listaPlazasPen;

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countPlazas(Integer numIssste, String base) {
        Integer countPlazasInt = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();

        String from = "";
        String query = null;
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }
        query = CPLAZAS_ACT.replace("[BASE]", from);
        countPlazasInt = super.getJdbcTemplate().queryForInt(query, new Object[]{numIssste, DateUtils.fechaActualToString()});

        return countPlazasInt;
    }
    //TODO:Insert
//    @ Transactional (rollbackFor = Exception.class, propagation= Propagation.REQUIRED)

    public void insertData(EntidadVO ent) {

        String sql = "INSERT INTO c_entidades "
                + "(cve_entidad, desc_entidad, abv_entidad, usuario, fecha_aud, componente_cve, ip_equipo) VALUES (?,?,?,?,?,?,?)";
        
        super.getJdbcTemplate().update(
                sql,
                new Object[]{ent.getCveEntidad(), ent.getDescEntidad(), ent.getAbvEntidad(), ent.getUsuario(), ent.getFechaAud(), ent.getComponenteCve(), ent.getIpEquipo()});
    }

    //TODO:delete
    public void deleteData(Integer id) {
        String sql = "delete from c_entidades where cve_entidad=" + id;
        super.getJdbcTemplate().update(sql);
        logger.debug(sql);
    }

    //TODO:Update
    public void updateData(EntidadVO ent) {

        String sql = "UPDATE c_entidades set desc_entidad=? where cve_entidad = ?";

        super.getJdbcTemplate().update(
                sql,
                new Object[]{ent.getDescEntidad(), ent.getCveEntidad()});

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countPlazasPen(DatosLaboralesVO datosLaboralesVO, String base, boolean fechaActu) {
        Integer countPlazasInt = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        String where = "";
        String from = "";
        String query = null;
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }

        if (datosLaboralesVO.getNumIssste() != null && datosLaboralesVO.getNumIssste() > 0) {
            if (where.equals("")) {
                where += " WHERE pza_pen.num_issste = " + datosLaboralesVO.getNumIssste();
            } else {
                where += " and  pza_pen.num_issste = " + datosLaboralesVO.getNumIssste();
            }
        }
        if (datosLaboralesVO.getRamo() != null && datosLaboralesVO.getRamo() > 0) {
            if (where.equals("")) {
                where += " WHERE pza_pen.num_ramo = " + datosLaboralesVO.getRamo();
            } else {
                where += " and  pza_pen.num_ramo = " + datosLaboralesVO.getRamo();
            }
        }
        if (datosLaboralesVO.getPagaduria() != null && !datosLaboralesVO.getPagaduria().equals("")) {
            if (where.equals("")) {
                where += " WHERE pza_pen.num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            } else {
                where += " and  pza_pen.num_pagaduria = '" + datosLaboralesVO.getPagaduria() + "'";
            }
        }
        if (fechaActu) {
            if (where.equals("")) {
                where += " where pza_pen.fecha_aud = to_date(" + DateUtils.fechaActualToString() + ",'%d/%m/%Y')";
            } else {
                where += " AND pza_pen.fecha_aud = to_date(" + DateUtils.fechaActualToString() + ",'%d/%m/%Y')";
            }
        }
        query = CPLAZAS_PEN_ACT.replace("[BASE]", from);
        countPlazasInt = super.getJdbcTemplate().queryForInt(query + where);

        return countPlazasInt;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Integer countPlazasPorModCve(Integer numIssste, String base) {
        Integer countPlazasInt = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();

        String from = "";
        String query = null;
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }
        query = CPLAZAPORMODCVE.replace("[BASE]", from);
        countPlazasInt = super.getJdbcTemplate().queryForInt(query, new Object[]{numIssste});

        return countPlazasInt;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PlazaVO> buscarPlazasAct(Integer numIssste, String base, boolean aLaFechaActual) {
        List<PlazaVO> listaPlazas = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();

        String from = "";
        String where = " where num_issste = " + numIssste;
        if (aLaFechaActual) {
            where += " AND fecha_aud = to_date('" + DateUtils.fechaActualToString() + "','%d/%m/%Y')";
        }

        String order = " order by fecha_aud desc ";
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":plaza ";
            } else {
                from += " plaza ";
            }
        }
        listaPlazas = super.getJdbcTemplate().query(BPLAZA__SELECT + from + where + order, new BPlazaVORowMapper());

        return listaPlazas;
    }

    /**
     * se obtiene la plaza de pensionado por el numero de ISSSTE con los filtros de ramo y t_pension
     * @param numIssste
     * @return
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PzaPenVO> obtenerPlzaPenByNumIsssteFiltrado(int numIssste) {
        List<PzaPenVO> listaPza = null;
        listaPza = (List) super.getJdbcTemplate().query(BXNUM_ISSSTE_FILTRADO, new Object[]{numIssste}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                PzaPenVO vo = new PzaPenVO();
                vo.setNumRamo(rs.getBigDecimal(1));
                vo.setNumPagaduria(rs.getString(2));
                vo.setNumIssste(rs.getInt(3));
                vo.setNumPension(rs.getInt(4));
                vo.setuVersion(rs.getString(5));
                vo.setSsnCve(rs.getString(6));
                vo.setImptPension(rs.getDouble(7));
                vo.settPension(rs.getDouble(8));
                vo.setPpnEstado(rs.getString(9));
                vo.setFechaAlta(rs.getDate(10));
                vo.setFechaBaja(rs.getDate(11));
                vo.setFechaMovto(rs.getDate(12));

                return vo;
            }
        });
        return listaPza;
    }

    public CtnoCveVO obtenerObjCTCve(int ctnoCve) {
        CtnoCveVO objCtnoCve = null;
        List<Serializable> listaObjCve = super.getJdbcTemplate().query(BTIPO_NOMINA_BY_CVE, new Object[]{ctnoCve}, new SerializableRowMapper() {

            public Serializable mapRow(ResultSet rs, int i) throws SQLException {
                CtnoCveVO ccvo = new CtnoCveVO();
                ccvo.setTnoCveSic(rs.getInt(1));
                ccvo.setDescripcionSic(rs.getString(2));
                return ccvo;
            }
        });
        if (listaObjCve != null && listaObjCve.size() > 0) {
            objCtnoCve = (CtnoCveVO) listaObjCve.get(0);
        }
        return objCtnoCve;
    }

    /**
     *Se inserta un nuevo registro de pza_pen en sipesic
     */
    public boolean insertPlazaPen(PzaPenVO pzaPenVO) {
        boolean inserto = false;
        int ramoPen;
        if (pzaPenVO.getNumRamoAnt() != null && pzaPenVO.getNumRamoAnt() > 0) {
            ramoPen = pzaPenVO.getNumRamoAnt();
        } else {
            ramoPen = pzaPenVO.getNumRamo().intValue();
        }
        try {

            String sql = "INSERT INTO pza_pen(num_ramo, num_pagaduria, num_issste, num_pension, u_version, sin_cve, ssn_cve, dis_cve, impt_pension, num_pensionista, t_pension, ppn_estado, fecha_alta, fecha_baja, fecha_movto, usuario, fecha_aud, hora_aud, componente_cve, ip_maquina) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            super.getJdbcTemplate().update(
                    sql,
                    new Object[]{ramoPen, pzaPenVO.getNumPagaduria(), pzaPenVO.getNumIssste(), pzaPenVO.getNumPension(), pzaPenVO.getuVersion(), pzaPenVO.getSinCve(), pzaPenVO.getSsnCve(), pzaPenVO.getDisCve(), pzaPenVO.getImptPension(), pzaPenVO.getNumPensionista(), pzaPenVO.gettPension(), pzaPenVO.getPpnEstado(), pzaPenVO.getFechaAlta(), pzaPenVO.getFechaBaja(), pzaPenVO.getFechaMovto(), pzaPenVO.getUsuario(), new Date(), DateUtils.horaActual(), pzaPenVO.getComponenteCve(), pzaPenVO.getIpMaquina()});

            inserto = true;
        } catch (Exception exp) {
            inserto = false;
        }
        return inserto;
    }

    /**
     *Se inserta un nuevo registro en plaza
     */
    public boolean insertPlaza(PlazaVO plazaVO) {
        boolean inserto = false;
        int ramo;

        if (plazaVO.getRamoAnterior()!=null && plazaVO.getRamoAnterior().intValue() > 0) {
            ramo = plazaVO.getRamoAnterior().intValue();
        } else {
            ramo = plazaVO.getNumRamo().intValue();
        }

        try {

            String sql = "INSERT INTO informix.plaza(num_ramo, num_pagaduria, num_issste, u_version, tno_cve, cpa_cve, sin_cve, ssn_cve, dis_cve, pto_cve, nsa_cve, fecha_alta, fecha_ms, sueldo_issste, sueldo_sar, remuneracn_total, cobro_cve, plz_estado, usuario, fecha_aud, hora_aud, componente_cve, ip_maquina, mod_cve) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            super.getJdbcTemplate().update(
                    sql,
                    new Object[]{ramo, plazaVO.getNumPagaduria(), plazaVO.getNumIssste(), plazaVO.getuVersion(), plazaVO.getTnoCve(), plazaVO.getCpaCve(), plazaVO.getSinCve(), plazaVO.getSsnCve(), plazaVO.getDisCve(), plazaVO.getPtoCve(), plazaVO.getNsaCve(), plazaVO.getFechaAlta(), plazaVO.getFechaMs(), plazaVO.getSueldoIssste(), plazaVO.getSueldoSar(), plazaVO.getRemuneracnTotal(), plazaVO.getCobroCve(), plazaVO.getPlzEstado(), plazaVO.getUsuario(), new Date(), DateUtils.horaActual(), plazaVO.getComponenteCve(), plazaVO.getIpMaquina(), plazaVO.getModCve()});

            inserto = true;
        } catch (Exception exp) {
            inserto = false;
        }
        return inserto;
    }

    /**
     *Se actualiza la pza_pen
     */
    public boolean updatePlazaPen(PzaPenVO pzaPenVO, Double sueldo, String usuario, String componente, String ipMaquina) {
        boolean actualizo = false;
        try {

            String sql = "UPDATE pza_pen set impt_pension=?, fecha_aud=?, hora_aud =?, usuario=?, componente_cve=?, ip_maquina=? where num_issste= ? "
                    + " and num_ramo=? and num_pagaduria=?";

            super.getJdbcTemplate().update(
                    sql,
                    new Object[]{sueldo, new Date(), DateUtils.horaActual(), usuario, componente, ipMaquina, pzaPenVO.getNumIssste(), pzaPenVO.getNumRamo(), pzaPenVO.getNumPagaduria()});

            actualizo = true;
        } catch (Exception exp) {
            actualizo = false;
        }
        return actualizo;
    }

    public boolean updatePlaza(PlazaVO plazaVO, Double sueldo, String usuario, String componente, String ipMaquina) {
        boolean actualizo = false;
        try {
            String sql = "UPDATE plaza set sueldo_issste=?, mod_cve=?, fecha_aud=?,hora_aud =?, usuario=?, componente_cve=?,tno_cve=?, ip_maquina=? where num_issste= ? "
                    + " and num_ramo=? and num_pagaduria=? and plz_estado = 'A' ";

            super.getJdbcTemplate().update(sql, new Object[]{sueldo, plazaVO.getModCve(), new Date(), DateUtils.horaActual(), usuario, componente, plazaVO.getTnoCve(), ipMaquina, plazaVO.getNumIssste(), plazaVO.getRamoAnterior(), plazaVO.getNumPagaduria()});

            actualizo = true;
        } catch (Exception exp) {
            exp.getMessage();
            actualizo = false;
        }
        return actualizo;
    }

    /**
     *Se inserta registro en Directo para sipesic
     */
    public boolean insertDirecto(DirectoAVVO directoAVVO) {
        boolean inserto = false;
        try {
            String sql = "INSERT INTO directo(num_issste, u_version, codigo_postal, nco_cve, ent_cve, curp, nss, clinica, dto_estado, sexo, estado_civil, t_directo, fecha_alta, fecha_baja, fecha_emi_vd1, fecha_ingreso, num_exterior, num_interior, rfc, telefono, apellido_paterno, apellido_materno, nombre, calle, poblacion, fec_nac, flag_homo, elig_proc, usuario, fecha_aud, hora_aud, componente_cve, ip_maquina, ent_ads) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            super.getJdbcTemplate().update(
                    sql,
                    new Object[]{directoAVVO.getNumIssste(), directoAVVO.getUversion(), directoAVVO.getCodigoPostal(), directoAVVO.getNcoCve(), directoAVVO.getEntCve(), directoAVVO.getCurp(), directoAVVO.getNss(), directoAVVO.getClinica(), directoAVVO.getDtoEstado(), directoAVVO.getSexo(), directoAVVO.getEstadoCivil(), directoAVVO.getTdirecto(), directoAVVO.getFechaAlta(), directoAVVO.getFechaBaja(), directoAVVO.getFechaEmiVd1(), directoAVVO.getFechaIngreso(), directoAVVO.getNumExterior(), directoAVVO.getNumInterior(), directoAVVO.getRfc(), directoAVVO.getTelefono(), directoAVVO.getApellidoPaterno(), directoAVVO.getApellidoMaterno(), directoAVVO.getNombre(), directoAVVO.getCalle(), directoAVVO.getPoblacion(), directoAVVO.getFecNac(), directoAVVO.getFlagHomo(), directoAVVO.getEligProc(), directoAVVO.getUsuario(), "to_date('" + DateUtils.fechaActualToString() + "','%d/%m/%Y')", DateUtils.horaActual(), directoAVVO.getComponenteCve(), directoAVVO.getIpMaquina(), null});

            inserto = true;
        } catch (Exception exp) {
            inserto = false;
        }
        return inserto;
    }

    public boolean updateDirecto(DirectoVO directoAVVO) {
        boolean inserto = false;
        try {
            Object[] params = new Object[7];
            String sql = "UPDATE directo SET elig_proc=?, usuario=?, fecha_aud=?, hora_aud=?, componente_cve=?, ip_maquina=? where num_issste=?";

            params[0] = directoAVVO.getEligProc();
            params[1] = directoAVVO.getUsuario();
            params[2] = new Date();
            params[3] = DateUtils.horaActual();
            params[4] = directoAVVO.getComponenteCve();
            params[5] = directoAVVO.getIpMaquina();
            params[6] = directoAVVO.getNumIssste();
            super.getJdbcTemplate().update(sql, params);

            inserto = true;
        } catch (Exception exp) {
            inserto = false;
        }
        return inserto;
    }

    public void updateDirectoEntRec(DirectoVO directoAVVO) {
        Object[] params = new Object[2];
        String sql = "Update Directo Set ent_ads = ? WHERE num_issste = ?";

        params[0] = directoAVVO.getEntAds();
        params[1] = directoAVVO.getNumIssste();
        super.getJdbcTemplate().update(sql, params);

    }

    /**
     * conteo para saber si la antiguedad es la permitida
     * con respecto a la tabla de parametros de otorgamiento
     * @param numIssste
     * @return 
     */
    public Integer countAntiguedadPermitida(int numIssste) {
        Integer count = null;
        count = super.getJdbcTemplate().queryForInt(CDATOS_X_ANT_PERMITIDA,
                new Object[]{Constants.PARAM_ANT_MIN_PERM, numIssste});
        return count;
    }
}
