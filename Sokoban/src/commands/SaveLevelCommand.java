package commands;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;

import model.data.ILevelSaver;
import model.data.Level;
import model.data.MyObjectLevelSaver;
import model.data.MyTextLevelSaver;
import model.data.MyXMLLevelSaver;

public class SaveLevelCommand implements ICommand {
	//Data members
	private static HashMap<String, ILevelSaver> _saversMap;
	private ILevelSaver _mySaver;
	private Level _myLevel;
	private String _fileName;
	
	//Constructor
	public SaveLevelCommand(String fileName, Level level) {
		if(_saversMap == null){
			SaveLevelCommand.init();
		}
		String typeOfFile = FilenameUtils.getExtension(fileName);//Get the .txt/.obj/.xml from the filename that the user typed
		this._mySaver = _saversMap.get(typeOfFile);//Get the type of saver the user typed
		this._myLevel = level;
		this._fileName = fileName;
	}
	
	/**
	 * The method initiates the savers hash map
	 */
	public static void init(){
		_saversMap = new HashMap<String, ILevelSaver>();
		_saversMap.put("txt", new MyTextLevelSaver());
		_saversMap.put("obj", new MyObjectLevelSaver());
		_saversMap.put("xml", new MyXMLLevelSaver());
	}
	
	//Override method
	@Override
	public void execute(){
		try {
			this._mySaver.saveLevel(this._myLevel, this._fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
