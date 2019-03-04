package pe.edu.cibertec.spring.base.service;

import java.util.List;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;
import pe.edu.cibertec.spring.base.repository.Repositorio;

public interface Servicio<E extends Entidad, R extends Repositorio<E>> {

    void guardar(E entidad);
    void actualizar(E entidad);
    void eliminar(E entidad);
    E obtenerPorId(Integer id);
    List<E> obtenerTodos();

}
