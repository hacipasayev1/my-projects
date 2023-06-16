package az.developia.MarketShopHaji.annologic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import az.developia.MarketShopHaji.anno.Nullolmaz;

public class CourseCodeValidator2 implements ConstraintValidator<Nullolmaz, Double>{


@Override
	public void initialize(Nullolmaz b) {

}


	@Override
	public boolean isValid(Double eded, ConstraintValidatorContext context) {
		boolean netice=false;
		if(eded!=null) {
			netice=true;
			
		}else {
			netice= false;
		}
		return netice;
	}

}
