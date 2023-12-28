package ReworkKeyboard.Commands;

public class CommandChangeBrightens implements Command {
    @Override
    public void execute() {
        System.out.println("Brightens changed up on 10%");
    }

    @Override
    public void undo() {
        System.out.println("Brightens changed down on 10%");
    }
}
