package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

@Service
public class UsuarioServicioImpl
    extends ServicioBase<Usuario, UsuarioRepositorio>
    implements UsuarioServicio {

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super(usuarioRepositorio);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario obtenerPorCorreoElectronico(String correoElectronico) {
        return repositorio.obtenerPorCorreoElectronico(correoElectronico);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario login(String correoElectronico, String contrasena) {
        Usuario usuario = obtenerPorCorreoElectronico(correoElectronico);
        return usuario.getContrasena().equals(contrasena) ? usuario : null;
    }
}
