package service;

import java.util.List;

import model.Cart;

public interface Promotions {
	
	int apply(List<Cart> cartList);

}
