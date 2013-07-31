/**
 * 
 */
package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Type describing a gift certificate option.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * 
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiftCertificateOption implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 6534223210966836495L;

	/** gift_certificates.options.price number Gift certificate option price (in cents) */
	private double price;
	
	/** gift_certificates.options.formatted_price string Gift certificate option price (formatted, e.g. "$50") */
	private String formattedPrice;

	/**
	 * Gift certificate option price (in cents)
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Gift certificate option price (in cents)
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gift certificate option price (formatted, e.g. "$50")
	 * @return the formattedPrice
	 */
	public String getFormattedPrice() {
		return formattedPrice;
	}

	/**
	 * Gift certificate option price (formatted, e.g. "$50")
	 * @param formattedPrice the formattedPrice to set
	 */
	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}
}
