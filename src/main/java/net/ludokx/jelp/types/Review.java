package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Rating review.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review implements Serializable {

	/** Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = -7650779912665115443L;

	/** reviews.id string Review identifier */
	private String id;
	
	/** reviews.rating number Rating from 1-5 */
	private short rating;
	
	/** reviews.rating_image_url url URL to star rating image for this business (size = 84x17) */
	private String ratingImageUrl;
	
	/** reviews.rating_image_small_url url URL to small version of rating image for this business (size = 50x10) */
	private String ratingImageSmallUrl;
	
	/** reviews.rating_image_large_url url URL to large version of rating image for this business (size = 166x30) */
	private String ratingImageLargeUrl;
	
	/** reviews.excerpt string Review excerpt */
	private String excerpt;
	
	/** reviews.time_created number Time created (Unix timestamp) */
	private long createdTime;
	
	/** reviews.user dict User who wrote the review */
	private User user;

	/**
	 * Review identifier
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Review identifier
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Rating from 1-5
	 * @return the rating
	 */
	public short getRating() {
		return rating;
	}

	/**
	 * Rating from 1-5
	 * @param rating the rating to set
	 */
	public void setRating(short rating) {
		this.rating = rating;
	}

	/**
	 * URL to star rating image for this business (size = 84x17)
	 * @return the ratingImageUrl
	 */
	public String getRatingImageUrl() {
		return ratingImageUrl;
	}

	/**
	 * URL to star rating image for this business (size = 84x17)
	 * @param ratingImageUrl the ratingImageUrl to set
	 */
	public void setRatingImageUrl(String ratingImageUrl) {
		this.ratingImageUrl = ratingImageUrl;
	}

	/**
	 * URL to small version of rating image for this business (size = 50x10)
	 * @return the ratingImageSmallUrl
	 */
	public String getRatingImageSmallUrl() {
		return ratingImageSmallUrl;
	}

	/**
	 * URL to small version of rating image for this business (size = 50x10)
	 * @param ratingImageSmallUrl the ratingImageSmallUrl to set
	 */
	public void setRatingImageSmallUrl(String ratingImageSmallUrl) {
		this.ratingImageSmallUrl = ratingImageSmallUrl;
	}

	/**
	 * URL to large version of rating image for this business (size = 166x30)
	 * @return the ratingImageLargeUrl
	 */
	public String getRatingImageLargeUrl() {
		return ratingImageLargeUrl;
	}

	/**
	 * URL to large version of rating image for this business (size = 166x30)
	 * @param ratingImageLargeUrl the ratingImageLargeUrl to set
	 */
	public void setRatingImageLargeUrl(String ratingImageLargeUrl) {
		this.ratingImageLargeUrl = ratingImageLargeUrl;
	}

	/**
	 * Review excerpt
	 * @return the excerpt
	 */
	public String getExcerpt() {
		return excerpt;
	}

	/**
	 * Review excerpt
	 * @param excerpt the excerpt to set
	 */
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	/**
	 * Time created (Unix timestamp)
	 * @return the createdTime
	 */
	@JsonProperty("time_created")
	public long getCreatedTime() {
		return createdTime;
	}

	/**
	 * Time created (Unix timestamp)
	 * @param createdTime the createdTime to set
	 */
	@JsonProperty("time_created")
	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * User who wrote the review
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * User who wrote the review
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
