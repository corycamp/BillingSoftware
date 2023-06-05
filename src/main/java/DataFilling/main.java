package DataFilling;

import org.json.JSONObject;

class mainApp{
	
	public static void main(String args[]) throws Exception {
		
		int option = 2;
		
		if(option==1) {
			UniqueFileData fileOpener = new UniqueFileData();
			
			//Turns opened Excel file into JSON
			JSONObject fileData = fileOpener.getFileData();
			
			System.out.println(fileData);
		}else{
//			CunyFirstUpdater cf = new CunyFirstUpdater();
			AwardsDocuments ad = new AwardsDocuments();
		}
		
		
	}
}