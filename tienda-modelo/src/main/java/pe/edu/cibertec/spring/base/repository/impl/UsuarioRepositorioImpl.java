package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;
import pe.edu.cibertec.spring.base.util.MapUtil;

@Repository
public class UsuarioRepositorioImpl
        extends RepositorioBaseJpaImpl<Usuario>
        implements UsuarioRepositorio {

    @Override
    public Usuario obtenerPorCorreoElectronico(String correoElectronico) {
        String jpql = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico";
        return obtenerUnicoResultado(jpql, MapUtil.crearMapa("correoElectronico", correoElectronico));
    }
}
