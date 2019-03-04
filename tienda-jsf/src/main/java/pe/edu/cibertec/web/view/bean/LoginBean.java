package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;
import pe.edu.cibertec.web.view.util.JsfUtil;

@Component
@Scope("view")
public class LoginBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String correoElectronico;
    private String contrasena;
    private String mensajeError;

    private final UsuarioServicio usuarioServicio;

    public LoginBean(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String login() {
        mensajeError = "";
        String resultado = "";
        Usuario usuario = usuarioServicio.login(correoElectronico, contrasena);
        if (usuario != null) {
            JsfUtil.getSession().setAttribute("usuario", usuario);
            resultado = "productos";
        } else {
            mensajeError = "Hubieron problemas para identificar al usuario";
        }
        return resultado;
    }
}
