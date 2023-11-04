package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VirtualKeyboard implements CommandReader{
    private VirtualKeyboardGUI keyboardGUI;

    private Stack<String> commandExecuted;
    private List<String> commands;


    public static void main(String[] args) {
        new VirtualKeyboard();
    }

    public VirtualKeyboard(){
        keyboardGUI = new VirtualKeyboardGUI(this);
        commandExecuted = new Stack<>();
        commands = new ArrayList<>();

    }



    @Override
    public void runCommand(String command) {
        commandExecuted.push(command);
    }

    @Override
    public void undoCommand() {
        if (!commandExecuted.empty())
            System.out.println("Command UNDO" + commandExecuted.pop());
    }

    @Override
    public void createCommand(String command) {
        commands.add(command);
        new CommandDialog(command);
    }
}


