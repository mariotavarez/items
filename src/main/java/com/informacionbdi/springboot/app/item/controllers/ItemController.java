/**
 * 
 */
package com.informacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.informacionbdi.springboot.app.item.models.Item;
import com.informacionbdi.springboot.app.item.service.ItemServiceImpl;

/**
 * @author MarioTavarez
 *
 */
@RestController
@Qualifier("serviceFeign")
public class ItemController {

	@Autowired
	private ItemServiceImpl itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	
}
