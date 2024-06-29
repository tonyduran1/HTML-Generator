package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement{
	
	// Represents a paragraph (<p>) tag. It relies on an *ArrayList* in order to keep track 
	// of the set of Element objects that are part of the paragraph.
	private ArrayList<Element> contentElementList;
	
	public ParagraphElement(String attributes) {
		
		super("p", true, null, attributes);
		contentElementList = new ArrayList<>();
		
	}
	
	public void addItem (Element item) {
		//adds an element to the paragraph 
		contentElementList.add(item);
	}
	
	@Override
	public String genHTML(int indentation) {

		StringBuffer string = new StringBuffer();
		
		for(int i=0 ; i < indentation; i++) {
			string.append(" ");
		}
		string.append(getStartTag());
		
		for(int i = 0; i < contentElementList.size(); i++) {
			string.append(contentElementList.get(i).genHTML(indentation));
		}
		
		string.append(getEndTag());
		
		return string.toString();
		
	}
	// had to make its own genHTML because it has an instance variable that holds many elements 
	// inside the method we go through all the elements of the element list and generate the html for that content 
	// in between the start and end tags
	
}

