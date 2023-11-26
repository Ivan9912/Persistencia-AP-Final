package com.utn.trabajofinalargprograma;

import controlador.GestorCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import modelo.Cliente;
import vista.ClienteVista;

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        try {
            //obtenerConexion();
            GestorCliente gCliente = new GestorCliente();
            
            System.out.println("Ingrese el CUIT para identificar al Cliente: ");
            Long cuit = new Scanner(System.in).nextLong();
            
            Cliente cliente = gCliente.getClienteXCUIT(cuit);
            
            ClienteVista vistaCliente = new ClienteVista();        
            
            if(cliente == null){
                System.out.println("El cliente solicitado NO EXISTE. \nProceda a cargar uno nuevo: ");
                cliente = vistaCliente.cargarClienteNuevo();
                gCliente.guardar(cliente);
            }else{
                System.out.println("Bienvenido: " + cliente.getRazonSocial() + "\nEsta es sú información cargada: \n" + "- Razón Social: " + cliente.getRazonSocial() + ".\n- CUIT: " + cliente.getCuit() + ".\n");
                System.out.println("Para modificar ingrese \"U/u\". \nSi desea eliminar ingrese \"D/d\"\nSi desea salir presione \"E/e\"");
                String accion = new Scanner(System.in).nextLine();
                if(accion.toUpperCase().equals("u") || accion.toUpperCase().equals("U")){
                    cliente = vistaCliente.modificarCliente(cliente);
                    gCliente.guardar(cliente);
                }else if(accion.toUpperCase().equals("d") || accion.toUpperCase().equals("D")){
                    gCliente.eliminar(cliente);
                }else if (accion.toUpperCase().equals("e") || accion.toUpperCase().equals("E")){
                    System.exit(0);
                }
            }
            

            //System.out.println("BASE DE DATOS GENERADA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void obtenerConexion() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");//mysql 5
            Class.forName("com.mysql.cj.jdbc.Driver");//mysql 8
            //jdbc:mysql://localhost:3306/database //mysql 5
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/argentina_programa?useTimezone=true&serverTimezone=UTC", "root", "123456");
            if(con != null){
                System.out.println("CONECTADO");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
