package Lab5;

import Lab5.Listeners.CustomListener;
import Lab5.Listeners.INotifyPropertyChanged;

import java.util.ArrayList;
import java.util.List;

public class MyClass implements INotifyPropertyChanged {


    private final List<CustomListener> listeners;

    private String prop;

    public MyClass(String prop) {
        listeners = new ArrayList<>();
        setProp(prop);
    }

    public String getProp() {
        return prop;
    }

    @Override
    public void AddInotifyPropertyChangedListener(CustomListener listener) {
        listeners.add(listener);
    }

    @Override
    public void RemoveNotifyPropertyChangedListener(CustomListener listener) {
        listeners.remove(listener);
    }

    public void setProp(String prop) {
        for (CustomListener listener : listeners)
            listener.actionPerformed(prop);
        this.prop = prop;
    }
}
