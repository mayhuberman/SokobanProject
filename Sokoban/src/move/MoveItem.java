package move;

import levels.Character;
import levels.Item;
import levels.Level;
import policy.MySokobanPolicy;

public abstract class MoveItem {
	//Data members
	private MySokobanPolicy _policy;
	private Level _level;
	
	//Constructor
	public MoveItem(MySokobanPolicy policy, Level level) {
		this._policy=policy;
		this._level=level;
	}
	
	//Get and set methods
	public MySokobanPolicy get_policy() {
		return _policy;
	}
	
	public Level get_level() {
		return _level;
	}

	public void set_level(Level _level) {
		this._level = _level;
	}
	
	//Abstract method
	public abstract boolean moveCharacter(Character character, Item moveToItem, Item nextItem);
	public abstract boolean moveChararcterRight(Character character);
	public abstract boolean moveChararcterLeft(Character character);
	public abstract boolean moveChararcterUp(Character character);
	public abstract boolean moveChararcterDown(Character character);
	
}
