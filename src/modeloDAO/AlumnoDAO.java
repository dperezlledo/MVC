/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.util.*;
import modelo.*;

/**
 *
 * @author dapelle
 */
public class AlumnoDAO {

    private LinkedHashSet<Alumno> listaAlumnos;

    public AlumnoDAO() {
        listaAlumnos = new LinkedHashSet();
    }

    // Objecto CRUD (Crear, Obtener, actualizar y borrar)
    public Alumno buscar(Alumno alumno) {

        if (listaAlumnos.contains(alumno)) {
            // Buscamos el alumno en la coleccion
            for (Iterator<Alumno> it = listaAlumnos.iterator(); it.hasNext();) {
                Alumno alumno1 = it.next();
                if (alumno1.equals(alumno)) {
                    return alumno1;
                }
            }
        } 
        return null;
        
    }

    public Alumno añadir(Alumno alumno) {
        // Comprobamos si ya existe
        if (!listaAlumnos.contains(alumno)) {
            listaAlumnos.add(alumno);
            return alumno;
        } else {
            return null;
        }
    }

    public Alumno eliminar(Alumno alumno) {
        // Comprobamos que existe para poder eliminarlo
        if (listaAlumnos.contains(alumno)) {
            listaAlumnos.remove(alumno);
            return alumno;
        } else {
            return null; // No existe
        }
    }

    public Alumno modificar(Alumno alumno) {
        // Implica primero busqueda y luego modificación
        Alumno aux = this.buscar(alumno);

        if (aux != null) { // Si existe alumno
            listaAlumnos.remove(aux); // Borramos el que tenemos en la lista actualmente
            listaAlumnos.add(alumno); // Insertamos el nuevo
            return alumno;
        } else {
            return null;
        }
    }

}
