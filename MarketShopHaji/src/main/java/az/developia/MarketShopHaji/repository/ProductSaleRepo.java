package az.developia.MarketShopHaji.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.MarketShopHaji.model.ProductSale;

public interface ProductSaleRepo extends JpaRepository<ProductSale, Integer>{
	@Query(value="select * from product_sale where sale_date=?1",nativeQuery = true)
	@Modifying
	List<ProductSale> findByDate(LocalDate d);
}
