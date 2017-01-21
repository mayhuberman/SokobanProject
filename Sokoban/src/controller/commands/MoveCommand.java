package controller.commands;

import model.data.Character;
import model.policy.MoveItem;

public class MoveCommand implements ICommand {
	//Data members
	private Character _character;
	private MoveItem _move;
	private String _direction;
	
	//Constructor
	public MoveCommand(Character character, MoveItem move, String direction) {
		this._character = character;
		this._move = move;
		this._direction = direction;
	}
	
	//Get and set method
	public Character get_myCharacter() {
		return _character;
	}
	
	
	//
	/**
	 * The method checks which way the user wants the character
	 * to move to and than activates the move method in MySokobanPolicy
	 */
	public void moveCharacter(){
		switch(this._direction){
		case "Right":
		case "right":
		case "RIGHT":
			_move.moveChararcterRight(this._character);
			break;
		case "Left":
		case "left":
		case "LEFT":
			_move.moveChararcterLeft(this._character);
			break;
		case "Up":
		case "up":
		case "UP":
			_move.moveChararcterUp(this._character);
			break;
		case "Down":
		case "down":
		case "DOWM":
			_move.moveChararcterDown(this._character);
			break;
		default:
			System.out.println("wrong input :(");
			break;
		}
	}
	
	//Override method
	@Override
	public void execute() {
		this.moveCharacter();
	}

	

}
