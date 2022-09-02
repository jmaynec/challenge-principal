package cl.mayne.productos.model;

import java.math.BigDecimal;

import cl.mayne.productos.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
public class ProductoDTO {

	private String id;
	private String nombre;
	private String descripcion;
	private String marca;
	private String modelo;
	private String categoria;
	private BigDecimal precioVenta;
	private BigDecimal descuento;
	
	public ProductoDTO() {
		
	}
	
	public ProductoDTO(Producto producto) {
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.descripcion = producto.getDescripcion();
		this.marca = producto.getMarca();
		this.modelo = producto.getModelo();
		this.categoria = producto.getCategoria();
		this.precioVenta = producto.getPrecioVenta();
		this.descuento = producto.getDescuento();
	}
	
	public Producto toEntity() {
		Producto producto = new Producto();
		producto.setId(getId());
		producto.setNombre(getNombre());
		producto.setDescripcion(getDescripcion());
		producto.setModelo(getModelo());
		producto.setMarca(getMarca());
		producto.setCategoria(getCategoria());
		producto.setPrecioVenta(getPrecioVenta());
		producto.setDescuento(getDescuento());
		return producto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", modelo=" + modelo + ", categoria=" + categoria + ", precioVenta=" + precioVenta + ", descuento="
				+ descuento + "]";
	}
	
	
	
}
