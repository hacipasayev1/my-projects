package az.developia.MarketShopHaji.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserModel {
	@Id
	private String username;
	private String password;
	private Integer enabled;
}
