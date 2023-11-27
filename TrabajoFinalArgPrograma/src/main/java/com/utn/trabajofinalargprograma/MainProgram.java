package com.utn.trabajofinalargprograma;

import controlador.GestorCliente;

import java.util.Scanner;

import controlador.GestorEmpleado;
import modelo.Cliente;
import modelo.Empleado;
import vista.ClienteVista;
import vista.EmpleadoVista;

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean stateAppClient = true;
        Boolean stateAppGeneral = true;
        Boolean stateAppTechnical = true;

        try {
            menu_general:
            while (stateAppGeneral) {
                System.out.println("Seleccione una opción: \n1- Cliente. \n2- Empleado. \n3- Técnico.\n4- Servicio.\n5- Salir.");
                int infoSelect = new Scanner(System.in).nextInt();
                switch (infoSelect) {
                    case 1:
                        menu_client:
                        while (stateAppClient) {
                            GestorCliente gCliente = new GestorCliente();

                            System.out.println("Ingrese el CUIT para identificar al Cliente: ");
                            Long cuit = new Scanner(System.in).nextLong();

                            Cliente cliente = gCliente.getClienteXCUIT(cuit);

                            ClienteVista vistaCliente = new ClienteVista();

                            if (cliente == null) {
                                System.out.println("El cliente solicitado NO EXISTE. \nProceda a cargar uno nuevo: ");
                                cliente = vistaCliente.cargarClienteNuevo();
                                gCliente.guardar(cliente);
                                continue menu_client;
                            } else {
                                System.out.println("Bienvenido: " + cliente.getRazonSocial() + "\nEsta es sú información cargada: \n" + "- Razón Social: " + cliente.getRazonSocial() + ".\n- CUIT: " + cliente.getCuit() + ".\n- Email: " + cliente.getDatosContacto().getEmail() + ".\n- Celular: " + cliente.getDatosContacto().getCelular() + ".\n");
                                System.out.println("Para modificar ingrese \"U\".\nSi desea eliminar ingrese \"D\".\nSi desea volver al menu presione \"V\".\nSi desea salir presione \"E\"");
                                String accion = new Scanner(System.in).nextLine();
                                if (accion.toUpperCase().equals("U")) {
                                    cliente = vistaCliente.modificarCliente(cliente);
                                    gCliente.guardar(cliente);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionUpdate = new Scanner(System.in).nextLine();
                                    if (accionUpdate.toUpperCase().equals("V")) {
                                        continue menu_client;
                                    } else if (accionUpdate.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + cliente.getRazonSocial() + "!");
                                        break menu_client;
                                    }
                                } else if (accion.toUpperCase().equals("D")) {
                                    gCliente.eliminar(cliente);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionDelete = new Scanner(System.in).nextLine();
                                    if (accionDelete.toUpperCase().equals("V")) {
                                        continue menu_client;
                                    } else if (accionDelete.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + cliente.getRazonSocial() + "!");
                                        break menu_general;
                                    }
                                } else if (accion.toUpperCase().equals("E")) {
                                    break menu_general;
                                } else if (accion.toUpperCase().equals("V")) {
                                    continue menu_general;
                                }
                            }
                        }
                    case 2:
                        menu_empleado:
                        while (stateAppTechnical) {
                            GestorEmpleado gEmpleado = new GestorEmpleado();

                            System.out.println("Ingrese el Legajo para identificar al Empleado: ");
                            Long legajo = new Scanner(System.in).nextLong();

                            Empleado empleado = gEmpleado.getEmpleadoXLegajo(legajo);

                            EmpleadoVista empleadoVista = new EmpleadoVista();
                            if (empleado == null) {
                                System.out.println("El Empleado solicitado NO EXISTE. \nProceda a cargar uno nuevo: ");
                                empleado = empleadoVista.cargarEmpleadoNuevo();
                                gEmpleado.guardar(empleado);
                                continue menu_empleado;
                            } else {
                                System.out.println("Bienvenido: " + empleado.getApellido() + "\nEsta es sú información cargada: \n" + "- Apellido y Nombre: " + empleado.getApellido() + ", " + empleado.getNombre() + ".\n- Legajo: " + empleado.getLegajo() + ".\n- Email: " + empleado.getDatosContacto().getEmail() + ".\n- Celular: " + empleado.getDatosContacto().getCelular() + ".\n");
                                System.out.println("Para modificar ingrese \"U\".\nSi desea eliminar ingrese \"D\".\nSi desea volver al menu presione \"V\".\nSi desea salir presione \"E\"");
                                String accionEmpleado = new Scanner(System.in).nextLine();
                                if (accionEmpleado.toUpperCase().equals("U")) {
                                    empleado = empleadoVista.modificarEmpleado(empleado);
                                    gEmpleado.guardar(empleado);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionUpdate = new Scanner(System.in).nextLine();
                                    if (accionUpdate.toUpperCase().equals("V")) {
                                        continue menu_empleado;
                                    } else if (accionUpdate.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + empleado.getApellido() + "!");
                                        break menu_empleado;
                                    }
                                } else if (accionEmpleado.toUpperCase().equals("D")) {
                                    gEmpleado.eliminar(empleado);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionDelete = new Scanner(System.in).nextLine();
                                    if (accionDelete.toUpperCase().equals("V")) {
                                        continue menu_empleado;
                                    } else if (accionDelete.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + empleado.getApellido() + "!");
                                        break menu_general;
                                    }
                                } else if (accionEmpleado.toUpperCase().equals("E")) {
                                    break menu_general;
                                } else if (accionEmpleado.toUpperCase().equals("V")) {
                                    continue menu_general;
                                }
                            }
                        }
                    case 3:
                        continue;
                    case 4:
                        continue;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Opción NO VALIDA!.");
                        continue menu_general;
                }

            }
            //System.out.println("BASE DE DATOS GENERADA");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}