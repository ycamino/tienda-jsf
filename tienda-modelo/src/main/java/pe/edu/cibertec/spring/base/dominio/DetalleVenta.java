package pe.edu.cibertec.spring.base.dominio;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pe.edu.cibertec.spring.base.dominio.base.Entidad;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta extends Entidad {

    @OneToOne(optional = false)
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venta")
    private Venta venta;
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    private int cantidad;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
