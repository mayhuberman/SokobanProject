package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import controller.commands.ICommand;
import model.IModel;
import view.IView;

public class SokobanController implements Observer {
	//Data members
	private IModel _model;
	private IView _view;
	private Controller _controller;
	private Map<String, ICommand> _commands;
	
	//Constructor
	public SokobanController(IModel model, IView view) {
		this._model = model;
		this._view = view;
		
		this._controller = new Controller();
		this._controller.start();
		
		this.initCommands();
	}
	
	/**
	 * The method initiates the commands map
	 */
	private void initCommands(){
		this._commands = new HashMap<String, ICommand>();
		/*this._commands.put("Move", new MoveCommand(this._model));
		this._commands.put("Display", new DisplayCommand(model, view));*/
	}
	
	@Override
	public void update(Observable o, Object arg){
		LinkedList<String> params = (LinkedList<String>) arg;
		String commandKey = params.removeFirst();
		ICommand c = this._commands.get(commandKey);
		if (c == null) {
			//this._view.displayMessage("Command not found");
			return;
		}		
		//c.setParams(params);
		this._controller.insertCommand(c);
	}
	
}
