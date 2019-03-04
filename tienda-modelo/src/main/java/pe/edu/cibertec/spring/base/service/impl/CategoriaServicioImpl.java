package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.repository.CategoriaRepositorio;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;

@Service
public class CategoriaServicioImpl
    extends ServicioBase<Categoria, CategoriaRepositorio>
    implements CategoriaServicio {

    public CategoriaServicioImpl(CategoriaRepositorio categoriaRepositorio) {
        super(categoriaRepositorio);
    }
}
