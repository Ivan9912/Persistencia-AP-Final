/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import persistencia.ConfigHibernate;

public class GestorCliente extends Gestor {

    public GestorCliente() {
        sesion = ConfigHibernate.openSession();
    }
};