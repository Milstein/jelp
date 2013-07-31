/**
 * 
 */
package net.ludokx.jelp.types;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Type describing a deal.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deal implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = -5465041445296817167L;

	/** deals.id string Deal identifier */
	private String id;
	
	/** deals.title string Deal title */
	private String title;
	
	/** deals.url url Deal url */
	private String url;
	
	/** deals.image_url url Deal image url */
	private String imageUrl;
	
	/** deals.currency_code string ISO_4217 Currency Code */
	private String currencyCode;
	
	/** deals.time_start number Deal start time (Unix timestamp) */
	private long timeStart;
	
	/** deals.time_end number Deal end time (optional: this field is present only if the Deal ends) */
	private long timeEnd;
	
	/** deals.is_popular bool Whether the Deal is popular (optional: this field is present only if true) */
	private boolean popular;
	
	/** deals.what_you_get string Additional details for the Deal, separated by newlines */
	private String details;
	
	/** deals.important_restrictions string Important restrictions for the Deal, separated by newlines */
	private String importantRestrictions;
	
	/** deals.additional_restrictions string Deal additional restrictions */
	private String additionalRestrictions;
	
	/** deals.options list Deal options */
	private List<DealOption> options;

	/**
	 * Deal identifier
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Deal identifier
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Deal title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Deal title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Deal url
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Deal url
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Deal image url
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Deal image url
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * ISO_4217 Currency Code
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * ISO_4217 Currency Code
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Deal start time (Unix timestamp)
	 * @return the timeStart
	 */
	public long getTimeStart() {
		return timeStart;
	}

	/**
	 * Deal start time (Unix timestamp)
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(long timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * Deal end time (optional: this field is present only if the Deal ends)
	 * @return the timeEnd
	 */
	public long getTimeEnd() {
		return timeEnd;
	}

	/**
	 * Deal end time (optional: this field is present only if the Deal ends)
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(long timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * Whether the Deal is popular (optional: this field is present only if true)
	 * @return the popular
	 */
	@JsonProperty("is_popular")
	public boolean isPopular() {
		return popular;
	}

	/**
	 * Whether the Deal is popular (optional: this field is present only if true)
	 * @param popular the popular to set
	 */
	@JsonProperty("is_popular")
	public void setPopular(boolean popular) {
		this.popular = popular;
	}

	/**
	 * Additional details for the Deal, separated by newlines
	 * @return the details
	 */
	@JsonProperty("what_you_get")
	public String getDetails() {
		return details;
	}

	/**
	 * Additional details for the Deal, separated by newlines
	 * @param details the details to set
	 */
	@JsonProperty("what_you_get")
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * Important restrictions for the Deal, separated by newlines
	 * @return the importantRestrictions
	 */
	public String getImportantRestrictions() {
		return importantRestrictions;
	}

	/**
	 * Important restrictions for the Deal, separated by newlines
	 * @param importantRestrictions the importantRestrictions to set
	 */
	public void setImportantRestrictions(String importantRestrictions) {
		this.importantRestrictions = importantRestrictions;
	}

	/**
	 * Deal additional restrictions
	 * @return the additionalRestrictions
	 */
	public String getAdditionalRestrictions() {
		return additionalRestrictions;
	}

	/**
	 * Deal additional restrictions
	 * @param additionalRestrictions the additionalRestrictions to set
	 */
	public void setAdditionalRestrictions(String additionalRestrictions) {
		this.additionalRestrictions = additionalRestrictions;
	}

	/**
	 * Deal options
	 * @return the options
	 */
	public List<DealOption> getOptions() {
		return options;
	}

	/**
	 * Deal options
	 * @param options the options to set
	 */
	public void setOptions(List<DealOption> options) {
		this.options = options;
	}
}
