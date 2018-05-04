package kata.command;

public class QuitCommand extends Command {
	
	public void execute() {
		System.out.println("Bye !");
		System.exit(0);
	}
}
