/**
 * 
 */
package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Center position of map bounds.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
public class Coordinates implements Serializable {

	/**	Holds the <code>serialVersionUID</code> */
	private static final long serialVersionUID = -3766787046205358312L;

	/** region.center.latitude	double	Latitude position of map bounds center */
	private double latitude;
	
	/** region.center.longitude	double	Longitude position of map bounds center */
	private double longitude;
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("[latitude=");
		sb.append(latitude);
		sb.append(";longitude=");
		sb.append(longitude);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Latitude position of map bounds center
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Latitude position of map bounds center
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Longitude position of map bounds center
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Longitude position of map bounds center
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
