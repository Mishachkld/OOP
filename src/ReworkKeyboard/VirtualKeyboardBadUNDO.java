package ReworkKeyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Lab4.Constants.Constants.ALL_ROWS;

public class VirtualKeyboardBadUNDO {

    public static final int TIME_SLEEP_THREAD = 500;


    public static void main(String[] args) throws InterruptedException {
        VirtualKeyboardBadUNDO keyboardBadUNDO = new VirtualKeyboardBadUNDO();
        keyboardBadUNDO.addKeyWithCommand("ctr+z");
        keyboardBadUNDO.executeCommand("ctr+z");
        keyboardBadUNDO.undoCommand();

        keyboardBadUNDO.executeCommand("A");
        keyboardBadUNDO.executeCommand("B");
        keyboardBadUNDO.executeCommand("O");
        keyboardBadUNDO.executeCommand("B");
        keyboardBadUNDO.executeCommand("A");
        keyboardBadUNDO.executeCommand("!");
        keyboardBadUNDO.undoCommand();

    }
    private final Stack<MyKey> executedCommands;
    private final List<MyKey> arrayWithcommands;
    private  StringBuilder builder = new StringBuilder();

    public void executeCommand(int position) throws InterruptedException {
        Thread.sleep(TIME_SLEEP_THREAD);
        MyKey executedKey = arrayWithcommands.get(position);
        executedCommands.add(executedKey);
        executedKey.execute();
        buildOutLine(executedKey.getKey());
    }

    private void buildOutLine(String text) {
        builder.append(text);
        System.out.println(builder);
    }

    public void executeCommand(String text) throws InterruptedException {
        for (int index = arrayWithcommands.size() - 1; index > 0; index--) {
            if (arrayWithcommands.get(index).getKey().equals(text)){
                executeCommand(index);
                return;
            }
        }
        System.out.println("NOT FOUND COMMAND: " + text);
    }

    public VirtualKeyboardBadUNDO() {
        executedCommands = new Stack<>();
        arrayWithcommands = new ArrayList<>();
        work();
    }

    private void work() {
        createKeys();
    }

    public void undoCommand() throws InterruptedException {
        if (!executedCommands.isEmpty()) {
            Thread.sleep(1000);
            String text = executedCommands.pop().getKey();
            System.out.println("UNDO command: " + text);
            deleteItemInOutline(text);
        } else {
            System.out.println("Nothing UNDO");
        }
    }

    private void deleteItemInOutline(String text){
        int size = text.length();
        builder.delete(builder.length() - size, builder.length());
        System.out.println(builder);
    }


    private void createKeys() {
        for (String[] allRow : ALL_ROWS) {
            for (String text : allRow) {
                addKeyWithCommand(text);
            }
        }
    }

    public void addKeyWithCommand(String text) {
        arrayWithcommands.add(new MyKey(text) {
            @Override
            public void execute() {
                System.out.println("New command: " + text);
            }
        });
    }


}
