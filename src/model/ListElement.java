package model;

import java.util.ArrayList;

public class ListElement extends TagElement{
	
	
	//presents the <ul> and the <ol> tags. An ArrayList is used to keep track of the Element objects of the list.
	
	private ArrayList<Element> elementList ;
	
	public ListElement(boolean ordered, String attributes) {
		super(isItOrdered(ordered), true , null , attributes );
		elementList = new ArrayList<>();
	}
	public void addItem(Element Item) {
		elementList.add(Item);
	}
	
	private static String isItOrdered(boolean ordered) {
		// if the parameter is true that mean it is ordered and that the tagName should be ol
		// if the parameter is false that mean it is unordered and that the tagName should be ul
		if(ordered) {
			return "ol";
		}
		return "ul";
	}
	@Override
	public String genHTML(int indentation) {

		StringBuffer string = new StringBuffer();
		
		for(int i=0 ; i < indentation + 1; i++) {
			string.append(" ");
		}
		string.append(getStartTag());
		
		for(int i = 0; i < elementList.size(); i++) {
			
			string.append("\n");
			
			for(int j=0 ; j < indentation + 4 ; j++) {
				string.append(" ");
			}
			
			string.append("<li>\n ");
			
			for(int j=0 ; j < indentation + 4; j++) {
				string.append(" ");
			}
			
			string.append(elementList.get(i).genHTML(indentation));
			
			string.append("\n");
			
			for(int j=0 ; j < indentation + 4; j++) {
				string.append(" ");
			}
			string.append("</li>");
		 
		}
		string.append("\n");
		
		for(int j=0 ; j < indentation + 1; j++) {
			string.append(" ");
		}
		
		string.append(getEndTag());
		
		return string.toString();
		
	}
	// this is how you would write it if spacing mattered for the list 
}
