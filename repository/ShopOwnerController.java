package com.tnsif.shoppingmall;

import java.util.List;
import java.util.function.LongSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.shoppingmall.entity.ShopOwner;
import com.tnsif.shoppingmall.repository.ShopOwnerRepository;

@RestController
@RequestMapping("/shopowner")
public class ShopOwnerController {
	@Autowired
	ShopOwnerRepository repo;
	@PostMapping
	public ShopOwner createShopOwner(@RequestBody ShopOwner so) {
		return repo.save(so);
	}
	@GetMapping("/{id}")
	public ShopOwner getShopOwner(@PathVariable Long id) {
		return repo.findById(id).get();
		
	}
	@GetMapping
	public List<ShopOwner> getShopOwners(){
		return repo.findAll();
	}
	@PutMapping("/{id}")
	public ShopOwner updateShopOwner(@PathVariable Long id,@RequestBody ShopOwner so) {
		so.setId(id);
		return repo.save(so);
	}
	@DeleteMapping("/{id}")
	public void deleteShopOwner(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
