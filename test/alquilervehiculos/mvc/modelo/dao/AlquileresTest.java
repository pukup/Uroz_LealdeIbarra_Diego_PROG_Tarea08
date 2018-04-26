/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dao.Alquileres;
import static alquilervehiculos.mvc.modelo.dao.ClientesTest.c1;
import static alquilervehiculos.mvc.modelo.dao.ClientesTest.cs1;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Turismo;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Pruebas de clase defectuosas.
 * @author lol
 */
public class AlquileresTest
{

    public static Alquileres as1;
    public static Cliente c1;
    public static Vehiculo v1;

    /*
    Al crear nuevos arrays no se cierran los alquileres previamente almacenados
    por tanto no cambia la disponibilidad de los vehículos.
     */
    @BeforeClass
    public static void setUpBeforeClass()
    {
        c1 = new Cliente("a", "00000000A", "a", "a", "00000");
        v1 = new Turismo("0000XXX", "a", "a", 1, 1, 1);
        as1 = new Alquileres();
    }

    @Before
    public void setUp()
    {
    }

//    @Test
//    public void testAbrir()
//    {
//        //arrange
//        //act
//        as1.abrir(c1, v1);
//        //assert
//        assertEquals(0, as1.posicionAlquiler("0000XXX"));
//    }
//
//    @Test
//    public void testCerrar()
//    {
//        //arrange
//        //act
//        as1.cerrar("0000XXX");
//        //assert
//        assertEquals(0, as1.posicionAlquiler("0000XXX"));
//    }
//
//    @Test
//    public void testCerrarCerrado()
//    {
//        //arrange
//        //act
//        as1 = new Alquileres();
//        try
//        {
//            as1.cerrar("0000XXX");
//            fail("Excepción no lanzada.");
//        } catch (ExcepcionAlquilerVehiculos e)
//        {
//            System.out.println(e);
//        }
//        //assert
//    }

//    @Test
//    public void testAbrirCocheUsado()
//    {
//        //arrange
//        //act
//        try
//        {
//            as1.abrir(c1, v1);
//            fail("Excepción no lanzada.");
//        } catch (ExcepcionAlquilerVehiculos e)
//        {
//        }
//        //assert
//    }
//    @Test
//    public void testLeerEscribir()
//    {
//        //arrange  
//        //act        
//        as1.abrir(c1,v1);
//        as1.escribirFicheroObjetos();
//        as1 = new Alquileres();
//        as1.leerObjetosDeFichero();
//        as1.cerrar("0000XXX");
//        //assert
//    }
}
