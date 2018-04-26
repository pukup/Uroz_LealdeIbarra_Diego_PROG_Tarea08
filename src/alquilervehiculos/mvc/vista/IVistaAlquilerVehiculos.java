/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.mvc.vista;

import alquilervehiculos.mvc.controlador.ControladorAlquilerVehiculos;

/**
 *
 * @author lol
 */
public interface IVistaAlquilerVehiculos
{

    void abrirAlquiler();

    void anadirCliente();

    void anadirVehiculo();

    void borrarCliente();

    void borrarVehiculo();

    void buscarCliente();

    void buscarVehiculo();

    void cerrarAlquiler();

    void comenzar();

    void listarAlquileres();

    void listarAlquileresAbiertos();

    void listarAlquileresCliente();

    void listarAlquileresVehiculo();

    void listarClientes();

    void listarVehiculos();

    void salir();

    void setControlador(ControladorAlquilerVehiculos controlador);

}
