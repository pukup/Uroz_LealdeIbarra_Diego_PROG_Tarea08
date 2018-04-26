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
        assertEquals(v1, vs1.vehiculos[0]);
    }

    @Test
    public void testAnadir2()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        vs1.anadir(v2);
        //assert
        assertEquals(v1, vs1.vehiculos[0]);
        assertEquals(v2, vs1.vehiculos[1]);
    }

    @Test
    public void testAnadirLleno()
    {
        //arrange       
        //act
        for (int i = 0; i < 20; i++)
        {
            vs1.anadir(v1);
        }
        try
        {
            vs1.anadir(v1);
            fail("Excepción no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
    }

    @Test
    public void testBorrar1()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        vs1.borrar("0000XXX");
        //assert
        assertEquals(null, vs1.vehiculos[0]);
    }

    @Test
    public void testBorrarNull()
    {
        //arrange       
        //act
        vs1.anadir(v1);
        vs1.borrar("0000XXX");
        try
        {
            vs1.borrar("0000XXX");
            fail("Excepcion no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
            System.out.println(e);
        }
        //assert
        assertEquals(null, vs1.vehiculos[0]);
    }

    @Test
    public void testDatos()
    {
        //arrange  
        //act
        vs1.anadir(v1);
        //assert
        assertEquals(v1, vs1.getVehiculo("0000XXX"));
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
