package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.commons.io.FilenameUtils;
import files.ILevelLoader;
import files.MyObjectLevelLoader;
import files.MyTextLevelLoader;
import files.MyXMLLevelLoader;
import levels.Level;

public class LoadLevelCommand implements ICommand {
	//Data members
	private Level _myLevel;
	private static HashMap <String, ILevelLoader> _loadersMap;
	private ILevelLoader _myLoader;
	private InputStream _fileInputStream;
	
	//Constructor
	public LoadLevelCommand(String fileName) {
		if(_loadersMap == null){//Make sure that the loaders map will initiate one time only
			LoadLevelCommand.init();
		}
		String typeOfFile = FilenameUtils.getExtension(fileName);//Get the .txt/.obj/.xml from the filename that the user typed
		this._myLoader = _loadersMap.get(typeOfFile);//Get the type of loader the user typed
		try{
			this._fileInputStream = new FileInputStream(fileName);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
		
	//Get and set methods
	public Level get_myLevel() {
		return _myLevel;
	}

	public void set_myLevel(Level _myLevel) {
		this._myLevel = _myLevel;
	}
	
	//The method initiates the loaders hash map
	private static void init(){
		_loadersMap = new HashMap <String, ILevelLoader>();
		_loadersMap.put("txt", new MyTextLevelLoader());
		_loadersMap.put("obj", new MyObjectLevelLoader());
		_loadersMap.put("xml", new MyXMLLevelLoader());
	}
	
	//Override method
	@Override
	public void execute(){
		this._myLevel = this._myLoader.loadLevel(this._fileInputStream);
	}
}
