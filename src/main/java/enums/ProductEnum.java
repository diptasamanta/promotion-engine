/**
 * 
 */
package common;

/**
 * @author dipta Enum that contains the values against a particular code.
 *
 */
public enum ProductEnum {
	PRODUCT_A("A", 50), PRODUCT_B("B", 30), PRODUCT_C("C", 20), PRODUCT_D("D", 15);
	private final String uniqueCode;
	private final int price;
	
	private ProductEnum(String uniqueCode, int price) {
		this.uniqueCode = uniqueCode;
		this.price = price;
	}
	
	public String getUniqueCode() {
		return uniqueCode;
	}
	
	
	public int getPrice() {
		return price;
	}
	
	

}
