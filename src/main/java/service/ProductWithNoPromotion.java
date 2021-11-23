package service;

import java.util.List;

import model.Cart;

public class ProductWithNoPromotion implements Promotions {

	@Override
	public int apply(List<Cart> cartList) {
		if (cartList == null) {
			return 0;
		}
		return cartList.stream().reduce(0,
				(partialvalue, cart) -> partialvalue + cart.getProduct().getPrice() * cart.getCount(), Integer::sum);
	}

}
