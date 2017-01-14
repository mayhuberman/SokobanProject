package model.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader implements ILevelLoader {
	
	public MyObjectLevelLoader() {
		
	}
	
	//The method loads level from binary file
	public Level loadLevel(InputStream is){
		
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(is);
			Level level = (Level)in.readObject();
			in.close();
			return level;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
