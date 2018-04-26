/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
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
import java.util.List;
import java.util.Vector;

/**
 *
 * @author lol
 */
public class Alquileres
{

    private List<Alquiler> alquileres;
    private final String PATH_FICHERO = "datos/alquileres.dat";

    public Alquileres()
    {
        alquileres = new Vector<Alquiler>();
    }

    public void abrir(Cliente cliente, Vehiculo vehiculo)
    {
        if (vehiculo.getDisponible())
        {
            alquileres.add(new Alquiler(cliente, vehiculo));
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Vehículo no disponible.");
        }
    }

    public void cerrar(String matricula)
    {
        if (alquilerEncontrado(matricula) && alquileres.get(posicionAlquiler(matricula)).getAlquilerAbierto())
        {
            alquileres.get(posicionAlquiler(matricula)).close();
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Alquiler no encontrado o cerrado.");
        }
    }

    private boolean alquilerEncontrado(String matricula)
    {
        return alquileres.get(posicionAlquiler(matricula)).getVehiculo().getMatricula().equals(matricula);
    }

    public int posicionAlquiler(String matricula)
    {
        int i = 0;
        while (!alquileres.get(i).getVehiculo().getMatricula().equals(matricula)
                && i < alquileres.size() - 1)
        {
            i++;
        }
        return i;
    }

    public List<Alquiler> getAlquileres()
    {
        return new Vector<Alquiler>(alquileres);
    }

    public List<Alquiler> getAbiertos()
    {
        int i = 0;
        List<Alquiler> abiertos = new Vector<Alquiler>();
        while (i < alquileres.size())
        {
            if (alquileres.get(i).getAlquilerAbierto())
            {
                abiertos.add(alquileres.get(i));
            }
            i++;
        }
        return abiertos;
    }

    public List<Alquiler> getAlquileresCliente(String dni)
    {
        int i = 0;
        List<Alquiler> alquileresCliente = new Vector<Alquiler>();

        while (i < alquileres.size())
        {
            if (alquileres.get(i).getCliente().getDni().equals(dni))
            {
                alquileresCliente.add(alquileres.get(i));
            }
            i++;
        }
        return alquileresCliente;
    }

    public List<Alquiler> getAlquileresVehiculo(String matricula)
    {
        int i = 0;
        List<Alquiler> alquileresVehiculo = new Vector<Alquiler>();

        while (i < alquileres.size())
        {
            if (alquileres.get(i).getVehiculo().getMatricula().equals(matricula))
            {
                alquileresVehiculo.add(alquileres.get(i));
            }
            i++;
        }
        return alquileresVehiculo;
    }

    public void escribirFicheroObjetos()
    {
        try
        {
            FileOutputStream ficheroFLujoSalida = new FileOutputStream(crearNevoFichero());
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(ficheroFLujoSalida);
            for (Alquiler alquiler : alquileres)
            {
                flujoSalidaObjetos.writeObject(alquiler);
            }
            flujoSalidaObjetos.close();
            //System.out.println("Fichero alquileres escrito.");
        } catch (FileNotFoundException e)
        {
            System.out.println("Fichero no encontrado.\n");
        } catch (IOException e)
        {
            System.out.println("Error IO.\n");
        }
    }

    private File crearNevoFichero()
    {
        File fichero = new File(PATH_FICHERO);
        return fichero;
    }

    public void leerObjetosDeFichero() //throws FileNotFoundException, EOFException, IOException, ClassNotFoundException. No lo tengo claro ¿Instead trycatch?
    {
        try
        {
            FileInputStream ficheroFlujoEntrada = new FileInputStream(crearNevoFichero());
            ObjectInputStream FlujoEntradaObjetos = new ObjectInputStream(ficheroFlujoEntrada);
            try
            {
                while (true)
                {
                    Alquiler alquiler = (Alquiler) FlujoEntradaObjetos.readObject();
                    alquileres.add(alquiler);
                }
            } catch (EOFException eo)
            {
                FlujoEntradaObjetos.close();
                System.out.println("Fichero alquileres leído.");
            } catch (ClassNotFoundException e)
            {
                System.out.println("Clase no encontrada.\n");
            } catch (IOException e)
            {
                System.out.println("Error IO.\n");
            }
        } catch (IOException e)
        {
            System.out.println("Error IO.\n");
        }
    }

}
