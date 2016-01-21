/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.dao.impl;

import com.ucol.otweb.dao.IMinMaxDao;
import com.ucol.otweb.utils.PropertyUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 
 */
@Component
@Repository(value = "minMaxDao")
public class MinMaxDaoImpl extends GenericDao implements IMinMaxDao {

    private static final String BMINIMO_SELECT = "select min([NOMBRE_CAMPO]) from [BASE][TABLA] b";
    private static final String BMAXIMO_SELECT = "select max([NOMBRE_CAMPO]) from [BASE][TABLA] b";

    /**
     * constructor
     */
    public MinMaxDaoImpl() {
        super();
    }


    /**
     * Metodo Generico para obtener el valor Minimo de una tabla
     *
     * @param campo - campo de cual se requiere extaer el valor minimo (obligatorio)
     * @param tabla - Tabla a la cual pertenece el campo (obligatorio)
     * @param base - base deonde se encuentra la tabla a ser consultada(opcional)
     * @return
     */
    public Object getMinimo(String campo, String tabla, String base) {

        String from = "";
        String query = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }
        query = BMINIMO_SELECT.replace("[NOMBRE_CAMPO]", campo);
        query = query.replace("[TABLA]", tabla);
        query = query.replace("[BASE]", from);

        Object objeto = super.getJdbcTemplate().queryForObject(query, new RowMapper<Object>() {

            public Object mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                return rs.getObject(1);
            }
        });
        return objeto;

    }

    /**
     * Metodo Generico para obtener el valor Maximo de una tabla
     *
     * @param campo - campo de cual se requiere extaer el valor minimo (obligatorio)
     * @param tabla - Tabla a la cual pertenece el campo (obligatorio)
     * @param base - base deonde se encuentra la tabla a ser consultada (opcional)
     * @return
     */
    public Object getMaximo(String campo, String tabla, String base) {
        String from = "";
        String query = null;
        PropertyUtils properties = new PropertyUtils("config.properties");
        properties.cargaArchivo();
        if (base != null && !base.equals("")) {
            if (base.equals(properties.getParametro("conection.dsipe"))) {
                from += properties.getParametro("conection.dsipe") + ":";
            } else {
                from += "";
            }
        }
        query = BMAXIMO_SELECT.replace("[NOMBRE_CAMPO]", campo);
        query = query.replace("[TABLA]", tabla);
        query = query.replace("[BASE]", from);

        Object objeto = super.getJdbcTemplate().queryForObject(query, new RowMapper<Object>() {

            public Object mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
                return rs.getObject(1);
            }
        });
        return objeto;
    }
}
