package az.developia.MarketShopHaji.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
private String name;
private Double price;
private Integer saleQuantity;
private String barcode;
private Double cemqiymet;
private LocalDate saleDate;
}
