package Lab5;

import Lab5.Listeners.CustomListenerChange;
import Lab5.Listeners.INotifyPropertyChanging;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SecondClass implements INotifyPropertyChanging {
    private final List<CustomListenerChange> listeners;
    private String item;

    public void setItem(String item) {
        boolean flag = true;
        for (CustomListenerChange listener : listeners) {
            if (!listener.actionPerformed(item, this.item, true)) {
                flag = false;
            }
        }
        if (flag) {
            for (CustomListenerChange listener : listeners) {
                listener.actionPerformed(this.item, item, false);
            }
        }
        else
            for (CustomListenerChange listener : listeners) {
                listener.actionPerformed(this.item, this.item, false);
            }
        this.item = item;
    }

    public SecondClass(String item) {
        listeners = new ArrayList<>();
        setItem(item);
    }

    @Override
    public void addInotifyPropertyChangedListener(CustomListenerChange listener) {
        listeners.add(listener);
    }

    @Override
    public void removeNotifyPropertyChangedListener(CustomListenerChange listener) {
        listeners.remove(listener);
    }


}
