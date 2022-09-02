package cl.mayne.productos.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class DescuentoServiceImpl implements DescuentoService{

	private static final String DESCUENTO_PORCENTAJE = "10";
	
	@Override
	public BigDecimal obtenerDescuento() {
		return new BigDecimal(DESCUENTO_PORCENTAJE);
	}

}
