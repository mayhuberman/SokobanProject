package model;

import model.data.Character;
import model.data.Level;

public interface IModel {
	/**
	 * The method calls the moveCharacterRight method from MoveItem class
	 * @param _character the character that we want to move
	 * @return if we moved the character 
	 */
	public boolean moveChararcterRight(Character character);
	
	/**
	 * The method calls the moveCharacterLeft method from MoveItem class
	 * @param character the character that we want to move
	 * @return if we moved the character 
	 */
	public boolean moveChararcterLeft(Character character);
	
	/**
	 * The method calls the moveCharacterUp method from MoveItem class
	 * @param character the character that we want to move
	 * @return if we moved the character 
	 */
	public boolean moveChararcterUp(Character character);
	
	/**
	 * The method calls the moveCharacterDown method from MoveItem class
	 * @param character the character that we want to move
	 * @return if we moved the character 
	 */
	public boolean moveChararcterDown(Character character);
	
	/**
	 * The method returns the current level
	 * @return the current level
	 */
	public Level getLevel();
}
