/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dao.Clientes;
import java.util.List;
import java.util.Vector;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import java.io.EOFException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.runners.model.MultipleFailureException.assertEmpty;

/**
 *
 * @author lol
 */
public class ClientesTest
{

    public static Clientes cs1;
    public static Cliente c1, c2;

    @BeforeClass
    public static void setUpBeforeClass()
    {
        c1 = new Cliente("a", "00000000A", "a", "a", "00000");
        c2 = new Cliente("b", "00000000B", "b", "b", "11111");
    }

    @Before
    public void setUp()
    {
        cs1 = new Clientes();
    }

    @Test
    public void testAnadir()
    {
        //arrange       
        //act
        cs1.anadir(c1);
        //assert
        //assertEquals(c1, cs1.clientes[0]);
    }

    @Test
    public void testAnadir2()
    {
        //arrange       
        //act
        cs1.anadir(c1);
        cs1.anadir(c2);
        //assert        
        assertEquals(2, cs1.getCliente("00000000B").getIdentificador());
    }
    
        @Test
    public void testAnadirNull()
    {
        //arrange       
        //act
        cs1.anadir(null);
        //assert        
    }

    @Test
    public void testAnadirLleno()
    {
        //arrange
        //act
        for (int i = 0; i < 20; i++)
        {
            cs1.anadir(c1);
        }
        try
        {
            cs1.anadir(c1);
            fail("Excepción no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
        }
        //assert        
        //assertEquals(c1, cs1.clientes[19]);
    }

    @Test
    public void testBorrar()
    {
        //arrange  
        //act
        cs1.anadir(c1);
        cs1.anadir(c2);
        cs1.borrar("00000000B");
        //assert

    }

    @Test
    public void testBorrarNull()
    {
        //arrange  
        //act
        cs1.anadir(c1);
        cs1.anadir(c2);
        cs1.borrar("00000000B");
        try
        {
            cs1.borrar("00000000B");
            fail("Excepcion no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
        }
        //assert
    }

    @Test
    public void testDatos()
    {
        //arrange  
        //act
        cs1.anadir(c1);
        //assert
        assertEquals(c1, cs1.getCliente("00000000A"));
    }

    @Test
    public void testDatosNull()
    {
        //arrange  
        //act
        try
        {
            System.out.println(cs1.getCliente("00000000A"));
            fail("Excepción no lanzada.");
        } catch (ExcepcionAlquilerVehiculos e)
        {
        }
        //assert
    }

    @Test
    public void testEscribirLeerFichero()
    {
        //arrange  
        //act        
        cs1.anadir(c1);
        cs1.escribirFicheroObjetos();
        cs1 = new Clientes();
        cs1.leerObjetosDeFichero();
        cs1.borrar("00000000A");
        //assert
    }

    @Test
    public void testActualizarIdentificador()
    {
        //arrange  
        //act        
        cs1.anadir(c1);
        cs1.escribirFicheroObjetos();
        cs1 = new Clientes();
        cs1.leerObjetosDeFichero();
        cs1.anadir(c2);
        //assert
        assertEquals(2,cs1.getCliente("00000000B").getIdentificador());
    }

}
