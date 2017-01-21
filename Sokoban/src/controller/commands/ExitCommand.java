package controller.commands;

//The command will exit the program
public class ExitCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("Bye bye! :)");
		System.exit(0);//The program ends successfully
		
	}
}
