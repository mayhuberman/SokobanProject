package model;

import java.util.Observable;
import commons.Level;
import model.data.Character;
import model.policy.MoveItem;
import model.policy.MoveItemPolicy1;

public class MyModel extends Observable implements IModel{

	private MoveItem _moveFunctionality;
	private Level _level;
	
	public MyModel() {
		this._level = new Level();
		this._moveFunctionality = new MoveItemPolicy1(this._level);
	}
	
	public MyModel(Level level, MoveItem moveFunctionality) {
		this._level = level;
		this._moveFunctionality = moveFunctionality;
	}
	
	@Override
	public boolean moveChararcterRight(Character character) {
		return this._moveFunctionality.moveChararcterRight(character);
	}

	@Override
	public boolean moveChararcterLeft(Character character) {
		return this._moveFunctionality.moveChararcterLeft(character);
	}

	@Override
	public boolean moveChararcterUp(Character character) {
		return this._moveFunctionality.moveChararcterUp(character);
	}

	@Override
	public boolean moveChararcterDown(Character character) {
		return this._moveFunctionality.moveChararcterDown(character);
	}

	@Override
	public Level getLevel() {
		return this._level;
	}
	
}
