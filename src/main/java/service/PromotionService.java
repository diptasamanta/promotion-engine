package service;

import java.util.ArrayList;
import java.util.List;

import model.Cart;

public class PromotionService implements Promotions{
	
	List<Promotions> promotions = new ArrayList<>();

	@Override
	public int apply(List<Cart> cartList) {
		// TODO Auto-generated method stub
		promotions.add(new ProductWithNoPromotion());
	    List<Cart> list = new ArrayList<>(cartList);
	    return promotions.stream().reduce(0, (partial, promotion) -> (partial + promotion.apply(list)), Integer::sum);
	}
	
	public void add(Promotions promotion) {
	    promotions.add(promotion);
	  }
	  
	  public void remove(Promotions promotion) {
	    promotions.remove(promotion);
	  }

}
