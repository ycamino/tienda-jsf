package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;

public interface UsuarioServicio extends Servicio<Usuario, UsuarioRepositorio> {

    Usuario obtenerPorCorreoElectronico(String correoElectronico);

    Usuario login(String correoElectronico, String contrasena);
}
