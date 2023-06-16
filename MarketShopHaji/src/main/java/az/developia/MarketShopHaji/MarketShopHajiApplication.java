package az.developia.MarketShopHaji;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarketShopHajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketShopHajiApplication.class, args);
	}

	
	@Bean
	public ModelMapper mapper() {
		ModelMapper m=new ModelMapper();
		return m;
}
}