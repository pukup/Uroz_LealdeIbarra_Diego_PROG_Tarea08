/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.modelo;

import alquilervehiculos.mvc.modelo.dominio.Alquiler;
import alquilervehiculos.mvc.modelo.dominio.Cliente;
import alquilervehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author lol
 */
public interface IModeloAlquilerVehiculos
{

    Alquiler[] obtenerAlquileres();

    Cliente[] obtenerClientes();

    Vehiculo[] obtenerVehiculos();

    void abrirAlquiler(Cliente cliente, Vehiculo vehiculo);

    void cerrarAlquiler(String matricula);

    void anadirCliente(Cliente cliente);

    void borrarCliente(String dni);

    void anadirVehiculo(Vehiculo vehiculo);

    void borrarVehiculo(String matricula);

    Cliente buscarCliente(String dni);

    Vehiculo buscarVehiculo(String matricula);

    void leerClientes();

    void escribirClientes();

    void leerVehiculos();

    void escribirVehiculos();

    void leerAlquileres();

    void escribirAlquileres();
}
