package Lab4.Commands;

public interface CommandReader {
    void runCommand(String command);
    void undoCommand();

    void createCommand(String command);
}
