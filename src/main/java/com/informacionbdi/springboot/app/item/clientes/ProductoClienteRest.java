/**
 * 
 */
package com.informacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.informacionbdi.springboot.app.item.models.Producto;

/**
 * @author MarioTavarez
 *
 */
@FeignClient(name = "servicio-productos", url = "http://localhost:9090")
public interface ProductoClienteRest {

	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
	
}
