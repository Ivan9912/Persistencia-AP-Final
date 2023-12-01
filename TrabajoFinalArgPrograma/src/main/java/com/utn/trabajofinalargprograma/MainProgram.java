package com.utn.trabajofinalargprograma;

import controlador.GestorCliente;

import java.util.Scanner;

//import controlador.GestorEspecialidad;
import controlador.GestorEspecialidad;
import controlador.GestorTecnico;
import modelo.Cliente;
import modelo.Tecnico;
import vista.ClienteVista;
import vista.EspecialidadVista;
import vista.TecnicoVista;

public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean stateAppClient = true;
        Boolean stateAppGeneral = true;
        Boolean stateAppTechnical = true;

        try {
            GestorEspecialidad addEspecialidad = new GestorEspecialidad();
            if (addEspecialidad.getEscialidadesList() == 0) {
                addEspecialidad.addEspecialidades();
            }

            menu_general:
            while (stateAppGeneral) {
                System.out.println("Seleccione una opción para administrar: \n1- Clientes. \n2- Técnicos. \n3- Especialidades.\n4- Operadores.\n5- Servicios.\n6- Reporte de Incidencias.\n7- Reporte de Incidencias hecho por técnicos en el día.\n8- Reporte de Incidencias resueltos y desde que especialidad.\n9- Estadistica técnico más eficiente en resolucion de Incidentes reportados.\n0- Salir.");
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
                        menu_technical:
                        while (stateAppTechnical) {
                            GestorTecnico gTecnico = new GestorTecnico();

                            System.out.println("Ingrese el Legajo para identificar al Técnico: ");
                            Long legajo = new Scanner(System.in).nextLong();

                            Tecnico tecnico = gTecnico.getTecnicoXLegajo(legajo);

                            TecnicoVista tecnicoVista = new TecnicoVista();
                            if (tecnico == null) {
                                System.out.println("El Legajo solicitado NO EXISTE. \nProceda a cargar los datos: ");
                                Tecnico tec = new Tecnico();
                                tecnico = tecnicoVista.cargarTecnicoNuevo(tec, legajo); //ACAAAAA
                                EspecialidadVista vistaEspecialidad = new EspecialidadVista();
                                vistaEspecialidad.cargarNuevaEspecialidadTecnico(tecnico, gTecnico.getSesion());

                                gTecnico.guardar(tecnico);
                                continue menu_technical;
                            } else {
                                System.out.println("Bienvenido: " + tecnico.getApellido() + "\nEsta es sú información cargada: \n" + "- Legajo: " + tecnico.getLegajo() + ".\n" + "- Apellido y Nombre: " + tecnico.getApellido() + ", " + tecnico.getNombre() +  ".\n- Email: " + tecnico.getDatosContacto().getEmail() + ".\n- Celular: " + tecnico.getDatosContacto().getCelular() + ".\n");
                                System.out.println("Para modificar ingrese \"U\".\nSi desea eliminar ingrese \"D\".\nSi desea volver al menu presione \"V\".\nSi desea salir presione \"E\"");
                                String accionEmpleado = new Scanner(System.in).nextLine();
                                if (accionEmpleado.toUpperCase().equals("U")) {
                                    Tecnico tec = new Tecnico();
                                    tecnico = tecnicoVista.modificarTecnico(tec, legajo);  //ACAAA
                                    gTecnico.guardar(tecnico);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionUpdate = new Scanner(System.in).nextLine();
                                    if (accionUpdate.toUpperCase().equals("V")) {
                                        continue menu_technical;
                                    } else if (accionUpdate.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + tecnico.getApellido() + "!");
                                        break menu_technical;
                                    }
                                } else if (accionEmpleado.toUpperCase().equals("D")) {
                                    gTecnico.eliminar(tecnico);
                                    System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                                    String accionDelete = new Scanner(System.in).nextLine();
                                    if (accionDelete.toUpperCase().equals("V")) {
                                        continue menu_technical;
                                    } else if (accionDelete.toUpperCase().equals("E")) {
                                        System.out.println("Hasta Pronto " + tecnico.getApellido() + "!");
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
                        GestorEspecialidad gEspecialidad = new GestorEspecialidad();
                        gEspecialidad.getEscialidadesList();
                        System.out.println("Para Volver al menú ingrese \"V\". \nSi desea salir definitivamente ingrese \"E\".\n");
                        String accionEspecialidad = new Scanner(System.in).nextLine();
                        if (accionEspecialidad.toUpperCase().equals("V")) {
                            continue menu_general;
                        } else if (accionEspecialidad.toUpperCase().equals("E")) {
                            System.out.println("Hasta Pronto!");
                            break menu_general;
                        }

                    case 4:
                        continue menu_general;
                    case 5:
                        continue menu_general;
                    case 6:
                        continue menu_general;
                    case 7:
                        continue menu_general;
                    case 8:
                        continue menu_general;
                    case 9:
                        continue menu_general;
                    case 0:
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