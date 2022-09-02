package cl.mayne.productos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mayne.productos.dao.ProductoDao;
import cl.mayne.productos.entity.Producto;
import cl.mayne.productos.model.ProductoDTO;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<ProductoDTO> findAll() {
		return productoDao
				.getList().stream().map(c -> new ProductoDTO(c.getId(), c.getNombre(), c.getDescripcion(), c.getMarca(),
						c.getModelo(), c.getCategoria(), c.getPrecioVenta(), c.getDescuento()))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ProductoDTO> guardarProducto(ProductoDTO productoDto) {

		if (productoDto != null && productoDto.getId() == null) {
			Producto producto = productoDto.toEntity();
			producto.setId(UUID.randomUUID().toString());			
			productoDto = new ProductoDTO(productoDao.save(producto));
		}
		return Optional.of(productoDto);
	}

	@Override
	public Optional<ProductoDTO> buscarPorId(String id) {
		return Optional.of(new ProductoDTO(productoDao.findById(id)));
	}

	@Override
	public Optional<ProductoDTO> eliminarProducto(String id) {
		return Optional.of(new ProductoDTO(productoDao.delete(id)));
	}

	@Override
	public Optional<ProductoDTO> actualizarProducto(ProductoDTO producto) {
		return Optional.of(new ProductoDTO(productoDao.update(producto.toEntity())));
	}

}
