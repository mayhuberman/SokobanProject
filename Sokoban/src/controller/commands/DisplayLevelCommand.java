package commands;

import commons.Level;
import displayers.ILevelDisplayer;
import displayers.MyTextLevelDisplayer;

public class DisplayLevelCommand implements ICommand {
	//Data members
	private ILevelDisplayer _myDisplayer;
	private Level _myLevel;
	
	
	//Constructors
	public DisplayLevelCommand(Level level) {
		this._myDisplayer = new MyTextLevelDisplayer();
		this._myLevel = level;
	}
	
	public DisplayLevelCommand(Level level, ILevelDisplayer displayer) {
		this._myDisplayer = displayer;
		this._myLevel = level;
	}
		
	
	//Get and set methods
	public Level get_myLevel() {
		return _myLevel;
	}

	public ILevelDisplayer get_myDisplayer() {
		return _myDisplayer;
	}

	public void set_myDisplayer(ILevelDisplayer _myDisplayer) {
		this._myDisplayer = _myDisplayer;
	}

	
	//Override method
	@Override
	public void execute() {
		this._myDisplayer.display(this._myLevel);
	}

	
}
