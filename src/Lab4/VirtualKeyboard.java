package Lab4;

import Lab4.Commands.CommandReader;
import Lab4.GUI.CommandDialog;
import Lab4.GUI.VirtualKeyboardGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VirtualKeyboard implements CommandReader {
    private VirtualKeyboardGUI keyboardGUI;

    private final Stack<String> commandExecuted;
    private final List<String> commands;


    public static void main(String[] args) {
        new VirtualKeyboard();
    }

    public VirtualKeyboard() {
        keyboardGUI = new VirtualKeyboardGUI(this);
        commandExecuted = new Stack<>();
        commands = new ArrayList<>();

    }


    @Override
    public void runCommand(String command) {
        if (commands.contains(command)) {
            commandExecuted.push(command);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new CommandDialog("Command " + command + " running!");
            System.out.println("Command " + command + " running!");
        } else new CommandDialog("Command not found 404");
    }

    @Override
    public void undoCommand() {
        if (!commandExecuted.empty()) {
            System.out.println("Command UNDO: " + commandExecuted.peek());
            new CommandDialog("UNDO ", "Command UNDO: " + commandExecuted.pop());
        } else
            new CommandDialog("Nothing UNDO :(");
    }

    @Override
    public void createCommand(String command) {
        if (!command.isEmpty() && !commands.contains(command)) {
            commands.add(command);
            new CommandDialog("Created new command: ", "Created new command: " + command);
            System.out.println("Created new command: " + command);
        }

    }
}


