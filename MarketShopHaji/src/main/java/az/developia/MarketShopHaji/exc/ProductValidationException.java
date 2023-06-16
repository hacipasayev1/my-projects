package az.developia.MarketShopHaji.exc;

import org.springframework.validation.BindingResult;

import lombok.Data;
@Data
public class ProductValidationException extends RuntimeException {
private BindingResult br;
public ProductValidationException(BindingResult br) {
	this.br=br;
}
}
