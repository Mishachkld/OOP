package ReworkKeyboard;

import Lab4.Commands.Command;

public abstract class MyKey implements Command {
    private String key;

    public String getKey() {
        return key;
    }

    public MyKey(String key) {
        this.key = key;
    }

}
