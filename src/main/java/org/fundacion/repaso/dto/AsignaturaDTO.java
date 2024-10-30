package org.fundacion.repaso.dto;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignaturaDTO {
    private Long id;
    private String asignaturaName;
    private List<AlumnoYNotasDTO> alumnosMat;

    public AsignaturaDTO(Asignatura a) {
        this.id = a.getAsignaturaId();
        this.asignaturaName = a.getAsignaturaName();
        this.alumnosMat = a.getAlumnosMatriculados().stream()
                .map(al -> new AlumnoYNotasDTO(al, a)).toList();
    }
}
  
