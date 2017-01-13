package controller;

import java.util.Observable;

import model.IModel;
import view.IView;

public class MyController implements IController{
	//Data members
	private IView _view;
	private IModel _model;
	
	//Constructor
	public MyController(IView view, IModel model) {
		this._view = view;
		this._model = model;
	}
	
	//Override method
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
