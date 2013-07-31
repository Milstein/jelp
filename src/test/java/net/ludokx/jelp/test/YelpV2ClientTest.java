package net.ludokx.jelp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import net.ludokx.jelp.Search;
import net.ludokx.jelp.SearchResult;
import net.ludokx.jelp.YelpClient;
import net.ludokx.jelp.YelpException;
import net.ludokx.jelp.impl.test.MockYelpV2Client;
import net.ludokx.jelp.types.Business;

import org.junit.Test;

public class YelpV2ClientTest {
	
	private YelpClient yelp = new MockYelpV2Client();

	@Test
	public void search() {
		SearchResult result;
		try {
			result = yelp.search(new Search());
		} catch (YelpException e) {
			e.printStackTrace();
			result = null;
		}
		assertNotNull(result);
		List<Business> businesses = result.getBusinesses();
		assertNotNull(businesses);
		assertEquals(19, businesses.size());
		assertEquals("Poesia", businesses.get(0).getName());
		assertEquals("poesia-san-francisco", businesses.get(0).getId());
	}
	
	@Test
	public void getBusiness() {
		Business b;
		try {
			b = yelp.getBusiness("poesia");
		} catch (YelpException e) {
			e.printStackTrace();
			b = null;
		}
		assertNotNull(b);
		assertEquals("Poesia", b.getName());
		assertEquals("poesia-san-francisco", b.getId());
	}

}
