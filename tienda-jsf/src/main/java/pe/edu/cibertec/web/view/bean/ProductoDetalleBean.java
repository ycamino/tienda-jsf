package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

@Component
@Scope("request")
public class ProductoDetalleBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private transient Integer idProducto;
    private transient Producto producto;

    @Autowired
    private transient ProductoServicio productoServicio;

    public void cargaProducto() {
        producto = productoServicio.obtenerPorId(idProducto);
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
