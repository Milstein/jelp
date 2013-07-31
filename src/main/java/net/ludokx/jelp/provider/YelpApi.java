/**
 * 
 */
package net.ludokx.jelp.provider;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Service Provider for OAuth 1.0a.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 *
 */
public class YelpApi extends DefaultApi10a {

	/* (non-Javadoc)
	 * @see org.scribe.builder.api.DefaultApi10a#getRequestTokenEndpoint()
	 */
	@Override
	public String getRequestTokenEndpoint() {
		// no endpoint
		return null;
	}

	/* (non-Javadoc)
	 * @see org.scribe.builder.api.DefaultApi10a#getAccessTokenEndpoint()
	 */
	@Override
	public String getAccessTokenEndpoint() {
		// no endpoint
		return null;
	}

	/* (non-Javadoc)
	 * @see org.scribe.builder.api.DefaultApi10a#getAuthorizationUrl(org.scribe.model.Token)
	 */
	@Override
	public String getAuthorizationUrl(Token requestToken) {
		// no authorization URL
		return null;
	}

}
