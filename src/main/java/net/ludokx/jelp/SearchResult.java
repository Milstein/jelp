package net.ludokx.jelp;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import net.ludokx.jelp.types.Business;
import net.ludokx.jelp.types.Region;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Instance of a search result with the list of businesses, region and total result count.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 1958331236965415040L;

	/** The list of business entries (see Business) */
	private List<Business> businesses;
	
	/** Suggested bounds in a map to display results in */
	private Region region;
	
	/** Total number of business results */
	private int total;

	/**
	 * The list of business entries (see Business)
	 * @return the businesses
	 */
	public List<Business> getBusinesses() {
		return businesses;
	}

	/**
	 * The list of business entries (see Business)
	 * @param businesses the businesses to set
	 */
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

	/**
	 * Suggested bounds in a map to display results in
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Suggested bounds in a map to display results in
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Total number of business results
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Total number of business results
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
