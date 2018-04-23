/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.controlador;

import alquilervehiculos.mvc.modelo.IModeloAlquilerVehiculos;
import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;
import alquilervehiculos.mvc.vista.IVistaAlquilerVehiculos;

/**
 *
 * @author lol
 */
public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos
{

    private IModeloAlquilerVehiculos modelo;
    private IVistaAlquilerVehiculos vista;

    public ControladorAlquilerVehiculos(IModeloAlquilerVehiculos modelo, IVistaAlquilerVehiculos vista)
    {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
    }

    @Override
    public void comenzar()
    {
        modelo.leerClientes();
        modelo.leerVehiculos();
        modelo.leerAlquileres();
        vista.comenzar();
    }

    @Override
    public void salir()
    {
        modelo.escribirClientes();
        modelo.escribirVehiculos();
        modelo.escribirAlquileres();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Vehiculo turismo)
    {
        modelo.abrirAlquiler(cliente, turismo);
    }

    @Override
    public void anadirCliente(Cliente cliente)
    {
        modelo.anadirCliente(cliente);
    }

    @Override
    public void anadirVehiculo(Vehiculo turismo)
    {
        modelo.anadirVehiculo(turismo);
    }

    @Override
    public void cerrarAlquiler(String matricula)
    {
        modelo.cerrarAlquiler(matricula);
    }

    @Override
    public void borrarCliente(String dni)
    {
        modelo.borrarCliente(dni);
    }

    @Override
    public void borrarVehiculo(String matricula)
    {
        modelo.borrarVehiculo(matricula);
    }

    @Override
    public Cliente buscarCliente(String dni)
    {
        return modelo.buscarCliente(dni);
    }

    @Override
    public Vehiculo buscarVehiculo(String matricula)
    {
        return modelo.buscarVehiculo(matricula);
    }

    @Override
    public Alquiler[] obtenerAlquileres()
    {
        return modelo.obtenerAlquileres();
    }

    @Override
    public Cliente[] obtenerClientes()
    {
        return modelo.obtenerClientes();
    }

    @Override
    public Vehiculo[] obtenerVehiculos()
    {
        return modelo.obtenerVehiculos();
    }

}
