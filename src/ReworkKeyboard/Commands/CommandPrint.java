package ReworkKeyboard.Commands;

public class CommandPrint implements Command{

    private String text;

    public CommandPrint(String text){
        this.text = text;
    }

    @Override
    public void execute() {
        System.out.println("Execute command: " + text);
    }

    @Override
    public void undo() {
        System.out.println("Undo command: " + text);
    }
}
