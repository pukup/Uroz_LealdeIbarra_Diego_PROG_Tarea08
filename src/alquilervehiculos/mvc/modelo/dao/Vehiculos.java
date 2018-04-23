/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author lol
 */
public class Vehiculos
{

    public Vehiculo[] vehiculos;
    private static final int MAX_VEHICULOS = 20;
    private static final String PATH_FICHERO = "datos/vehiculos.dat";

    public Vehiculos()
    {
        vehiculos = new Vehiculo[MAX_VEHICULOS];
    }

    public Vehiculo[] getVehiculos()
    {
        return vehiculos.clone();
    }

    public void anadir(Vehiculo vehiculo)
    {
        if (vehiculos[posicionLibre()] == null)
        {
            vehiculos[posicionLibre()] = vehiculo;
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Array vehiculos lleno.\n");
        }

    }

    private int posicionLibre()
    {
        int i = 0;
        while (vehiculos[i] != null && indiceMenorTamañoArray(i))
        {
            i++;
        }
        return i;
    }

    private boolean indiceMenorTamañoArray(int i)
    {
        return i < vehiculos.length - 1;
    }

    public void borrar(String matricula)
    {
        if (vehiculoEncontrado(matricula))
        {
            desplazarIzquierda(posicionVehiculo(matricula));
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Vehiculo inexsistente.\n");
        }
    }

    private boolean vehiculoEncontrado(String matricula)
    {
        return vehiculos[posicionVehiculo(matricula)] != null
                && vehiculos[posicionVehiculo(matricula)].getMatricula().equals(matricula);
    }

    private void desplazarIzquierda(int posicion)
    {
        for (int i = posicion; indiceMenorTamañoArray(i) && vehiculos[i] != null; i++)
        {
            vehiculos[i] = vehiculos[i + 1];
        }
    }

    private int posicionVehiculo(String matricula)
    {
        int i = 0;
        while (vehiculos[i] != null
                && !vehiculos[i].getMatricula().equals(matricula)
                && indiceMenorTamañoArray(i))
        {
            i++;
        }
        return i;
    }

    public Vehiculo getVehiculo(String matricula)
    {
        if (vehiculoEncontrado(matricula))
        {
            return vehiculos[posicionVehiculo(matricula)];
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Vehiculo no encontrado.\n");
        }
    }

    public void escribirFicheroObjetos()
    {
        try
        {
            FileOutputStream ficheroFlujoSalida = new FileOutputStream(nuevoFichero());
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(ficheroFlujoSalida);
            flujoSalidaObjetos.writeObject((Vehiculo[]) vehiculos);
            flujoSalidaObjetos.close();
        } catch (FileNotFoundException e)
        {
            System.out.println(e);
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }

    private File nuevoFichero()
    {
        File fichero = new File(PATH_FICHERO);
        return fichero;
    }

    public void leerFicheroObjetos()
    {
        try
        {
            FileInputStream ficheroFlujoEntrada = new FileInputStream(nuevoFichero());
            ObjectInputStream FlujoEntradaObjetos = new ObjectInputStream(ficheroFlujoEntrada);
            try
            {
                vehiculos = (Vehiculo[]) FlujoEntradaObjetos.readObject();
                FlujoEntradaObjetos.close();
                //System.out.println("Fichero clientes leído.");
            } catch (ClassNotFoundException e)
            {
                System.out.println(e);
            } catch (IOException e)
            {
                System.out.println(e);
            }
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
