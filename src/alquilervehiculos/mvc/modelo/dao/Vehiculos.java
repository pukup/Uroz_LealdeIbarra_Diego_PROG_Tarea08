/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author lol
 */
public class Vehiculos
{

    private Map<String, Vehiculo> vehiculos;
    private static final String PATH_FICHERO = "datos/vehiculos.dat";

    public Vehiculos()
    {
        vehiculos = new HashMap<String, Vehiculo>();
    }

    public void anadir(Vehiculo vehiculo)
    {
        if (vehiculo == null || vehiculos.containsKey(vehiculo.getMatricula()))
        {
            throw new ExcepcionAlquilerVehiculos("El vehículo ya existe");
        } else
        {
            vehiculos.put(vehiculo.getMatricula(), vehiculo);
        }
    }

    public void borrar(String matricula)
    {
        if (vehiculos.containsKey(matricula))
        {
            vehiculos.remove(matricula);
        } else
        {
            throw new ExcepcionAlquilerVehiculos("El vehículo no existe");
        }
    }

    public List<Vehiculo> getVehiculos()
    {
        return new Vector<Vehiculo>(vehiculos.values());
    }

    public Vehiculo getVehiculo(String matricula)
    {
        if (vehiculos.containsKey(matricula))
        {
            return vehiculos.get(matricula);
        } else
        {
            throw new ExcepcionAlquilerVehiculos("El vehículo no existe");
        }
    }

    public void escribirFicheroObjetos()
    {
        try
        {
            FileOutputStream ficheroFlujoSalida = new FileOutputStream(nuevoFichero());
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(ficheroFlujoSalida);
            for (Vehiculo vehiculo : vehiculos.values())
            {
                flujoSalidaObjetos.writeObject(vehiculo);
            }
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
                while (true)
                {
                    Vehiculo vehiculo = (Vehiculo) FlujoEntradaObjetos.readObject();
                    vehiculos.put(vehiculo.getMatricula(), vehiculo);
                }
            } catch (EOFException eo)
            {
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
