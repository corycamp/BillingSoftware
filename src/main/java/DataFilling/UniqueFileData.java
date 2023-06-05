package DataFilling;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

class UniqueFileData{
	private JSONObject fileData = null;
	
	public UniqueFileData(){
		Scanner userInput = new Scanner(System.in);
		try {
			//Create a workbook from the name selected in pop-up
			Workbook workbook = new XSSFWorkbook(handleFileSearch());
			
			//Gets all available sheets in the file
			String[] sheets = new String[workbook.getNumberOfSheets()];
			for(int sheetNumber = 0; sheetNumber < workbook.getNumberOfSheets(); ++sheetNumber) {
				sheets[sheetNumber] = workbook.getSheetAt(sheetNumber).getSheetName();
			}
			
			//Allows the user to select which sheet they want to use
			int sheetSelection = this.handleSelection(sheets, userInput);
			Sheet sheet1 = workbook.getSheetAt(sheetSelection);
			
			boolean firstRow = true;
			String[] columnTitle = null;
			int selectedOption = 0;
			JSONObject item = new JSONObject();
			for(Row row : sheet1) {
				if(firstRow)
					columnTitle = new String[row.getLastCellNum()];
				JSONObject itemData = new JSONObject();
				String key = "";
				for(Cell cell : row) {
						if(firstRow) {
							columnTitle[cell.getColumnIndex()] = cell.toString();
						}else {
							if(cell.getColumnIndex() != selectedOption) {
								itemData.put(columnTitle[cell.getColumnIndex()], cell.toString());
							}else {
								key = cell.toString();
							}
						}
				}
				if(firstRow)
					selectedOption = this.handleSelection(columnTitle, userInput);
				firstRow = false;
				if(key!="")
					item.put(key, itemData);
			}
			userInput.close();
			this.setFileData(item);
		}
		catch(Exception e) {
			System.out.println("Couldn't create workbook");
			System.out.println(e);
		}	
	}
	
	private FileInputStream handleFileSearch() {
		FileInputStream file=null;
		//Open a file selector
		try {
			 System.out.println("Working Directory = " + System.getProperty("user.dir"));
			 JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("xlsx","xlsx","csv");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(chooser);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       file = new FileInputStream(chooser.getSelectedFile());
			    }
		}
		catch(Exception e) {
			System.out.println("There was a problem reading that file, please check the file provided....");
			System.out.println(e);
		}
		return file;
	}
	
	private int handleSelection(String[] columnTitle, Scanner userInput){
		
		int index = 1;
		for(String title : columnTitle) {
			System.out.printf("%d) %s\n", index, title);
			index++;
		}
		
		//Functionality to ask user which row is the unique key
		System.out.println("\nSelect the number next to the value you want to use...");
		int response = userInput.nextInt();
		boolean flag = response < 1 || response > columnTitle.length;
		if(flag)
			do {
				System.out.println("Option Selected is not valid.....\nEnter a different choice:");
				response = userInput.nextInt();
			}while(response < 1 || response > columnTitle.length);
		
		return response-1;
	}
	
	private void setFileData(JSONObject data) {
		this.fileData = data;
	}
	
	public JSONObject getFileData() {
		return this.fileData;
	}
}