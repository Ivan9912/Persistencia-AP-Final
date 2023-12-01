/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "arg_prog_especialidad")
@Getter @Setter
public class Especialidad  extends EntidadId{
    
    @Column(length = 175, nullable = false)
    private String denominacion;

    @ManyToMany(mappedBy = "especialidades")
    private List<Tecnico> tecnicos;//N a N

}