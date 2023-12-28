package ReworkKeyboard;

import ReworkKeyboard.Commands.Command;
import ReworkKeyboard.Commands.CommandChangeBrightens;
import ReworkKeyboard.Commands.CommandChangeVolume;
import ReworkKeyboard.Commands.CommandPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Lab4.Constants.Constants.ALL_ROWS;

public class VirtualKeyboardBadUNDO {

    public static final int TIME_SLEEP_THREAD = 750;


    public static void main(String[] args) throws InterruptedException {
        VirtualKeyboardBadUNDO keyboardBadUNDO = new VirtualKeyboardBadUNDO();
        keyboardBadUNDO.addKeyWithCommandPrint("ctr+v", new CommandChangeVolume());
        keyboardBadUNDO.executeCommand("ctr+v");
        keyboardBadUNDO.undoCommand();
        keyboardBadUNDO.setNewCommandOnKey("ctr+v", new CommandChangeBrightens());
        keyboardBadUNDO.executeCommand("ctr+v");
        keyboardBadUNDO.undoCommand();
        keyboardBadUNDO.pressKey(keyboardBadUNDO.getKey("A"));
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
    private final StringBuilder builder = new StringBuilder();


    public VirtualKeyboardBadUNDO() {
        executedCommands = new Stack<>();
        arrayWithcommands = new ArrayList<>();
        work();
    }

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

    public void pressKey(MyKey key) throws InterruptedException {
        executeCommand(key.getKey());
    }
    public void executeCommand(String text) throws InterruptedException {
        for (int index = arrayWithcommands.size() - 1; index > 0; index--) {
            if (arrayWithcommands.get(index).getKey().equals(text)){
                executeCommand(index);
                return;
            }
        }
        System.out.println("NOT FOUND COMMAND WITH NAME: " + text);
    }



    private void work() {
        createKeys();
    }

    public void undoCommand() throws InterruptedException {
        if (!executedCommands.isEmpty()) {
            Thread.sleep(TIME_SLEEP_THREAD);
            String text = executedCommands.peek().getKey();
            executedCommands.pop().undo();
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

    public void setNewCommandOnKey(String name, Command command){
        for (MyKey key: arrayWithcommands){
            if (key.getKey().equals(name)){
                key.setCommand(command);
                return;
            }
        }
            System.out.println("Not found 404!!!!!");
    }

    private void createKeys() {
        for (String[] allRow : ALL_ROWS) {
            for (String text : allRow) {
                addKeyWithCommandPrint(text);
            }
        }
    }

    public MyKey getKey(String keyName){
        for (MyKey key: arrayWithcommands){
            if (key.getKey().equals(keyName)){
                return key;
            }
        }
        return null;
    }


    public void addKeyWithCommandPrint(String text) {
        addKeyWithCommandPrint(text, new CommandPrint(text));
    }

    public void addKeyWithCommandPrint(String nameOfKey, Command command) {
        arrayWithcommands.add(new MyKey(nameOfKey, command));
    }


}
