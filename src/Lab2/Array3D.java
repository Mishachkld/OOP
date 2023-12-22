package Lab2;

import java.util.ArrayList;
import java.util.List;

public class Array3D<T> {
    private final List<T> array;
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
        if (isCorrectIndex(i, j, k))
            return array.get((array.size() / x) * i + (array.size() / (x * y)) * j + k);
        throw new IndexOutOfBoundsException();
    }

    public void setValue(int i, int j, int k, T t) {
        if (isCorrectIndex(i, j, k))
            array.add((array.size() / x) * i + (array.size() / (x * y)) * j + k, t);
        throw new IndexOutOfBoundsException();
    }

    public void setValue(int x, int position, List<List<T>> array) {
        switch (position) {
            case 0:
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < z; k++) {
                        if (array.size() > j && array.get(j).size() > k) {
                            setValue(x, j, k, array.get(j).get(k));
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < this.x; i++) {
                    for (int k = 0; k < z; k++) {
                        if (array.size() > i && array.get(k).size() > k) {
                            setValue(i, x, k, array.get(i).get(k));
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < this.x; i++) {
                    for (int j = 0; j < y; j++) {
                        if (array.size() > i && array.get(i).size() > j) {
                            setValue(i, j, x, array.get(i).get(j));
                        }
                    }
                }
                break;
        }

    }

    private boolean isCorrectIndex(int i, int j, int k) {
        return (i >= 0 && j >= 0 && k >= 0) && (i < x && j < y && k < z);
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
