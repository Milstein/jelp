package net.ludokx.jelp.types;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Type describing the location of a business.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable {
 
	/**	Holds the <code>serialVersionUID</code> */
	private static final long serialVersionUID = -7568936368276640453L;

	/** location.address list Address for this business. Only includes address fields. */
	private List<String> address;
	
	/** location.display_address list Address for this business formatted for display. Includes all address fields, cross streets and city, state_code, etc. */
	private List<String> displayAddress;
	 
	/** location.city string City for this business */
	private String city;
	
	/** location.state_code string ISO 3166-2 state code for this business */
	private String stateCode;
	
	/** location.postal_code string Postal code for this business */
	private String postalCode;
	
	/** location.country_code string ISO 3166-1 country code for this business */
	private String countryCode;
	
	/** location.cross_streets string Cross streets for this business */
	private String crossStreets;
	
	/** location.neighborhoods list List that provides neighborhood(s) information for business */
	private List<String> neighborhoods;

	/**
	 * Address for this business. Only includes address fields.
	 * @return the address
	 */
	public List<String> getAddress() {
		return address;
	}

	/**
	 * Address for this business. Only includes address fields.
	 * @param address the address to set
	 */
	public void setAddress(List<String> address) {
		this.address = address;
	}

	/**
	 * Address for this business formatted for display. Includes all address fields, cross streets and city, state_code, etc.
	 * @return the displayAddress
	 */
	@JsonProperty("display_address")
	public List<String> getDisplayAddress() {
		return displayAddress;
	}

	/**
	 * Address for this business formatted for display. Includes all address fields, cross streets and city, state_code, etc.
	 * @param displayAddress the displayAddress to set
	 */
	@JsonProperty("display_address")
	public void setDisplayAddress(List<String> displayAddress) {
		this.displayAddress = displayAddress;
	}

	/**
	 * City for this business
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * City for this business
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * ISO 3166-2 state code for this business
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * ISO 3166-2 state code for this business
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Postal code for this business
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Postal code for this business
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * ISO 3166-1 country code for this business
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * ISO 3166-1 country code for this business
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Cross streets for this business
	 * @return the crossStreets
	 */
	public String getCrossStreets() {
		return crossStreets;
	}

	/**
	 * Cross streets for this business
	 * @param crossStreets the crossStreets to set
	 */
	public void setCrossStreets(String crossStreets) {
		this.crossStreets = crossStreets;
	}

	/**
	 * List that provides neighborhood(s) information for business
	 * @return the neighborhoods
	 */
	public List<String> getNeighborhoods() {
		return neighborhoods;
	}

	/**
	 * List that provides neighborhood(s) information for business
	 * @param neighborhoods the neighborhoods to set
	 */
	public void setNeighborhoods(List<String> neighborhoods) {
		this.neighborhoods = neighborhoods;
	}
	
}
