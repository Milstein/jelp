package net.ludokx.jelp.types;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Type describing the region of a search result.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {

	/** Span of suggested map bounds */
	private CoordinatesDelta span;
	
	/** Center position of map bounds */
	private Coordinates center;
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("Center: ");
		sb.append(center.toString());
		sb.append("\nSpan: ");
		sb.append(span.toString());
		return sb.toString();
	}

	/**
	 * Span of suggested map bounds
	 * @return the span
	 */
	public CoordinatesDelta getSpan() {
		return span;
	}

	/**
	 * Span of suggested map bounds
	 * @param span the span to set
	 */
	public void setSpan(CoordinatesDelta span) {
		this.span = span;
	}

	/**
	 * Center position of map bounds
	 * @return the center
	 */
	public Coordinates getCenter() {
		return center;
	}

	/**
	 * Center position of map bounds
	 * @param center the center to set
	 */
	public void setCenter(Coordinates center) {
		this.center = center;
	}
}
