package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Cart;

public class SingleProductPromotion implements Promotions {
	private String uniqueCode;
	private int discount;
	private int items;
	
	public SingleProductPromotion(String uniqueCode, int discount, int items) {
		this.uniqueCode = uniqueCode;
		this.discount = discount;
		this.items = items;
	}

	@Override
	public int apply(List<Cart> cartList) {
		// TODO Auto-generated method stub
		List<Cart> list = cartList.stream().filter(cart -> this.uniqueCode.equals(cart.getProduct().getUniqueCode())).collect(Collectors.toList());
	    if (list.size() == 1 && list.get(0).getCount() >= items) {

	      Cart discountCart = list.get(0);
	      int discountedPrice = ((discountCart.getCount() / items) * this.discount)
	              + (discountCart.getCount() % items * discountCart.getProduct().getPrice());
	      cartList.remove(list.get(0));
	      return discountedPrice;
	    }
	    return 0;
	}
}
