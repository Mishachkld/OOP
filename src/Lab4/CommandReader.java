package Lab4;

public interface CommandReader {
    void runCommand(String command);
    void undoCommand();

    void createCommand(String command);
}
