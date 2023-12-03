package Lab5.Listeners;

public interface INotifyPropertyChanging {
    void AddInotifyPropertyChangedListener(CustomListener listener, boolean isChanged);

    void RemoveNotifyPropertyChangedListener(CustomListener listener, boolean isRemoved);

}
