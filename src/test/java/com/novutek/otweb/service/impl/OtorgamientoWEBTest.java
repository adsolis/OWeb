/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.service.impl;

import com.ucol.otweb.dao.IDatosLaborales;
import com.ucol.otweb.service.IOtorgamientoWEB;
import com.ucol.otweb.vo.EntidadVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 
 */
public class OtorgamientoWEBTest {
    
    public OtorgamientoWEBTest() {
    }
    
    private ApplicationContext context;
    @Autowired
    private IDatosLaborales datosLaborales;

    @Autowired
    private IOtorgamientoWEB iOtorgamientoWEB;
    
    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("file:C:\\otWEB\\OtorgamientoWEB\\src\\test\\java\\resources\\test-context.xml");
        //context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        datosLaborales = (IDatosLaborales) context.getBean("datosLaborales");
        iOtorgamientoWEB = (IOtorgamientoWEB) context.getBean("iOtorgamientoWEB");
    }

    /**
     * Test of finEntidades method, of class CEentidadesDaoImpl.
     */
  /*  @Test
    public void testFinEntidades() {
        System.out.println("finEntidades");
        List<BplazaVO> lent = null;
        lent = datosLaborales.busquedaRamoPagaduriaPlaza(2);
                
        System.out.println("tamaño list" + lent.size());
    }
*/
    @Test
    public void testSaveProduct() {

        EntidadVO cEntidades = new EntidadVO();
       
        List<EntidadVO> lsEntidades = new ArrayList<EntidadVO>();

        cEntidades.setCveEntidad(41);
        cEntidades.setAbvEntidad("333");
        cEntidades.setComponenteCve("--");
        cEntidades.setDescEntidad("actualizado");
        //cEntidades.setFechaAud(new Date());
        cEntidades.setIpEquipo("---");
        cEntidades.setUsuario("----");
        lsEntidades.add(cEntidades);
        
        cEntidades = new EntidadVO();
        cEntidades.setCveEntidad(42);
        cEntidades.setAbvEntidad("666");
        cEntidades.setComponenteCve("--");
        cEntidades.setDescEntidad("actualizado");
        //cEntidades.setFechaAud(new Date());
        cEntidades.setIpEquipo("---");
        cEntidades.setUsuario("----");
        lsEntidades.add(cEntidades);
        
        cEntidades = new EntidadVO();
        cEntidades.setCveEntidad(43);
        cEntidades.setAbvEntidad("666");
        cEntidades.setComponenteCve("--");
        cEntidades.setDescEntidad("actualizado");
        //cEntidades.setFechaAud(new Date());
        cEntidades.setIpEquipo("---");
        cEntidades.setUsuario("----");
        lsEntidades.add(cEntidades);
        
        cEntidades = new EntidadVO();
        cEntidades.setCveEntidad(43);
        cEntidades.setAbvEntidad("666");
        cEntidades.setComponenteCve("--");
        cEntidades.setDescEntidad("actualizado");
        //cEntidades.setFechaAud(new Date());
        cEntidades.setIpEquipo("---");
        cEntidades.setUsuario("----");
        lsEntidades.add(cEntidades);
        
        
        for(EntidadVO ls : lsEntidades){
            System.out.println("ls entidad ==="+ls.getCveEntidad());
            iOtorgamientoWEB.insertData(ls);
            //datosLaborales.insertData(ls);
        }
    }
}