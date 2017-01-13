package policy;

import levels.Character;
import levels.Item;
import levels.Level;

public abstract class MySokobanPolicy {

	public abstract boolean canCharacterMove(Item moveToItem, Item nextItem);
	public abstract boolean canChararcterMoveRight(Character character, Level level);
	public abstract boolean canChararcterMoveLeft(Character character, Level level);
	public abstract boolean canChararcterMoveUp(Character character, Level level);
	public abstract boolean canChararcterMoveDown(Character character, Level level);
	public abstract boolean isWinner(Level level);
}
