import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Cart;
import model.Product;

import static enums.ProductEnum.PRODUCT_A;
import static enums.ProductEnum.PRODUCT_B;
import static enums.ProductEnum.PRODUCT_C;
import static enums.ProductEnum.PRODUCT_D;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import service.MultiProductPromotion;
import service.PromotionService;
import service.SingleProductPromotion;

public class PromotionTest {
	private PromotionService service = new PromotionService();
    @Before
    public void setUp() throws Exception {
        service.add(new SingleProductPromotion(PRODUCT_A.getUniqueCode(), 3, 130));
        service.add(new SingleProductPromotion(PRODUCT_B.getUniqueCode(), 2, 45));
        service.add(new MultiProductPromotion(PRODUCT_C.getUniqueCode(), PRODUCT_D.getUniqueCode(), 30));
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSinglePromotion() {
    	List<Cart> result = mockSinglePromotion();
    	int totalPrice = service.apply(result);
    	assertTrue(totalPrice == 100);
    }

	private List<Cart> mockSinglePromotion() {
		// TODO Auto-generated method stub
		List<Cart> result = new ArrayList<>();
		result.add(new Cart(new Product(PRODUCT_A.getUniqueCode(), PRODUCT_A.getPrice()), 1));
        result.add(new Cart(new Product(PRODUCT_B.getUniqueCode(), PRODUCT_B.getPrice()), 1));
        result.add(new Cart(new Product(PRODUCT_C.getUniqueCode(), PRODUCT_C.getPrice()), 1));
		return result;
	}
}
