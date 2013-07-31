package net.ludokx.jelp;

/**
 * Locale parameters to be used in a search or to retrieve a business.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class LocaleParameters {

	/** cc	 string	 optional	ISO 3166-1 alpha-2 country code.
	 * Default country to use when parsing the location field. United States = US, Canada = CA, United Kingdom = GB (not UK). */
	private String countryCode;
	
	/** lang	string	optional	ISO 639 language code (default=en). Reviews written in the specified language will be shown. */
	private String language;
	
	/** lang_filter	bool	optional	Whether to filter business reviews by the specified lang */
	private Boolean filterByLanguage;
	
	/**
	 * ISO 3166-1 alpha-2 country code.
	 * Default country to use when parsing the location field. United States = US, Canada = CA, United Kingdom = GB (not UK).
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * ISO 3166-1 alpha-2 country code.
	 * Default country to use when parsing the location field. United States = US, Canada = CA, United Kingdom = GB (not UK).
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * ISO 639 language code (default=en). Reviews written in the specified language will be shown.
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * ISO 639 language code (default=en). Reviews written in the specified language will be shown.
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Whether to filter business reviews by the specified lang
	 * @return the filterByLanguage
	 */
	public Boolean isFilterByLanguage() {
		return filterByLanguage;
	}
	
	/**
	 * Whether to filter business reviews by the specified lang
	 * @param filterByLanguage the filterByLanguage to set
	 */
	public void setFilterByLanguage(Boolean filterByLanguage) {
		this.filterByLanguage = filterByLanguage;
	}
	
}
