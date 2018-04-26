/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dominio.vehiculo;

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
public class VehiculoTest
{

    @Test
    public void testCompruebaMatriculaCorrecta()
    {
        //arrange
        String matricula;

        //act
        matricula = "0000CCC";

        //assert
        assertTrue(Vehiculo.compruebaMatricula(matricula));
    }

    @Test
    public void testCompruebaMatriculaIncorrecta()
    {
        //arrange
        String matricula;

        //act
        matricula = "0000CcC";

        //assert
        assertFalse(Vehiculo.compruebaMatricula(matricula));
    }

    @Test
    public void testCompruebaMatriculaNull()
    {
        //arrange
        String matricula;

        //act
        matricula = null;

        //assert
        assertFalse(Vehiculo.compruebaMatricula(matricula));
    }

    @Test
    public void testCadenaLlenaConTexto()
    {
        //arrange
        String stringLlena;

        //act
        stringLlena = "Llena";

        //assert
        assertTrue(Vehiculo.cadenaLlena(stringLlena));
    }

    @Test
    public void testCadenaLlenaSinTexto()
    {
        //arrange
        String stringVacia;

        //act
        stringVacia = "";

        //assert
        assertFalse(Vehiculo.cadenaLlena(stringVacia));
    }

    @Test
    public void testCadenaLlenaNula()
    {
        //arrange
        String stringNula;

        //act
        stringNula = null;

        //assert
        assertFalse(Vehiculo.cadenaLlena(stringNula));
    }

}
