/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author dapelle
 */
public class Alumno {
    private int numeroExpediente;
    private String nombre;
    private int edad;
    private Collection<Asignatura> matricula;

    public Alumno(int numeroExpediente, String nombre, int edad, Asignatura a) {
        this.numeroExpediente = numeroExpediente;
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = new ArrayList();
        this.matricula.add(a);
    }

    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Collection<Asignatura> getMatricula() {
        return matricula;
    }

    public void setMatricula(Collection<Asignatura> matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numeroExpediente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.numeroExpediente != other.numeroExpediente) {
            return false;
        }
        return true;
    }

    
  
}
