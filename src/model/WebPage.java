package model;

import java.util.ArrayList;

public class WebPage implements Comparable<WebPage>{
	
	// Represents a web page. Web page elements are stored in an ArrayList of Element objects. 
	// A title is associated with every page. This class implements the Comparable interface. 
	// Pages will be compared based on the title.
	ArrayList<Element> webPageElements;
	private String title;

	public WebPage(String title) {
		this.title = title;
		webPageElements = new ArrayList<>();
	}
	public int addElement(Element element) {
		webPageElements.add(element);
		if(element instanceof TagElement) {
			return ((TagElement) element).getId();
		}
		return -1;
	}
	public String getWebPageHTML(int indentation) {
		StringBuffer string = new StringBuffer();
		string.append("<!doctype html>\n<html>\n");
		for(int i=0 ; i < indentation ; i++) {
			string.append(" ");
		}
		string.append("<head>\n");
		for(int i=0 ; i < indentation+3; i++) {
			string.append(" ");
		}
		string.append("<meta charset=\"utf-8\"/>\n");
		for(int i=0 ; i < indentation+3; i++) {
			string.append(" ");
		}
		string.append("<title>" + title + "</title>\n");
		for(int i=0 ; i < indentation; i++) {
			string.append(" ");
		}
		string.append("</head>\n");
		for(int i=0 ; i < indentation+1; i++) {
			string.append(" ");
		}
		string.append("<body>\n");
		 
		
		for(int i = 0 ; i < webPageElements.size(); i++) {
			for(int j=0 ; j < indentation; j++) {
				string.append(" ");
			}
			
			string.append(webPageElements.get(i).genHTML(indentation));
			string.append("\n");
			
		}
		for(int i=0 ; i < indentation+1; i++) {
			string.append(" ");
		}
		string.append("</body>\n</html>");
		return string.toString();
	}
	public void writeToFile(String filename, int indentation) {
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}
	public Element findElem(int id) {
		for(int i = 0 ; i < webPageElements.size(); i++) {
			if(webPageElements.get(i) instanceof TagElement) {
				TagElement element = (TagElement) webPageElements.get(i);
				if(element.getId()  == id) {
					return webPageElements.get(i);
				}
			}
		}
		return null;
	}
	public String stats() {
		//List Count: 1
		//Paragraph Count: 0
		//Table Count: 2
		//TableElement Utilization: 75.0
		StringBuffer string = new StringBuffer();
		//basically all of them find the count by going through the element arrayList and seeing if IS A relationship
		// IS A can go down subclasses but not up
		int listCount = 0;
		for(int i = 0; i < webPageElements.size(); i++) {
			if (webPageElements.get(i) instanceof ListElement) {
				listCount++;
			}
		}
	
		string.append("List Count: " + listCount + "\n" );
		int paraCount = 0;
		for(int i = 0; i < webPageElements.size(); i++) {
			if (webPageElements.get(i) instanceof ParagraphElement) {
				paraCount++;
			}
		}
		string.append("Paragraph Count: " + paraCount + "\n" );
		int tableCount = 0;
		for(int i = 0; i < webPageElements.size(); i++) {
			if (webPageElements.get(i) instanceof TableElement) {
				tableCount++;
			}
		}
		string.append("Table Count: " + tableCount + "\n" );
		double totUtil = 0, avg;
		for(int i = 0; i < webPageElements.size(); i++) {
			if (webPageElements.get(i) instanceof TableElement) {
				TableElement element = (TableElement) webPageElements.get(i);
				totUtil += element.getTableUtilization();
			}
		}
		if(tableCount>0) {
		avg = totUtil/tableCount;
		}
		else {
			avg = 0;
		}
		string.append("TableElement Utilization: " + String.format("%.1f", avg) ); 
		return string.toString();
	}
	public static void enableId(boolean choice) {
		TagElement.enableId(choice);
	}
	public int compareTo (WebPage webpage) {
		return this.title.compareTo(webpage.title);
	}
	
}
