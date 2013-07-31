package net.ludokx.jelp;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Description of an error returned after a failed API call.
 * @author Ludovic Galibert (ludokxg@gmail.com)
 */
@XmlRootElement
@JsonRootName(value = "error")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDescription implements Serializable {

	/**	Holds the <code>serialVersionUID</code>. */
	private static final long serialVersionUID = 1867955121240319910L;
	
	/** Holds the logger. */
  private static final Logger LOG = Logger.getLogger(ErrorDescription.class.getName());

	/** Holds the ID of the error. */
	private String id;
	
	/** Holds the text of the error. */
	private String text;
	
	/** Holds the incriminated field of the error. */
	private String field;
	
	/**
	 * Creates a new ErrorDescription.	
	 */
	public ErrorDescription() {
		// do nothing
	}
	
	/**
	 * Creates a new ErrorDescription.
	 * @param aMessage  The message to be used as ID and text.
	 */
	public ErrorDescription(String aMessage) {
		setId(aMessage);
		setText(aMessage);
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonParseException e) {
			LOG.log(Level.SEVERE, "Could not parse search result!", e);
		} catch (JsonMappingException e) {
			LOG.log(Level.SEVERE, "Could not map search result!", e);
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Could not read and convert search result!", e);
		}
		return super.toString();
	}
}
