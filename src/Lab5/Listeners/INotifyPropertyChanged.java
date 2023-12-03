package Lab5.Listeners;

public interface INotifyPropertyChanged {

    void AddInotifyPropertyChangedListener(CustomListener listener);

    void RemoveNotifyPropertyChangedListener(CustomListener listener);

}
