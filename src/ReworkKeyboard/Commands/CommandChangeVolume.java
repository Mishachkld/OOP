package ReworkKeyboard.Commands;

public class CommandChangeVolume implements Command{
    @Override
    public void execute() {
        System.out.println("Volume changed up on 5%");

    }

    @Override
    public void undo() {
        System.out.println("Volume changed down on 5%");

    }
}
