package az.developia.MarketShopHaji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopHaji.model.AuthorityModel;
import az.developia.MarketShopHaji.model.Cashier;
import az.developia.MarketShopHaji.model.Product;
import az.developia.MarketShopHaji.model.UserModel;
import az.developia.MarketShopHaji.repository.AuthRepo;
import az.developia.MarketShopHaji.repository.CashierRepo;
import az.developia.MarketShopHaji.repository.ProductRepo;
import az.developia.MarketShopHaji.repository.UserRepo;

@Service
public class GeneralService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AuthRepo authRepo;
	@Autowired
	private CashierRepo cashierRepo;

	public void save(UserModel user) {
		userRepo.save(user);
	}

	public void saveAll(List<AuthorityModel> authorityModels) {
		authRepo.saveAll(authorityModels);
	}

	public UserModel findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public void deleteById(Integer id) {
Cashier cashier= cashierRepo.findById(id).get();

			userRepo.deleteById(cashier.getUsername());
			cashierRepo.deleteById(id);

		
		
	}

//	public List<Product> findAll() {
//
//		return productRepo.findAll();
//	}

	public void save(Cashier cashier) {
		cashierRepo.save(cashier);

	}

	

	
	public Cashier findByIdCashier(Integer id) {
	Optional<Cashier> finded = cashierRepo.findById(id);
	if(finded.isPresent()) {
		return finded.get();
	}else {
		return null;
	}
		
	}
}
