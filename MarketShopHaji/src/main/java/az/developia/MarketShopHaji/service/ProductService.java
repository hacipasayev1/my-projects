package az.developia.MarketShopHaji.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.model.ProductSale;
import az.developia.MarketShopHaji.repository.ProductRepo;
import az.developia.MarketShopHaji.repository.ProductSaleRepo;
@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductSaleRepo productSaleRepo;
	
	public Product save(Product product) {
		LocalDate indi=LocalDate.now();
		product.setUpdateDate(indi);
		Double percent=(product.getCost()/product.getPrice())*100;
		
		product.setPercent(100-percent);
		
		productRepo.save(product);
		return product;

	}

	public Product findById(Integer id) {
		Optional<Product> finded = productRepo.findById(id);
		if (finded.isPresent()) {
			return finded.get();
		} else {
			return null;
		}
	}

	public List<Product> findAll() {
		
		return productRepo.findAll();
	}

	public void deleteById(Integer id) {
productRepo.deleteById(id);		
	}

	public List<Product> searchProduct(String date,String name,String price,String cost,String percent,String quantity) {
		
		return productRepo.searchProduct(date,name,price,cost,percent,quantity);
	}

	public List<Product> productAllInfo(String barcode) {
		
		return productRepo.findAllByBarcode(barcode);
	}

	public ProductSale sale(ProductSale productSale) {
		LocalDate indi=LocalDate.now();
		productSale.setSaleDate(indi);
		productSale.setCemqiymet(productSale.getPrice()*Double.valueOf(productSale.getSaleQuantity()));
		productSaleRepo.save(productSale);
		return productSale;
	}

	public List<ProductSale> findByDate(LocalDate d) {
	return	productSaleRepo.findByDate(d);
		
	}

	public List<ProductSale> allSales() {
		
		return productSaleRepo.findAll();
	}



}
