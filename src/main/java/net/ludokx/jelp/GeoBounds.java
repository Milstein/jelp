package net.ludokx.jelp;

/**
 * Geo bounds for the search.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class GeoBounds {
	
	/**	sw_latitude	double	required	Southwest latitude of bounding box */
	private double southWestLatitude;
	/** sw_longitude	double	required	Southwest longitude of bounding box */
	private double southWestLongitude;
	/** ne_latitude	double	required	Northeast latitude of bounding box */
	private double northEastLatitude;
	/** ne_longitude	double	required	Northeast longitude of bounding box */
	private double northEastLongitude;
	
	/**
	 * Creates a new GeoBounds.
	 * @param aNorthEastLatitude  The north east latitude.
	 * @param aNorthEastLongitude  The north east longitude.
	 * @param aSouthWestLatitude  The south west latitude.
	 * @param aSouthWestLongitude  The south west latitude.
	 */
	public GeoBounds(double aNorthEastLatitude, double aNorthEastLongitude, double aSouthWestLatitude, double aSouthWestLongitude) {
		setNorthEastLatitude(aNorthEastLatitude);
		setNorthEastLongitude(aNorthEastLongitude);
		setSouthWestLatitude(aSouthWestLatitude);
		setSouthWestLongitude(aSouthWestLongitude);
	}
	
	/**
	 * Southwest latitude of bounding box
	 * @return the southWestLatitude
	 */
	public double getSouthWestLatitude() {
		return southWestLatitude;
	}
	
	/**
	 * Southwest latitude of bounding box
	 * @param southWestLatitude the southWestLatitude to set
	 */
	protected void setSouthWestLatitude(double southWestLatitude) {
		this.southWestLatitude = southWestLatitude;
	}
	
	/**
	 * Southwest longitude of bounding box
	 * @return the southWestLongitude
	 */
	public double getSouthWestLongitude() {
		return southWestLongitude;
	}
	
	/**
	 * Southwest longitude of bounding box
	 * @param southWestLongitude the southWestLongitude to set
	 */
	protected void setSouthWestLongitude(double southWestLongitude) {
		this.southWestLongitude = southWestLongitude;
	}
	
	/**
	 * Northeast latitude of bounding box
	 * @return the northEastLatitude
	 */
	public double getNorthEastLatitude() {
		return northEastLatitude;
	}
	
	/**
	 * Northeast latitude of bounding box
	 * @param northEastLatitude the northEastLatitude to set
	 */
	protected void setNorthEastLatitude(double northEastLatitude) {
		this.northEastLatitude = northEastLatitude;
	}
	
	/**
	 * Northeast longitude of bounding box
	 * @return the northEastLongitude
	 */
	public double getNorthEastLongitude() {
		return northEastLongitude;
	}
	
	/**
	 * Northeast longitude of bounding box
	 * @param northEastLongitude the northEastLongitude to set
	 */
	protected void setNorthEastLongitude(double northEastLongitude) {
		this.northEastLongitude = northEastLongitude;
	}
}
