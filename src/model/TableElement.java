package model;

public class TableElement extends TagElement {
	
	//Represents the <table> tag. A two dimensional array is used to keep track of the Element objects of table.
	Element[][] element2dArray ;

	public TableElement ( int rows, int cols, String attributes) {
		super("table",true,null,attributes);
		element2dArray = new Element [rows][cols];
	}
	
	public void addItem(int rowIndex, int colIndex, Element item) {
		element2dArray[rowIndex][colIndex] = item;	
	}
	public double getTableUtilization() {
		double occupied = 0, totalCells = getRows()*getCols(),d;
		for (int i = 0; i < element2dArray.length ;i++) {
			for(int j = 0; j < element2dArray[i].length;j++) {
			
				if(!(element2dArray[i][j] == null)) {
					occupied++;
				}
			}
		}
		d = (occupied / totalCells ) * 100;
		return d;
		
	}
	@Override
	public String genHTML(int indentation) {
		StringBuffer string = new StringBuffer();
		
		for(int i=0 ; i < indentation + 1; i++) {
			string.append(" ");
		}
		string.append(getStartTag());
		string.append("\n");
		
		 
		
		for(int i = 0; i < element2dArray.length; i++) {
			for(int k=0 ; k < indentation + 4; k++) {
				string.append(" ");
			}
			string.append("<tr>");
			for(int j = 0; j < element2dArray[i].length; j++) {
				string.append("<td>");
				if(!(element2dArray[i][j] == null)) {
					string.append(element2dArray[i][j].genHTML(0));
					}
				string.append("</td>");
			}
			string.append("</tr>\n");
		}
		for(int i=0 ; i < indentation + 1; i++) {
			string.append(" ");
		}
		string.append(getEndTag());
		
		return string.toString();
		
	}
	public int getRows() {
		return element2dArray.length;
	}
	public int getCols() {
		return element2dArray[0].length;
		// not staggering 
	}
}
