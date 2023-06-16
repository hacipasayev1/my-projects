package az.developia.MarketShopHaji.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import az.developia.MarketShopHaji.annologic.CourseCodeValidator;

@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ean {
	

	public String message() default "Yanlis ean-13 barcode";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
