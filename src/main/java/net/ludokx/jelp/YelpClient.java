/**
 * 
 */
package net.ludokx.jelp;

import net.ludokx.jelp.types.Business;

/**
 * Interface to the Yelp API v2.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public interface YelpClient {
	
	/**
	 * Searches for some businesses.
	 * @param aSearch  The search defining what you're looking for.
	 * @return  Returns a list of businesses or an empty list if nothing was found.
	 * @throws YelpException  Throws a {@link YelpException} when an API call is not successful and the Yelp API returns an error description. 
	 */
	SearchResult search(Search aSearch) throws YelpException;
	
	/**
	 * Searches for some businesses.
	 * @param aSearch  The search defining what you're looking for.
	 * @param someLocaleParameters  The locale parameters to filter by country/language.
	 * @return  Returns a list of businesses or an empty list if nothing was found.
	 * @throws YelpException  Throws a {@link YelpException} when an API call is not successful and the Yelp API returns an error description. 
	 */
	SearchResult search(Search aSearch, LocaleParameters someLocaleParameters) throws YelpException;
	
	/**
	 * Gets the business with the given ID.
	 * @param aBusinessId  The business ID, must not be <code>null</code>.
	 * @return  Returns a Business.
	 * @throws YelpException  Throws a {@link YelpException} when an API call is not successful and the Yelp API returns an error description.
	 */
	Business getBusiness(String aBusinessId) throws YelpException;
	
	/**
	 * Gets the business with the given ID.
	 * @param aBusinessId  The business ID, must not be <code>null</code>.
	 * @param someLocaleParameters  The locale parameters to filter by country/language.
	 * @return  Returns a Business.
	 * @throws YelpException  Throws a {@link YelpException} when an API call is not successful and the Yelp API returns an error description.
	 */
	Business getBusiness(String aBusinessId, LocaleParameters someLocaleParameters) throws YelpException;
	
}
