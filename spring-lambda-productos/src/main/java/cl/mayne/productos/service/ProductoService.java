package cl.mayne.productos.service;

import java.util.List;
import java.util.Optional;

import cl.mayne.productos.model.ProductoDTO;

public interface ProductoService {

	public List<ProductoDTO> findAll();
	public Optional<ProductoDTO> guardarProducto(ProductoDTO productoDto);
	public Optional<ProductoDTO> buscarPorId(String id);
	public Optional<ProductoDTO> eliminarProducto(String id);
	public Optional<ProductoDTO> actualizarProducto(ProductoDTO productoDto);
}
