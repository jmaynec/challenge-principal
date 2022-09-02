package cl.mayne.productos.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import cl.mayne.productos.model.ProductoDTO;

@Service
public class DescuentoProductoServiceImpl implements DescuentoProductoService{
	
	public static final String _100_PORCIENTO = "100";

	@Override
	public ProductoDTO aplicarDescuento(ProductoDTO producto, BigDecimal descuento) {

		BigDecimal precioDescontado = (producto.getPrecioVenta().multiply(descuento)).divide(new BigDecimal(_100_PORCIENTO));
		producto.setPrecioVenta(producto.getPrecioVenta().subtract(precioDescontado));
		producto.setDescuento(descuento);
		return producto;
	}

}
