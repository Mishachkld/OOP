package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Array3D<T> {
    private List<T> array;
    private int size;
    private int x, y, z;

    public Array3D(List<T> array, int x, int y, int z) {
        this.array = array;
        size = x * y * z;
        this.x = x;
        this.z = z;
        this.y = y;

    }

    @SafeVarargs
    public Array3D(int x, int y, int z, T... elements) {
        this.array = new ArrayList<>(List.of(elements));
        this.x = x;
        this.z = z;
        this.y = y;
    }


    public void fillArray(Array3D<T> array3D) {

    }


    public List<List<T>> getValueArray(int i, int j) {
        List<List<T>> temp = new ArrayList<>();


        return temp;
    }

    public T getValue(int i, int j, int k) {
        T value = null;
        return value;
    }

    public void setValue(T t, int position) {
        array.add(position, t);
    }


    @Override
    public String toString() {
        return array.toString();
    }
}
