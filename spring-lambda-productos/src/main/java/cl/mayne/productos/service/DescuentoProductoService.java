package cl.mayne.productos.service;

import java.math.BigDecimal;

import cl.mayne.productos.model.ProductoDTO;

public interface DescuentoProductoService {

	public ProductoDTO aplicarDescuento(ProductoDTO producto, BigDecimal descuento);
}
