package az.developia.MarketShopHaji.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopHaji.dto.ProductSaleDTO;
import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.model.ProductSale;
import az.developia.MarketShopHaji.service.ProductService;

@RequestMapping(path = "/productforcashier")
@CrossOrigin(origins = "*")
@RestController
public class ProductForCashierRestController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductService productService;
	
	
@GetMapping
@PreAuthorize("hasAuthority('for:cashier')")
public List<Product> productInfo(@RequestParam(name="barcode",required = false,defaultValue = "") String barcode){
	return productService.productAllInfo(barcode);
}
@PostMapping(path="/sale")
@PreAuthorize("hasAuthority('for:cashier')")
public ProductSale productSale(@RequestBody ProductSaleDTO productSaleDto) {

	List<Product> product = productService.productAllInfo(productSaleDto.getBarcode());
	ProductSale productSale=new ProductSale();
	
	for(Product p:product) {
		mapper.map(p, productSale);
	}
	productSale.setSaleQuantity(productSaleDto.getSaleQuantity());
	productService.sale(productSale);
	//?service-controller return
	return productSale;
}
}
