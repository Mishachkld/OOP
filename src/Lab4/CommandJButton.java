package Lab4;

import Lab4.Commands.Command;

import javax.swing.*;


public abstract class CommandJButton extends JButton implements Command {
    public CommandJButton(String text){
        super(text);
    }
}
