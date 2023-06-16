package az.developia.MarketShopHaji.annologic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import az.developia.MarketShopHaji.anno.Ean;

public class CourseCodeValidator implements ConstraintValidator<Ean, String>{


@Override
	public void initialize(Ean b) {

}


	@Override
	public boolean isValid(String barcode, ConstraintValidatorContext context) {
		if (barcode == null || barcode.length() != 13 || !barcode.matches("[0-9]+")) {
            return false; 
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(barcode.charAt(i));
            sum += (i % 2 == 0) ? digit*3 : digit ;
        }

        int checkDigit = 10 - (sum % 10);
        return checkDigit == Character.getNumericValue(barcode.charAt(12));
	}

}
