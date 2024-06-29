package model;

public class TagElement implements Element{
	
	private String tagName;
	private boolean endTag;
	private Element content;
	private String attributes;
	private int id;
	private static int idCounter = 0;
	private static boolean enableID;
	
	 
	
	public TagElement (String tagName, boolean endTag, Element content, String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		id = ++idCounter;
		
	}
	
	public int getId() {
		return id;
	}
	public String getStringId() {
		return tagName + id;
	}
	public String getStartTag() {
		if(enableID == false) {
			if(attributes!=null) {
				return "<" + tagName + " " + attributes + ">" ;
				//		    																	  <p  attributes>
				// if there is not supposed to be an id and there are attributes
			}	
			 return "<" + tagName + ">";
			 //		    																		  <p>
			 // if there is not supposed to be an id system and there is also not attributes
		}
		if(attributes!=null) {
			 return "<" + tagName + " " + "id=" + "\""+ tagName + id +"\" "+ attributes + ">" ;
			//      																			  <p id="p1" attributes>   
			// if there is supposed to be an id and there is supposed to be an attribute as well 
		}
	
		return "<" + tagName + " " + "id=" + "\""+ tagName + id +"\""+ ">" ;
		//    																					  <p id="p1">
		// if there is supposed to be an id system but there is not attributes
	}
	 
	public String genHTML(int indentation) {
		 
			StringBuffer string = new StringBuffer();
			
			for(int i=0 ; i < indentation; i++) {
				string.append(" ");
			}
			string.append(getStartTag());
			// so at this point it added the indentation and then put the string id accordingly
			// so not would we append the content accordingly?
			if(content!=null) {
			string.append(content.genHTML(indentation)); // +1 so its one space away
			// this is the base case meaning if content is null the recursive method is at its end and no more content 
			// to put within the body 
			}
			//by calling this content.genHTML recusivley now I can nest tags and other elements such as:
			// <p> <a href= "www.umdcs.com"> <content> </a> <p>
			
			if(endTag) {
				string.append(getEndTag());
			}
			return string.toString();
			
	}
	public static void enableId(boolean choice) {
	 	enableID = choice;
	}
	public String getEndTag(){
		if(endTag) {
			return "</" + tagName + ">";
		}
		return "";
	}
	public static void resetIds() {
		idCounter = 0;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getAttributes() {
		return attributes;
	}
	public String getTagName() {
		return tagName;
	}
}
