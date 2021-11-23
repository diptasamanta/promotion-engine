/**
 * 
 */
package model;

/**
 * @author dipta
 *
 */
public class Product {
	private String uniqueCode;
	private int price;
	
	public Product(String uniqueCode, int price) {
		this.uniqueCode = uniqueCode;
		this.price = price;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}
	
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

}
