/**
 * 
 */
package net.ludokx.jelp.impl;

import static net.ludokx.jelp.SearchCriteria.bounds;
import static net.ludokx.jelp.SearchCriteria.category_filter;
import static net.ludokx.jelp.SearchCriteria.cll;
import static net.ludokx.jelp.SearchCriteria.deals_filter;
import static net.ludokx.jelp.SearchCriteria.limit;
import static net.ludokx.jelp.SearchCriteria.ll;
import static net.ludokx.jelp.SearchCriteria.location;
import static net.ludokx.jelp.SearchCriteria.offset;
import static net.ludokx.jelp.SearchCriteria.radius_filter;
import static net.ludokx.jelp.SearchCriteria.sort;
import static net.ludokx.jelp.SearchCriteria.term;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.ludokx.jelp.ErrorDescription;
import net.ludokx.jelp.LocaleParameters;
import net.ludokx.jelp.Search;
import net.ludokx.jelp.SearchResult;
import net.ludokx.jelp.YelpClient;
import net.ludokx.jelp.YelpException;
import net.ludokx.jelp.provider.YelpApi;
import net.ludokx.jelp.types.Business;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Default implementation of the YelpClient to use the Yelp API v2.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class DefaultYelpV2Client implements YelpClient {
	
	/** Holds the search endpoint. */
	public static final String API_ENDPOINT = "http://api.yelp.com/v2";
	
	/** Holds the OAuthService. */
	private OAuthService service;
	
	/** Holds the access token. */
  private Token accessToken;
  
  /** Holds the object mapper. */
  private ObjectMapper mapper;
  
  /** Holds the logger. */
  private static final Logger LOG = Logger.getLogger(DefaultYelpV2Client.class.getName());

  /**
   * Setup the Yelp API OAuth credentials.
   *
   * OAuth credentials are available from the developer site, under Manage API access (version 2 API).
   *
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public DefaultYelpV2Client(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(YelpApi.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /** {@inheritDoc} */
	@Override
	public SearchResult search(Search aSearch) throws YelpException {
		return search(aSearch, null);
	}
	
	/** {@inheritDoc} */
	@Override
	public SearchResult search(Search aSearch, LocaleParameters someLocaleParameters) throws YelpException {
		String body = getSearchResponse(aSearch, someLocaleParameters);
    try {
			SearchResult result = getMapper().readValue(body, SearchResult.class);
			return result;
		} catch (JsonParseException e) {
			LOG.log(Level.SEVERE, "Could not parse search result!", e);
		} catch (JsonMappingException e) {
			LOG.log(Level.SEVERE, "Could not map search result!", e);
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Could not read and convert search result!", e);
		}
		return null;
	}
	
	/**
	 * Builds the resource URL. The values will be concatenated, '/' will not be prepended before each value.
	 * @param someSubPaths  Some sub paths, must contain at least one element.
	 * @return  Returns the API resource URL.
	 */
	protected String buildApiResourceUrl(String... someSubPaths) {
		assert null != someSubPaths && someSubPaths.length > 0;
		StringBuilder sb = new StringBuilder(128);
		sb.append(API_ENDPOINT);
		for (String s : someSubPaths) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	/**
	 * Gets the search response as string.
	 * @param aSearch  The search.
	 * @param someLocaleParameters  The locale parameters to filter by country/language.
	 * @return  Returns the response as string, can be <code>null</code> if the request was not successful.
	 */
	protected String getSearchResponse(Search aSearch, LocaleParameters someLocaleParameters) throws YelpException {
		OAuthRequest request = new OAuthRequest(Verb.GET, buildApiResourceUrl("/search"));
		fillSearchCriteria(request, aSearch);
		fillLocaleParameters(request, someLocaleParameters);
    
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    if (200 == response.getCode()) {
    	String body = response.getBody();
    	if (LOG.isLoggable(Level.FINE)) {
      	LOG.fine("Search result:\n" + body);
      }
    	return body;
    }
    LOG.severe("Search " + aSearch + " could not be processed, status code: "
    		+ response.getCode() + "\n" + response.getMessage() + "\n" + response.getBody());
    throw new YelpException(getError(response));
	}
	
	/**
	 * Gets the error description from the given response.
	 * @param aResponse  
	 * @return
	 */
	protected ErrorDescription getError(Response aResponse) {
		ErrorDescription error = null;
		if (null != aResponse.getBody()) {
    	try {
    		ObjectMapper mapper = new ObjectMapper();
    		mapper.configure(Feature.UNWRAP_ROOT_VALUE, true);
				error = mapper.readValue(aResponse.getBody(), ErrorDescription.class);
			} catch (JsonParseException e) {
				LOG.log(Level.SEVERE, "Could not parse search result!", e);
			} catch (JsonMappingException e) {
				LOG.log(Level.SEVERE, "Could not map search result!", e);
			} catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read and convert search result!", e);
			}
    }
		if (null == error) {
    	error = new ErrorDescription(aResponse.getMessage());
    }
		return error;
	}
	
	/**
	 * Fills the OAuthRequest with the given search criteria as query parameters.
	 * @param aRequest  The OAuthRequest to fill with the search criteria.
	 * @param aSearch  The Search object containing the search criteria.
	 */
	protected void fillSearchCriteria(OAuthRequest aRequest, Search aSearch) {
		if (null != aSearch.getTerm()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search term: " + aSearch.getTerm());
			}
			aRequest.addQuerystringParameter(term.name(), aSearch.getTerm());
		}
		if (null != aSearch.getLimit()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search limit: " + aSearch.getLimit());
			}
			aRequest.addQuerystringParameter(limit.name(), aSearch.getLimit().toString());
		}
		if (null != aSearch.getOffset()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search offset: " + aSearch.getOffset());
			}
			aRequest.addQuerystringParameter(offset.name(), aSearch.getOffset().toString());
		}
		if (null != aSearch.getSort()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search sort: " + aSearch.getSort());
			}
			aRequest.addQuerystringParameter(sort.name(), aSearch.getSort().toString());
		}
		if (null != aSearch.getCategoryFilter()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search category filter: " + aSearch.getCategoryFilter());
			}
			aRequest.addQuerystringParameter(category_filter.name(), aSearch.getCategoryFilter().toString());
		}
		if (null != aSearch.getRadiusFilter()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search radius filter: " + aSearch.getRadiusFilter());
			}
			aRequest.addQuerystringParameter(radius_filter.name(), aSearch.getRadiusFilter().toString());
		}
		if (null != aSearch.isDealsFilter()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search deal filter: " + aSearch.isDealsFilter());
			}
			aRequest.addQuerystringParameter(deals_filter.name(), aSearch.isDealsFilter().toString());
		}
		if (null != aSearch.getLocation()) {
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search location: " + aSearch.getLocation());
			}
			aRequest.addQuerystringParameter(location.name(), aSearch.getLocation());
    }
		if (null != aSearch.getGeolocation()) {
			StringBuilder sb = new StringBuilder(128);
			sb.append(aSearch.getGeolocation().getLatitude());
			sb.append(',');
			sb.append(aSearch.getGeolocation().getLongitude());
			if (null == aSearch.getLocation()) { // use the full geo if available
				if (null != aSearch.getGeolocation().getAccuracy()) {
					sb.append(',');
					sb.append(aSearch.getGeolocation().getAccuracy());
					if (null != aSearch.getGeolocation().getAltitude()) {
						sb.append(',');
						sb.append(aSearch.getGeolocation().getAltitude());
						if (null != aSearch.getGeolocation().getAltitudeAccuracy()) {
							sb.append(',');
							sb.append(aSearch.getGeolocation().getAltitudeAccuracy());
						}
					}
				}
			}
			String geo = sb.toString();
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search geolocation: " + geo);
			}
			aRequest.addQuerystringParameter(null != aSearch.getLocation() ? cll.name() : ll.name(), geo);
		}
		if (null != aSearch.getLocationBounds()) {
			StringBuilder sb = new StringBuilder(128);
			sb.append(aSearch.getLocationBounds().getSouthWestLatitude());
			sb.append(',');
			sb.append(aSearch.getLocationBounds().getSouthWestLongitude());
			sb.append('|');
			sb.append(aSearch.getLocationBounds().getNorthEastLatitude());
			sb.append(',');
			sb.append(aSearch.getLocationBounds().getNorthEastLongitude());
			String locationBounds = sb.toString();
			if (LOG.isLoggable(Level.INFO)) {
				LOG.info("Setting search location bounds: " + locationBounds);
			}
			aRequest.addQuerystringParameter(bounds.name(), locationBounds);
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public Business getBusiness(String aBusinessId) throws YelpException {
		return getBusiness(aBusinessId, null);
	}

	/** {@inheritDoc} */
	@Override
	public Business getBusiness(String aBusinessId, LocaleParameters someLocaleParameters) throws YelpException {
		String body = getBusinessResponse(aBusinessId, someLocaleParameters);
    if (null != body) {
	    try {
				Business result = getMapper().readValue(body, Business.class);
				return result;
			} catch (JsonParseException e) {
				LOG.log(Level.SEVERE, "Could not parse search result!", e);
			} catch (JsonMappingException e) {
				LOG.log(Level.SEVERE, "Could not map search result!", e);
			} catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read and convert search result!", e);
			}
    }
    return null;
	}
	
	/**
	 * Gets the business retrieval response as string.
	 * @param aBusinessId  The business ID, must not be <code>null</code>.
	 * @param someLocaleParameters  The locale parameters to filter by country/language.
	 * @return  Returns the response as string, can be <code>null</code> if the request was not successful.
	 */
	protected String getBusinessResponse(String aBusinessId, LocaleParameters someLocaleParameters) throws YelpException {
		OAuthRequest request = new OAuthRequest(Verb.GET, buildApiResourceUrl("/business/", aBusinessId));
		fillLocaleParameters(request, someLocaleParameters);
		
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    if (200 == response.getCode()) {
    	String body = response.getBody();
    	if (LOG.isLoggable(Level.FINE)) {
      	LOG.fine("Business retrieved:\n" + body);
      }
    	return body;
    }
    LOG.severe("Business " + aBusinessId + " could not be retrieved, status code: "
    		+ response.getCode() + "\n" + response.getMessage() + "\n" + response.getBody());
    throw new YelpException(getError(response));
	}
	
	/**
	 * Fills the OAuthRequest with the given search criteria as query parameters.
	 * @param aRequest  The OAuthRequest to fill with the search criteria.
	 * @param someLocaleParameters  The locale parameters to filter by country/language.
	 */
	protected void fillLocaleParameters(OAuthRequest aRequest, LocaleParameters someLocaleParameters) {
		if (null != someLocaleParameters) {
			if (null != someLocaleParameters.getCountryCode()) {
				if (LOG.isLoggable(Level.FINER)) {
					LOG.finer("Setting country code parameter: " + someLocaleParameters.getCountryCode());
				}
				aRequest.addQuerystringParameter("cc", someLocaleParameters.getCountryCode());
			}
			if (null != someLocaleParameters.getLanguage()) {
				if (LOG.isLoggable(Level.FINER)) {
					LOG.finer("Setting language parameter: " + someLocaleParameters.getLanguage());
				}
				aRequest.addQuerystringParameter("lang", someLocaleParameters.getLanguage());
			}
			if (null != someLocaleParameters.isFilterByLanguage()) {
				if (LOG.isLoggable(Level.FINER)) {
					LOG.finer("Setting language filter parameter: " + someLocaleParameters.isFilterByLanguage());
				}
				aRequest.addQuerystringParameter("lang_filter", someLocaleParameters.isFilterByLanguage().toString());
			}
		}
	}
	
	/**
	 * Gets the object mapper.
	 * @return  Returns the object mapper.
	 */
	protected ObjectMapper getMapper() {
		if (null == this.mapper) {
			this.mapper = createMapper();
		}
		return this.mapper;
	}
	
	/**
   * Creates and configures the object mapper to use to map responses to java objects.
   * @return  Returns an ObjectMapper.
   */
  protected ObjectMapper createMapper() {
  	ObjectMapper retVal = new ObjectMapper();
  	retVal.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
  	return retVal;
  }

}
