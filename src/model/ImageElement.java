package model;

public class ImageElement extends TagElement {

	
	 
	
	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, null, imageAttributes(imageURL,width,height,alt,attributes));
		 
		
	}

	private static String imageAttributes(String imageURL, int width, int height, String alt, String attributes) {
		
		if(!(attributes==null || attributes.isBlank())) {
			return  "src=\"" + imageURL + "\" width=\"" + width + "\" height=\"" + height + " " + attributes; 	
		}// if the attributes is existing it will concatenate on the end and then set the attribute to the image version
		else {
		return "src=\"" + imageURL + "\" width=\"" + width + "\" height=\"" + height + "\" alt=\"" + alt + "\"";
		}
	// we could not use this method if it was not static why is that
		// that is because 
	// the point of this method is to take the original parameters to build the attributes section for the tagElement 
		// that is specific to the image. it makes a string that then serves as the real attributes
		
		
	}
}
