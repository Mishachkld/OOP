package ReworkKeyboard;


import ReworkKeyboard.Commands.Command;

public class MyKey{
    private String key;
    private Command command;

    public void undo(){
      command.undo();
    }

    public void execute(){
        command.execute();
    }

    public String getKey() {
        return key;
    }

    public MyKey(String key, Command command) {
        this.key = key;
        this.command = command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

}
