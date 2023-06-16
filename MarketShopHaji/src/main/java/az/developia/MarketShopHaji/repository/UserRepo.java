package az.developia.MarketShopHaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.MarketShopHaji.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, String>{

	UserModel findByUsername(String username);

}
