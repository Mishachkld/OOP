package Lab5.Listeners;

import Lab5.State;

public interface INotifyCollectionChanged {

    void AddInotifyPropertyChangedListener(CustomListener listener, State state);
    void RemoveNotifyPropertyChangedListener(CustomListener listener, State state);

}
