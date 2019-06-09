package Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Constants.Constants;

public class CustomLogger extends Constants {
	
	
	public CustomLogger() throws IOException {
		super();
	}

	public static void log(String info, String testname) throws IOException {

	      
	      File file = new File(Constants.TIMESTAMPFOLDER+"/"+testname+".txt");   
	      System.out.println(file.getAbsolutePath().toString());
	      FileWriter fileWriter = new FileWriter(file,true);
	      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	      
	      bufferedWriter.write(info+"\n");
	      bufferedWriter.close();
	      fileWriter.close();
	}
	

}
