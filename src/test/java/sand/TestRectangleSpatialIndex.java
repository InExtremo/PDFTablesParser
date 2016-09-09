package sand;

import static org.junit.Assert.*;

import org.junit.Test;
import technology.tabula.Rectangle;
import technology.tabula.RectangleSpatialIndex;

public class TestRectangleSpatialIndex {

	@Test
	public void testIntersects() {
		
		Rectangle r = new Rectangle(0, 0, 0, 0);
		
		RectangleSpatialIndex rSpatialIndex = new RectangleSpatialIndex<Rectangle>();
		rSpatialIndex.add(r);
		
		assertTrue(rSpatialIndex.intersects(r).size() > 0);

	}

}
