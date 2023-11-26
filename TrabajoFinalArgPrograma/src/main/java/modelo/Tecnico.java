/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "arg_prog_tecnico")
@Getter @Setter
public class Tecnico extends Empleado{
    
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReporteIncidencia> reportesIncidencia;//1 a N
    
    @ManyToMany(fetch=FetchType.LAZY,
    targetEntity=Especialidad.class,
    cascade=CascadeType.ALL)
    @JoinTable(
    name="arg_prog_tecnico_especialidad", 
            joinColumns=@JoinColumn(name="idtecnico"),
            inverseJoinColumns=@JoinColumn(name="idespecialidad")
    )
    private List<Especialidad> especialidades;// N a N
    
    
    
    
}
