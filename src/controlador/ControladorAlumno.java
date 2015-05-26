/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import modeloDAO.AlumnoDAO;
import modelo.*;
import vista.*;

/**
 *
 * @author dapelle
 */
// El controlador es el responsable de independizar el MODELO de la VISTA
// Añadimos el modelo con el cual vamos a interactuar y las vista/s que modificaremos
public class ControladorAlumno implements ActionListener {

    private JFrameAlumno vista;
    private AlumnoDAO modelo;

    public ControladorAlumno(JFrameAlumno vista, AlumnoDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        // Añadimos el oyente a los botones CRUD
        this.vista.getjButtonAñadir().addActionListener(this);
        this.vista.getjButtonEliminar().addActionListener(this);
        this.vista.getjButtonModificar().addActionListener(this);
        this.vista.getjButtonBuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nexp, edad;
        String nombre;
        Asignatura asignatura;
        Alumno alumno;

        // Si se pulsa el boton BUSCAR
        if (e.getSource() == vista.getjButtonBuscar()) {
            // Nos creamos un alumno con numero expediente introducido por el usuario
            alumno = new Alumno(Integer.parseInt(vista.getjTextFieldNumeroExpediente().getText()), null, 0, null);
            alumno = modelo.buscar(alumno);

            // Actualizamos la vista según exista o no el alumno
            if (alumno == null) { // No existe
                this.vista.getjLabelTitulo().setText("El alumno no ha sido encontrado");
                this.vista.getjTextFieldNumeroExpediente().setText("");
                this.vista.getjTextFieldNombre().setText("");
                this.vista.getjTextFieldEdad().setText("");
                this.vista.getjTextAreaAsignaturas().setText("");
            } else {
                // Introducimos datos en la vista verDatos
                this.vista.getjLabelTitulo().setText("Alumno encontrado con exito");
                this.vista.getjTextFieldNumeroExpediente().setText(alumno.getNumeroExpediente() + "");
                this.vista.getjTextFieldNombre().setText(alumno.getNombre());
                this.vista.getjTextFieldEdad().setText(alumno.getEdad() + "");
                StringBuilder s = new StringBuilder();
                for (Iterator<Asignatura> it = alumno.getMatricula().iterator(); it.hasNext();) {
                    s.append((Asignatura) it.next());
                }
                this.vista.getjTextAreaAsignaturas().setText(s.toString());
            }
        } else if (e.getSource() == vista.getjButtonAñadir()) {
            // Añadir alumnos
            nexp = Integer.parseInt(vista.getjTextFieldNumeroExpediente().getText());
            nombre = vista.getjTextFieldNombre().getText();
            edad = Integer.parseInt(vista.getjTextFieldEdad().getText());
            asignatura = new Asignatura(1, "ASIG", 5);
            alumno = new Alumno(nexp, nombre, edad, asignatura);
            if (modelo.añadir(alumno)!=null) 
                this.vista.getjLabelTitulo().setText("Alumno añadido");

        } else if (e.getSource() == vista.getjButtonEliminar()) {
            // Eliminar alumnos
            nexp = Integer.parseInt(vista.getjTextFieldNumeroExpediente().getText());
            alumno = new Alumno(nexp, null, 0, null);
            if (modelo.eliminar(alumno)!=null)
                this.vista.getjLabelTitulo().setText("Alumno eliminado");

        } else if (e.getSource() == vista.getjButtonModificar()) {
            // Modificar alumno
            nexp = Integer.parseInt(vista.getjTextFieldNumeroExpediente().getText());
            nombre = vista.getjTextFieldNombre().getText();
            edad = Integer.parseInt(vista.getjTextFieldEdad().getText());
            asignatura = new Asignatura(1, "ASIG", 5);
            alumno = new Alumno(nexp, nombre, edad, asignatura);
            if (modelo.modificar(alumno)!=null)
                this.vista.getjLabelTitulo().setText("Alumno modificado");
        }

    }

}
