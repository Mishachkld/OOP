package Lab4;

import javax.swing.*;

public abstract class CommandJButton extends JButton implements Command {

    private  String command;

    public CommandJButton(String text){
        super(text);
        this.command = text;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command){
        this.command = command;
    }
}
