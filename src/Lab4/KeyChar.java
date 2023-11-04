package Lab4;

public class KeyChar {
    private String nameOfKey;
    private Command command;

    public KeyChar(String nameOfKey) {
        this.nameOfKey = nameOfKey;
    }
    public KeyChar(String nameOfKey, Command command) {
        this.command = command;
        this.nameOfKey = nameOfKey;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        if (command!=null)
            return command;
        throw new NullPointerException("Define command!!!");
    }

}
