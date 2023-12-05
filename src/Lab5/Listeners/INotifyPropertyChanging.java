package Lab5.Listeners;

public interface INotifyPropertyChanging {
    void addInotifyPropertyChangedListener(CustomListenerChange listener);

    void removeNotifyPropertyChangedListener(CustomListenerChange listener);

}
