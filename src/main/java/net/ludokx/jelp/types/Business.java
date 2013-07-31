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
 * Type describing a business on Yelp.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Business implements Serializable {

	/** Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 6174297480584542180L;

	/** id string Yelp ID for this business */
	private String id;

	/** name string Name of this business */
	private String name;

	/** is_claimed bool Whether business has been claimed by a business owner */
	private boolean claimed;

	/** is_closed bool Whether business has been (permanently) closed */
	private boolean closed;

	/** image_url string URL of photo for this business */
	private String imageUrl;

	/** url string URL for business page on Yelp */
	private String url;

	/** mobile_url string URL for mobile business page on Yelp */
	private String mobileUrl;

	/** phone string Phone number for this business with international dialing code (e.g. +442079460000) */
	private String phone;

	/** display_phone string Phone number for this business formatted for display */
	private String displayPhone;

	/** review_count number Number of reviews for this business */
	private int reviewCount;

	/** categories list Provides a list of category name, alias pairs that this business is associated with. For example,
	 * [["Local Flavor", "localflavor"], ["Active Life", "active"], ["Mass Media", "massmedia"]]
	 * The alias is provided so you can search with the category_filter. */
	private String[][] categories;

	/** distance number Distance that business is from search location in meters, if a latitude/longitude is specified. */
	private int distance;

	/** rating number Rating for this business (value ranges from 1, 1.5, ... 4.5, 5) */
	private double rating;

	/** rating_img_url string URL to star rating image for this business (size = 84x17) */
	private String ratingImageUrl;

	/** rating_img_url_small string URL to small version of rating image for this business (size = 50x10) */
	private String ratingImageUrlSmall;

	/** rating_img_url_large string URL to large version of rating image for this business (size = 166x30) */
	private String ratingImageUrlLarge;

	/** snippet_text string Snippet text associated with this business */
	private String snippetText;

	/** snippet_image_url string URL of snippet image associated with this business */
	private String snippetImageUrl;

	/** location dict location data for a business. */
	private Location location;

	/** deals list Deal info for this business (optional: this field is present only if there's a Deal) */
	private List<Deal> deals;

	/** gift_certificates list Gift certificate info for this business (optional: this field is present only if there are gift certificates available) */
	private List<GiftCertificate> giftCertificates;

	/** reviews list List of up to 3 review snippets for the business */
	private List<Review> reviews;

	/**
	 * Yelp ID for this business
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Yelp ID for this business
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Name of this business
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name of this business
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Whether business has been claimed by a business owner
	 * @return the claimed
	 */
	@JsonProperty("is_claimed")
	public boolean isClaimed() {
		return claimed;
	}

	/**
	 * Whether business has been claimed by a business owner
	 * @param claimed the claimed to set
	 */
	@JsonProperty("is_claimed")
	public void setClaimed(boolean claimed) {
		this.claimed = claimed;
	}

	/**
	 * Whether business has been (permanently) closed
	 * @return the closed
	 */
	@JsonProperty("is_closed")
	public boolean isClosed() {
		return closed;
	}

	/**
	 * Whether business has been (permanently) closed
	 * @param closed the closed to set
	 */
	@JsonProperty("is_closed")
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	/**
	 * URL of photo for this business
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * URL of photo for this business
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * URL for business page on Yelp
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * URL for business page on Yelp
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * URL for mobile business page on Yelp
	 * @return the mobileUrl
	 */
	public String getMobileUrl() {
		return mobileUrl;
	}

	/**
	 * URL for mobile business page on Yelp
	 * @param mobileUrl the mobileUrl to set
	 */
	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	/**
	 * Phone number for this business with international dialing code (e.g. +442079460000)
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Phone number for this business with international dialing code (e.g. +442079460000)
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Phone number for this business formatted for display
	 * @return the displayPhone
	 */
	public String getDisplayPhone() {
		return displayPhone;
	}

	/**
	 * Phone number for this business formatted for display
	 * @param displayPhone the displayPhone to set
	 */
	public void setDisplayPhone(String displayPhone) {
		this.displayPhone = displayPhone;
	}

	/**
	 * Number of reviews for this business
	 * @return the reviewCount
	 */
	public int getReviewCount() {
		return reviewCount;
	}

	/**
	 * Number of reviews for this business
	 * @param reviewCount the reviewCount to set
	 */
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	/**
	 * Provides a list of category name, alias pairs that this business is associated with. For example, 
	 * [["Local Flavor", "localflavor"], ["Active Life", "active"], ["Mass Media", "massmedia"]] 
	 * The alias is provided so you can search with the category_filter.
	 * @return the categories
	 */
	public String[][] getCategories() {
		return categories;
	}

	/**
	 * Provides a list of category name, alias pairs that this business is associated with. For example, 
	 * [["Local Flavor", "localflavor"], ["Active Life", "active"], ["Mass Media", "massmedia"]] 
	 * The alias is provided so you can search with the category_filter.
	 * @param categories the categories to set
	 */
	public void setCategories(String[][] categories) {
		this.categories = categories;
	}

	/**
	 * Distance that business is from search location in meters, if a latitude/longitude is specified.
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Distance that business is from search location in meters, if a latitude/longitude is specified.
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * Rating for this business (value ranges from 1, 1.5, ... 4.5, 5)
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Rating for this business (value ranges from 1, 1.5, ... 4.5, 5)
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * URL to star rating image for this business (size = 84x17)
	 * @return the ratingImageUrl
	 */
	@JsonProperty("rating_img_url")
	public String getRatingImageUrl() {
		return ratingImageUrl;
	}

	/**
	 * URL to star rating image for this business (size = 84x17)
	 * @param ratingImageUrl the ratingImageUrl to set
	 */
	@JsonProperty("rating_img_url")
	public void setRatingImageUrl(String ratingImageUrl) {
		this.ratingImageUrl = ratingImageUrl;
	}

	/**
	 * URL to small version of rating image for this business (size = 50x10)
	 * @return the ratingImageUrlSmall
	 */
	@JsonProperty("rating_img_url_small")
	public String getRatingImageUrlSmall() {
		return ratingImageUrlSmall;
	}

	/**
	 * URL to small version of rating image for this business (size = 50x10)
	 * @param ratingImageUrlSmall the ratingImageUrlSmall to set
	 */
	@JsonProperty("rating_img_url_small")
	public void setRatingImageUrlSmall(String ratingImageUrlSmall) {
		this.ratingImageUrlSmall = ratingImageUrlSmall;
	}

	/**
	 * URL to large version of rating image for this business (size = 166x30)
	 * @return the ratingImageUrlLarge
	 */
	@JsonProperty("rating_img_url_large")
	public String getRatingImageUrlLarge() {
		return ratingImageUrlLarge;
	}

	/**
	 * URL to large version of rating image for this business (size = 166x30)
	 * @param ratingImageUrlLarge the ratingImageUrlLarge to set
	 */
	@JsonProperty("rating_img_url_large")
	public void setRatingImageUrlLarge(String ratingImageUrlLarge) {
		this.ratingImageUrlLarge = ratingImageUrlLarge;
	}

	/**
	 * Snippet text associated with this business
	 * @return the snippetText
	 */
	public String getSnippetText() {
		return snippetText;
	}

	/**
	 * Snippet text associated with this business
	 * @param snippetText the snippetText to set
	 */
	public void setSnippetText(String snippetText) {
		this.snippetText = snippetText;
	}

	/**
	 * URL of snippet image associated with this business
	 * @return the snippetImageUrl
	 */
	public String getSnippetImageUrl() {
		return snippetImageUrl;
	}

	/**
	 * URL of snippet image associated with this business
	 * @param snippetImageUrl the snippetImageUrl to set
	 */
	public void setSnippetImageUrl(String snippetImageUrl) {
		this.snippetImageUrl = snippetImageUrl;
	}

	/**
	 * Location data for this business
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Location data for this business
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Deal info for this business (optional: this field is present only if there's a Deal)
	 * @return the deals
	 */
	public List<Deal> getDeals() {
		return deals;
	}

	/**
	 * Deal info for this business (optional: this field is present only if there's a Deal)
	 * @param deals the deals to set
	 */
	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	/**
	 * Gift certificate info for this business (optional: this field is present only if there are gift certificates available)
	 * @return the giftCertificates
	 */
	public List<GiftCertificate> getGiftCertificates() {
		return giftCertificates;
	}

	/**
	 * Gift certificate info for this business (optional: this field is present only if there are gift certificates available)
	 * @param giftCertificates the giftCertificates to set
	 */
	public void setGiftCertificates(List<GiftCertificate> giftCertificates) {
		this.giftCertificates = giftCertificates;
	}

	/**
	 * List of up to 3 review snippets for the business
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * List of up to 3 review snippets for the business
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
