/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Autobus;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lol
 */
public class VehiculosTest
{

    static Vehiculo v1, v2;
    static Vehiculos vs1;

    @BeforeClass
    public static void setUpClass()
    {
        v1 = new Turismo("0000XXX", "a", "a", 1, 1, 1);
        v2 = new Autobus("0000BBB", "b", "b", 2, 2, 2);
    }

    @Before
    public void setUp()
    {
        vs1 = new Vehiculos();
    }

    @Test
    public void testAnadir1()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        //assert
        assertEquals("a",vs1.getVehiculo("0000XXX").getMarca());
    }

    @Test
    public void testAnadir2()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        vs1.anadir(v2);
        //assert
        assertEquals("b",vs1.getVehiculo("0000BBB").getMarca());
    }

    @Test
    public void testBorrar1()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        vs1.borrar("0000XXX");
        //assert
        
    }

    @Test
    public void testBorrarNull()
    {
        //arrange       
        //act
        try
        {
            vs1.borrar("0000XXX");
            fail("Excepcion no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
    }

    @Test
    public void testDatos()
    {
        //arrange  
        //act
        vs1.anadir(v1);
        //assert
        assertEquals("a", vs1.getVehiculo("0000XXX").getMarca());
    }

    @Test
    public void testDatosNull()
    {
        //arrange  
        //act
        try
        {
            vs1.getVehiculo("0000XXX");
            fail("Excepcion no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
    }

    @Test
    public void testEscribirLeer()
    {
        //arrange  
        //act
        vs1.anadir(v1);
        vs1.escribirFicheroObjetos();
        vs1 = new Vehiculos();
        vs1.leerFicheroObjetos();
        vs1.borrar("0000XXX");
        //assert
    }

}
