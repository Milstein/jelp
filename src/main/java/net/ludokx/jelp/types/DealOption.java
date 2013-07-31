package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Type describing deal options.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class DealOption implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 1796977195674240941L;

	/** deals.options.title string Deal option title */
	private String title;
	
	/** deals.options.purchase_url url Deal option url for purchase */
	private String purchaseUrl;
	
	/** deals.options.price number Deal option price (in cents) */
	private double price;
	
	/** deals.options.formatted_price string Deal option price (formatted, e.g. "$6") */
	private String formattedPrice;
	
	/** deals.options.original_price number Deal option original price (in cents) */
	private double originalPrice;
	
	/** deals.options.formatted_original_price string Deal option original price (formatted, e.g. "$12") */
	private String originalFormattedPrice;
	
	/** deals.options.is_quantity_limited bool Whether the deal option is limited or unlimited */
	private boolean quantityLimited;
	
	/** deals.options.remaining_count number The remaining deal options available for purchase (optional: this field is only present if the deal is limited) */
	private int remainingCount;

	/**
	 * Deal option title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Deal option title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Deal option url for purchase
	 * @return the purchaseUrl
	 */
	public String getPurchaseUrl() {
		return purchaseUrl;
	}

	/**
	 * Deal option url for purchase
	 * @param purchaseUrl the purchaseUrl to set
	 */
	public void setPurchaseUrl(String purchaseUrl) {
		this.purchaseUrl = purchaseUrl;
	}

	/**
	 * Deal option price (in cents)
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Deal option price (in cents)
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Deal option price (formatted, e.g. "$6")
	 * @return the formattedPrice
	 */
	public String getFormattedPrice() {
		return formattedPrice;
	}

	/**
	 * Deal option price (formatted, e.g. "$6")
	 * @param formattedPrice the formattedPrice to set
	 */
	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}

	/**
	 * Deal option original price (in cents)
	 * @return the originalPrice
	 */
	public double getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * Deal option original price (in cents)
	 * @param originalPrice the originalPrice to set
	 */
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	/**
	 * Deal option original price (formatted, e.g. "$12")
	 * @return the originalFormattedPrice
	 */
	public String getOriginalFormattedPrice() {
		return originalFormattedPrice;
	}

	/**
	 * Deal option original price (formatted, e.g. "$12")
	 * @param originalFormattedPrice the originalFormattedPrice to set
	 */
	public void setOriginalFormattedPrice(String originalFormattedPrice) {
		this.originalFormattedPrice = originalFormattedPrice;
	}

	/**
	 * Whether the deal option is limited or unlimited
	 * @return the quantityLimited
	 */
	@JsonProperty("is_quantity_limited")
	public boolean isQuantityLimited() {
		return quantityLimited;
	}

	/**
	 * Whether the deal option is limited or unlimited
	 * @param quantityLimited the quantityLimited to set
	 */
	@JsonProperty("is_quantity_limited")
	public void setQuantityLimited(boolean quantityLimited) {
		this.quantityLimited = quantityLimited;
	}

	/**
	 * The remaining deal options available for purchase (optional: this field is only present if the deal is limited)
	 * @return the remainingCount
	 */
	public int getRemainingCount() {
		return remainingCount;
	}

	/**
	 * The remaining deal options available for purchase (optional: this field is only present if the deal is limited)
	 * @param remainingCount the remainingCount to set
	 */
	public void setRemainingCount(int remainingCount) {
		this.remainingCount = remainingCount;
	}
	
}
