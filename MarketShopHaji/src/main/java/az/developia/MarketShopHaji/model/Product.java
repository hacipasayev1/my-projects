package az.developia.MarketShopHaji.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

	private String name;
	private String barcode;
	private Double price;
	private Double cost;
	private String description;
	private LocalDate registerDate;
	private LocalDate updateDate;
	private Double quantity;
	private Double percent;
}
