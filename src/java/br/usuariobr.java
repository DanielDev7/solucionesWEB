/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

import be.usuariobe;
import dao.usuariodao;

/**
 *
 * @author Estudiante
 */
public class usuariobr {

    public usuariobr() {
    }
    public int validausuario(usuariobe e){
        return new usuariodao().validar(e);
    }
}
