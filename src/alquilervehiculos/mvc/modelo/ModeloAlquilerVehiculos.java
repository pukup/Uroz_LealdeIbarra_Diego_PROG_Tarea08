/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo;

import alquilervehiculos.mvc.modelo.dao.Alquileres;
import alquilervehiculos.mvc.modelo.dao.Clientes;
import alquilervehiculos.mvc.modelo.dao.Vehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import java.util.List;

/**
 *
 * @author lol
 */
public class ModeloAlquilerVehiculos implements IModeloAlquilerVehiculos
{

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Alquileres alquileres;

    public ModeloAlquilerVehiculos()
    {
        vehiculos = new Vehiculos();
        clientes = new Clientes();
        alquileres = new Alquileres();
    }

    @Override
    public Alquiler[] obtenerAlquileres()
    {
        return alquileres.getAlquileres();
    }

    @Override
    public List<Cliente> obtenerClientes()
    {
        return clientes.getClientes();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos()
    {
        return vehiculos.getVehiculos();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        alquileres.abrir(cliente, vehiculo);
    }

    @Override
    public void cerrarAlquiler(String matricula)
    {
        alquileres.cerrar(matricula);
    }

    @Override
    public void anadirCliente(Cliente cliente)
    {
        clientes.anadir(cliente);
    }

    @Override
    public void borrarCliente(String dni)
    {
        clientes.borrar(dni);
    }

    @Override
    public void anadirVehiculo(Vehiculo vehiculo)
    {
        vehiculos.anadir(vehiculo);
    }

    @Override
    public void borrarVehiculo(String matricula)
    {
        vehiculos.borrar(matricula);
    }

    @Override
    public Cliente buscarCliente(String dni)
    {
        return clientes.getCliente(dni);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula)
    {
        return vehiculos.getVehiculo(matricula);
    }

    @Override
    public void leerClientes()
    {
        clientes.leerObjetosDeFichero();
    }

    @Override
    public void escribirClientes()
    {
        clientes.escribirFicheroObjetos();
    }

    @Override
    public void leerVehiculos()
    {
        vehiculos.leerFicheroObjetos();
    }

    @Override
    public void escribirVehiculos()
    {
        vehiculos.escribirFicheroObjetos();
    }

    @Override
    public void leerAlquileres()
    {
        alquileres.leerObjetosDeFichero();
    }

    @Override
    public void escribirAlquileres()
    {
        alquileres.escribirFicheroObjetos();
    }

}
