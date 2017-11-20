/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import be.usuariobe;
import br.usuariobr;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean
@RequestScoped
public class usuarioFormbean {
    private String login;
    private String clave;
    private String errorlogin;
    /**
     * Creates a new instance of usuarioFormbean
     */
    public usuarioFormbean() {
        this.errorlogin = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getErrorlogin() {
        return errorlogin;
    }

    public void setErrorlogin(String errorlogin) {
        this.errorlogin = errorlogin;
    }
    
    public String validarcuenta(){
        // crear un objeto be
        usuariobe e = new usuariobe(this.login, this.clave);
        // crear un objeto br
        usuariobr r = new usuariobr();
        // llamar al metodo de validacion
//        if(this.login.equals("admin") && this.clave.equals("12345678")){
        if(r.validausuario(e)>0){
            return "si";
        }
        else{
            return "no";
        }
    }
    
    public String regresar(){
        return "returnlogin";
    }
    
    public void validarLogin(AjaxBehaviorEvent evento){
        if(this.login.length()<=0 || this.login==null){
            this.errorlogin="Usuario es campo obligatorio";
        }else{
            this.errorlogin="";
        }
    }
}
