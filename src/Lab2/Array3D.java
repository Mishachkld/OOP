package Lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array3D<T> {
    private List<T> array;
    private int size;
    private int x, y, z;

    public Array3D(List<T> array, int x, int y, int z) {
        this(x, y, z);
        this.array = array;
    }

    public Array3D(int x, int y, int z) {
        if ((x > 0) && (y > 0) && (z > 0)) {
            array = new ArrayList<>();
            size = x * y * z;
            this.x = x;
            this.y = y;
            this.z = z;
            for (int i = 0; i < size; i++) {
                array.add(null);
            }
        }
        else throw new IndexOutOfBoundsException();
    }


    public Array3D<T> fillArray(T t, int size) {
        Array3D<T> array3D = new Array3D<>(size, size, size);
        Collections.fill(array3D.getBaseArray(), t);
        return array3D;
    }


    private List<List<T>> getValueArray2D(int index, int x) {
        List<List<T>> resultArray = new ArrayList<>();
        List<T> temp = new ArrayList<>();
        switch (index) {
            case 0:
                for (int j = 0; j < this.y; j++) {
                    for (int k = 0; k < z; k++) {
                        temp.add(getValue(x, j, k));
                    }
                    resultArray.add(temp);
                    temp = new ArrayList<>();
                }
                break;
            case 1:
                for (int i = 0; i < this.x; i++) {
                    for (int k = 0; k < z; k++) {
                        temp.add(getValue(i, x, k));
                    }
                    resultArray.add(temp);
                    temp = new ArrayList<>();
                }
                break;
            case 2:
                for (int i = 0; i < this.x; i++) {
                    for (int j = 0; j < y; j++) {
                        temp.add(getValue(i, j, x));
                    }
                    resultArray.add(temp);
                    temp = new ArrayList<>();
                }
                break;
        }
        return resultArray;
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

    public void setValue2D(int x, int position, List<List<T>> array) {
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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < x; i++) {
            builder.append(i).append(":").append("\n");
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    builder.append(getValue(i, j, k));
                }
                builder.append("\n");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private List<T> getBaseArray() {
        return array;
    }
}
