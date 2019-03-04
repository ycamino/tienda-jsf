package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

@Component
@Scope("view")
public class ListaProductoBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private transient List<Producto> listaProducto;

    @Autowired
    private transient ProductoServicio productoServicio;

    @PostConstruct
    public void init() {
        listaProducto = productoServicio.obtenerTodos();
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
}
