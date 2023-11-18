/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.utn.trabajofinalargprograma;

import controlador.GestorCliente;
import modelo.Cliente;

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // T ODO code application logic here
        Cliente cliente = new Cliente();
        GestorCliente gCliente = new GestorCliente();

        System.out.println("BASE DE DATOS GENERADA");
        System.out.println(cliente);
        System.out.println(gCliente);
    }
};