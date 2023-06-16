package az.developia.MarketShopHaji.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.model.ProductSale;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query(value = "select * from product where register_date like %?1% and name like %?2% and price like %?3% and cost like %?4% and percent like %?5% and quantity like %?6%", nativeQuery = true)
	@Modifying
	List<Product> searchProduct(String date, String name, String price, String cost, String percent, String quantity);

	List<Product> findAllByBarcode(String barcode);

	
}
