package kata;

import org.junit.*;

public class PointTest {
	Point _point;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/*@Before
	public void setUp() throws Exception {
		_point = new Point(PointType.WALL, 0, 0);
	}*/

	@Test
	public void should_point_not_null() {
		Assert.assertNotNull(_point);
	}

}
