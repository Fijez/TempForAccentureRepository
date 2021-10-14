package m08io.sample;

import java.io.*;
import java.util.List;

public class ObjectReaderSample {

	@SuppressWarnings("rawtypes")
	public static void main(String arg[]){
		File target= new File(".\\bin\\sef\\module11\\sample\\ObjectData.obj");
		
		try {
			if (!target.exists())
				target.createNewFile();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(target));
	
				List list = (List)in.readObject();
				in.close();
				for(int i=0; i<list.size(); i++){
					System.out.println(list.get(i));
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
