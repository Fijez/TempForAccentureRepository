package m08io.sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectWriterSample {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String arg[]){
		
		List saveMe = new ArrayList();
		saveMe.add("Curly");
		saveMe.add("Larry");
		saveMe.add("Moe");
		
		File target= new File(".\\bin\\sef\\module11\\sample\\ObjectData.obj");
		try {
			System.out.println("Saving ArrayList of Strings");
			//We use FileOutputStream to save raw bytes to a file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target));
			out.writeObject(saveMe);
			out.flush();
			out.close();
			System.out.println("Done!");
		}catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		
		
	}
}
