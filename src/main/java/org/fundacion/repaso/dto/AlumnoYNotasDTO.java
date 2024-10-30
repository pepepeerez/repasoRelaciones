package org.fundacion.repaso.dto;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.model.Nota;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AlumnoYNotasDTO {

    private String nombreAlumno;
    private List<NotaDTO> notas;

    public AlumnoYNotasDTO(Alumno al, Asignatura as) {
       this.nombreAlumno = al.getAlumnoName();
       this.notas = toNotasDTO(al, as);
    }
    
    public List<NotaDTO> toNotasDTO(Alumno al, Asignatura as) {
        List<NotaDTO> notasCalificadas = new ArrayList<NotaDTO>();
        for (Nota s : al.getNotas()) {
           if(s.getAsignaturaCalificada().getAsignaturaId().equals(as.getAsignaturaId())) {
               notasCalificadas.add(new NotaDTO(s));
           }
        }
        return notasCalificadas;
    }
    
}
