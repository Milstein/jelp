package net.ludokx.jelp;

/**
 * The search criteria.
 * 
 * @author Ludovic Galibert (ludokxg@gmail.com)
 * 
 */
public class Search {

	/** term string optional Search term (e.g. "food", "restaurants"). If term isn't included we search everything. */
	private String term;
	/** limit number optional Number of business results to return */
	private Integer limit;
	/** offset number optional Offset the list of returned business results by this amount */
	private Integer offset;
	/** sort number optional Sort mode: 0=Best matched (default), 1=Distance,
	 * 2=Highest Rated. If the mode is 1 or 2 a search may retrieve an additional
	 * 20 businesses past the initial limit of the first 20 results. This is done
	 * by specifying an offset and limit of 20. Sort by distance is only supported
	 * for a location or geographic search. The rating sort is not strictly sorted
	 * by the rating value, but by an adjusted rating value that takes into
	 * account the number of ratings, similar to a bayesian average. This is so a
	 * business with 1 rating of 5 stars doesn't immediately jump to the top.  */
	private Short sort;
	/** category_filter string optional Category to filter search results with.
	 * See the list of supported categories. The category filter can be a list of
	 * comma delimited categories. For example, 'bars,french' will filter by Bars and French.
	 * The category identifier should be used (for example 'discgolf', not 'Disc Golf'). */
	private String categoryFilter;
	/** radius_filter number optional Search radius in meters. If the value is too large,
	 * a AREA_TOO_LARGE error may be returned. The max value is 40000 meters (25 miles). */
	private Integer radiusFilter;
	/** deals_filter bool optional Whether to exclusively search for businesses with */
	private Boolean dealsFilter;
	
	/** The city location. */
	private String location;
	
	/** The geolocation coordinates. */
	private GeoBounds locationBounds;
	
	/** The geolocation coordinates. */
	private GeoLocation geolocation;
	

	/**
	 * Creates a new general SearchCriteria.
	 */
	public Search() {
		// do nothing
	}

	/**
	 * Creates a new SearchCriteria with the given search term.
	 * 
	 * @param aTerm
	 *          The search term.
	 */
	public Search(String aTerm) {
		setTerm(aTerm);
	}
	
	/**
	 * Creates a new SearchCriteria with the given search term.
	 * 
	 * @param aTerm
	 *          The search term.
	 * @param aLocation  The search location.          
	 */
	public Search(String aTerm, String aLocation) {
		this(aTerm);
		setLocation(aLocation);
	}
	
	/**
	 * Search term (e.g. "food", "restaurants"). If term isn't included we search everything.
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * Search term (e.g. "food", "restaurants"). If term isn't included we search everything.
	 * @param term  the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * The city location.
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * The city location.
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Number of business results to return
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * Number of business results to return
	 * @param limit  the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * Offset the list of returned business results by this amount
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * Offset the list of returned business results by this amount
	 * @param offset  the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * sort number optional Sort mode: 0=Best matched (default), 1=Distance,
	 * 2=Highest Rated. If the mode is 1 or 2 a search may retrieve an additional
	 * 20 businesses past the initial limit of the first 20 results. This is done
	 * by specifying an offset and limit of 20. Sort by distance is only supported
	 * for a location or geographic search. The rating sort is not strictly sorted
	 * by the rating value, but by an adjusted rating value that takes into
	 * account the number of ratings, similar to a bayesian average. This is so a
	 * business with 1 rating of 5 stars doesn't immediately jump to the top.
	 * @return the sort
	 */
	public Short getSort() {
		return sort;
	}

	/**
	 * sort number optional Sort mode: 0=Best matched (default), 1=Distance,
	 * 2=Highest Rated. If the mode is 1 or 2 a search may retrieve an additional
	 * 20 businesses past the initial limit of the first 20 results. This is done
	 * by specifying an offset and limit of 20. Sort by distance is only supported
	 * for a location or geographic search. The rating sort is not strictly sorted
	 * by the rating value, but by an adjusted rating value that takes into
	 * account the number of ratings, similar to a bayesian average. This is so a
	 * business with 1 rating of 5 stars doesn't immediately jump to the top.
	 * @param sort  the sort to set
	 */
	public void setSort(Short sort) {
		this.sort = sort;
	}

	/**
	 * category_filter string optional Category to filter search results with.
	 * See the list of supported categories. The category filter can be a list of
	 * comma delimited categories. For example, 'bars,french' will filter by Bars and French.
	 * The category identifier should be used (for example 'discgolf', not 'Disc Golf').
	 * @return the categoryFilter
	 */
	public String getCategoryFilter() {
		return categoryFilter;
	}

	/**
	 * category_filter string optional Category to filter search results with.
	 * See the list of supported categories. The category filter can be a list of
	 * comma delimited categories. For example, 'bars,french' will filter by Bars and French.
	 * The category identifier should be used (for example 'discgolf', not 'Disc Golf').
	 * @param categoryFilter  the categoryFilter to set
	 */
	public void setCategoryFilter(String categoryFilter) {
		this.categoryFilter = categoryFilter;
	}

	/**
	 * radius_filter number optional Search radius in meters. If the value is too large,
	 * a AREA_TOO_LARGE error may be returned. The max value is 40000 meters (25 miles).
	 * @return the radiusFilter
	 */
	public Integer getRadiusFilter() {
		return radiusFilter;
	}

	/**
	 * radius_filter number optional Search radius in meters. If the value is too large,
	 * a AREA_TOO_LARGE error may be returned. The max value is 40000 meters (25 miles).
	 * @param radiusFilter  the radiusFilter to set
	 */
	public void setRadiusFilter(Integer radiusFilter) {
		this.radiusFilter = radiusFilter;
	}

	/**
	 * deals_filter bool optional Whether to exclusively search for businesses with
	 * @return the dealsFilter
	 */
	public Boolean isDealsFilter() {
		return dealsFilter;
	}

	/**
	 * deals_filter bool optional Whether to exclusively search for businesses with
	 * @param dealsFilter  the dealsFilter to set
	 */
	public void setDealsFilter(Boolean dealsFilter) {
		this.dealsFilter = dealsFilter;
	}

	/**
	 * The geolocation bounds.
	 * @return the locationBounds
	 */
	public GeoBounds getLocationBounds() {
		return locationBounds;
	}

	/**
	 * The geolocation bounds.
	 * @param locationBounds the locationBounds to set
	 */
	public void setLocationBounds(GeoBounds locationBounds) {
		this.locationBounds = locationBounds;
	}

	/**
	 * The geolocation coordinates.
	 * @return the geolocation
	 */
	public GeoLocation getGeolocation() {
		return geolocation;
	}

	/**
	 * The geolocation coordinates.
	 * @param geolocation the geolocation to set
	 */
	public void setGeolocation(GeoLocation geolocation) {
		this.geolocation = geolocation;
	}

}
