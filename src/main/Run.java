package main;

import controlador.ControladorAlumno;
import modeloDAO.AlumnoDAO;
import vista.JFrameAlumno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dapelle
 */
public class Run {
    
    public static void main(String[] args) {
        // Nos creamos modelo vista y controlador
        AlumnoDAO modelo = new AlumnoDAO();         
        JFrameAlumno jFrameAlumno  = new JFrameAlumno();
        ControladorAlumno controlador = new ControladorAlumno(jFrameAlumno, modelo);
    }
    
}
