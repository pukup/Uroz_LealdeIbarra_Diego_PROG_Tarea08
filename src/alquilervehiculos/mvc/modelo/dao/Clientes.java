/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo.dao;

import java.io.EOFException;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
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
public class Clientes
{

    private final int MAX_CLIENTES = 20;
    private Cliente[] clientes;
    private final String PATH_FICHERO = "datos/clientes.dat";

    public Clientes()
    {
        clientes = new Cliente[MAX_CLIENTES];
    }

    public Cliente[] getClientes()
    {
        return clientes.clone();
    }

    public void anadir(Cliente cliente)
    {
        if (clientes[posicionLibre()] == null)
        {
            clientes[posicionLibre()] = cliente;
            //System.out.println("Cliente añadido.");
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Array clientes lleno.\n");
        }
    }

    private int posicionLibre()
    {
        int i = 0;
        while (clientes[i] != null && indiceMenorTamañoArray(i))
        {
            i++;
        }
        return i;
    }

    public void borrar(String dni)
    {
        if (clienteEncontrado(dni))
        {
            desplazarIzquierda(posicionCliente(dni));
            //System.out.println("Cliente eliminado.");
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Cliente inexistente.\n");
        }
    }

    private boolean clienteEncontrado(String dni)
    {
        return clientes[posicionCliente(dni)] != null && clientes[posicionCliente(dni)].getDni().equals(dni);
    }

    private int posicionCliente(String dni)
    {
        int i = 0;
        while (clientes[i] != null
                && !clientes[i].getDni().equals(dni)
                && indiceMenorTamañoArray(i))
        {
            i++;
        }
        return i;
    }

    private boolean indiceMenorTamañoArray(int i)
    {
        return i < clientes.length - 1;
    }

    private void desplazarIzquierda(int posicion)
    {
        for (int i = posicion; indiceMenorTamañoArray(i) && clientes[i] != null; i++)
        {
            clientes[i] = clientes[i + 1];
        }
    }

    public Cliente getCliente(String dni)
    {
        if (clienteEncontrado(dni))
        {
            return clientes[posicionCliente(dni)];
        } else
        {
            throw new ExcepcionAlquilerVehiculos("Cliente no encontrado.\n");
        }
    }
    
    

    public void escribirFicheroObjetos()
    {
        try
        {
            FileOutputStream ficheroFLujoSalida = new FileOutputStream(crearNevoFichero());
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(ficheroFLujoSalida);
            flujoSalidaObjetos.writeObject((Cliente[]) clientes);
            flujoSalidaObjetos.close();
            //System.out.println("Fichero clientes escrito.");
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
                clientes = (Cliente[]) FlujoEntradaObjetos.readObject();
                FlujoEntradaObjetos.close();
                System.out.println("Fichero clientes leído.");
                actualizarUltimoIdentificador();
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

    private void actualizarUltimoIdentificador()
    {
        while (Cliente.ultimoIdentificador != getUltimoIdentificadorEnFichero())
        {
            Cliente.aumentarUltimoIdentificador();
        }
    }

    private int getUltimoIdentificadorEnFichero()
    {
        int ultimoIdentificador = 0;
        int i = 0;
        while (clientes[i] != null)
        {
            if (clientes[i].getIdentificador() > ultimoIdentificador)
            {
                ultimoIdentificador = clientes[i].getIdentificador();
            }
            i++;
        }
        return ultimoIdentificador;
    }

}
