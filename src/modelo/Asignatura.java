/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author dapelle
 */
public class Asignatura {
    private int codigo;
    private String nombre;
    private int numeroDeCreditos;

    public Asignatura(int codigo, String nombre, int numeroDeCreditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroDeCreditos = numeroDeCreditos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeCreditos() {
        return numeroDeCreditos;
    }

    public void setNumeroDeCreditos(int numeroDeCreditos) {
        this.numeroDeCreditos = numeroDeCreditos;
    }

    @Override
    public String toString() {
        return this.getCodigo() + " " + this.getNombre() + " " + this.getNumeroDeCreditos() + "\n";
    }
    
   
    
}
