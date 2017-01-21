package model;

import java.util.LinkedList;
import java.util.Observable;

import commons.Level;
import model.data.Character;
import model.policy.MoveItem;
import model.policy.MoveItemPolicy1;

public class SokobanModel extends Observable implements IModel{
	//Data members
	private MoveItem _moveFunctionality;
	private Level _level;
	
	//Constructors
	public SokobanModel() {
		this._level = new Level();
		this._moveFunctionality = new MoveItemPolicy1(this._level);
	}
	
	public SokobanModel(Level level, MoveItem moveFunctionality) {
		this._level = level;
		this._moveFunctionality = moveFunctionality;
	}
	
	@Override
	public void moveCharacter(String direction, Character character){
		switch(direction){
		case "Right":
		case "right":
		case "RIGHT":
			this._moveFunctionality.moveChararcterRight(character);
			break;
		case "Left":
		case "left":
		case "LEFT":
			this._moveFunctionality.moveChararcterLeft(character);
			break;
		case "Up":
		case "up":
		case "UP":
			this._moveFunctionality.moveChararcterUp(character);
			break;
		case "Down":
		case "down":
		case "DOWM":
			this._moveFunctionality.moveChararcterDown(character);
			break;
		default:
			throw new IllegalArgumentException("Invalid direction");
		}
		
		this.setChanged();//Set an indication that there was a change
		LinkedList<String> params = new LinkedList<String>();
		params.add("Display");//After we moved the character, we want to display the game with the changes
		this.notifyObservers(params);//Notify observers about the change
		//this.clearChanged();//Clear the indication
	}

	@Override
	public Level getLevel() {
		return this._level;
	}

	@Override
	public void setLevel(Level level) {
		this._level = level;
	}
	
}
