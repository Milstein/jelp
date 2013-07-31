package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * User who wrote a review.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

	/** Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 4205201994261737627L;

	/** reviews.user.id string User identifier */
	private String id;
	
	/** reviews.user.image_url url User profile image url */
	private String imageUrl;
	
	/** reviews.user.name string User name */
	private String name;

	/**
	 * User identifier
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * User identifier
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * User profile image url
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * User profile image url
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * User name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * User name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
