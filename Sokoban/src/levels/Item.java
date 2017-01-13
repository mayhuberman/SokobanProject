package levels;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Data members
	private Position _position;
	private boolean _isFreeSpace;//Only final position and floor will get T value
	private boolean _isMoveable;//Only items that can be moved (only box)
	private boolean _isItemOnFinalPosition;

	//Constructors
	public Item() {
		this._position = new Position();
		this._isFreeSpace = true;
		this._isMoveable = false;
		this._isItemOnFinalPosition = false;
	}
	
	public Item(boolean isFreeSpace, boolean isMoveable){
		this._position = new Position();
		this._isFreeSpace = isFreeSpace;
		this._isMoveable = isMoveable;
		this._isItemOnFinalPosition = false;
	}
	
	//Get and Set methods
	public Position get_position() {
		return _position;
	}

	public void set_position(Position item_position) {
		this._position = item_position;
	}
	
	public void set_position(int x, int y) {
		this._position.setP_x(x);
		this._position.setP_y(y);
	}
	
	public boolean isFreeSpace() {
		return _isFreeSpace;
	}

	public boolean isMoveable() {
		return _isMoveable;
	}

	public boolean isItemOnFinalPosition() {
		return _isItemOnFinalPosition;
	}

	public void set_isItemOnFinalPosition(boolean _isItemOnFinalPosition) {
		this._isItemOnFinalPosition = _isItemOnFinalPosition;
	}

}
