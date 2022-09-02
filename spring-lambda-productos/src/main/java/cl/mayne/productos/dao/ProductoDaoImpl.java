package cl.mayne.productos.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.mayne.productos.entity.Producto;
import cl.mayne.productos.utils.Constantes;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.utils.StringUtils;

@Repository
public class ProductoDaoImpl implements ProductoDao{


	@Autowired
	private DynamoDbEnhancedClient dynamoDbenhancedClient ;

	@Override
	public List<Producto> getList() {
		List<Producto> auxiliarAduaneroList = new ArrayList<Producto>();
		try{
			Iterator<Producto> results = getTable().scan().items().iterator();
			while (results.hasNext()) {

				Producto producto = results.next();
				auxiliarAduaneroList.add(producto);
				System.out.println(producto);
			}

		} catch (DynamoDbException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Finalizo obtencion de datos");
		return auxiliarAduaneroList;
	} 
	@Override
	public Producto save(final Producto producto) {
		DynamoDbTable<Producto> orderTable = getTable();
		orderTable.putItem(producto);
		return producto;
	}
	@Override
	public Producto findById(final String id) {
		
		Key key = Key.builder().partitionValue(id).build();
		return getTable().getItem(key);
	}
	
	@Override
	public Producto delete(final String id) {
		if (!StringUtils.isBlank(id)) {
        	return getTable().deleteItem(Key.builder().partitionValue(id).build());
        }
		return null;
	}
	
	@Override
	public Producto update(final Producto producto) {
		if(producto != null && producto.getId() != null) {
			return getTable().updateItem(producto);
		}
		return null;
	}

	private DynamoDbTable<Producto> getTable() {
		// Create a tablescheme to scan our bean class order
		DynamoDbTable<Producto> productoDB = dynamoDbenhancedClient.table(Constantes.NOMBRE_TABLA, TableSchema.fromBean(Producto.class));
		return productoDB;
	}

}
