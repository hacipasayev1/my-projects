package az.developia.MarketShopHaji.exc;

import org.springframework.validation.BindingResult;

import lombok.Data;
@Data
public class MyValidationException extends RuntimeException {
	private BindingResult br;

	public MyValidationException(BindingResult br) {
		this.br = br;

	}
}
