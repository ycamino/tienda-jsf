package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.repository.ProductoRepositorio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

@Service
public class ProductoServicioImpl
    extends ServicioBase<Producto, ProductoRepositorio>
    implements ProductoServicio {

    public ProductoServicioImpl(ProductoRepositorio productoRepositorio) {
        super(productoRepositorio);
    }

}
