package files;

import java.io.IOException;

import levels.Level;

public interface ILevelSaver {
	public void saveLevel(Level level, String fileName) throws IOException;
}
