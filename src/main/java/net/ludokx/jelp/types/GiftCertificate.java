/**
 * 
 */
package net.ludokx.jelp.types;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Type describing a gift certificate for a business.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * 
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class GiftCertificate implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = -7941135364989629992L;

	/** gift_certificates.id string Gift certificate identifier */
	private String id;
	
	/** gift_certificates.url url Gift certificate landing page url */
	private String url;
	
	/** gift_certificates.image_url url Gift certificate image url */
	private String imageUrl;
	
	/** gift_certificates.currency_code string ISO_4217 Currency Code */
	private String currencyCode;
	
	/** gift_certificates.unused_balances string Whether unused balances are returned as cash or store credit */
	private String unusedBalances;
	
	/** gift_certificates.options list Gift certificate options */
	private List<GiftCertificateOption> options;

	/**
	 * Gift certificate identifier
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gift certificate identifier
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gift certificate landing page url
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gift certificate landing page url
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gift certificate image url
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Gift certificate image url
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * ISO_4217 Currency Code<br>
	 * http://en.wikipedia.org/wiki/ISO_4217
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * ISO_4217 Currency Code<br>
	 * http://en.wikipedia.org/wiki/ISO_4217
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Whether unused balances are returned as cash or store credit
	 * @return the unusedBalances
	 */
	public String getUnusedBalances() {
		return unusedBalances;
	}

	/**
	 * Whether unused balances are returned as cash or store credit
	 * @param unusedBalances the unusedBalances to set
	 */
	public void setUnusedBalances(String unusedBalances) {
		this.unusedBalances = unusedBalances;
	}

	/**
	 * Gift certificate options
	 * @return the options
	 */
	public List<GiftCertificateOption> getOptions() {
		return options;
	}

	/**
	 * Gift certificate options
	 * @param options the options to set
	 */
	public void setOptions(List<GiftCertificateOption> options) {
		this.options = options;
	}
}
