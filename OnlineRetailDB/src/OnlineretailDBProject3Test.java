
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.sam.dao.CategoryDao;
import com.sam.dao.DaoException;
import com.sam.dao.DaoFactory;
import com.sam.dao.ProductDao;
import com.sam.dao.PurchaseProductDao;
import com.sam.dao.UserDao;
import com.sam.entity.Cart;
import com.sam.entity.Category;
import com.sam.entity.Product;
import com.sam.entity.SubCategory;
import com.sam.entity.User;

public class OnlineretailDBProject3Test {
	private UserDao userDao;
	private CategoryDao categoryDao;
	private ProductDao productDao;
	private PurchaseProductDao purchaseProductDao;

	@Before
	public void setup() {
		try {
			userDao = DaoFactory.getDaoFactory("file").getUserDao();

			User user1, user2, user3;
			user1 = new User(10011, "vinod1", "9731424683", "male", "bengaluru",
					"india");
			user2 = new User(10012, "kumari1", "9823456689", "female",
					"bengaluru", "india");
			user3 = new User(10013, "scott1", "555332645", "male", "bengaluru",
					"india");

			userDao.addUser(user1);
			userDao.addUser(user2);
			userDao.addUser(user3);

			categoryDao = DaoFactory.getDaoFactory("file").getCategoryDao();

			Category c1 = new Category(1111, "Doll", "Small Dolls");
			Category c2 = new Category(1112, "Dress", "Men and women dresses");

			categoryDao.addCategory(c1);
			categoryDao.addCategory(c2);

			SubCategory s1 = new SubCategory(1121, "Men Dress",
					"men dressing", 1111);
			SubCategory s2 = new SubCategory(1122, "Women Dress",
					"women dressing", 1112);

			categoryDao.addSubCategory(s1);
			categoryDao.addSubCategory(s2);

			Product p1 = new Product(10011, "TShrit", "Half T-Shrit", 2000, 1121);

			productDao = DaoFactory.getDaoFactory("file").getProductDao();
			productDao.addProduct(p1);

			purchaseProductDao = DaoFactory.getDaoFactory("file").getPurchaseProductDao();

		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UTC_02_01_testGetExistingUserByMobile() {
		try {
			User user1 = userDao.getUsersByMobileNumber("9731424683");
			assertEquals(user1.getCity(), "bengaluru");
			assertEquals(user1.getUsername(), "vinod1");
			assertEquals(user1.getCountry(), "india");
		} catch (DaoException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void UTC_02_02_testGetNonExistingUserByMobile() {
		try {
			User user1 = userDao.getUsersByMobileNumber("2478497314");
			assertNull(user1);
		} catch (DaoException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void UTC_03_01_testGetExistingCategory() {
		try {
			Category category = categoryDao.getCategory(1111);
			assertEquals("Doll", category.getCname());
			assertEquals("Small Dolls", category.getDescription());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void UTC_03_02_testGetNonExistingCategory() {
		try {
			Category category = categoryDao.getCategory(90);
			assertNull(category);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void UTC_05_03_testGetExistingBuyProduct() {
		try {
			
			Cart cart = new Cart(11143, 10011, 10, 10011);
			purchaseProductDao.addCart(cart);

			Cart cartObj = purchaseProductDao.getCartDetails(11143);
			assertEquals(10, cartObj.getQty());

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteRecordFromTables() {
		try {
			purchaseProductDao.deleteCart(11143);
			
			userDao.deleteUser(10011);
			userDao.deleteUser(10012);
			userDao.deleteUser(10013);
			
			productDao.deleteProduct(10011);
			
			categoryDao.deleteSubCategory(1121);
			categoryDao.deleteSubCategory(1122);
			
			categoryDao.deleteCategory(1111);
			categoryDao.deleteCategory(1112);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private Date stringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	private String dateToString(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dt);
	}

}
