package cl.mayne.productos.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cl.mayne.productos.model.ProductoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Productos", description = "API del recurso Productos")
public interface IProductosController {

	@Operation(summary = "Agrega un nuevo producto", description = "Recibe un objeto del tipo producto y responde un producto con su Id asignado")
	public ResponseEntity<?> guardarProducto(
			@Parameter(description = "Un producto a ingresar de la clase producto", required = true)
			@RequestBody ProductoDTO productoDto);
	
	@Operation(summary = "Obtiene todos los productos", description = "Lista todos los productos")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoDTO>> findAll();
	
	@Operation(summary = "Obtiene un producto por su id", description = "Recibe un objeto del tipo producto y responde un producto con su Id")
	public ResponseEntity<?> getProductoById(@Parameter(description = "Id de un producto", required = true) String id);
	
	@Operation(summary = "Actualiza un producto", description = "Recibe un objeto del tipo producto y responde con un producto actualizado")
	public ResponseEntity<?> actualizarProducto(@Parameter(description = "Un producto a ingresar de la clase producto", required = true) ProductoDTO productoDto);
	
	@Operation(summary = "Elimina un producto", description = "Recibe un Id como parametro para eliminar un producto")
	public ResponseEntity<?> eliminarProducto(@Parameter(description = "Id de un producto", required = true) @PathVariable String id);
}
