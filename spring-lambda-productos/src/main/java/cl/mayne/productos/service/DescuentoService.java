package cl.mayne.productos.service;

import java.math.BigDecimal;

public interface DescuentoService {

	/**
	 * Metodo que obtiene descuento desde BD despues pueden agregarse otras condiciones para obtener descuento
	 * @return
	 */
	public BigDecimal obtenerDescuento();
}
