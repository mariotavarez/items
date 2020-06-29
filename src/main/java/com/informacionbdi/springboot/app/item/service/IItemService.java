/**
 * 
 */
package com.informacionbdi.springboot.app.item.service;

import java.util.List;

import com.informacionbdi.springboot.app.item.models.Item;

/**
 * @author MarioTavarez
 *
 */
public interface IItemService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
