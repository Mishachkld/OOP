package Lab5;

import Lab5.Listeners.CustomListener;
import Lab5.Listeners.INotifyCollectionChanged;
import Lab5.Listeners.INotifyPropertyChanged;
import Lab5.Listeners.INotifyPropertyChanging;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomCollection  {

    private List<String> collection;
    private INotifyCollectionChanged notifyCollectionChanged;
    private INotifyPropertyChanged notifyPropertyChanged;
    public static void main(String[] args) {

    }

    public CustomCollection(){

    }

    public void add(String item){
        collection.add(item);

    }



}
