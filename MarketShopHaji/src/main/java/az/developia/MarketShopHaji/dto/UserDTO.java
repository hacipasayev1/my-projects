package az.developia.MarketShopHaji.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {
	private Integer id;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	private String username;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	private String password;
	private List<String> auths;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	private String name;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	private String surname;
	@Pattern(regexp = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,4}", message = "Email düzgün yazılmayıb")
	private String email;
	@Pattern(regexp = "[0-9]{3}+[0-9]{3}+[0-9]{4}", message = "Telefon düzgün yazılmayıb")
	private String phone;
}
