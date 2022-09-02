package cl.mayne.productos.dao;

import java.util.List;

import cl.mayne.productos.entity.Producto;

public interface ProductoDao {

	public List<Producto> getList();
	public Producto save(final Producto producto);
	public Producto delete(final String id);
	public Producto update(final Producto producto);
	public Producto findById(String id);
}
