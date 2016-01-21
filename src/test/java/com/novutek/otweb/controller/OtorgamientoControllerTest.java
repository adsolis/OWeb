/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucol.otweb.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 
 */
public class OtorgamientoControllerTest {
    
    public OtorgamientoControllerTest() {
    }
    
     @Test
     public void testHandleRequestView() throws Exception{
        OtorgamientoController controller = new OtorgamientoController();
        ModelAndView modelAndView = controller.tipoOtorgamiento();
        assertEquals("index", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("command");
        assertNotNull(nowValue);
    }
}