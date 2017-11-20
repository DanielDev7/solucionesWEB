/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import be.usuariobe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class usuariodao {

    public usuariodao() {
    }
    
    public int crearUsuario(usuariobe u){
        int r=0;
        String sql="insert into usuario(login, clave, nombre, estado) "
                + "values('"+u.getLogin()+"','"+u.getClave()+"','"+u.getNombre()+"',1)";
        //data d = new data();
        //Connection c = d.getMysql();
        Connection c = new data().getMysql();
        try {
            Statement st = c.createStatement();
            r = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int actualizarUsuario(usuariobe u){
        int r=0;
        String sql="update usuario set "
                + "clave='"+u.getClave()+"', nombre='"+u.getNombre()+"' where login = '"+u.getLogin()+"'";
        //data d = new data();
        //Connection c = d.getMysql();
        Connection c = new data().getMysql();
        try {
            Statement st = c.createStatement();
            r = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int habilitarUsuario(usuariobe u){
        int r=0;
        String sql="update usuario set "
                + "estado=1 where login = '"+u.getLogin()+"'";
        //data d = new data();
        //Connection c = d.getMysql();
        Connection c = new data().getMysql();
        try {
            Statement st = c.createStatement();
            r = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int bloquearUsuario(usuariobe u){
        int r=0;
        String sql="update usuario set "
                + "estado=0 where login = '"+u.getLogin()+"'";
        //data d = new data();
        //Connection c = d.getMysql();
        Connection c = new data().getMysql();
        try {
            Statement st = c.createStatement();
            r = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public List<usuariobe> listarUsuario(){
        List<usuariobe> lista = new ArrayList();
        String sql = "select login, clave,nombre,estado from usuario";
        Connection c = new data().getMysql();
        try {
            Statement st=c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                usuariobe e = new usuariobe();
                e.setLogin(rs.getString("login"));
                e.setClave(rs.getString("clave"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getInt("estado"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public int validar(usuariobe e){
        int r=0;
        String sql = "select count(1) registro from usuario where login = '"+e.getLogin()+"' and clave = '"+e.getClave()+"'";
        Connection c = new data().getMysql();
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                r = rs.getInt("registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
