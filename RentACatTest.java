import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import java.util.ArrayList;

public class RentACatTest{


	@Test
	public void testReturningRentedCat(){
		Cat c = Mockito.mock(Cat.class);
		c = new Cat(1, "Leo");
		RentACat r = new RentACat();
		c.rentCat();
		boolean rentCheck = r.returnCat(c);
		assertTrue(rentCheck);
	}
	
	@Test
	public void testReturningNonRentedCat(){
		Cat c = Mockito.mock(Cat.class);
		c = new Cat(1, "Leo");
		RentACat r = new RentACat();
		c.returnCat();
		boolean rentCheck = r.returnCat(c);
		assertFalse(rentCheck);
	}
	
	@Test
	public void testExistListNull(){
		RentACat r = new RentACat();
		ArrayList<Cat> testList = new ArrayList<Cat>();

		boolean existCheck = r.catExists(1, testList);
		assertFalse(existCheck);
	}
	
	@Test
	public void testCatDoesntExist(){
		Cat c = Mockito.mock(Cat.class);
		c = new Cat(1, "Leo");
		RentACat r = new RentACat();
		ArrayList<Cat> testList = new ArrayList<Cat>();
		testList.add(c);
		boolean existCheck = r.catExists(2, testList);
		assertFalse(existCheck);
	}
	
	
	@Test
	public void testCatExists(){
		Cat c = Mockito.mock(Cat.class);
		c = new Cat(1, "Leo");
		RentACat r = new RentACat();
		ArrayList<Cat> testList = new ArrayList<Cat>();
		testList.add(c);
		boolean existCheck = r.catExists(1, testList);
		assertTrue(existCheck);
	}
}