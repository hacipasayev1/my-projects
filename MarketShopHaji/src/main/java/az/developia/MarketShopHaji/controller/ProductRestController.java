package az.developia.MarketShopHaji.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.dto.ProductDTO;
import az.developia.MarketShopHaji.exc.IdFalseException;
import az.developia.MarketShopHaji.exc.MyValidationException;
import az.developia.MarketShopHaji.exc.NotFindedProductException;
import az.developia.MarketShopHaji.exc.ProductValidationException;
import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.service.ProductService;

@RestController
@RequestMapping(path = "products")
@CrossOrigin(origins = "*")
public class ProductRestController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ProductService productService;

	@GetMapping
	@PreAuthorize("hasAuthority('for:admin')")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('for:admin')")
	public Product addProduct(@Valid @RequestBody ProductDTO productDto,BindingResult br) {
		if (br.hasErrors()) {
			throw new ProductValidationException(br);
		}
		Product product = new Product();
		mapper.map(productDto, product);

		product.setId(null);

		productService.save(product);
		return product;
	}

	@PutMapping
	@PreAuthorize("hasAuthority('for:admin')")
	public Product updateProduct(@Valid @RequestBody ProductDTO productDto,BindingResult br) {
		if (br.hasErrors()) {
			throw new ProductValidationException(br);
		}
		Product product = new Product();
		mapper.map(productDto, product);
		if (product.getId() == null || product.getId() == 0) {
			throw new IdFalseException("id 0 yada null ola bilmez");
		}

		Product p = productService.findById(product.getId());
		if (p == null) {
			throw new NotFindedProductException("bu id-li mehsul bazada yoxdur");
		}
	
		product.setQuantity(product.getQuantity()+p.getQuantity());
		productService.save(product);
		return product;
	}

	@DeleteMapping(path="{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteById(id);
	}


	@GetMapping(path="/search")
	@PreAuthorize("hasAuthority('for:admin')")
	public List<Product> searchProduct(@RequestParam(name="date", required = false, defaultValue = "")String date,@RequestParam(name="name", required = false, defaultValue = "")String name,@RequestParam(name="price", required = false, defaultValue = "")String price,@RequestParam(name="cost", required = false, defaultValue = "")String cost,@RequestParam(name="percent", required = false, defaultValue = "")String percent,@RequestParam(name="quantity", required = false, defaultValue = "")String quantity){
	return productService.searchProduct(date,name,price,cost,percent,quantity);
	}
	
	
	
}
