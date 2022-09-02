package cl.mayne.productos.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mayne.productos.model.ProductoDTO;
import cl.mayne.productos.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductosController implements IProductosController{
	
	@Autowired
	private ProductoService productoService;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardarProducto(@RequestBody ProductoDTO productoDto) {
    	Optional<ProductoDTO> productoNuevo = productoService.guardarProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoDTO>> findAll() {
    	List<ProductoDTO> productoList = productoService.findAll();
    	System.out.println(productoList);
        return ResponseEntity.ok(productoList);
    }
    
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductoById(@PathVariable("id")String id) {   	
    	ProductoDTO producto = productoService.buscarPorId(id).orElseThrow();
    	return ResponseEntity.ok(producto);
    }
    
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarProducto(@RequestBody ProductoDTO productoDto) {
    	ProductoDTO productoActualizado = productoService.actualizarProducto(productoDto).orElseThrow();
    	return ResponseEntity.ok(productoActualizado);
    }
    
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarProducto(@PathVariable String id) {
    	if(!Strings.isBlank(id)) {
    		Optional<ProductoDTO> productoOp = productoService.eliminarProducto(id);

    		return ResponseEntity.ok(productoOp.orElseThrow());
    	}
		return (ResponseEntity<?>) ResponseEntity.badRequest();
    	
    }
}
