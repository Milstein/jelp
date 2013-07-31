/**
 * 
 */
package net.ludokx.jelp.types;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Span of suggested map bounds.<br>
 * Make sure to configure the ObjectMapper using "setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)"
 * since we're using Java Bean names and not C-style names.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
public class CoordinatesDelta implements Serializable {

	/**	Holds the <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4910682203526733614L;

	/** region.span.latitude_delta	double	Latitude width of map bounds */
	private double latitudeDelta;
	
	/** region.span.longitude_delta	double	Longitude height of map bounds */
	private double longitudeDelta;
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("[latitudeDelta=");
		sb.append(latitudeDelta);
		sb.append(";longitudeDelta=");
		sb.append(longitudeDelta);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Latitude width of map bounds
	 * @return the latitudeDelta
	 */
	public double getLatitudeDelta() {
		return latitudeDelta;
	}

	/**
	 * Latitude width of map bounds
	 * @param latitudeDelta the latitudeDelta to set
	 */
	public void setLatitudeDelta(double latitudeDelta) {
		this.latitudeDelta = latitudeDelta;
	}

	/**
	 * Longitude height of map bounds
	 * @return the longitudeDelta
	 */
	public double getLongitudeDelta() {
		return longitudeDelta;
	}

	/**
	 * Longitude height of map bounds
	 * @param longitudeDelta the longitudeDelta to set
	 */
	public void setLongitudeDelta(double longitudeDelta) {
		this.longitudeDelta = longitudeDelta;
	}
}
