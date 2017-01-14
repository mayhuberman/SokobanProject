package cli;

import java.util.LinkedList;
import java.util.List;
import commands.DisplayLevelCommand;
import commands.ExitCommand;
import commands.ICommand;
import commands.LoadLevelCommand;
import commands.MoveCommand;
import commands.SaveLevelCommand;
import model.data.Level;
import model.policy.MoveItem;
import model.policy.MoveItemPolicy1;
import model.policy.MySokobanPolicy;
import model.policy.Policy1;

public class CLI {
	//Data members
	private Level _myLevel;
	private MySokobanPolicy _myPolicy;
	private LinkedList<ICommand> _commands;
	
	//Constructors
	public CLI() {
		this._commands = new LinkedList<ICommand>();
		this._myLevel = new Level();
		this._myPolicy = new Policy1();
	}
	
	public CLI(Level level, MySokobanPolicy policy) {
		this._myLevel = level;
		this._commands = new LinkedList<ICommand>();
		this._myPolicy = policy;
	}
	
	//Get and set methods
	public Level get_myLevel() {
		return _myLevel;
	}

	public void set_myLevel(Level _myLevel) {
		this._myLevel = _myLevel;
	}

	public LinkedList<ICommand> get_commands() {
		return _commands;
	}

	public void set_commands(LinkedList<ICommand> _commands) {
		this._commands = _commands;
	}

	public MySokobanPolicy get_myPolicy() {
		return _myPolicy;
	}

	public void set_myPolicy(MySokobanPolicy _myPolicy) {
		this._myPolicy = _myPolicy;
	}
	
	
	/**
	 * The method adds command to the commands queue
	 * @param commandList the commandlist that we want to add a command to
	 */
	public void addCommandToCommandsQueue(List<String> commandList){
		
		ICommand newCommand = null;
		
		switch(commandList.get(0)){//Checks which command the user asked
		case "Load":
			newCommand = new LoadLevelCommand(commandList.get(1));//Create new load command with the file that the user asked
			newCommand.execute();//Load level
			this._myLevel = ((LoadLevelCommand)newCommand).get_myLevel();//Set the level that we loaded to the CLI level data member
			return;
		case "Display":
			newCommand = new DisplayLevelCommand(_myLevel);
			break;
		case "Move":
			newCommand = new MoveCommand(this._myLevel.get_characters().get(0), this.moveItemCreator(), commandList.get(1));
			break;
		case "Save":
			newCommand = new SaveLevelCommand(commandList.get(1),_myLevel);
			break;
		case "Exit":
			newCommand = new ExitCommand();
			break;
		default:
			System.out.println("Wrong input :(");
			return;
		}
		this._commands.addLast(newCommand);//Add command to the end of the commands queue
	}
	
	/**
	 * The method creates MoveItem by the relevant policy
	 * @return the MoveItem with the relevant policy
	 */
	public MoveItem moveItemCreator(){
		String nameOfPolicy = this._myPolicy.getClass().toString().substring(13);//Set the name of the policy
		
		switch(nameOfPolicy){//Right now we only have one policy, but in the future it can be extended
		case "Policy1":
			return new MoveItemPolicy1(_myLevel);
		default:
			break;
		}
		
		return null;
	}
	
	/**
	 * The method activates the commands in the queue
	 */
	public void doCommands(){
		while(!(this._commands.isEmpty())){//While the command queue isn't empty
			this._commands.removeFirst().execute();//Remove the first command and execute it
		}
	}

	
}
