/**
 * 
 */
package net.ludokx.jelp.impl.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.ludokx.jelp.LocaleParameters;
import net.ludokx.jelp.Search;
import net.ludokx.jelp.impl.DefaultYelpV2Client;

/**
 * Mock implementation of the Yelp client.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class MockYelpV2Client extends DefaultYelpV2Client {

	/**
	 * Creates a new {@link MockYelpV2Client}
	 */
	public MockYelpV2Client() {
		super("123", "123", "123", "123");
	}
	
	/** {@inheritDoc} */
	@Override
	protected String getSearchResponse(Search aSearch, LocaleParameters someLocaleParameters) {
		// TODO mock content depending on search params and locale params
		return getMockContent("search.json");
	}
	
	/** {@inheritDoc} */
	@Override
	protected String getBusinessResponse(String aBusinessId, LocaleParameters someLocaleParameters) {
		// TODO mock content depending on locale params
		return getMockContent("business.json");
	}
	
	/**
	 * Gets the mock content from the given file.
	 * @param aFilename  The name of the file.
	 * @return  Returns the mock content.
	 */
	protected String getMockContent(String aFilename) {
		InputStream is = getClass().getResourceAsStream("/" + aFilename);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		StringBuilder sb = new StringBuilder(1024);
		try {
			while (null != (line = br.readLine())) {
				sb.append(line);
				sb.append('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString().trim();
	}

}
