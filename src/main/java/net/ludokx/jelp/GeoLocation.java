package net.ludokx.jelp;

/**
 * Object describing a geolocation with latitude, longitude, accuracy, altitude and altitude accuracy.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class GeoLocation {
	
	/** latitude	double	required	Latitude of geo-point to search near */
	private double latitude;
	/** longitude	double	required	Longitude of geo-point to search near */
	private double longitude;
	/** accuracy	double	optional	Accuracy of latitude, longitude */
	private Double accuracy;
	/** altitude	double	optional	Altitude */
	private Double altitude;
	/** altitude_accuracy	double	optional	Accuracy of altitude */
	private Double altitudeAccuracy;
	
	/**
	 * Creates a geolocation.
	 * @param aLatitude  The latitude.
	 * @param aLongitude  The longitude.
	 */
	public GeoLocation(double aLatitude, double aLongitude) {
		setLatitude(aLatitude);
		setLongitude(aLongitude);
	}
	
	/**
	 * Latitude of geo-point to search near
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Latitude of geo-point to search near
	 * @param latitude the latitude to set
	 */
	protected void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * Longitude of geo-point to search near
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Longitude of geo-point to search near
	 * @param longitude the longitude to set
	 */
	protected void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Accuracy of latitude, longitude
	 * @return the accuracy
	 */
	public Double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Accuracy of latitude, longitude
	 * @param accuracy the accuracy to set
	 */
	protected void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * Altitude
	 * @return the altitude
	 */
	public Double getAltitude() {
		return altitude;
	}
	
	/**
	 * Altitude
	 * @param altitude the altitude to set
	 */
	protected void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	/**
	 * Accuracy of altitude
	 * @return the altitudeAccuracy
	 */
	public Double getAltitudeAccuracy() {
		return altitudeAccuracy;
	}
	
	/**
	 * Accuracy of altitude
	 * @param altitudeAccuracy the altitudeAccuracy to set
	 */
	protected void setAltitudeAccuracy(Double altitudeAccuracy) {
		this.altitudeAccuracy = altitudeAccuracy;
	}

	
}
