package model;

public class AnchorElement extends TagElement{
	
	private String linkText;
	private String urlText;
	
	public AnchorElement(String url , String linkText, String attributes) {
		
		super("a", true, new TextElement(linkText), revisedAttributes(url,attributes));
		this.linkText = linkText;
		this.urlText = urlText;
		
		
		//		a, it will have an end tag , the physical link , attributes
		//the way we store the words that will be the physical link is by creating a 
		//textElement and then making that the parameter for the tagElement and the tagElement 
		//will put that content between the start and middle tag
																			// you can see why we make the linkText a 
																			// text element here so it can be put in middle
		//attributes specific to the anchor element <a href="www.umdcs.com" > linkText </a>  
												// tagName + attributes + url 
	}
	
	private static String revisedAttributes(String url, String attributes) {
		if(attributes ==null || attributes.isEmpty()) {
			return "href=\"" + url + "\"";
		}
		return "href=\"" + url + "\" " + attributes;
	}
	// this method makes the attributes for an anchor element with the url and attributes and so it passes the 
	// public tests we have to have an alternate for if the attributes are null
	public String getLinkText() {
		return linkText;
	}
	public String getUrlText(){
		return urlText;
	}
}
