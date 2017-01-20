package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import commands.ICommand;

public class Controller{
	//Data members
	private BlockingQueue<ICommand> _commandsQueue;
	private boolean _isExit;
	
	//Constructor
	public Controller() {
		this._commandsQueue = new ArrayBlockingQueue<ICommand>(10);
		this._isExit = false;
	}
	
	/**
	 * The method inserts command to the commands BlockingQueue
	 * @param cmd the command we want to insert to the queue
	 */
	public void insertCommand(ICommand cmd) {
		try {
			this._commandsQueue.put(cmd);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	/**
	 * The method polls the first command from the command queue
	 * and activates the command by his exectue() method until
	 * got an exit flag
	 */
	public void start() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!_isExit) {
					try {
						ICommand cmd = _commandsQueue.poll(1, TimeUnit.SECONDS);//polls the first command in the commands queue
						//The command can be null if the time passed until got input
						if (cmd != null){
							cmd.execute();//activates the command
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	/**
	 * The method turns on the exit flag
	 */
	public void stop() {
		this._isExit = true;
	}
}

