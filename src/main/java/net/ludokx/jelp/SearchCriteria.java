package net.ludokx.jelp;

public enum SearchCriteria {

	/** term	string	optional	Search term (e.g. "food", "restaurants"). If term isn't included we search everything. */
	term,
	location,
  /** An optional latitude, longitude parameter can also be specified as a hint to the geocoder to disambiguate the location text.
   * The format for this is defined as: cll=latitude,longitude */
	cll, 
	/** The geographic coordinate format is defined as:
	 * ll=latitude,longitude,accuracy,altitude,altitude_accuracy*/
	ll,
	/** bounds=sw_latitude,sw_longitude|ne_latitude,ne_longitude */
	bounds,
	/** limit	number	optional	Number of business results to return */
	limit,
	/** offset	number	optional	Offset the list of returned business results by this amount */
	offset,
	/** sort	number	optional	Sort mode: 0=Best matched (default), 1=Distance, 2=Highest Rated. If the mode is 1 or 2 a search may retrieve
	 * an additional 20 businesses past the initial limit of the first 20 results.
	 * This is done by specifying an offset and limit of 20. Sort by distance is only supported for a location or geographic search.
	 * The rating sort is not strictly sorted by the rating value, but by an adjusted rating value that takes into account the number of ratings,
	 * similar to a bayesian average. This is so a business with 1 rating of 5 stars doesn't immediately jump to the top. */
	sort,
	/** category_filter	string	optional	Category to filter search results with. See the list of supported categories.
	 * The category filter can be a list of comma delimited categories. For example, 'bars,french' will filter by Bars and French.
	 * The category identifier should be used (for example 'discgolf', not 'Disc Golf'). */
	category_filter,
	/** radius_filter	number	optional	Search radius in meters. If the value is too large, a AREA_TOO_LARGE error may be returned. The max value is 40000 meters (25 miles). */
	radius_filter,
	/** deals_filter	bool	optional	Whether to exclusively search for businesses with deals */
	deals_filter
		
}
