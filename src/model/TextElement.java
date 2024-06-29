package model;

public class TextElement implements Element {
	
	
	private String text;
	
	 
	public TextElement(String text) {
		this.text = text;
	}
	public String genHTML(int indentation){
		StringBuffer string = new StringBuffer();
		for(int i=0 ; i < indentation; i++) {
			string.append(" ");
		}
		string.append(text);
		return string.toString();
	}
	 //the indentation parameter represents a space character before the text itself.
	 //if you look at the public test compared to the expected results everytime the 
	 //getHTML method is called , the parameter indentation decided how many blank spaces 
	 //to print before printing the code. indentation = blank spaces
	 // 
	 //TextElement element = new TextElement("University of Maryland")
	 //element.getHTML(3) 
	 //
	 //Output:
	 // 
	 //   University of Maryland
}
