package Lab5.Listeners;

public interface INotifyCollectionChanged {

    void addInotifyPropertyChangedListener(CustomListenerState listener);
    void RemoveNotifyPropertyChangedListener(CustomListenerState listener);

}
