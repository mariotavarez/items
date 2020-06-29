/**
 * 
 */
package com.informacionbdi.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.informacionbdi.springboot.app.item.models.Item;
import com.informacionbdi.springboot.app.item.models.Producto;

/**
 * @author MarioTavarez
 *
 */
@Service("serviceRestTemplate")
public class ItemServiceImpl implements IItemService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		List<Producto> producto = Arrays.asList(clienteRest.getForObject("http://localhost:9090/listar", Producto[].class));
		return producto.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>(); 
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:9090/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
