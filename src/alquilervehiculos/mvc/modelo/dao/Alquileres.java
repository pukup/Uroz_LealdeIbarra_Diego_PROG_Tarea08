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
public class Alquileres
{

    private final int MAX_ALQUILERES = 20;
    private Alquiler[] alquileres;
    private final String PATH_FICHERO = "datos/alquileres.dat";

    public Alquileres()
    {
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Alquiler[] getAlquileres()
    {
        return alquileres.clone();
    }

    public void abrir(Cliente cliente, Vehiculo vehiculo)
    {
        if (alquileres[posicionLibre()] == null && vehiculo.getDisponible())
        {
            alquileres[posicionLibre()] = new Alquiler(cliente, vehiculo);
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Espacio agotado o vehículo no disponible.");
        }
    }

    private int posicionLibre()
    {
        int i = 0;
        while (alquileres[i] != null && i < alquileres.length - 1)
        {
            i++;
        }
        return i;
    }

    public void cerrar(String matricula)
    {
        if (alquilerEncontrado(matricula) && alquileres[posicionAlquiler(matricula)].getAlquilerAbierto())
        {
            alquileres[posicionAlquiler(matricula)].close();
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Alquiler no encontrado o cerrado.");
        }
    }

    private boolean alquilerEncontrado(String matricula)
    {
        return alquileres[posicionAlquiler(matricula)] != null
                && alquileres[posicionAlquiler(matricula)].getVehiculo().getMatricula().equals(matricula);
    }

    public int posicionAlquiler(String matricula)
    {
        int i = 0;
        while (alquileres[i] != null
                && !alquileres[i].getVehiculo().getMatricula().equals(matricula)
                && i < alquileres.length - 1)
        {
            i++;
        }
        return i;
    }

    public void escribirFicheroObjetos()
    {
        try
        {
            FileOutputStream ficheroFLujoSalida = new FileOutputStream(crearNevoFichero());
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(ficheroFLujoSalida);
            flujoSalidaObjetos.writeObject((Alquiler[]) alquileres);
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
                alquileres = (Alquiler[]) FlujoEntradaObjetos.readObject();
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
