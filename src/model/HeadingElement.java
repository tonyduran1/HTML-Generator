package model;

public class HeadingElement extends TagElement {

	
	
	public HeadingElement(Element content, int level, String attributes) {
		
		super("h" + level, true, content, attributes);
		
		//     tagName	endTag  content attributes
		// so the heading element tagName is h1 - h6 and it has a endTag and it has a content element for the 
		// elements in between the heading element
		// i would guess that usually only testElements go in between heaingElements
	}
	
	
}
