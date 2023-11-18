/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Empleado extends EntidadId {

    protected String apellido;
    protected String nombre;
    protected int legajo;
    @OneToOne
    @JoinColumn(name = "iddatoscontacto")
    protected DatosContacto datosContacto;// 1 a 1
};