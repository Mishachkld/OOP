package Lab5;

import Lab5.Listeners.*;

import java.util.ArrayList;
import java.util.List;

public class CustomCollection implements INotifyCollectionChanged {

    private final List<String> collection;
    private final List<CustomListenerState> listeners;

    public static void main(String[] args) {
        MyClass myClass = new MyClass("Примат привет");
        CustomListener listener = value -> System.out.println("Значение параментра: " + value);
        myClass.AddInotifyPropertyChangedListener(listener);
        myClass.setProp("Amiiiiigooos!!!");
        myClass.setProp("Привет, Медвед!");
        System.out.println("--------------- -------------- --------------- ------------");
        SecondClass secondClass = new SecondClass("Примат пока");
        secondClass.addInotifyPropertyChangedListener((old, newValue, cancel) -> {
            boolean check = true;
            if (cancel) {
                check = old.length() < newValue.length();
            } else if (!old.equals(newValue)) {
                System.out.println("Новое значение свойства: " + old + " -> " + newValue);
            } else {
                System.out.println("Ничего не поменялось: " + old);
            }
            return check;
        });
        secondClass.setItem("Приматика почти отчислили");
        secondClass.setItem("Приматика больше нет :(");
        System.out.println("--------------- -------------- --------------- ------------");
        CustomCollection customCollection = new CustomCollection();
        customCollection.addInotifyPropertyChangedListener((state, newValue) -> {
            switch (state){
                case Added:
                    System.out.println("Добавлен элемент: " + newValue);
                    break;
                case Removed:
                    System.out.println("Удален объект: " + newValue);
                    break;
                case ItemChanged:
                    System.out.println("Изменен объект: " + newValue);
                    break;
            }
        });
        customCollection.add("Памагите");
        customCollection.change(0, "Нет");
        customCollection.remove("Нет");
    }

    public CustomCollection() {
        collection = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    private void updateListeners(State state, String item) {
        for (CustomListenerState listener : listeners)
            listener.actionPerformed(state, item);
    }

    public void add(String item) {
        updateListeners(State.Added, item);
        collection.add(item);
    }

    public void change(int index, String item) {
        updateListeners(State.ItemChanged, item);
        collection.set(index, item);
    }

    public void remove(String item) {
        updateListeners(State.Removed, item);
        collection.remove(item);
    }

    @Override
    public void addInotifyPropertyChangedListener(CustomListenerState listener) {
        listeners.add(listener);
    }

    @Override
    public void RemoveNotifyPropertyChangedListener(CustomListenerState listener) {
        listeners.remove(listener);
    }


}
