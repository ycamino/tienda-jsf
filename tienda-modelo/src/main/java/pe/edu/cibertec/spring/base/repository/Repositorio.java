package pe.edu.cibertec.spring.base.repository;

import java.util.List;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

public interface Repositorio<E extends Entidad> {

    void guardar(E entidad);
    void actualizar(E entidad);
    void eliminar(E entidad);
    E obtenerPorId(Integer id);
    List<E> obtenerTodos();

}
