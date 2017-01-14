package controller;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import commands.ICommand;
import model.IModel;
import view.IView;

public class MyController implements IController{
	//Data members
	private IView _view;
	private IModel _model;
	private BlockingQueue<ICommand> _commands;
	
	//Constructor
	public MyController(IView view, IModel model) {
		this._view = view;
		this._model = model;
	}
	
	//Override method
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o == _view){
			
		}
		
		if(o == _model){
			
		}
	}

	@Override
	public void start() {
		Thread t = new Thread();
	}

}
