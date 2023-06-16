package az.developia.MarketShopHaji.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.MarketShopHaji.exc.IdFalseException;
import az.developia.MarketShopHaji.exc.MyValidationException;
import az.developia.MarketShopHaji.exc.NotFindedCashierException;
import az.developia.MarketShopHaji.exc.NotFindedProductException;
import az.developia.MarketShopHaji.exc.ProductValidationException;
import az.developia.MarketShopHaji.exc.UsernameAlreadyDefinedException;

@RestControllerAdvice
public class GlobalAdvice {
@ExceptionHandler
@ResponseStatus(code = HttpStatus.CONFLICT)
public String handleUsernameAlreadyDefinedException(UsernameAlreadyDefinedException exception) {
return exception.getMessage();
}

@ExceptionHandler
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public String handleIdFalseException(IdFalseException exception) {
	return exception.getMessage();
}
@ExceptionHandler
public String handleNotFindedProductException(NotFindedProductException exception) {
	return exception.getMessage();
}

@ExceptionHandler
public String handleNotFindedCashierException(NotFindedCashierException exception) {
	return exception.getMessage();
}



@ExceptionHandler
@ResponseStatus(code = HttpStatus.ACCEPTED)
public List<String> handleMyValidationException(MyValidationException exc){
	BindingResult br=exc.getBr();
	ArrayList<String> errors=new ArrayList<>();
	for (FieldError e : br.getFieldErrors()) {
		errors.add(e.getField()+":::"+e.getDefaultMessage());
	}
	return errors;
}

@ExceptionHandler
@ResponseStatus(code = HttpStatus.ACCEPTED)
public List<String> handleProductValidationException(ProductValidationException exc){
	BindingResult br=exc.getBr();
	ArrayList<String> errors=new ArrayList<>();
	for (FieldError e : br.getFieldErrors()) {
		errors.add(e.getField()+":::"+e.getDefaultMessage());
	}
	return errors;
}
}