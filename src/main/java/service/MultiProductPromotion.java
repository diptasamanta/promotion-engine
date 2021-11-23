package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Cart;

public class MultiProductPromotion implements Promotions{
	private String firstUniqueProductCode;
	private String secondUniqueProductCode;
	private int discout;
	
	public MultiProductPromotion(String firstUniqueProductCode, String secondUniqueProductCode, int discout) {
		super();
		this.firstUniqueProductCode = firstUniqueProductCode;
		this.secondUniqueProductCode = secondUniqueProductCode;
		this.discout = discout;
	}

	@Override
	public int apply(List<Cart> cartList) {
		// TODO Auto-generated method stub
		List<Cart> discountCart = cartList.stream()
				.filter(cart -> this.firstUniqueProductCode.equals(cart.getProduct().getUniqueCode())
						|| this.secondUniqueProductCode.equals(cart.getProduct().getUniqueCode()))
				.collect(Collectors.toList());
		int discuountedPrice = 0;
		if (discountCart.size() == 2) {
			Cart firstCart = discountCart.get(0);
			Cart secondCart = discountCart.get(1);
			int productCount1 = firstCart.getCount();
			int productCount2 = secondCart.getCount();
			if (productCount1 == productCount2) {
				discuountedPrice = productCount2 * this.discout;
			} else if (productCount1 < productCount2) {
				discuountedPrice = (productCount1 * this.discout)
						+ ((productCount2 - productCount1) * secondCart.getProduct().getPrice());
			} else {
				discuountedPrice = (productCount2 * this.discout)
						+ ((productCount1 - productCount2) * firstCart.getProduct().getPrice());
			}
			cartList.removeAll(discountCart);
			return discuountedPrice;
		}
		return 0;
	}
}
