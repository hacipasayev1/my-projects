package az.developia.MarketShopHaji.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import az.developia.MarketShopHaji.anno.Ean;
import az.developia.MarketShopHaji.anno.Nullolmaz;
import lombok.Data;

@Data
public class ProductDTO {
	private Integer id;
	private String name;
	@Ean
	private String barcode;
	@Nullolmaz
	private Double price;
	@Nullolmaz
	private Double cost;
	private String description;
	private LocalDate registerDate;
	private LocalDate updateDate;
	@Nullolmaz
	private Double quantity;
	private Double percent;
}
