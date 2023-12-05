package Lab5.Listeners;

public interface CustomListenerChange {
    boolean actionPerformed(String old, String newValue, Boolean cancel);
}
