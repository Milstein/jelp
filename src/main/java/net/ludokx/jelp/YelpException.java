/**
 * 
 */
package net.ludokx.jelp;

/**
 * Exception thrown when an API call is not successful and the Yelp API returns an error description.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
public class YelpException extends Exception {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 3893849650837096952L;
	
	/** Holds the error description. */
	private ErrorDescription error;

	/**
	 * Creates a new YelpException.
	 * @param anError  The error description, must not be <code>null</code>.
	 */
	public YelpException(ErrorDescription anError) {
		super(anError.getText());
		setError(anError);
	}

	/**
	 * @return the error
	 */
	public ErrorDescription getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	protected void setError(ErrorDescription error) {
		this.error = error;
	}
}
